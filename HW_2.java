import java.util.InputMismatchException;
import java.util.Scanner;

public class HW_2 {
    public static void main(String[] args) throws Exception {

        // Task 1:
        float num = inputFloat();
        System.out.println("Float number = " + num);

        // // Task 2:
        int[] intArray = new int[10];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i;
        }
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

        // // Task 3:
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так...");
        }

        // Task 4:
        System.out.println("Inputted string = " + '"' + inputString() + '"');
    }

    // for Task 1
    public static float inputFloat() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input float number: ");
            return scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Invalid characters inputted. Please try again");
            return inputFloat();
        }
    }

    // for Task 3
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

    // for Task 4
    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the string: ");
        String line = scanner.nextLine();
        scanner.close();
        if (line.isEmpty())
            throw new RuntimeException("Error! You cannot input an empty string");
        return line;
    }

}
