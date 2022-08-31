package august_leetcode_easy.MaxProfit_BuySell;

/* Brute Force:

edge case :
if prices.length=1
    return 0;

class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        for(int i = 0; i < prices.length-1; i++) {
            for( int j = i+1 ; j < prices.length; j++) {
                int profit=prices[j]-prices[i];
                if(profit>maxprofit) {
                    maxprofit=profit;
                }
            }
        }
       return maxprofit; 
    }
}

TC : O(n^2)
SC : O(1)


Optimal Solution:

prices = [7,1,5,3,6,4]

min_ele=1
max_p =0

we find the min_element and min_ele = curr
find maxprofit for curr[i+1]-min_ele

TC:O(n)
SC:O(1)



*/
import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int min_ele = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxprofit = Math.max(maxprofit, prices[i] - min_ele);
            min_ele = Math.min(min_ele, prices[i]);
        }
        return maxprofit;
    }
}

public class MaxProfit_buySell {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("input length of array : ");
            int n = sc.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.println("input price of stock on " + i + "th day : ");
                prices[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            System.out.println("Max profit gained is : " + obj.maxProfit(prices));
        }

    }
}
