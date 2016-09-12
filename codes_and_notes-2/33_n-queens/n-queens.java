/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/n-queens
@Language: Java
@Datetime: 16-06-24 02:34
*/

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (n <= 0) {
            return result;
        }
        search(n, new ArrayList<Integer>(), result);
        return result;
    }
    private void search(int n, ArrayList<Integer> cols, ArrayList<ArrayList<String>> result) {
        if (cols.size() == n) {
            result.add(drawChessboard(cols));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (!isValid(cols, col)) {
                continue;
            }
            cols.add(col);
            search(n, cols, result);
            cols.remove(cols.size() - 1);
        }
    }
    private boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            // same column
            if (cols.get(i)== col)  {
                return false;
            }
            // left-top to right-bottom
            if (i - cols.get(i) == row - col) {
                return false;
            }
            // right-top to left-bottom
            if (i + cols.get(i) == row + col) {
                return false;
            }
        }
        return true;
    }
    private ArrayList<String> drawChessboard(ArrayList<Integer> cols) {
        String[] chessboard = new String[cols.size()];
        ArrayList<String> chessboard2 = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            chessboard[i] = "";
            for (int j = 0; j < cols.size(); j++) {
                if (j == cols.get(i)) {
                    chessboard[i] += "Q";
                } else {
                    chessboard[i] += ".";
                }
            }
        }
        for(String s: chessboard){
            chessboard2.add(s);
        }
        return chessboard2;
    }
};