/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/the-smallest-difference
@Language: Java
@Datetime: 16-09-11 22:18
*/

public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        if(A== null || A.length ==0|| B == null || B.length == 0){
            return 0;
        }
        Arrays.sort(A);
        Arrays.sort(B);
            int  i =0, j= 0, ans = Integer.MAX_VALUE;
            while(i< A.length && j< B.length){
                if(A[i]< B[j]){
                    ans = Math.min(ans, Math.abs(B[j]-A[i++]));
                    
                }else if(A[i]> B[j]){
                   ans = Math.min(ans, Math.abs(B[j++]-A[i]));
                    
                }else return 0;
            }
            return ans;
        
    }
}
