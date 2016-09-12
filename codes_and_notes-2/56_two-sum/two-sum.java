/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/two-sum
@Language: Java
@Datetime: 16-05-28 21:19
*/

public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        int [] result = new int[2];
       if (numbers == null || numbers.length == 0) {
           return result;
       }
       HashMap<Integer, Integer> temp = new HashMap<>();
       for (int i = 0; i < numbers.length; i++) {
           if (! temp.containsKey (numbers[i])) {
               temp.put (target-numbers[i], i);
           }else {
               result[0] = temp.get(numbers[i]) +1;
               result[1] = i+1;
               return result;
           }
       }
       return result;
    }
}