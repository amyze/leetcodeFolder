/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/combinations
@Language: Java
@Datetime: 16-06-21 00:28
*/

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
     
     
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> com = new ArrayList<Integer>();
		
		helper (n, k, result,com,1);
		return result;
    }
    
    public void helper(int n, int k, List<List<Integer>> result, List<Integer>com, int start) {
      
        if (com.size()==k) {
            result.add (new ArrayList(com));
            return;
        }
        for (int i=start; i<= n;i++) {
          com.add(i);
          helper(n, k, result,com, i+1);
          com.remove(com.size()-1);
        }
    }
}