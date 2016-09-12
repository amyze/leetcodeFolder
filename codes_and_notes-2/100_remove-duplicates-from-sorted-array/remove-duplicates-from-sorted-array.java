/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-array
@Language: Java
@Datetime: 16-05-27 23:40
*/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] A) {
        if (A.length < 2)
		return A.length;
 
	int j = 0;
	int i = 1;
 
	while (i < A.length) {
		if (A[i] == A[j]) {
			i++;
		} else {
			j++;
			A[j] = A[i];
			i++;
		}
	}
 
	return j + 1;
    }
}