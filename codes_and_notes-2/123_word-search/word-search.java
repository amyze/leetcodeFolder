/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/word-search
@Language: Java
@Datetime: 16-09-04 04:20
*/

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
         if (board == null || board.length == 0 
            ||  word == null || word.length() == 0) {
            return false;        
        }
        int height = board.length;
        int width = board[0].length;
        boolean[][] visited = new boolean[height][width];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) != board[i][j]) {
                    continue;
                }
                if (dfs(0, i, j, visited, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int index, int i,int j, boolean[][] visited,char[][]board,String word){
        //if reach the last char of word
        if (index == word.length()) return true;
        int height = board.length;
        int width = board[0].length;
        // if out of bound or visited or char not equal
        if(i<0||i>=height||
        j<0||j>=width||visited[i][j]||board[i][j]!= word.charAt(index)){
            return false;
        }
        visited[i][j]= true;
        int []dx ={0, 0, 1,-1};
        int []dy ={1, -1, 0, 0};
        for(int k=0;k<4;k++){
            if(dfs( index+1, i+dx[k], j+dy[k],visited, board, word)){
                return true;
            }
        }
        visited[i][j]= false;
        return false;
    }
}