/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/maximum-product-subarray
@Language: Java
@Datetime: 16-06-24 21:00
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
       if (nums==null || nums.length==0) {
           return 0;
       }
       int n=nums.length;
       int[]min= new int[n];
       int[]max = new int[n];
       int result = nums[0];
       max[0]=min[0]=nums[0];
       for(int i=1; i<n;i++) {
           if(nums[i]>0) {
               max[i]= Math.max(nums[i],max[i-1]*nums[i]);
               min[i]= Math.min(nums[i],min[i-1]*nums[i]);
           }else {
               max[i]= Math.max(nums[i],min[i-1]*nums[i]);
               min[i]= Math.min(nums[i],max[i-1]*nums[i]);
           }
           result = Math.max(max[i], result);
       }
       return result;
    }
}