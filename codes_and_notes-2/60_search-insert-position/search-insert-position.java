/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/search-insert-position
@Language: Java
@Datetime: 15-09-16 14:16
*/

public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        if(A.length == 0 || A == null){
            return 0;
        }
        
    
        int start = 0;
        int end = A.length-1;
        
        while(start +1 < end){
            int mid = start +(end - start)/2;
            if(A[mid] == target){
                return mid;
            }
            if( A[mid] < target){
                start = mid;
            
            }else end= mid;
        }
        
        if(A[start] >= target ){
            return start; // 考虑了start=第一个元素（一直挪end）
        }else if(A[end ]>= target){
            return end;  //考虑了target=最后一个元素（一直在挪start）及start和
                        //end都挪动的general的情况
        }else return end+1;//考虑了target 大于最后一个元素的情况
        
    }
}

