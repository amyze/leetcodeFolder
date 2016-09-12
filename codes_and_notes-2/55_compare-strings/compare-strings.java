/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/compare-strings
@Language: Java
@Datetime: 16-05-27 03:48
*/

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        if (A == null || B ==null ||A.length() < B.length()) {
            return false;
        }
        HashMap<Character, Integer> temp = new HashMap<>();
        for (int i = 0; i< A.length(); i++) {
            char p = A.charAt(i);
            Integer fre = temp.get(p);
            if (fre == null){
                fre = 1;
            }else {
                fre ++;
            }
            temp.put(p, fre);
        }
        for (int i = 0; i< B.length(); i++) {
            char q = B.charAt(i);
            Integer fren = temp.get(q);
            if (!temp.containsKey(q) || fren ==0) {
                return false;
            } else {
                
                temp.put(q, --fren);
            }
        } return true;
    }
}