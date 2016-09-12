/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array
@Language: Java
@Datetime: 16-05-31 21:44
*/

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int start =0, end = num.length-1;
        while (start +1 < end) {
            int mid = start + (end - start)/2;
            if ((num[mid] > num[start]) && (num[mid] > num[end]) ) {
                start = mid;
            } else if ((num[mid] < num[start] && num[mid] < num[end])||(num[mid] < num[end]&& num[mid] > num[start]) ){
                end = mid;
            } 
        }
         if (num[start] <num[end] ) {
             return num[start];
         } else {
             return num[end];
         }
    }
}