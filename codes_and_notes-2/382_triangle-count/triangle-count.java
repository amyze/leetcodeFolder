/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/triangle-count
@Language: Java
@Datetime: 16-09-01 01:56
*/

public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        if (S==null || S.length <3) {
            return 0;
        }
        Arrays.sort(S);
        int result =0;
        for(int end = S.length-1; end>1;end--){
             int start=0; int mid = end-1;
            while(start<mid){
               
                if(S[start]+S[mid]<=S[end]){
                    start++;
                }else{
                    result+=mid-start;
                    mid--;
                }
            }
        }
        return result;
    }
}
