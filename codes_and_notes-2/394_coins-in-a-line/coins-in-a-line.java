/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/coins-in-a-line
@Language: Java
@Datetime: 15-10-03 18:52
*/

public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        return n%3 !=0;// write your code here
    }
}
