/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/gas-station
@Language: Java
@Datetime: 16-06-02 15:14
*/

public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
    //   if ( gas == null || cost == null ) return 0;
    //   if ( gas.length == 0 || cost.length == 0 ) return 0;
    //   int curGas = 0,i = 0;
    //   for (int start = 0; start < gas.length; start ++) {
    //       int count = gas.length;
    //       for (int cur = start; count >0; cur++,count--) {
            
    //          i = cur % gas.length;
    //             if (curGas + gas[i]- cost[i] < 0) {
    //                 curGas =0;
    //                 break;
    //             }else {
    //                 curGas+=(gas[i]- cost[i]);
    //             }
    //       }
    //       if (count ==0) {
    //           return start;
    //       }
    //   }
       
    //   return -1;
    int i = 0, j = 0;
    int sum = 0;
    int total = 0;
    while (j < gas.length) {
        int diff = gas[j] - cost[j];
        if (sum + diff < 0) {
            i = j + 1;
            sum = 0;
        } else {
            sum += diff;
        }
        j++;
        total += diff;
    }
    return total >= 0 ? i : -1;
       
    }
}