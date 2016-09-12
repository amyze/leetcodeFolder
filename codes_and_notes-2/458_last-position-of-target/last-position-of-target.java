/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/last-position-of-target
@Language: Java
@Datetime: 16-07-09 00:29
*/

public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int lastPosition(int[] A, int target) {
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
                // 如果相等，继续往右寻找边界
                left = mid;
            } else if (target > A[mid]) {
                // move right;
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (A[right] == target) {
            return right;
        } else if (A[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}