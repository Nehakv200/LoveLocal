//Easy 1
//Given a string s consisting of words and spaces, return the length of the last word in the string.
package lovelocal;

import java.util.Scanner;

public class Easy1 {
    public static int LastWord(String s) {
        // Initialize the length to 0
        int length = 0;

        // Iterate through the characters in reverse order
        for (int i = s.length() - 1; i >= 0; i--) {
            // If a non-space character is encountered, increment the length
            if (s.charAt(i) != ' ') {
                length++;
            } 
            // If a space is encountered and length > 0, we've found the last word
            else if (length > 0) {
                break; // Break the loop once the last word is found
            }
        }

        return length;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input = sc.nextLine();
        int result = LastWord(input);
        System.out.println(result);
    }
}
