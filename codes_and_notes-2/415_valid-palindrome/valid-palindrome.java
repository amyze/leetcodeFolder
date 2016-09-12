/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/valid-palindrome
@Language: Java
@Datetime: 16-09-11 20:48
*/

public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s == null )
            return false;
        if (s.length() <2){
            return true;
        }
        int l=0,r = s.length()-1;
        while(l<r){
            while (l < s.length() && !isvalid(s.charAt(l))){ 
                l++;
            }
            if (l == s.length()) {     
                return true; 
            }           

            while (r >= 0 && ! isvalid(s.charAt(r))) { 
                r--;
            }

            if(Character.toLowerCase(s.charAt(l))!= Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return r<=l;
    }
    private boolean isvalid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}