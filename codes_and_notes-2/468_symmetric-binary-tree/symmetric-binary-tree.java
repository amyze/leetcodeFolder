/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/symmetric-binary-tree
@Language: Java
@Datetime: 16-07-14 21:16
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
     * @param root, the root of binary tree.
     * @return true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> left = new LinkedList<TreeNode>();
        Queue<TreeNode> right = new LinkedList<TreeNode>();

        left.add(root.left);
        right.add(root.right);        

        while(!left.isEmpty() && !right.isEmpty()){

            TreeNode l = left.remove();
            TreeNode r = right.remove();

            if(l == null && r == null) continue;

            else if(l == null || r == null) return false;

            if(l.val != r.val){
                return false;
            }
            else{
                left.add(l.left);
                left.add(l.right);
                right.add(r.right);
                right.add(r.left);
            }
        }
        return true;
    }
}