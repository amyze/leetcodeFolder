/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/total-occurrence-of-target
@Language: Java
@Datetime: 16-07-09 00:37
*/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
         int leftIndex =0, rightIndex=0;
        
        if (A == null || A.length == 0) {
            return 0;
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
            leftIndex = left;
        } else if (A[right] == target) {
            leftIndex = right;
        } else {
            return 0;
        }
        
        left = 0; 
        right = len - 1;
        // so when loop end, there will be 2 elements in the array.
        // search the right bound.
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target == A[mid]) {
                // 如果相等，继续往右寻找右边界
                left = mid;
            } else if (target > A[mid]) {
                // move right;
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (A[right] == target) {
            rightIndex = right;
        } else if (A[left] == target) {
            rightIndex = left;
        } else {
            return 0;
        }
        
        return rightIndex-leftIndex+1;
    }
}