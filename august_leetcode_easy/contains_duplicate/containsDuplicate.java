package august_leetcode_easy.contains_duplicate;

/* 
Problem:
if a element repeats itself >=2 return true else false

Edge Cases:
if nums.length==1 , return false

Approach:

Brute Force-
nums = [1,2,3,1]
1-> 1==2 , false
1-> 1==3 , false
1-> 1==1 , true

nums = [1,1,1,3,7,4,8,9,4,2]
3-> 3==7 , false
3-> 3==4 , false
3-> 3==8 , false


Pseudo code:
    for i=0 to n-2 :
       for j=i+1 to n-1:
            if arr[i]==arr[j]
                return true

Brute Force Code:

TC: O(n^2)
SC :O(1)

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 1) {
             return false;
        }
            
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }         
            }
        }
        return false;         
    }
}


                       
-----------------------xxxxxxxxxxxx---------------------------  

Optimal Approach-

TC:O(n)
SC:O(n)

Can be approached using 2 structures - HashMap , HashSet. 
Use HashMap. Why? (Elements will be stored in a key:value pair, duplicate keys not allowed)
Use HashSet. Why? (Because Set doesnt allow to add duplicates values)

HashMap{a:1, b:2 , b:3 }
HashSet{a,b,c,d}

PseudoCode -
    
    for i=0 to n :
        set.add(nums[i])
        if set.contains(nums[i])
            return true
  

1-> add
2-> add
3-> add
4-> add 




*/
import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            else
                set.add(nums[i]);
        }
        return false;
    }
}

public class containsDuplicate {
    // nums = [1,1,1,3,3,4,3,2,4,2]
    public static void main(String[] args) {
        try (Scanner obj = new Scanner(System.in)) {
            System.out.println("Enter length of array: ");
            int n = obj.nextInt();
            System.out.println("enter array: ");
            int nums[] = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = obj.nextInt();
            }
            Solution obj1 = new Solution();
            System.out.println(obj1.containsDuplicate(nums));
        }

    }

}
