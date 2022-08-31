package august_leetcode_easy.valid_anagram;

import java.util.HashMap;
import java.util.Scanner;

/*class Solution {
    public boolean isAnagram(String s, String t) {
        char temp;
        s=s.toLowerCase();
        t=t.toLowerCase();
        
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        
       for(int i = 0; i < ch1.length-1; i++) {
            for(int j = i+1; j < ch1.length; j++)
            if(ch1[i]>ch1[j]){
                temp=ch1[j];
                ch1[j]=ch1[i];
                ch1[i]=temp;
            }
        }
        for(int i = 0; i < ch2.length-1; i++) {
            for(int j = i+1; j < ch2.length; j++)
            if(ch2[i]>ch2[j]){
                temp=ch2[j];
                ch2[j]=ch2[i];
                ch2[i]=temp;
            }
        } 
        
        if(s.length()==t.length()){
            if(Arrays.equals(ch1,ch2))
                return true;
        }
        
    return false;   
    }
}

/* 
Approach:

// Brute Force : 

We need to check if a letter from string s matches with string t after sorting the string.
TC: O(n^2);


Edge Cases:
if string has capital letters return false.
if both string have unequal length then false.

Dry Run:
 s = "anagram", t = "nagaram"
 search for index 1 letter in s ,
 a -> found in t
 ans so on

Pseudocode:
    for i in s :
        for j in t :
            if s[i]==t[j]
                flag=1
        if flag==1
            return true;

Approach:
Store s in a hashmap where 
key is character in s and value is the count of occurence
s = "anagram"
    a,0
    n,0
    a
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hash.get(s.charAt(i)) == null) {
                hash.put(s.charAt(i), 0);
            } else {
                hash.put(s.charAt(i), hash.get(s.charAt(i)) + 1);
            }
        }
        /*
         * anagram
         * a,2
         * n,0
         * g,0
         * r,0
         * m,0
         * 
         */

        for (int i = 0; i < t.length(); i++) {
            if (hash.get(t.charAt(i)) == null) {
                return false;
            } else {
                hash.put(t.charAt(i), hash.get(t.charAt(i)) - 1);
            }
        }
        /*
         * nagaram
         * a,-1
         * n,-1
         * g,-1
         * r,-1
         * m,-1
         * all values of hashmap is -1 , return true else return false
         */
        for (int i = 0; i < t.length(); i++) {
            if (hash.get(t.charAt(i)) != -1)
                return false;
        }
        return true;
    }
}

public class validAnagram {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the first string : ");
            String s = sc.next();
            System.out.println("Enter the second string : ");
            String t = sc.next();
            Solution obj = new Solution();
            System.out.println(" are the two strings valid anagram ? " + obj.isAnagram(s, t));
        }

    }

}
