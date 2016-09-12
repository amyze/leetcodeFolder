/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/kth-largest-in-n-arrays
@Language: Java
@Datetime: 16-08-31 17:02
*/

public class Solution {
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        if(arrays == null || arrays.length == 0 ){
            return -1;
        }
        int m= arrays.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i=0;i<m;i++){
            if(arrays[i].length>0){
            for(int j=0;j<arrays[i].length;j++){
                if (pq.size()<k){
                    pq.add(arrays[i][j]);
                }else{
                   if(pq.peek()< arrays[i][j]){
                       pq.poll();
                       pq.add(arrays[i][j]);
                   }
                }
            }
        }
        }
       
        return pq.poll();
    }
}