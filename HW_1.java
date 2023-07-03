public class HW_1 {

    public static void main(String[] args) {

        // Task 1: All the necessary methods in the tasks below

        // Task 3
        System.out.println("-----");
        int[] arr0 = { 0, 1, 2, 3, 4, 5 };

        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 5, 4, 3, 2, 1 };
        arrDiff(arr1, arr2);
        // arrDiff(arr1, arr0);

        // Task 4
        System.out.println("\n-----");
        arrDiv(arr1, arr2);
        // arrDiv(arr1, arr0);

    }

    /* Task 2 */
    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) { // ArrayIndexOutOfBoundsException
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }

    public static int[] arrDiff(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Error! Arrays differ in length");
        } else {
            int[] res = new int[arr1.length];
            System.out.print("Result: ");
            for (int i = 0; i < arr1.length; i++) {
                res[i] = arr1[i] - arr2[i];
                System.out.print(res[i] + ", ");
            }
            
            return res;
        }
    }

    public static float[] arrDiv(int[] arr1, int[] arr2) {
        checkZero(arr1);
        checkZero(arr2);
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Error! Arrays differ in length");
        } else {
            float[] res = new float[arr1.length];
            System.out.print("Result: ");
            for (int i = 0; i < arr1.length; i++) {
                res[i] = (float) arr1[i] / arr2[i];
                System.out.printf("%.2f, ", res[i]);
            }
            return res;
        }
    }

    private static void checkZero(int[] arr) {
        for (int i : arr) {
            if (i == 0) {
                throw new ArithmeticException("Error! Division by zero");
            }
        }
    }

}
