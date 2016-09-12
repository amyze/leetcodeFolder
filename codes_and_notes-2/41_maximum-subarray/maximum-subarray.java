/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/maximum-subarray
@Language: Java
@Datetime: 16-06-24 20:39
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public  int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] local = new int[n];
        int[] global = new int[n];
        local[0]= nums[0];
        global[0]= nums[0];
        for(int i=1;i<n;i++){
            local[i]=Math.max(nums[i],local[i-1]+nums[i]);
            global[i]= Math.max(global[i-1], local[i]);
        }
        return global[n-1];
    }
}