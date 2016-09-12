/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/subsets
@Language: Java
@Datetime: 16-06-21 02:25
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (nums == null) return result;
        ArrayList<Integer> com = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(nums, 0, result,com);
        return result;
    }
    
    public void helper (int[] nums, int start, 
     ArrayList<ArrayList<Integer>> result, ArrayList<Integer> com) {
         result.add(new ArrayList(com));
         
         for(int i= start; i< nums.length;i++) {
             com.add(nums[i]);
             helper(nums,i+1, result, com);
             com.remove(com.size()-1);
         }
     }
}