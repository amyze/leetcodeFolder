/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/update-bits
@Language: Java
@Datetime: 16-06-01 17:24
*/

class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        int mask = (j < 31 ? (~((1 << (j + 1)) - (1 << i))) : ((1 << i) - 1));
        return (m << i) | (mask & n);
    }
}

// N=(10000000000)2  M=(10101)2 即N=1024,将其表示成32位的形式，即在前面补0得到N=(00000000 00000000 00000100 00000000)2  M=(00000000 00000000 00000000 00010101)2。Update之后N=(10001010100)2，即N=(00000000 00000000 00000000 00000100 01010100)2。其中加粗的部分即M。与Update之前的N对比，可以发现，除了i到j这一部分，其他部分与原数据相同。

// 由位运算的性质可知，要保留一个数不变，需要与1做与运算，而变成M的部分可以先将该部分变成0，然后再与M做或运算，或者直接将M移位后做加法。

