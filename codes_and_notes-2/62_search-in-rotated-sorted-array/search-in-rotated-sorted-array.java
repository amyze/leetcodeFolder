/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array
@Language: Java
@Datetime: 15-09-25 01:09
*/

public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
       if (A.length == 0|| A == null){
            return -1;
        }
        
        int start = 0;
        int end = A.length-1;
        while(start+1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] == target){
                return mid;
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
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1; // write your code here
    }
}

