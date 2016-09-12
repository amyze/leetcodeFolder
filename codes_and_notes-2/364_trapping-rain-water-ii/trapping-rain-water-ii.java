/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/trapping-rain-water-ii
@Language: Java
@Datetime: 16-09-07 17:13
*/

public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    class Cell {
        public int x, y,h;
        Cell(int x, int y, int h){
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    public int trapRainWater(int[][] heights) {
       if (heights == null || heights.length ==0 ){
           return 0;
       }
       
       PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>()
       { public int compare(Cell a, Cell b) {
           return a.h- b.h;
        }});
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        // add left and right
        for(int i =0; i< m; i++){
            queue.add(new Cell(i, 0, heights[i][0]));
            queue.add(new Cell(i, n-1, heights[i][n-1]));
            visited[i][0] = true;
            visited[i][n-1] = true;
        }
        // add top and bottom
        for(int j =0; j<n ;j++){
            queue.add(new Cell(0, j, heights[0][j]));
            queue.add(new Cell(m-1, j, heights[m-1][j]));
            visited[0][j] = true;
            visited[m-1][j] = true;
        }
        int [] dx ={0,0,1,-1};
        int [] dy ={1,-1,0,0};
        int res =0;
        // search unvsited 
        while(!queue.isEmpty()){
            Cell cur = queue.poll();
            for(int k=0;k<4; k++){
                int nx = cur.x+ dx[k];
                int ny = cur.y+ dy[k];
                if(nx>0&& nx<(m-1)&& ny>0 && ny< (n-1) && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    res += Math.max(0, cur.h-heights[nx][ny]);
                    queue.add(new Cell(nx, ny , Math.max(cur.h, heights[nx][ny])));
                }
            }
        }
        return res;
        
    }
};