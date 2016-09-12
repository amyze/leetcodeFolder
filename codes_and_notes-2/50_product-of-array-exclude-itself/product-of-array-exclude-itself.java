/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/product-of-array-exclude-itself
@Language: Java
@Datetime: 16-05-28 02:46
*/

public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        long [] right = new long[A.size()];
        long[] left = new long[A.size()];
        ArrayList<Long> result = new ArrayList<>();
        
        if(A== null || A.size()==0 ||A.size()==1) {
            result.add((long)1);
            return result;
        }
        long startR  = 1;
        long startL  = 1;
        for (int i =0; i<A.size(); i++) {
            startR *= A.get(i);
            right[i] = startR;
            // System.out.println( ""+ startR);
        }
         for (int j = A.size()-1; j>=0; j--) {
            startL *= A.get(j);
            left[j] = startL;
            // System.out.println( ""+ startL);
        }
        result.add(left[1]);
        for(int k =1; k< A.size()-1; k++) {
            result.add(right[k-1] * left[k+1]);
        }
        result.add(right[A.size()-2]);
        return result;
    }
}
