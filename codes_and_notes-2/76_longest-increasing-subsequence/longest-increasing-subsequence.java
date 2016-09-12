/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/longest-increasing-subsequence
@Language: Java
@Datetime: 16-07-16 20:42
*/

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
       if (nums== null || nums.length == 0) return 0;
       int length = nums.length;
       int[]dp =new int[length];
       int result =0;
       for (int i=0;i<length;i++){
           dp[i]=1;
           for(int j=0;j<i;j++){
               if (nums[j] <=nums[i]) {
                   dp[i] = Math.max(dp[i],dp[j]+1);
               }
           }
           if (dp[i]>result){
               result = dp[i];
           }
       }
       return result;
    }
}
