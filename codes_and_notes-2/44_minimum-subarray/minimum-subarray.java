/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/minimum-subarray
@Language: Java
@Datetime: 16-07-22 03:45
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        if (nums == null)
            return 0;
        int len = nums.size();
        int min = Integer.MAX_VALUE, currSum = 0;
        int []localmin  = new int[len];
        int []globalmin = new int[len];
        for (int i = 0; i < len; i++) {
            if( i ==0 )
                globalmin[i] = localmin[i] = nums.get(i);
            else {
                localmin[i] = Math.min(localmin[i - 1] + nums.get(i), nums.get(i));
                globalmin[i] = Math.min(globalmin[i - 1], localmin[i]);
            }
            
        }
        return globalmin[len-1];
    }
}
