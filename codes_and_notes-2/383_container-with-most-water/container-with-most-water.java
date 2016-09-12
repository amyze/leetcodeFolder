/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/container-with-most-water
@Language: Java
@Datetime: 16-09-08 22:13
*/

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        if (heights == null || heights.length == 0) {
    		return 0;
    	}
    	int left = 0;
    	int right = heights.length - 1;
    	int maxWater = Integer.MIN_VALUE;
    	while (left < right) {
    		maxWater = Math.max(maxWater, (right-left) * (heights[left] < heights[right] ? heights[left] : heights[right]));
    		if (heights[left] < heights[right]) {
    			left++;
    		} else {
    			right--;
    		}
    	}
    	return maxWater;// write your code here
    }
}
//这题是choose any two bars