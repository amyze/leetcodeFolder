/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/sliding-window-median
@Language: Java
@Datetime: 16-09-07 22:49
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (nums== null || nums.length ==0 ){
            return rst;
        }
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(1,
        Collections.reverseOrder());
        
        max.add(nums[0]);
        for(int i =1;i< k; i++){
            add(nums[i]);
        }
        rst.add(max.peek());
        for(int j =k ; j<nums.length; j++){
            add(nums[j]);
            remove(nums[j-k]);
            rst.add(max.peek());
        }
        return rst;
    }
    
    public void add(int i){
        int num = max.peek();
        if(i<= num){
            max.add(i);
        }else{
            min.add(i);
        }
        balance();
    }
    
    public void remove(int i){
        int num = max.peek();
        if(i<= num){
            max.remove(i);
        }else{
            min.remove(i);
        }
        balance();
    }
    public void balance(){
        if(max.size()> min.size()+1){
            min.add(max.poll());
        }else if(max.size()< min.size()){
            max.add(min.poll());
        }
            
    }
}
