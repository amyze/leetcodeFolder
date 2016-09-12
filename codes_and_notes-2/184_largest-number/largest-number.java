/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/largest-number
@Language: Java
@Datetime: 16-06-02 19:17
*/

public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        if (num == null || num.length == 0) {
            return "";
        }
        String []num2 = new String[num.length];
        // change every element in num from int to string
        for(int i =0; i< num.length; i++) {
            num2[i] = ""+num[i];
        }
        // override the concompartor
        Comparator<String> com = new Comparator<String>(){
            public int compare(String s1, String s2) {
                String s1as2 = s1+s2;
                String s2as1 = s2+s1;
                return s2as1.compareTo(s1as2);
            }
            };
        Arrays.sort(num2, com);
        StringBuilder sb = new StringBuilder();
        for(String s: num2) {
            sb.append(s);
        }
        if (num2[0].equals("0")) return "0";
        return sb.toString();
    }
}