import java.util.Random;
import java.util.Arrays;

public class ArrayAnalyzer {

    public static int[] arr;

    public static void initArray() {
        arr = new int[10];

        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            arr[i] = r.nextInt(100) + 1;
        }
    }

    public static void main(String[] args) {

        //Step 1: Initialize and populate the array
        initArray();

        //Step 2: Implement calculation loops
        int sum = 0;
        int max = arr[0];
        int min = arr[0];

        for (int num : arr) {
            sum += num;

            if (num > max) {
                max = num;
            }

            if (num < min) {
                min = num;
            }
        }

        double average = (double) sum / arr.length;

        //Step 3: Log the Results
        System.out.println("Original array values: " + Arrays.toString(arr));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }

}
