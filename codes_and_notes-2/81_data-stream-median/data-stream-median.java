/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/data-stream-median
@Language: Java
@Datetime: 16-09-07 23:24
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    
    public int[] medianII(int[] nums) {
       ArrayList<Integer> rst = new ArrayList<Integer>();
       int [] result = new int[nums.length];
        if (nums== null || nums.length ==0 ){
            return result;
        }
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(1,
        Collections.reverseOrder());
        
        max.add(nums[0]);
        rst.add(nums[0]);
        for(int i =1; i< nums.length; i++){
            add(nums[i]);
            rst.add(max.peek());
        }
        for(int i=0; i< rst.size(); i++){
            result[i]= rst.get(i);
        }
        return result;
    }
    public void add(int i){
        // 此题maxheap比minheap值多1， 所以优先考虑max的删除和添加
        int num = max.peek();
        if(i<= num){
            max.add(i);
        }else{
            min.add(i);
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