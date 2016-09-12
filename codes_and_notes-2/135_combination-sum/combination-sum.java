/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/combination-sum
@Language: Java
@Datetime: 16-06-21 02:04
*/

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> com = new ArrayList<Integer>();
        if (candidates == null) return result;
        Arrays.sort(candidates);
        helper(candidates, target, 0, result, com);
        return result;
    }
    
    public void helper(int[] candidates, int target, int start,List<List<Integer>> result,
    List<Integer> com) {
        if ( target ==0){
            result.add(new ArrayList(com));
            return;
        }
        for (int i = start; i< candidates.length; i++){
            if (candidates[i] > target) break;
            com.add(candidates[i]);
            helper(candidates, target-candidates[i],i,result, com);
            com.remove(com.size()-1);
        }
    }
}