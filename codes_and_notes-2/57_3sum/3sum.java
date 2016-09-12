/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/3sum
@Language: Java
@Datetime: 16-05-29 02:59
*/

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       if (numbers == null || numbers.length <3) {
          return result;
       }
       Arrays.sort(numbers);
       for (int i =0; i< numbers.length-2; i++){
           if (i >0 && numbers[i]== numbers[i-1]) {
               continue;
           }
           int j = i +1;
           int k = numbers.length-1;
           
           
           if ( numbers[i]+ numbers[j]+numbers[j+1]> 0 || numbers[i]+ numbers[k]+ numbers[k-1]< 0) {
               continue;
           }
           while (j<k) {
               
               if (numbers[i]+ numbers[j]+numbers[k]==0){
                  ArrayList<Integer> temp = new ArrayList<Integer>();
                  temp.add(numbers[i]);
                  temp.add(numbers[j]);
                  temp.add(numbers[k]);
                  result.add(temp);
                  j++;
                  k--;
                  while(j<k && numbers[j]==numbers[j-1]){
                    j++;
                  }
                  while(j<k && numbers[k]==numbers[k+1]){
                    k--;
                 }
               } else if (numbers[i]+ numbers[j]+numbers[k] <0) {
                   j++;
               } else {
                   k--;
               }
           }
       }
       return result;
    }
}