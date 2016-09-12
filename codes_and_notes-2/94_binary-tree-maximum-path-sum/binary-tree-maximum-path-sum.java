/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum
@Language: Java
@Datetime: 16-07-12 01:21
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
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[1];
        res[0]= Integer.MIN_VALUE;
        int temp= helper(root, res);
        return res[0];
    }
    
    public int helper(TreeNode node, int[]res) {
        if(node == null) return 0;
        int left = helper(node.left, res);
        int right = helper(node.right, res);
        int arch= left + right+ node.val;
        int single = Math.max(node.val, Math.max(right+node.val, left+node.val));
        res[0]= Math.max(res[0], Math.max(single, arch));
        return single;
    }
}