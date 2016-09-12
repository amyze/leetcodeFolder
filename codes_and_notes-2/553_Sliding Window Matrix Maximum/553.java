public class Solution {
    /**
     * @param matrix an integer array of n * m matrix
     * @param k an integer
     * @return the maximum number
     */
    public int maxSlidingWindow2(int[][] matrix, int k) {
       if(matrix == null) return 0;
       int m = matrix.length;
       if (m == 0|| m<k) return 0;
       int n = matrix[0].length;
       if(n ==0 || n<k) return 0;
       int [][]sum = new int[m+1][n+1];
       for(int i =0; i<n+1; i++){
           sum[0][i] =0;
       }
       for(int i =0; i<m+1; i++){
           sum[i][0] =0;
       }
       for(int i = 1; i< m+1 ; i++){
           for(int j=1;j<n+1;j++){
               sum[i][j]= sum[i-1][j]+sum[i][j-1]- sum[i-1][j-1]+matrix[i-1][j-1];
           }
       }
       int ans = Integer.MIN_VALUE;
       for(int i=k;i<m+1;i++){
           for(int j=k;j<n+1;j++){
               int val = sum[i][j]-sum[i-k][j]-sum[i][j-k]+sum[i-k][j-k];
               if(val > ans){
                   ans = val;
               }
           }
       }
       return ans;
    }
}
//类似于prefix的处理，先求sum
