/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/coins-in-a-line-iii
@Language: Java
@Datetime: 15-10-03 21:58
*/

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
     if(values.length <= 2)   return true;
        int[][] D = new int[values.length+2][values.length+2];
        for(int i=0; i<D.length; i++) {
            for(int j=0; j<D[0].length; j++) {
                D[i][j] = Integer.MAX_VALUE/2;
            }
        }
        for(int i=1; i<=values.length; i++) {
            D[i][i] = values[i-1]; 
        }
        int sum = 0;
        for(int i=values.length; i>=1; i--) {
            sum +=values [i-1];
            for(int j=i+1; j<=values.length; j++) {
                D[i][j] = Math.max(values[i-1] + Math.min(D[i+2][j], D[i+1][j-1]),  
                    values[j-1] + Math.min(D[i+1][j-1], D[i][j-2]));
            }
        }

        return D[1][values.length] > sum - D[1][values.length];
      // write your code here
    }
}
