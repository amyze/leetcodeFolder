/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/sqrtx
@Language: Java
@Datetime: 16-05-30 02:21
*/

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        if (x ==1) {
            return 1;
        }
        long left = 0, right = x;
        while (left< right){
            long mid = left + (right- left)/2;
            if (mid*mid == x) {
                return (int)mid;
            } else if (mid * mid < x){
                
                if ((mid+1)* (mid+1) >x) {
                    return (int) mid;
                }else {
                    left=mid;
                }
            } else {
                right=mid;
            }
        }
        return 0;
    }
}
//注意这里如果用int的话会溢出