/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/interval-minimum-number
@Language: Java
@Datetime: 16-09-06 01:51
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    class SegmentMinTreeNode {
		int start,end,min;
		SegmentMinTreeNode left, right;
		public SegmentMinTreeNode(int start, int end, int min) {
			this.start = start;
			this.end = end;
			this.min = min;
			this.left = null;
			this.right = null;
		}
	}
	
	public SegmentMinTreeNode build(int start, int end, int[] A) {
		if (start == end) {
			return new SegmentMinTreeNode(start, end, A[start]);
		}
		int min = (start + end) / 2;
		SegmentMinTreeNode left = build(start, min, A);
		SegmentMinTreeNode right = build(min + 1, end, A);
		SegmentMinTreeNode node = new SegmentMinTreeNode(start, end, Math.min(left.min, right.min));
		node.left = left;
		node.right = right;
		
		return node;
	}
	//Query method
	public int search(SegmentMinTreeNode root, int start, int end){
		if (root.start == start && root.end == end) {
			return root.min;
		}

		int mid = (root.start + root.end) / 2;
		if (end <= mid) {
			return search(root.left, start, end);
		}
		if (start > mid) {
			return search(root.right, start, end);
		}

		return Math.min(search(root.left, start, root.left.end), search(root.right, root.right.start, end));
	}
    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if(A== null||A.length ==0||queries == null|| queries.size()==0){
            return rst;
        }
        // build segment tree
        SegmentMinTreeNode root = build(0,A.length-1, A);
        for(Interval query: queries){
           int num= search(root,query.start, query.end);
           rst.add(num);
           
        }
        return rst;
    }
}