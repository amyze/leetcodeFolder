/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/strstr
@Language: Java
@Datetime: 15-09-07 15:23
*/

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null ) {
            return -1;
        }
        if (target.length() > source.length()){
            return -1;
        }
        for (int i = 0; i <= source.length() - target.length(); i++){
            boolean successFLAG = true;
            for (int j = 0; j < target.length(); j++){
                if (source.charAt(i + j) != target.charAt(j)){
                    successFLAG = false;
                    break;
                }
            }   
            if (successFLAG){
                return i;
            }
        } return -1;
        //write your code here
    }
}
