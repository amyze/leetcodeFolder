/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/longest-common-substring
@Language: Java
@Datetime: 15-09-29 01:27
*/

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        
        int Alen = A.length();
        int Blen = B.length();
        if( A == null || B == null || Alen == 0 || Blen == 0)
            return 0;
        int maxlen = 0;
        for (int i = 0; i < Alen; i++)
        {
            for (int j =0; j < Blen; j++)
            {
                int pluslen = 0;
                while( i + pluslen < Alen && j + pluslen < Blen &&
                A.charAt(i + pluslen) == B.charAt(j + pluslen))
                {
                    pluslen ++;
                    
                } 
                if( pluslen > maxlen)
                        maxlen = pluslen;
                
            }
           
        } return maxlen;
       /* 
        如 A B C D E F G M
           B C D B C D E F
        对于每个i 需遍历一次j，其中如i=1时，j 中有多个对应，所以每个i都需遍历完
        第二个序列，对每个i更新一次对应在B中的最大相同序列，pluslen中存的是每个
        子重复序列如BCD BCDEF,每次发现更大的plus时都需要更新maxlen
        
        */
       /*
       int maxlen = 0;
        int xlen = A.length();
        int ylen = B.length();
        for(int i = 0; i < xlen; ++i)
	    {
		    for(int j = 0; j < ylen; ++j)
		    {
			    int len = 0;
                while (i + len < xlen && j + len < ylen && 
                    A.charAt(i + len) == B.charAt(j + len))
                        len ++;
			    if(len > maxlen)
				    maxlen = len;
		    }
	    }
        return maxlen;
        */// write your code here
    }
}
