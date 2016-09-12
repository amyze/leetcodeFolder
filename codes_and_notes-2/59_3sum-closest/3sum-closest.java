/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/3sum-closest
@Language: Java
@Datetime: 16-05-29 03:28
*/

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] nums, int target) {
        int closet=0;
    if(nums==null) return closet;
    Arrays.sort(nums);
    for(int i=0; i<3 && i<nums.length; i++)   
    closet += nums[i];
    if(nums.length<=3) return closet;
    
    for(int i=0;i<nums.length-2;i++){
        int j=i+1;
        int k=nums.length-1;
        while(j<k){
        int sum= nums[i]+nums[j]+nums[k];
        if(Math.abs(sum-target)<Math.abs(closet-target)){
            closet=sum;
        if(sum==target)return sum;
        }
        if(sum>target)k--;
        else j++;
    }
    } return closet;
    }
}
