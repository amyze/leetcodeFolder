/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/subsets-ii
@Language: Java
@Datetime: 16-06-21 03:04
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (S == null)  return result;
        ArrayList<Integer> sub = new ArrayList<Integer>();
        //why not int[] here?
        Integer[] sets = new Integer[S.size()];
        sets = S.toArray(sets);
        Arrays.sort(sets);
        helper(sets, 0, result, sub);
        return result;
    }
    
    public void helper(Integer[] sets, int start, ArrayList<ArrayList<Integer>> result,
    ArrayList<Integer> sub ) {
        result.add(new ArrayList(sub));
        for (int i=start; i<sets.length;i++) {
            if (i!= start && (sets[i] ==sets[i-1])) {
                continue;
            }
            sub.add(sets[i]);
            helper(sets, i+1, result, sub);
            sub.remove(sub.size()-1);
        }
    }
}
