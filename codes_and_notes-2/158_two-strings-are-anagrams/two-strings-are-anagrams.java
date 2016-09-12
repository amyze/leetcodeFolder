/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/two-strings-are-anagrams
@Language: Java
@Datetime: 16-05-26 15:33
*/

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
       
        if (s == null || t == null || s.length()!= t.length()) {
            return false;
        }
         // create a hashmap
        HashMap<Character, Integer> temp = new HashMap<>();
        for ( int i=0; i< s.length(); i++) {
            char q = s.charAt(i);
            Integer fre = temp.get(q);
            if(fre == null) {
                fre = 1;
            } else {
                fre++;
            }
            temp.put(q, fre);
        }
        //delete element in hashmap
        for(int i=0; i< t.length(); i++) {
            char p = t.charAt(i);
         if (!temp.containsKey(p))  {
             return false;
         } else {
             if (temp.get(p) > 1){
                 temp.put (p, temp.get(p)-1);
             }else{
                 temp.remove(p);
             }
         }
        }
        
        if (temp.size() ==0) {
            return true;
        }else return false;
    }
};