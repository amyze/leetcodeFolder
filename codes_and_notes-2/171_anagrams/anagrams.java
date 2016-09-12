/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/anagrams
@Language: Java
@Datetime: 16-05-27 15:34
*/

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        HashMap<Integer, ArrayList<String>> temp = new HashMap<>();
        
        for(String s : strs) {
            int [] letters = new int[26];
            for(int i =0; i<s.length(); i++) {
                letters[s.charAt(i) - 'a'] ++;
            }
        
        Integer hashVal = getHash(letters);
            if(!temp.containsKey(hashVal)) {
                ArrayList<String> anagram = new ArrayList<String>();
                anagram.add(s);
                temp.put(hashVal, anagram);
             }else {
                temp.get(hashVal).add(s);
            }
        }
        for(ArrayList<String> a : temp.values()) {
            if (a.size()>1) {
                result.addAll(a);
            }
        }
        return result;
    
    }
    private Integer getHash(int[] str) {
        int a = 378551;
        int b = 63689;
        Integer hash = 0;
        for (Integer num : str) {
            hash = hash * a + num;
            a = a*b;
        }
        return hash;
    }
}