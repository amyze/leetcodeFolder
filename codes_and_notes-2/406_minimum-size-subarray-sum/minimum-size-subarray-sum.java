/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/minimum-size-subarray-sum
@Language: Java
@Datetime: 16-09-11 18:01
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        if (nums == null || nums.length ==0){
            return -1;
        }
        int ans  = Integer.MAX_VALUE;
        int sum  = 0;
        int j =0;
        for(int i =0; i< nums.length; i++){
            
            while(j< nums.length && sum< s){
                sum+= nums[j];
                j++;
            }
            if (sum>=s){
                ans = Math.min(ans, j-i);
            }
            sum-=nums[i];
        }
        if(ans == Integer.MAX_VALUE)
            ans = -1;
        return ans;
    }
}