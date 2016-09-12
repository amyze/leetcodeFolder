/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/subarray-sum
@Language: Java
@Datetime: 16-05-27 21:43
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        HashMap<Integer, Integer> mapping = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        mapping.put(0,-1);
        int sum = 0;
        Integer start=0;
        Integer end=0;
        for (int i=0; i< nums.length; i++) {
            sum+=nums[i];
            
                if (mapping.containsKey(sum)) {
                    start = mapping.get(sum)+1;
                    end = i;
                    result.add(start);
                    result.add(end);
                    return result;
                } else {
                    mapping.put(sum, i) ;
                }
            
        }
        result.add(0);
        result.add(0);
        return result;
    }
}