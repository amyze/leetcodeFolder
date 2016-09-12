/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/ugly-number-ii
@Language: Java
@Datetime: 16-07-03 17:05
*/

class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    private static int result =0;
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
       ArrayList<Integer> list = new ArrayList<Integer>();
       list.add(1);
        int i1= 0,i2=0,i3=0;
        
        
        while (list.size()<n){
      
          result = Math.min(list.get(i1)*2, Math.min(list.get(i2)*3, 
          list.get(i3)*5));
          list.add(result);
          if (result == list.get(i1)*2) {
              i1++;
          }
           if (result == list.get(i2)*3) {
              i2++;
          }
           if (result == list.get(i3)*5) {
              i3++;
          }
         
        }
        return result;
    }
};
//我们可以发现每个子列表都是一个丑陋数分别乘以2,3,5，而要求的丑陋数就是从已经生成的序列中取出来的，我们每次都从三个列表中取出当前最小的那个加入序列
