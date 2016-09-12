/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/minimum-window-substring
@Language: Java
@Datetime: 16-09-11 05:28
*/

public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        if (source == null || target == null ||source.length()== 0
           || target.length()== 0){
            return "";
        }
        HashMap<Character, Integer> tmap = new HashMap<>();
        // create a map for taraget
        for(int i = 0; i< target.length() ; i++) {
            char c = target.charAt(i);
            if (!tmap.containsKey(c)){
                tmap.put(c,1);
            }else{
                int fre = tmap.get(c);
                tmap.put(c,fre+1);
            }
        }
        //interate the source string
        int  r=0;
        String rst = "";
        int ans = Integer.MAX_VALUE;
        HashMap<Character, Integer> smap = new HashMap<>();
        for(int i = 0; i< source.length(); i++) {
            while (r<source.length() &&!isValid(smap, tmap)){
                char s = source.charAt(r);
                if (smap.containsKey(s)){
                    smap.put(s, smap.get(s)+1);
                }else{
                    smap.put(s,1);
                }
                if(r<source.length() )
                    r++;
                else
                    break;
                
            }
            if (isValid(smap, tmap)){
                
                    
                    if (ans> r-i){
                        ans = Math.min(ans,r-i);
                    rst = source.substring(i, r);
                    }
                    
                }
            // move i
            
            char scur = source.charAt(i);
            int sfre = smap.get(scur);
            if (sfre == 1){
                smap.remove(scur);
            }else{
                smap.put(scur, sfre-1);
            }
        }return rst;
    }
    
    public boolean isValid(HashMap<Character, Integer>a,HashMap<Character, Integer>b){
        for (char c: b.keySet()){
            if (!a.containsKey(c)|| a.get(c)< b.get(c)){
                return false;
            }
        }
        return true;
    }
}