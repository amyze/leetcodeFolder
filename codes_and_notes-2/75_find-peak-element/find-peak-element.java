/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/find-peak-element
@Language: Java
@Datetime: 15-09-24 21:12
*/

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        
        int low = 0;
        int high = A.length-1;
        while(low < high){
            int mid = low+(high-low)/2;
            if(A[mid]< A[mid+1] ){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        
        return low;// write your code here
    }
    
}

