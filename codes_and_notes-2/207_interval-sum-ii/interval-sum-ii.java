/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/interval-sum-ii
@Language: Java
@Datetime: 16-09-07 03:10
*/

public class Solution {
    /* you may need to use some attributes here */
    

    /**
     * @param A: An integer array
     */
    class SegmentSumTreeNode {
		int start,end;
		long sum;
		SegmentSumTreeNode left,right;
		public SegmentSumTreeNode(int start, int end, long sum){
			this.start = start;
			this.end = end;
			this.sum = sum;
			this.left = null;
			this.right = null;
		}
	}
	// build in post order
	public SegmentSumTreeNode build(int start, int end, int[] A) {
		if (start == end) {
			return new SegmentSumTreeNode(start, end, A[start]);
		}
		int mid = (start + end)/2;
		SegmentSumTreeNode left = build(start, mid, A);
		SegmentSumTreeNode right = build(mid + 1, end, A);

		SegmentSumTreeNode node = new SegmentSumTreeNode(start, end, left.sum + right.sum);
		node.left = left;
		node.right = right;	
		return node;
	}

	SegmentSumTreeNode root = null;
	
    public Solution(int[] A) {
        if (A == null || A.length == 0) {
			return;
		}
		root = build(0, A.length - 1, A);
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        return queryHelper(root, start, end);
    }
    public long queryHelper(SegmentSumTreeNode root, int start, int end){
    	if (start > end) {
    		return 0;
    	} else if (root.start == start && root.end == end) {
    		return root.sum;
    	}
    	int mid = (root.start + root.end)/2;
    	if (end <= mid) {
    		return queryHelper(root.left, start, end);
    	} else if (start > mid) {
    		return queryHelper(root.right, start, end);
    	}
    	return queryHelper(root.left, start, root.left.end) + queryHelper(root.right, root.right.start, end);
    }
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        modifyHelper(root, index, value);
    }
    public void modifyHelper(SegmentSumTreeNode node, int index, int value) {
    	if (node.start == index && node.end == index) {
    		node.sum = value;
    		return;
    	}
    	int mid = (node.start + node.end)/2;
    	if (index <= mid) {
    		modifyHelper(node.left, index, value);
    	} else {
    		modifyHelper(node.right, index, value);
    	}
    	node.sum = node.left.sum + node.right.sum;
    }
}
