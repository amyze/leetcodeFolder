/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/kth-smallest-number-in-sorted-matrix
@Language: Java
@Datetime: 16-08-31 20:49
*/

 class Entry {
        public int row;
        public int col;
        public int val;
        public Entry(int row, int col,int val){
          this.row = row;
          this.col = col;
          this.val = val;
        }
    }
class NumComparator implements Comparator<Entry> {
            public int compare(Entry a, Entry b) {
                return a.val - b.val;
            }
       }
public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix== null || matrix.length==0 || k<0){
            return 0;
        }
        int n= matrix[0].length;
        PriorityQueue<Entry> pq = new PriorityQueue<>(n, new NumComparator() );
        for(int i=0;i<matrix[0].length; i++){
            pq.add(new Entry(0,i,matrix[0][i]));
        }
        while(k>1){
        Entry temp = pq.poll();
        int r = temp.row;
        int c = temp.col;
        if(r<matrix.length-1){
            pq.add(new Entry(r+1,c,matrix[r+1][c]));
        }
        k--;
        }
        return pq.poll().val;
    }
}

// 利用heap,先对第一行所有元素加入heap,每个元素下面同一列的元素必然比他们大
// 重复K-1次下面的过程
// 取现在的root
// 将root下面的元素加入heap
