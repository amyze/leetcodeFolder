/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/coins-in-a-line-ii
@Language: Java
@Datetime: 15-10-03 21:04
*/

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
       
       if(values.length <= 2)   return true;
       int [] max = new int[values.length+1];
       max[values.length]=0;
       max[values.length-1]=values[values.length-1];
       max[values.length-2]=values[values.length-2]+values[values.length-1];
       max[values.length-3]=values[values.length-3]+values[values.length-2];
       
       for (int i = values.length-4; i>=0;i--){
           max [i] = values[i]+ Math.min(max[i+2],max[i+3]);
           max [i] = Math.max (max[i], values[i]+values[i+1]+
           Math.min(max[i+3],max[i+4]));
       }   
       int sum = 0;
       for(int a : values)  sum += a;
       return max[0] > sum-max[0];
       
        /*
        if(values.length <= 2)   return true;
        int[] D = new int[values.length+1];

        D[values.length] = 0;  
        D[values.length-1] = values[values.length-1];
        D[values.length-2] = values[values.length-2] + values[values.length-1];
        D[values.length-3] = values[values.length-3] + values[values.length-2];

        for(int i=values.length-4; i>=0; i--) {
            D[i] = values[i] + Math.min(D[i+1+1], D[i+1+2]);
            D[i] = Math.max(D[i],values[i]+values[i+1]+Math.min(D[i+2+1], D[i+2+2]));
        }

        int sum = 0;
        for(int a : values)  sum += a;
        return D[0] > sum-D[0];
         */// write your code  here
    }
}
