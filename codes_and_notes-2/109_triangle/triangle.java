/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/triangle
@Language: Java
@Datetime: 16-06-24 20:44
*/

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null ||triangle.length==0 
        ||triangle[0].length == 0) {
            return 0;
        }
        int row = triangle.length;
        int f[][]= new int[row][row];
        f[0][0]= triangle[0][0];
        // consider the left border
        for(int i =1;i< row;i++) {
            f[i][0] = f[i-1][0]+triangle[i][0];
        }
        //consider the right border
        for(int j=1;j<row;j++){
            f[j][j]=f[j-1][j-1]+triangle[j][j];
        }
        // consider the rest
       //* j start from 1 and j's upper limit is i
        for(int i=2;i<row;i++){
            for (int j =1; j< i;j++){
                f[i][j] =Math.min(f[i-1][j],f[i-1][j-1])+triangle[i][j];
            }
        }
        // find the min in the last row
        int min = f[row-1][0];
        for (int i= 1; i< row;i++) {
            if (f[row-1][i] < min) {
                min = f[row-1][i];
            }
        }
        return min;
    }
}
