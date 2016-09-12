/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/binary-tree-preorder-traversal
@Language: Java
@Datetime: 16-06-14 03:16
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
     * @return: Preorder in ArrayList which contains node values.
     */
      ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
       helper(result, root);
       return result;
       
    }
    public void helper (ArrayList<Integer> array,TreeNode root ){
        if(root == null) return;
        array.add(root.val);
        helper(array, root.left);
        helper(array, root.right);
        
    }
}