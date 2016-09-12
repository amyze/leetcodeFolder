/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/kth-smallest-sum-in-two-sorted-arrays
@Language: Java
@Datetime: 16-09-01 01:08
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
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        if (A== null || A.length==0||B==null|| B.length==0){
            return 0;
        }
        int n = Math.min(A.length,k), m= Math.min(k,B.length);
        int [][]matrix = new int[n][m];
        for(int i=0; i< n;i++){
            for (int j=0;j<m;j++){
                matrix[i][j]= A[i]+B[j];
            }
        }
        PriorityQueue<Entry> pq = new PriorityQueue<>(n, new NumComparator() );
        for(int s=0;s<Math.min(matrix[0].length,k); s++){
            pq.add(new Entry(0,s,matrix[0][s]));
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