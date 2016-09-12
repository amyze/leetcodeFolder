/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/segment-tree-build-ii
@Language: Java
@Datetime: 16-09-06 01:16
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
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        
        return buildHelper(0, A.length - 1, A);
    }
    
    public SegmentTreeNode buildHelper(int start, int end, int[] A) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new SegmentTreeNode(start, end, A[end]);
        }
        
        SegmentTreeNode leftChild = buildHelper(start, (start + end)/2, A);
        SegmentTreeNode rightChild  = buildHelper((start + end)/2 + 1, end, A);

        SegmentTreeNode node = new SegmentTreeNode(start, end, Math.max(leftChild.max, rightChild.max));
        node.left = leftChild;
        node.right = rightChild;
        return node;
    }
}