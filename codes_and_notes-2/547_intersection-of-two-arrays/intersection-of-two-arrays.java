/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/intersection-of-two-arrays
@Language: Java
@Datetime: 16-07-22 02:24
*/

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // arraylist to array
        HashSet<Integer> set2 = new HashSet<>();
        
        if (nums1 == null || nums2== null) {
            return null;
        }
        int length1 = nums1.length;
        int length2 = nums2.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<length1;i++){
            set.add(nums1[i]);
        }
        for(int j=0;j<length2;j++){
            if(set.contains(nums2[j])){
                set2.add(nums2[j]);
            }
        }
        int size = set2.size();
        int[] rst = new int[size];
        int index=0;
        
        for(Integer num: set2){
            rst[index++]= num;
        }
        
        return rst;
        
    }
}