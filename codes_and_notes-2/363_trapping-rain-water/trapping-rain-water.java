/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/trapping-rain-water
@Language: Java
@Datetime: 16-09-07 19:12
*/

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        if (heights == null | heights.length == 0){
            return 0;
        }
        int l = 0;
        int r = heights.length-1;
        int res =0;
        // cur low previous bar
        int leftH = heights[l];
        // cur low previous bar
        int rightH = heights[r];
        while(l<r){
            if (heights[l]<=heights[r]){
                l++;
                // cur bar is higher than next bar,means can trap water in next bar
                if(heights[l]<leftH){
                    res+= leftH- heights[l];
                }else{
                    leftH= heights[l];
                }
            }else{
                r--;
                if (heights[r]< rightH) {
                    res += rightH- heights[r];
                }else{
                    rightH = heights[r];
                }
            }
        }return res;
    }
}
//两个指针想内遍历，每次找到左右更低的边（因为至少能灌到这个高度），该边与同侧next
// bar作比较，更低则可以灌差值的水，更高则update bar的值（leftH，rightH ）