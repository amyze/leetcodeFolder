/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/identical-binary-tree
@Language: Java
@Datetime: 16-07-14 23:48
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
     * @param a, b, the root of binary trees.
     * @return true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
      if (a== null && b== null) return true;
      if (a==null || b== null) return false;
      return (a.val==b.val) && isIdentical(a.left,b.left) &&
      isIdentical(a.right,b.right);
    }
    //ĺĺş
   
}