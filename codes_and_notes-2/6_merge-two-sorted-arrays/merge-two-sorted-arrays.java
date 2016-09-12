/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/merge-two-sorted-arrays
@Language: Java
@Datetime: 16-07-22 23:47
*/

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        if(A== null || A.length == 0){
            return B;
        }
        if(B== null || B.length == 0){
            return A;
        }
        int[] rst = new int[A.length+B.length];
        int i=0,j=0,k=0;
        while(i<A.length &&j <B.length){
            if (A[i]<=B[j]) {
                rst[k]= A[i];
                i++;
                k++;
            }else{
                rst[k] = B[j];
                j++;
                k++;
            }
        }
        if (i<A.length){
            for (int n =i;n<A.length;n++){
                rst[k]= A[n];
                k++;
               
            }
        }
         if (j<B.length){
            for (int m =j;m<B.length;m++){
                rst[k]= B[m];
                k++;
               
            }
        }
        return rst;
    }
}