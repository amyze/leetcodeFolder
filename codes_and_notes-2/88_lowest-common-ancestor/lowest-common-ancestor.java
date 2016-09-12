/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor
@Language: Java
@Datetime: 16-07-12 02:13
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
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
       if (root == null) return null;
       if (root.val == A.val || root.val == B.val) return root;
       TreeNode left = lowestCommonAncestor(root.left, A, B);
       TreeNode right = lowestCommonAncestor(root.right, A, B);
       if(left!=null && right!=null) return root;
       return(left!=null)?left:right;
    }
}