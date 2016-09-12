/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 16-07-09 21:46
*/

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // if (num == null || num.length==0) {
        //     return -1;
        // }
        
        // int start =0, end = num.length-1;
        // if (num[end] > num[start]) {
        //     return num[start];
        // }else {
        //     while(start<end-1) {
        //         int mid = start+ (end-start)/2;
        //         if (num[start]<= num[mid]) {
        //             start = mid;
        //         }else {
        //             end= mid;
        //         }
        //     }
        //     if (num[start]<= num[end]){
        //         return num[start];
        //     }else{
        //         return num[end];
        //     }
        // }
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[end]) {
                // if mid equals to end, that means it's fine to remove end
                // the smallest element won't be removed
                end--;
            } else if (nums[mid] < nums[end]) {
                end = mid;
                // of course you can merge == & <
            } else {
                start = mid;
                // or start = mid + 1
            }
        }
        
        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        return nums[end];
    }
}