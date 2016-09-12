/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/jump-game
@Language: Java
@Datetime: 16-06-02 03:18
*/

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        int maxCover = 0, n = A.length;  
            for(int start =0; start<= maxCover && start<n; start++)  
            {  
                 if(A[start]+start > maxCover)  
                      maxCover = A[start]+start;  
                if(maxCover >= n-1) return true;  
            }  
            return false;  
    }// start <= maxCover 保证了可以走到当前这一步
}
