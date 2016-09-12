/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/closest-number-in-sorted-array
@Language: Java
@Datetime: 16-07-09 02:17
*/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid]== target) {
                return mid;
            }
            else if (A[mid] < target) {
                start = mid;
            } else if(A[mid] > target) {
                end = mid;
            } 
        }
        
        int result1 = Math.abs(target-A[start]);
        int result2= Math.abs(A[end]-target);
        if (result1<= result2) {
            return start;
        }
        else{
            return end;
        }
        
    }
}