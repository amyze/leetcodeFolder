/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/count-of-smaller-number-before-itself
@Language: Java
@Datetime: 16-09-06 22:45
*/

public class Solution {
   /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is 
     *          smaller than it and return count number array
     */ 
    public class SegmentTreeNode {
        public int start, end, count;
         public SegmentTreeNode left, right;
         public SegmentTreeNode(int start, int end, int count) {
             this.start = start;
             this.end = end;
             this.count = count;
             this.left = this.right = null;
         }
     }
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (A == null || A.length ==0){
           return rst; 
        }
        SegmentTreeNode root = build(0,10000);
        
        for(int i=0;i<A.length;i++){
            int count = 0;
            
            if(A[i]>0){
            count =query(root, 0, A[i]-1);
            }
            rst.add(count);
            modify(root, A[i], 1);
        }
        
         return rst;
    }
    
    // build segment tree in postorder with all count =0
     
    
    public SegmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new SegmentTreeNode(start, end,0);
        }
        
        SegmentTreeNode leftChild = build(start, (start + end)/2);
        SegmentTreeNode rightChild  = build((start + end)/2 + 1, end);

        SegmentTreeNode node = new SegmentTreeNode(start, end, 0);
        node.left = leftChild;
        node.right = rightChild;
        return node;
    }
    // modify the tree with given array
    public void modify(SegmentTreeNode root, int val, int count){
        if (root.start == val && root.start == root.end){
            root.count+= count;
            return;
        }
        int mid = (root.start+root.end)/2;
        //注意这里val的判断条件
        if (root.start <= val && val <= mid){
            modify(root.left, val, count);
        }else if(mid < val && val <= root.end){
            modify(root.right, val, count);
        }
        root.count = root.right.count+root.left.count;
    }
    //	Look for that number based on start&&end*/
	public int query(SegmentTreeNode root, int start, int end) {
		if (root.start == start && root.end == end) {
			return root.count;
		}
// 		int sum = 0;
		int mid = root.start + (root.end - root.start)/2;
		if (end <= mid) {
// 			sum += query(root.left, start, end);
            return query(root.left, start, end);
		} else if (start > mid) {
// 			sum += query(root.right, start, end);
			return query(root.right, start, end);
		} else   {
// 			sum += query(root.left, start, mid);
// 			sum += query(root.right, mid + 1, end);
			return query(root.left, start, mid)+query(root.right, mid + 1, end);
		}
// 		return sum;
	}
    // class of segment tree node
    
}
