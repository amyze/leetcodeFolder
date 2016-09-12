/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/longest-common-subsequence
@Language: Java
@Datetime: 15-10-03 16:41
*/

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
       int m = A.length();
       int n = B.length();
       int result = 0;
       if(A.length() == 0 ||B.length() ==0)
       {
           return 0;
        }
        int [][] temp = new int[m+1][n+1];
        for(int i =1; i<=m;i++){
            for(int j = 1; j<=n; j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    temp[i][j]= temp[i-1][j-1]+1;
                }else temp[i][j] = Math.max(temp[i-1][j],temp[i][j-1]);
                 result = Math.max(result, temp[i][j]);
            }     
        } return result;// write your code here
    }
}
// http://java.freesion.com/article/37965126/

