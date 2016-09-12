/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers
@Language: Java
@Datetime: 16-08-08 00:05
*/

class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i =0; i< nums.length; i++) {
            if (pq.size()<k){
                pq.add(nums[i]);
                
            }else{
                if(nums[i]>pq.peek()){
                    pq.poll();
                    pq.add(nums[i]);
                   
                }
            }
        }
        int[] res = new int[pq.size()];
        
        for(int i=k-1;i>=0;i--){
            res[i]= pq.poll();
        }
        return res;
    }
};

