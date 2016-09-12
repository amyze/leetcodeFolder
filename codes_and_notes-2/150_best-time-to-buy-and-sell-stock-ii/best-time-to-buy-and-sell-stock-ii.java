/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-ii
@Language: Java
@Datetime: 16-07-23 19:49
*/

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices== null|| prices.length <2 ) return 0;
        int i =0, rst =0;
        while (i<prices.length-1){
            if (prices[i]>prices[i+1]){
                i++;
            } else{
                int j = i;
                while ((i+1)<prices.length && prices[i]<=prices[i+1]  ){
                    i++;
                }
                rst += prices[i]- prices[j];
               
            }
            
        }
        return rst;
    }
};