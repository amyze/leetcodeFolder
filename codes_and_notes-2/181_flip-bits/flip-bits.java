/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/flip-bits
@Language: Java
@Datetime: 16-06-01 01:26
*/

class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
       //计算异或后的结果中有多少位1
       int count =0;
       for (int c = a ^ b; c != 0; c = c >>> 1) {
           if ((c&1) ==1) {
               count++;
           }
       } return count;
    }
};
