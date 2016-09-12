/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/longest-substring-with-at-most-k-distinct-characters
@Language: Java
@Datetime: 16-09-10 02:17
*/

public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
      int start = 0;  
    int maxLen = 0;  
  
    // Key: letter; value: the number of occurrences.  
    Map<Character, Integer> map = new HashMap<Character, Integer>();  
    int i;  
    for (i = 0; i < s.length(); ++i) {  
        char c = s.charAt(i);  
        if (map.containsKey(c)) {  
            map.put(c, map.get(c) + 1);  
        } else {  
            map.put(c, 1);  
            while (map.size() > k) {  
                char startChar = s.charAt(start++);  
                int count = map.get(startChar);  
                if (count > 1) {  
                    map.put(startChar, count - 1);  
                } else {  
                    map.remove(startChar);  
                }  
            }  
        }  
  
        maxLen = Math.max(maxLen, i - start + 1);  
    }  
  
    return maxLen;  
    }
}