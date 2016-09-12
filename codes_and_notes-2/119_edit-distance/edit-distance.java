/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/edit-distance
@Language: Java
@Datetime: 16-06-29 04:00
*/

public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        //corner case
        if (word1 == null || word2 == null ) {
            return 0;
        }
        // define 2D dp array
        int n = word1.length();
        int m = word2.length();
        int [][]dp = new int[n+1][m+1];
        //initial value
        for(int i =0;i<n+1; i++) {
            dp[i][0] = i;
        }
        for(int j =0;j<m+1; j++) {
            dp[0][j] = j;
        }
        for(int i=1;i<n+1; i++) {
            for (int j=1; j<m+1; j++) {
                char a = word1.charAt(i-1);
                char b = word2.charAt(j-1);
                if(a == b) {
                dp[i][j]= dp[i-1][j-1];
                }else{
                    dp[i][j] = 1+ Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }
        return dp[n][m];
    }
}