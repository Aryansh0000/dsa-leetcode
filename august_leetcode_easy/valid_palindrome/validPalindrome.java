package august_leetcode_easy.valid_palindrome;

import java.util.*;

class Solution {
    public boolean isPalindrome(String s) {
        String rev = "";
        StringBuilder str = new StringBuilder("");

        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((Character.isLetter(ch)) || (Character.isDigit(ch))) {
                str.append(ch);
            }
        }
        // s = s.replaceAll("[^a-z0-9]", "");
        // System.out.println(str.toString());
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        // System.out.println(rev);
        if (str.toString().equals(rev)) {
            return true;
        }
        return false;
    }
}

/*
 * ascii values 48-57 for numbers.
 * ascii values 65-90 for Captial Letters
 * ascii values 97-122 for small letters
 * 
 * Approach:
 * 
 * 1. converting all uppercase letters into lowercase letters
 * 2. removing all non-alphanumeric characters
 * 3. read same forward and backward
 * 
 * example: ArYansH
 * System.out.println(txt.toUpperCase());
 * String s = naman
 * PseudoCode :
 * 
 */

public class validPalindrome {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the string : ");
            String s = sc.nextLine();
            System.out.println("The String is palindrome? ");
            Solution obj = new Solution();
            System.out.println(obj.isPalindrome(s));
        }

    }

}
