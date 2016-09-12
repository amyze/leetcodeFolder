/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/partition-array-by-odd-and-even
@Language: Java
@Datetime: 16-09-11 21:45
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
       if (nums == null || nums.length == 0){
           return;
       }
       int l =0, r = nums.length-1;
       while(l<r) {
           while (l< r && nums[l]%2==1){
               l++;
           }
           while (l<r && nums[r]%2==0){
               r--;
           }
           swap(nums, l, r);
           l++;
           r--;
       }
       
    }
    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}