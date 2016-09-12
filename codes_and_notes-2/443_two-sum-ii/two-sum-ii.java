/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/two-sum-ii
@Language: Java
@Datetime: 16-08-10 21:43
*/

public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // if(nums== null || nums.length==0) {
        //     return 0;
        // }
        // Arrays.sort(nums);
        // int l =0, r = nums.length-1;
        // while (l+1 <r) {
        //     if (nums[l]+nums[r] == target){
        //         while((l+1)<nums.length &&(nums[l+1]==nums[l])){
        //             l++;
        //         }
        //         if (l+1<nums.length) l++;
        //         if ((nums[l]+nums[r] > target) &&(l<r)){
        //             return (r-l)*(r-l-1)/2;
        //         }
        //     }else if (nums[l]+nums[r] > target){
        //         return (r-l)*(r-l-1)/2;
        //     }else {
        //         l++;
        //     }
        // }
        // if ((nums[l]+nums[r] > target)&&(l<r)) {
        //     return 1;
        // }else{
        //     return 0;
        // }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int ans = 0;
        while(left < right) {
            if(nums[left] + nums[right] > target) {
                ans = ans + (right - left);
                right --;
            } else {
                left ++;
            }
        }
        return ans;
    }
}