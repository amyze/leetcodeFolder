/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/first-missing-positive
@Language: Java
@Datetime: 16-05-28 03:36
*/

public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        if (A == null ||A.length ==0) return 1;
        HashSet<Integer> set = new HashSet<>();
        int max = A[0];
        // find max in the array A and create a hashSet that contains the array A
        for(int i : A) {
            set.add(i);
           if (i > max) {
               max = i;
           } 
        }
        if (max<=0) {
            return 1;
        }
        // find the first missing positive
        for (int num = 1; num <= max; num++){
            if (!set.contains(num)) {
                return num;
            }
        }
        return max+1;
    }
}