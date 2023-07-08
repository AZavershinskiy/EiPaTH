package HW_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Handler {
    public static void run(String path) {
        while (true) {
            String strIn = strInput();
            if (!strIn.equals("exit")) {
                try {
                    String[] dataIn = new String[5];
                    dataIn = splitLine(strIn);
                    Data dataWork = new Data(dataIn);
                    try {
                        writeData(dataWork, path);
                    } catch (DataWrite e) {
                        e.printStackTrace();
                    }
                } catch (MyInputException e) {
                    System.err.println("Warning: " + e);
                }
            } else {
                System.out.println("\nProgram stopped");
                return;
            }
        }
    }

    private static String strInput() {
        Scanner terminal = new Scanner(System.in);
        System.out.printf("\nInput the data separated by a space in the format:\n<Last name> <First name> <Patronymic> "
                +
                "<Date of Birth(dd.mm.yyyy)> <Phone number> <Gender(m/f)>\nOr input <exit> to stop the Program\n->");
        return terminal.nextLine();
    }

    private static String[] splitLine(String strIn) throws MyInputException {
        String[] dataIn = strIn.split(" ");
        if (dataIn.length > 6)
            throw new ExtraData();
        else if (dataIn.length < 6)
            throw new LackData();
        else if (!checkString(dataIn[0]) || !checkString(dataIn[1]) || !checkString(dataIn[2]))
            throw new NumericInNameException();
        else if (!checkDate(dataIn[3]))
            throw new NotCurrentDateValueError();
        else if (!checkNumeric(dataIn[4]))
            throw new LetterInPhoneException();
        else if (!dataIn[5].equals("f") && !dataIn[5].equals("m"))
            throw new GenderError();
        else
            return dataIn;
    }

    private static boolean checkString(String value) {
        for (char c : value.toCharArray()) {
            if ((int) c - 48 < 10)
                return false;
        }
        return true;
    }

    private static boolean checkDate(String value) throws NotCurrentDateValueError {
        value = value.replace(".", ",");
        String[] dateIn = value.split(",");
        if (dateIn.length != 3)
            throw new DateIncompletelyException();
        else if (dateIn[0].length() != 2 || dateIn[1].length() != 2 || dateIn[2].length() != 4)
            throw new ExtraSymbolException();
        else if (Integer.parseInt(dateIn[0]) < 1 || Integer.parseInt(dateIn[0]) > 31) // without complicated check for
                                                                                      // non-existent days
            throw new DateNotValidException("Birthday number is incorrect");
        else if (Integer.parseInt(dateIn[1]) < 1 || Integer.parseInt(dateIn[1]) > 12)
            throw new DateNotValidException("Birthday month is incorrect");
        else if (Integer.parseInt(dateIn[2]) < 999 || Integer.parseInt(dateIn[2]) > 2023)
            throw new DateNotValidException("Birthday year is incorrect");
        return true;
    }

    private static boolean checkNumeric(String value) {
        for (char c : value.toCharArray()) {
            if ((int) c - 48 > 9)
                return false;
        }
        return true;
    }

    private static void writeData(Data data, String path) throws DataWrite {
        if (!Files.exists(Path.of(path))) {
            new File(path).mkdir();
        }
        String filename = path + data.getLastName();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(data.toString());
            System.out.println("Data saved to file: " + path + data.getLastName());
        } catch (IOException e) {
            throw new DataWrite();
        }
    }
}