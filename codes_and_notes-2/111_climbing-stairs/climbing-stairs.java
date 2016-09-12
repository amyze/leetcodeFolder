/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/climbing-stairs
@Language: Java
@Datetime: 15-10-03 23:48
*/

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        int[] tmp = new int[n];
        if (n < 2)   return 1;
        tmp[0] = 1;
        tmp[1] = 2;
        for (int i = 2; i < n; i++)
            tmp[i] = tmp[i-1] + tmp[i-2];
        return tmp[n-1];// write your code here
    }
}
