/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum-ii
@Language: Java
@Datetime: 16-07-11 20:47
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    // public static int max = 0, cur =0;
    public int maxPathSum2(TreeNode root) {
        // if (root == null) return 0;
        // dfsHelper(root, max);
        // return max;
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        return root.val + Math.max(0, Math.max(left, right));
    }
    
    // public void dfsHelper(TreeNode node, int max) {
    //     if (node == null) return;
        
    //     cur+=node.val;
    //     if(cur> max){
    //         max = cur;
    //     }
    //     dfsHelper(node.left, max);
    //     dfsHelper(node.right, max);
        
    // }
    
}