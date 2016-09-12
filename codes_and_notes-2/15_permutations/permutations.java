/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/permutations
@Language: Java
@Datetime: 16-06-21 03:21
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
         if (nums == null || nums.size() == 0) {
             return rst; 
         }

         ArrayList<Integer> list = new ArrayList<Integer>();
         Integer[] num = new Integer[nums.size()];
         num= nums.toArray(num);
         helper(rst, list, num);
         return rst;
    }
    // the start here is alway from 0, so there is no meaning to have the 'start' index
    public void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list, Integer[] num){
        if(list.size() == num.length) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i<num.length; i++){
            // skip the duplicates
            if(list.contains(num[i])){
                continue;
            }
            list.add(num[i]);
            helper(rst, list, num);
            list.remove(list.size() - 1);
        }
        
    }
}
