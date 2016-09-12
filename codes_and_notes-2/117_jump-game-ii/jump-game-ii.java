/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/jump-game-ii
@Language: Java
@Datetime: 16-07-16 22:49
*/

public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
         if (A.length == 0 || A.length == 1)
   return 0;
 int examingStart = 0;
 int currSectionCanReach = 0;
 int steps = 0;
 while (examingStart <= currSectionCanReach) {
   int examingEnd = currSectionCanReach;
   int nextSectionCanReach = examingStart;
   for (int i = examingStart; i <= examingEnd; i++) {
     nextSectionCanReach = Math.max(nextSectionCanReach, i + A[i]);
     if (nextSectionCanReach >= A.length - 1)
       return steps + 1;
   }
   examingStart = examingEnd + 1;
   currSectionCanReach = nextSectionCanReach;
   steps++;
 }
 return -1;
    }
}
