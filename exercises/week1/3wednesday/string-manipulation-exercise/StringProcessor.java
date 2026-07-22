public class StringProcessor {

    //Step 1: Manual Implementation of String methods

    public static String reverse(String input) {
        if (input == null) {
            return "";
        }

        String reversedString = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversedString += input.charAt(i);
        }
        return reversedString;
    }

    public static int countVowels(String input) {
        if (input == null) {
            return 0;
        }

        String lowercase = input.toLowerCase();

        int count = 0;

        for (int i = 0; i < lowercase.length(); i++) {
            char c = lowercase.charAt(i);

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }

        return count;
    }

    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }

        String lowercase = input.toLowerCase();

        int l = 0;
        int r = input.length() - 1;

        while (l < r) {
            char charL = lowercase.charAt(l);
            char charR = lowercase.charAt(r);

            if (charL == ' ') {
                l++;
                continue;
            }

            if (charR == ' ') {
                r--;
                continue;
            }

            if (charL == charR) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
