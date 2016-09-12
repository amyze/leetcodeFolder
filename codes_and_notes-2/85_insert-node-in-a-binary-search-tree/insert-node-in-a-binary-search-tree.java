/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/insert-node-in-a-binary-search-tree
@Language: Java
@Datetime: 16-06-14 02:58
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
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
       if(root == null) return node;
    //   if (root.left == null && root.val <node.val) {
    //       root.left = node;
    //       return root;
    //   }
    //   if (root.right == null && root.val >node.val) {
    //       root.right = node;
    //       return root;
    //   }
       if( root.val < node.val) {
           root.right = insertNode( root.right,  node);
       }else {
          root.left= insertNode( root.left, node);
       }
       return root;
    }
}