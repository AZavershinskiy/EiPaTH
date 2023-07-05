import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Sem_2 {

    public static void main(String[] args) {
        // String[][] arr = { { "f", "2" }, { "3", "4" } };
        // System.out.println(sum2d(arr));

        // Map<String, Integer> names = read("names.txt");
        // write(names, "names.txt");

        InputStream inputStream;
        try {
            String[] str1 = { "asdf", "asdf" };
            String str2 = str1[str1.length -1];
            test();
            int a = 1 / 0;
            inputStream = new FileInputStream("sdafgdsaf");
        } catch (StackOverflowError er) {
            System.out.println("Stack full");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("I still completed");
        }
        System.out.println("I'm alive!");

    }

    public static void test() throws IOException {
        File file = new File("l");
        file.createNewFile();
        FileReader reader = new FileReader(file);
        reader.read();
        reader.close();
        test();
    }

    public static void write(Map<String, Integer> names, String path) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for (String s : names.keySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append(s).append("=").append(names.get(s)).append("\n");
                bw.write(sb.toString());
            }
            bw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public static Map<String, Integer> read(String path) throws IOException {
        Map<String, Integer> names = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                String[] vals = line.split("=");
                if (vals[1].equals("?")) {
                    int size = vals[0].length();
                    names.put(vals[0], size);
                } else {
                    names.put(vals[0], Integer.parseInt(vals[1]));
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new IOException(e);
        }
        return names;
    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    int val = isNumeric(arr[i][j]);
                    sum += val;
                }
            }
        }
        return sum;
    }

    private static Integer isNumeric(String strNum) {
        if (strNum == null) {
            return 0;
        }
        try {
            Integer num = Integer.parseInt(strNum);
            return num;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
