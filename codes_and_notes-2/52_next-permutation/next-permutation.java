/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/next-permutation
@Language: Java
@Datetime: 16-06-02 22:25
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
     
      if(nums == null)
        return null;
      if (nums.length<2) return nums;
 
    int p=0;            
    for(int i=nums.length-2; i>=0; i--){
        if(nums[i]<nums[i+1]){
            p=i;
            break;
        }    
    }
 
    int q = 0;
    for(int i=nums.length-1; i>p; i--){
        if(nums[i]> nums[p]){
            q=i;
            break;
        }    
    }
 
    if(p==0 && q==0){
        reverse(nums, 0, nums.length-1);
        return nums;
    }
 
    int temp=nums[p];
    nums[p]=nums[q];
    nums[q]=temp;
 
    if(p<nums.length-1){
        reverse(nums, p+1, nums.length-1);
    } 
    
    return nums;
    }
    
    public void reverse(int[] nums, int left, int right){
    while(left<right){
        int temp = nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
        left++;
        right--;
    }
}
}

//http://www.programcreek.com/2014/06/leetcode-next-permutation-java/