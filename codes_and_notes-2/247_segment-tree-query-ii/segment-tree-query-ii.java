/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/segment-tree-query-ii
@Language: Java
@Datetime: 16-09-06 21:55
*/

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        if (root == null || start > end) {
            return 0;
        }
        if (root.start == start && root.end == end){
            return root.count;
        }
        if (end < root.start || start > root.end) {
    	    return 0;
    	}
    	if (start < root.start) {
    	    start = root.start;
    	}
        if (end > root.end) {
    	    end = root.end;
    	}
    	//注意这里是root的mid值
        int mid = (root.start+root.end)/2;
        
        if (end<= mid){
             return query(root.left, start,end);
        }else if(start>mid){
            return query(root.right, start,end);
        }else{
            int countL = query(root.left, start, root.left.end);
            int countR = query(root.right, root.right.start, end);
            return countL+countR;
        }
     
    }
}