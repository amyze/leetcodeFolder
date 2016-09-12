/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/segment-tree-build
@Language: Java
@Datetime: 16-09-05 18:15
*/

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end) {
 *         this.start = start, this.end = end;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param start, end: Denote an segment / interval
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int start, int end) {
            if (start >end){
                return null;
            }
            else if (start == end){
                return new SegmentTreeNode(start, end);
            }else{
                SegmentTreeNode node = new SegmentTreeNode(start, end);
                node.left = build(start, (start+end)/2);
                node.right = build((start+end)/2+1,end);
                return node;
            }
    }
}