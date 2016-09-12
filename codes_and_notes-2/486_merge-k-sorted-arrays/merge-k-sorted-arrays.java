/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-arrays
@Language: Java
@Datetime: 16-08-10 17:27
*/

public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    class Element {
    public int row, col, val;
    Element(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
private Comparator<Element> ElementComparator = new Comparator<Element>() {
        public int compare(Element left, Element right) {
            return left.val - right.val;
        }
    };

    public List<Integer> mergekSortedArrays(int[][] arrays) {
        
      
    
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
   
        if (arrays == null) {
            return null;
        }
        
        int total_size = 0;
        Queue<Element> Q = new PriorityQueue<Element>(
            arrays.length, ElementComparator);
            
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                Element elem = new Element(i, 0, arrays[i][0]);
                Q.add(elem);
                total_size += arrays[i].length;
            }
        }
        
        int[] result = new int[total_size];
        int index = 0;
        while (!Q.isEmpty()) {
            Element elem = Q.poll();
            result[index++] = elem.val;
            if (elem.col + 1 < arrays[elem.row].length) {
                elem.col += 1;
                elem.val = arrays[elem.row][elem.col];
                Q.add(elem);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i< result.length; i++){
            res.add(result[i]);
        }
        return res;
    }  // Write your code here
    

}