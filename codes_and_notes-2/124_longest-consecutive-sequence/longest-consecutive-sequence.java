/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/longest-consecutive-sequence
@Language: Java
@Datetime: 16-07-01 21:15
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0){
            return 0;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0; i< num.length;i++){
            if (map.containsKey(num[i])) continue;
            if (map.containsKey(num[i]+1)){
                map.put(num[i], 1+map.get(num[i]+1));
            } else{
                map.put(num[i], 1);
            }
            while (map.containsKey(num[i]-1) ){
                map.put(num[i]-1, 1+map.get(num[i]));
                num[i]=num[i]-1;
            }
           
        }
        
        int max = 0;
        for(Integer val : map.values()){
            max = Math.max(max, val);
        }
         return max;
    }
}