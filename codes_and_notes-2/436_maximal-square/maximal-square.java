/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/maximal-square
@Language: Java
@Datetime: 15-10-02 16:05
*/

public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
       int m = matrix.length;
       int n = matrix[0].length;
       int result=0;
       int[][] temp = new int[m+1][n+1];
       for (int i=1; i<=m;i++){
           for (int j = 1; j<= n; j++){
               if(matrix[i-1][j-1] == 1){
                   temp[i][j] = Math.min(Math.min(temp[i-1][j],temp[i][j-1]),
                   temp[i-1][j-1])+1;
               }
               result = Math.max(result,temp[i][j]);
           }
      
       } return result*result;// write your code here
    }
}
