/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iii
@Language: Java
@Datetime: 16-07-23 21:17
*/

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        //  if (prices== null|| prices.length <2 ) return 0;
        //  int i = 0;
        //  PriorityQueue<Integer> pq = new PriorityQueue<>();
        //  while ((i+1)< prices.length) {
        //      if (prices[i]>prices[i+1]){
        //         i++;
        //      } else{
        //         int j = i;
        //         while ((i+1)<prices.length && prices[i]<=prices[i+1]  ){
        //             i++;
        //         }
        //         int offset = prices[i]- prices[j];
        //         if(pq.size() <2) {
        //           pq.add(offset); 
        //         }else{
        //             if(offset>pq.peek()){
        //                 pq.poll();
        //                 pq.add(offset);
        //             }
        //         }
        //   }
        //  }
        //  int rst =0;
        //  while(pq.size()>0){
        //     rst+= pq.poll(); 
        //  }
         
        // return rst;
        if (prices.length < 2) return 0;
        
        int n = prices.length;
        int[] preProfit = new int[n];
        int[] postProfit = new int[n];
        
        int curMin = prices[0];
        for (int i = 1; i < n; i++) {
            curMin = Math.min(curMin, prices[i]);
            preProfit[i] = Math.max(preProfit[i - 1], prices[i] - curMin);
        }
        
        int curMax = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            curMax = Math.max(curMax, prices[i]);
            postProfit[i] = Math.max(postProfit[i + 1], curMax - prices[i]);
        }
        
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, preProfit[i] + postProfit[i]);
        }
        
        return  maxProfit;
    }
};