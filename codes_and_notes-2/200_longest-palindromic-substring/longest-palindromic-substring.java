/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/longest-palindromic-substring
@Language: Java
@Datetime: 15-10-18 20:53
*/

public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
       
    if(s == null || s.length()==0)
        return "";
     boolean [][]dp = new boolean[s.length()][s.length()];
        int maxlen=0;
        String res = "";
        /*
        if(s.length()==1) return s;
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1)){
                return s;
            }else return s.substring(0,1);
        }*/
        for(int i=0; i<=s.length()-1; i++){
            for(int j=i;j>=0;j--){
                if((s.charAt(i) == s.charAt(j)) &&((i-j<=2)||dp[j+1][i-1])){
                dp[j][i]= true;
                if(i-j+1>maxlen){
                maxlen=i-j+1;
                 res = s.substring(j,i+1); 
                }
                }
            }
        } return res;
   // Write your code here
    }
}
