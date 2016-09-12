/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/remove-element
@Language: Java
@Datetime: 16-05-27 20:11
*/

public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        //length = 0
        if(A == null || A.length ==0) {
            return 0;
        }
        
        int preIndex =0;
        int curIndex =0;
        for(int i=0; i<A.length; i++){
            if (A[curIndex]== elem){
                curIndex++;
            }else {
               A[preIndex] = A[curIndex];
               preIndex++;
               curIndex++;
            }
        }
        return preIndex;
    
    
    }
}