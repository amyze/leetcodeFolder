/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/kth-largest-element
@Language: Java
@Datetime: 16-08-10 22:20
*/

class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        if(nums== null || nums.length==0){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i =0; i<nums.length; i++){
            pq.add(nums[i]);
        }
        int size = nums.length-k;
        while(size>0){
            pq.poll();
            size--;
        }
        return pq.poll();
    }
};