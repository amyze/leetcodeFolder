/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/merge-sorted-array
@Language: Java
@Datetime: 15-09-04 15:59
*/

class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if(A== null|| B== null) return;
        int index1= m-1;// 此题需要维护三个指针
        int index2= n-1;
        int len= m+n-1;
        
    while(index1>=0 && index2>=0) {  //此题从后往前扫是因为如果从前往后会覆盖掉还未处理的元素
    if(A[index1]<B[index2]){
        A[len--]= B[index2--];
    }else A[len--]= A[index1--];
    }
    
    while(index2>=0){
        A[len--]= B[index2--];
    } // write your code here
    }
}
