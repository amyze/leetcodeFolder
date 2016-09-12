/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/search-for-a-range
@Language: Java
@Datetime: 15-09-25 01:55
*/

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        //int[] result = {-1,-1};
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(A.size()==0){
        result.add(0,-1);
        result.add(1,-1);
        return result;
        }
        
        int left= 0;
        int right = A.size()-1;
        
        while(left<right){
            int mid =(left+right)/2;
            if(A.get(mid)>=target){
                right = mid;
            }else left = mid+1;
        }
        if(A.get(left)== target){
            result.add(0,left);
        }else {
            result.add(0,-1);
            result.add(1,-1);
            return result;
        }
        left =0;
        right= A.size()-1;
       
        while(left<right){
            int mid=(left+right+1)/2;
            if(A.get(mid)<= target){
                left= mid;
            }else right= mid-1;
        }
        
            result.add(1,right);
        
        return result;//二分法分别找左右边界// write your code here
    }
}

