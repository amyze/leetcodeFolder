/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/segment-tree-query
@Language: Java
@Datetime: 16-09-05 21:52
*/

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
      
       int mid = (root.start+root.end)/2;
       // within the segment
       if(start==root.start&& end== root.end){
           return root.max;
       }
       // go left
       else if(end<= mid){
          
           return query(root.left, start, end);
       }else if(start>mid){
           
           return query(root.right, start, end);
       }else{
           int maxLeft =  query(root.left, start, root.left.end);
           int maxRight =  query(root.right, root.right.start, end);
           return Math.max(maxLeft, maxRight);
       }
    }
}