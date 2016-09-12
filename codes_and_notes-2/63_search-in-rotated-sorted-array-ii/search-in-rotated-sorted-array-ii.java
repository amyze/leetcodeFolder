/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 16-07-10 00:28
*/

public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        if (A.length == 0|| A == null){
            return false;
        }
        int i=0,j=A.length-1;
        while((i+1<A.length) && (A[i]==A[i+1])) {
            i++;
        }
        int start =i;
       
        while(j-1>0 && (A[j]==A[j-1])) {
            j--;
        }
        int end = j;
        while(start+1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] == target){
                return true;
            }
            if(A[start]< A[mid]){// NUMS[start]在这里是个turning point，分成了两段单调递增的线段；
                if(A[start]<=target && target<= A[mid]){//这里要加等号，ex[1,3,5] target=1
                    end = mid;
                }else{
                    start =mid;
                }
            }
            else{                                           //后半段线段
                if(A[mid]<=target && target<=A[end]){//这里要加等号，ex[5,1,3] target=3
                    start = mid;
                }else{
                    end =mid;
                }
            }
            
        }
        if (A[start] == target) {
            return true;
        }
        if (A[end] == target) {
            return true;
        }
        return false;
    }
}
