/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/backpack
@Language: Java
@Datetime: 16-07-01 18:24
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
    boolean [][] dp = new boolean[A.length + 1][m+1];
        for (int j = 0; j <= m; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i <= A.length; i++) {
            dp[i][0] = true;
        }
        for (int i =1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                //不取第i个数
                if (j >= A[i-1] && dp[i-1][j - A[i-1]]) {
                    //取第i个数 A[i-1]表示第i个数
                    dp[i][j] = true;
                }
            }
        }
        for (int k = m; k >=0; k--) {
            if (dp[A.length][k]) {
                return k;
            }
        }
        return 0;
    }
    
}