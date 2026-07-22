//Step 1: Creating utility class without instance var
public class MathUtils {

    //Step 2: Implementing 5 static methods
    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n-1);
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Input is empty or null");
            return 0;
        }

        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }

    public static double findMax(double[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Input is empty or null");
            return 0.0;
        }

        double largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }

    //Step 3: Writing Runner Code
    public static void main(String[] args) {

        int[] arr1 = {2, -5, 1, 12, 2, 99};
        double[] arr2 = {0.123, 24.1, 0.0, -12};

        System.out.println("Factorial of 6: " + MathUtils.factorial(6));
        System.out.println("73 is prime: " + MathUtils.isPrime(73));
        System.out.println("24C is equal to " + MathUtils.celsiusToFahrenheit(24) + "F");
        System.out.println("Maximum of int array is " + MathUtils.findMax(arr1));
        System.out.println("Maximum of double array is " + MathUtils.findMax(arr2));
    }
}
