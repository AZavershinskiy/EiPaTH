import java.io.IOException;

public class Sem_3 {

    public static void main(String[] args) throws IOException, MyAarraySizeExeption {
        // Task 1:
        // try {
        //     doSomthing();
        // } catch (IOException e) {
        //     System.out.println("Input-output error");
        // }

        // Task 2:
        // try (Counter count = new Counter()) {
        //     count.add();
        //     count.add();
        //     count.add();
        //     count.close();
        //     System.out.println(count.toString());
        //     count.add();
        // }

        // Task 3: Down in the code

        // Task 4:
        String[][] arr2d = { { "1", "f" }, { "1", "2" } };
        // String[][] arr2dNotSymet = { { "1", "f" }, { "1", "1", "1" } };

        System.out.println("Result = " + sum2d(arr2d));
        // System.out.println("Result = " + sum2d(arr2dNotSymet));
    }

    // for Task 1
    public static void doSomthing() throws IOException {
        throw new IOException();
    }

    // for Task 4
    public static int sum2d(String[][] arr) throws MyAarraySizeExeption {
        int sum = 0;
        if (!checkSize(arr))
            throw new MyAarraySizeExeption();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    int val = isNumeric(arr[i][j], i, j);
                    sum += val;
                }
            }
        }
        return sum;
    }

    // for Task 4
    private static boolean checkSize(String[][] arr) {
        if (arr.length != 2)
            return false;
        for (int i = 0; i < 2; i++) {
            if (arr[i].length != 2)
                return false;
        }
        return true;
    }

    // for Task 4
    private static int isNumeric(String strNum, int i, int j) {
        if (strNum == null) {
            return 0;
        }
        try {
            Integer num = Integer.parseInt(strNum);
            return num;
        } catch (NumberFormatException e) {
            System.err.println("Warning! The array contains an element[" + i + "][" + j + "] that is not a number");
            return 0;
        }
    }
}

// for Task 2
class Counter implements AutoCloseable {

    private Integer count;

    private boolean isOpen;

    public Counter() {
        this.count = 0;
        this.isOpen = true;
    }

    public void switchCounter() {
        isOpen = !isOpen;
    }

    public void close() {
        isOpen = false;
    }

    public void add() throws IOException {
        if (!isOpen) {
            throw new IOException("Counter is closed");
        }
        this.count++;
    }

    @Override
    public String toString() {
        return "Counter = " + count;
    }
}

// Example for Task 3
class DivisionByZeroException extends Exception {
    public DivisionByZeroException() {
        super("Error! Can't divide by zero");
    }
}

// for Task 3
class NullPointLinkedArrayException extends Exception {
    public NullPointLinkedArrayException() {
        super("Error! Referencing an empty array element");
    }
}

// for Task 3
class FileNotFoundException extends Exception {
    public FileNotFoundException() {
        super("Error! File not found");
    }
}

// for Task 4
class MyAarraySizeExeption extends Exception {
    public MyAarraySizeExeption() {
        super("Error! Two-dimensional array is not symmetrical");
    }
}