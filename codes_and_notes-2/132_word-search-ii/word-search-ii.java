/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/word-search-ii
@Language: Java
@Datetime: 16-09-05 02:50
*/

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    class TrieNode {
    String str;
    boolean isEnd;
    boolean visited;
    HashMap<Character, TrieNode> children;
    public TrieNode () {
      this.isEnd = false;
      this.str = "";
      children = new HashMap<Character, TrieNode>();
    }
  }
    public TrieNode root;
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> rst = new ArrayList<>();
        if (board== null|| board.length==0||words==null|| words.size()==0){
            return rst;
        }
        // build trietree 
        root = new TrieNode();
        for(String s: words){
            insert(s);
        }
        // visited array
        int row = board.length;
        int col = board[0].length;
        boolean [][]visited = new boolean[row][col];
        // call dfs in 2D array
        for (int i=0;i<row; i++){
            for(int j=0; j<col; j++){
                dfs(rst,"", i, j, visited, board);
            }
        }
        return rst;
    }
    // 4 direction DFS
    public void dfs(List<String> rst, String s, int x, int y, boolean[][] visited, char[][] board) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (visited[x][y]) {
            return;
        }
        s += board[x][y];
        if (!startWith(s)) {
            return;
        }
        
        if (search(s)) {
            rst.add(s);
        }
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(rst, s, nx, ny, visited, board);
        }
        visited[x][y] = false;
    }
    
    /**************************Trie section *********************/
    // insert
    public void insert (String s){
      
      TrieNode node = root;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (!node.children.containsKey(c)) {
          node.children.put(c, new TrieNode());
        }
        node = node.children.get(c);
        if (i == s.length() - 1) {
          node.isEnd = true;
          node.str = s;
        }
      }
    }
    // search
    public boolean search(String s) {
      
      TrieNode node = root;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (!node.children.containsKey(c)) {
          return false;
        }
        node = node.children.get(c);
      }
      if (node.visited||!node.isEnd) {
          return false;
      }
      node.visited= true;
      return true;
    }
    // startwith
    public boolean startWith(String s) {
      char[] arr = s.toCharArray();
      TrieNode node = root;
      for (int i = 0; i < arr.length; i++) {
        char c = arr[i];
        if (!node.children.containsKey(c)) {
          return false;
        }
        node = node.children.get(c);
      }
      return true;
    }
}