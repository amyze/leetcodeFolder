/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/classical-binary-search
@Language: Java
@Datetime: 16-07-09 02:24
*/

public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int findPosition(int[] A, int target) {
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
                return mid;
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