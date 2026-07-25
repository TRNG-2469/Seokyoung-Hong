public class PrimitivePractice {

    public static void main(String[] args) {

        //Step 1: Declaring Primitives
        byte byteVar = 64;
        short shortVar = 15000;
        int intVar = 1;
        long longVar = 23498934894839L;
        float floatVar = 0.56F;
        double doubleVar = 12.29392;
        char charVar = 'A';
        boolean booleanVar = true;

        System.out.println("byteVar: " + byteVar);
        System.out.println("shortVar: " + shortVar);
        System.out.println("intVar: " + intVar);
        System.out.println("longVar: " + longVar);
        System.out.println("floatVar: " + floatVar);
        System.out.println("doubleVar: " + doubleVar);
        System.out.println("charVar: " + charVar);
        System.out.println("booleanVar: " + booleanVar);

        //Step 2: Implicit and Explicit Casting
        byte smallVal = 50;
        int largeVal = smallVal;

        System.out.println("smallVal is " + smallVal);
        System.out.println("largeVal is " + largeVal);

        double decimalVal = 99.99;
        //int truncatedVal = decimalVal;
        int truncatedVal = (int) decimalVal;

        System.out.println("decimalVal is " + decimalVal);
        System.out.println("truncatedVal is " + truncatedVal);

        //Due to narrowing the decimal into an integer, the decimal places are truncated away

        //Step 3: Reference Variable Mutation
        int a = 10;
        int b = a;
        b = 20;

        System.out.println("a is " + a);
        System.out.println("b is " + b);

        int[] firstArray = new int[]{10, 20, 30};
        int[] secondArray = firstArray;
        secondArray[0] = 999;

        System.out.println("firstArray 0 index is " + firstArray[0]);
        System.out.println("secondArray 0 index is " + secondArray[0]);

        //Since the value of firstArray is a reference, when assign secondArray variable
        //to that reference, the reference points to the same object in memory. So changing
        //secondArray changes firstArray, they are the same!


    }


}
