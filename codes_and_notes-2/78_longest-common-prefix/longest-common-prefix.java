/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/longest-common-prefix
@Language: Java
@Datetime: 16-05-27 18:45
*/

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
       StringBuilder sb = new StringBuilder();
       if (strs == null || strs.length==0) {
           return sb.toString();
       }
    //   HashSet<Character> resultSet = new HashSet<>();
       for(int j = 0; j<strs[0].length();j++) {
           char q = strs[0].charAt(j);
            for (int i=1; i<strs.length;i++) {
                String s = strs[i];
                if(s.length()==0) {
                    return sb.toString();
                }
                    char p = s.charAt(j);
                    if(!(p==q)) {
                        return sb.toString();
                    }
            }
            sb.append(q);
       }
       return sb.toString();
       
    }
}