/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/word-break
@Language: Java
@Datetime: 16-07-01 03:50
*/

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
    //     if (s.length()==0) return true;
    //     for (int i=1; i<=s.length(); i++){
    //         String prefix = s.substring(0,i);
    //         String rest = s.substring(i);
    //         if (isContain(prefix, dict) && wordBreak(rest,dict)) {
    //             return true;
    //         }
    //     }
    //      return false;
    // }
    
    // public boolean isContain(String s, Set<String>dic) {
    //     if(s== null || s.length()==0) return false;
    //     return dic.contains(s);
    // } 
    // recursive 93% pass; space complexity is too high
    
    // if (s== null || s.length()==0) return true;
    // boolean[] dp = new boolean[s.length()+1];
    // dp[0] = true;
    // for(int i=0;i<s.length();i++){
    //     for (int j=0;j<=i;j++){
    //         if (dp[j]&&dict.contains(s.substring(j,i+1))) {
    //         dp[i+1]= true;
    //         break;
    //         }
    //     }
    // }
    // return dp[s.length()];
      if (s == null || s.length() == 0) {
            return true;
        }

        int maxLength = getMaxLength(dict);
        boolean[] canSegment = new boolean[s.length() + 1];

        canSegment[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            for (int lastWordLength = 1;
                     lastWordLength <= maxLength && lastWordLength <= i;
                     lastWordLength++) {
                if (!canSegment[i - lastWordLength]) {
                    continue;
                }
                String word = s.substring(i - lastWordLength, i);
                if (dict.contains(word)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }

        return canSegment[s.length()];
} 
private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }

}