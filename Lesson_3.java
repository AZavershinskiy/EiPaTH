import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lesson_3 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("TestFile");
                FileWriter writer = new FileWriter("TestFile_copy")) {
            while (reader.ready()) {
                writer.write(reader.read());
            }
        } catch (RuntimeException | IOException e) {
            System.out.println("catch exception: " + e.getClass().getSimpleName());
        }

        try {
            System.out.println("test operation");
        } finally {
            System.out.println("finally operation");
        }
    }
}
