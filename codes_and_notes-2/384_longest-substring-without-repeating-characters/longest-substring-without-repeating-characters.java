/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/longest-substring-without-repeating-characters
@Language: Java
@Datetime: 16-09-09 21:53
*/

public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        
    	if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int head = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) + 1 > head) {//make sure head does not travel back
                    head = map.get(c) + 1;
                }
            }
            map.put(c, i);
            String str = s.substring(head, i + 1);
            max = Math.max(max, str.length());
        }
        return max;
    }
}