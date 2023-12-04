//Hard2

package lovelocal;

import java.util.Scanner;

public class Hard2 {
    public static String shortestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        int n = s.length();
        int i = 0;

        // Find the index where the string becomes a palindrome
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }

        // The remaining portion needs to be added in front of the original string
        String prefix = s.substring(i);
        return new StringBuilder(prefix).reverse().toString() + s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("s=");
        String input = scanner.nextLine();

        String result = shortestPalindrome(input);
        System.out.println(result);
    }
}

