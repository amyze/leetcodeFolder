/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/sliding-window-maximum
@Language: Java
@Datetime: 16-09-08 02:58
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        if (nums == null || nums.length == 0) {
           return ans; 
        }
        // process the first k element
        for(int i = 0; i < k ; i ++){
            inQueue(queue, nums[i]);
        }
        ans.add(queue.peekFirst());
        for(int i = k; i< nums.length; i++) {
            inQueue(queue, nums[i]);
            outQueue(queue, nums[i-k]);
            ans.add(queue.peekFirst());
        }
        return ans;
    }
    public void inQueue(Deque<Integer> queue, int val) {
        while(!queue.isEmpty() && queue.peekLast()< val){
            queue.pollLast();
        }
        queue.offerLast(val);
    }
    
    public void outQueue(Deque<Integer> queue, int val) {
        if(!queue.isEmpty() && queue.peekFirst()== val){
            queue.pollFirst();
        }
    }
}
