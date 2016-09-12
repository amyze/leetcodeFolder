/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/partition-array
@Language: Java
@Datetime: 16-05-28 19:56
*/

public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length-1;
        
        while (true) {
            while ( start < nums.length && nums[start]< k ) {
                start++;
            }
            // System.out.println("start is" + start);
            while(  end >0 && nums[end]>= k) {
                end--;
            }  
            // System.out.println("end is" + end);
            //代表此时左右指针已交叉
            if (start >= end) {
                break;
            } else {
                swap (nums, start, end);
            }
            
       }
       
       return start;
    }
    private void swap (int[] arr, int num1, int num2) {
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }
}