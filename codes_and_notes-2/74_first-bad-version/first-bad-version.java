/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/first-bad-version
@Language: Java
@Datetime: 15-09-24 23:52
*/

/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        int low=1;
        int high=n;
        while(low+1 < high){
            int mid = low +(high-low)/2;
            if(VersionControl.isBadVersion(mid)){
                high = mid;
            }else{
                low = mid;
            }
        }
        if (VersionControl.isBadVersion(1)) {//考虑只有2个元素的边界情况
            return 1;
        }else return high; // write your code here
    }
}

