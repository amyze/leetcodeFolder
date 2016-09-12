/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/o1-check-power-of-2
@Language: Java
@Datetime: 16-06-01 01:42
*/

class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        if (n<1) {
            return false;
        } else {
            return (n&(n-1))==0;
        }
    }
};



// 除了考虑正整数之外，其他边界条件如小于等于0的整数也应考虑在内。在比较0和(n & (n - 1))的值时，需要用括号括起来避免优先级结合的问题。

// 2的整数幂若用二进制来表示，则其 中必只有一个1，其余全是0，那么怎么才能用一个式子把这种特殊的关系表示出来了？传统的位运算如按位与、按位或和按位异或等均无法直接求解，我就不卖关子了，比较下 x - 1和x的关系试试？以x=4为例。

// 0100 ==> 4
// 0011 ==> 3
// 两个数进行按位与就为0了！如果不是2的整数幂则无上述关系，反证法可证之。