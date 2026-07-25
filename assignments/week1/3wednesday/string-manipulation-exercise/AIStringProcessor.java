//Step 2: The AI's attempt to generate these functions 
public class AIStringProcessor {

    // Reverse a string
    public static String reverse(String input) {
        if (input == null) {
            return "";
        }

        return new StringBuilder(input).reverse().toString();
    }

    // Count vowels
    public static int countVowels(String input) {
        if (input == null) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            switch (Character.toLowerCase(input.charAt(i))) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
                    break;
            }
        }

        return count;
    }

    // Check if a string is a palindrome (ignoring case and spaces)
    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            char l = Character.toLowerCase(input.charAt(left));
            char r = Character.toLowerCase(input.charAt(right));

            if (l == ' ') {
                left++;
                continue;
            }

            if (r == ' ') {
                right--;
                continue;
            }

            if (l != r) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}