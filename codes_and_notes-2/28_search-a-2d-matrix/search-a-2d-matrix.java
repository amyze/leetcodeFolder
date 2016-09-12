/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix
@Language: Java
@Datetime: 16-05-31 20:52
*/

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length ==0){
            return false;
        }
        int row = matrix.length, column = matrix[0].length;
        int start =0, end = row -1;
        
       
           
            while (start + 1 < end ){
                int mid  = start + (end- start)/2;
                if (matrix[mid][0] == target) {
                    return true;
                }if (matrix[mid][0] >target){
                    end = mid;
                }else {
                    start = mid;
                }
            }
        //注意这里先考虑buttom，因为可能是target比最大值还大
        if (matrix[end][0] <= target) {
            row = end;
        } else if (matrix[start][0] <= target) {
            row = start;
        } else {
            return false;
        }
        
        
        // find the column index, the number equal to target
        start = 0;
        end = column - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[row][start] == target) {
            return true;
        } else if (matrix[row][end] == target) {
            return true;
        }
        return false;
        //此题还要注意因为是二维数组，start， end， mid都用index会写起来比较少cornercase
        //此种写法cover到了只有一行，一列，一个element，比最大大和比最小小的边界情况
    }
}
