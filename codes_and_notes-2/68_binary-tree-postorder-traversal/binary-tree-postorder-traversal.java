/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/binary-tree-postorder-traversal
@Language: Java
@Datetime: 16-07-10 02:16
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
     * @return: Postorder in ArrayList which contains node values.
     */
     ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        helper(result, root);
       return result;
    }
     public void helper (ArrayList<Integer> array,TreeNode root ){
        if(root == null) return;
       
        helper(array, root.left);
        helper(array, root.right);
        array.add(root.val);
        
    }
}