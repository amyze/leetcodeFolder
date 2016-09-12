/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/recover-rotated-sorted-array
@Language: Java
@Datetime: 15-09-16 15:18
*/

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // 此题三步：1.遍历找到index 2.对index前的部分reverse 3.对index天后
        //部分reverse 4.对整体reverse
        
        if (nums == null || nums.size() == 0){
            return ;
        }
        
        for (int index = 0; index < nums.size()-1; index++) {//
            if (nums.get(index) > nums.get(index+1)){       //如果程序中有index+1，
                                                    //主要边界为-1
                reverse(nums, 0, index);
                reverse(nums, index+1, nums.size()-1);
                reverse(nums, 0, nums.size()-1);
                return;
            }
        }
    }
     private void reverse(ArrayList<Integer> nums, int start, int end){
            while(start<end){
                int temp= nums.get(end);
                nums.set(end,nums.get(start));
                nums.set(start, temp);
                start++;
                end--;
            }//注意arraylist的set（index，value） get（Index） size（）方法
     }
}
