/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/first-position-of-target
@Language: Java
@Datetime: 16-07-09 00:26
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] A, int target) {
        // if (nums == null || nums.length == 0){
        //     return -1;
        // }
        // int start = 0;
        // int end = nums.length-1;
        // while (start + 1 < end){
        //     int mid = start + (end - start)/2;
        //     if (nums[mid] == target){
        //         end = mid;//这里需要先赋值end，因为最后start比end小1
        //     } else if (nums[mid] < target){
        //         start = mid;
        //     } else {
        //         end = mid;
        //     }// 二分法模型
        // }
        // if (nums[start] == target) {
        //     return start;//因为有重复，所以先检查start的位子是否相等
        //                  //最后应该是start mid end，这中间可能有重复
        //                  //一直挪动end
        // }
        // if(nums[end] == target){
        //     return end;
        // }
        // return -1;//write your code here
         if (A == null || A.length == 0) {
            return -1;
        }
        
        int len = A.length;
        int left = 0; 
        int right = len - 1;
        
        // so when loop end, there will be 2 elements in the array.
        // search the left bound.
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target == A[mid]) {
                // 如果相等，继续往左寻找边界
                right = mid;
            } else if (target > A[mid]) {
                // move right;
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (A[left] == target) {
            return left;
        } else if (A[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
}
