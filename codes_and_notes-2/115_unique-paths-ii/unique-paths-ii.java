/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/unique-paths-ii
@Language: Java
@Datetime: 16-06-24 16:52
*/

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       if (obstacleGrid == null || obstacleGrid.length==0 || 
       obstacleGrid[0].length==0) {
           return 0;
       }
       int row = obstacleGrid.length;
       int col = obstacleGrid[0].length;
       int[][] rst = new int[row][col];
       if(obstacleGrid[0][0] == 0) {
        rst[0][0]=1;
       }else{
           rst[0][0]=0;
       }
       // consider the first col
       for (int i=1; i<row; i++){
           if (obstacleGrid[i][0]==0) {
            rst[i][0] = rst[i-1][0]; 
           } else {
            rst[i][0] = 0;   
           }
       }
       // consider the first row
       for (int j=1; j<col; j++){
           if (obstacleGrid[0][j]==0) {
                rst[0][j] = rst[0][j-1]; 
           } else {
                rst[0][j] = 0;   
           }
       }
       // consider the rest matrix
       for(int i=1;i< row; i++){
           for (int j=1;j<col;j++){
              if (obstacleGrid[i][j]==0) {
                rst[i][j] = rst[i-1][j]+rst[i][j-1]; 
              } else {
                rst[i][j] = 0;   
              } 
           }
       }
       return rst[row-1][col-1];
    }
}