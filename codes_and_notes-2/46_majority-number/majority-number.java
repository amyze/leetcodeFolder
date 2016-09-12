/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/majority-number
@Language: Java
@Datetime: 16-06-01 23:41
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        Collections.sort(nums);
        return nums.get(nums.size()/2);// write your code
    }
}

