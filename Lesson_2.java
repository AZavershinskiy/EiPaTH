import java.io.FileReader;
import java.io.IOException;

public class Lesson_2 {
    public static void main(String[] args) {
        FileReader test = null;
        try {
            test = new FileReader("TestFile");
            // test.read();
        } catch (RuntimeException | IOException e) {
            System.out.println("catch exception: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("finally start");
            if (test != null) {
                try {
                    test.close();
                } catch (IOException e) {
                    System.out.println("exception while close");
                }
            }
            System.out.println("finally finished");
        }

        /*
         * int number = 1;
         * try {
         * number = 10 / 1;
         * String test = null;
         * // System.out.println(test.length());
         * Collections.emptyList().add(new Object());
         * } catch (ArithmeticException e) {
         * System.out.println("operation divide by zero not supported");
         * } catch (NullPointerException e) {
         * System.out.println("nullpointer exception");
         * } catch (Exception e) {
         * System.out.println("exception");
         * }
         * System.out.println("number = " + number);
         */

        /*
         * List<Object> emptyList = Collections.emptyList();
         * emptyList.add(new Object());
         * 
         * String number = "123fq";
         * int result = Integer.parseInt(number);
         * System.out.println(result);
         * 
         * Object object = new String("123");
         * File file = (File) object;
         * System.out.println(file);
         * 
         * String name = null;
         * System.out.println(name.length());
         */
    }
}
