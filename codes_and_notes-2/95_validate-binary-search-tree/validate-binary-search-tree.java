/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/validate-binary-search-tree
@Language: Java
@Datetime: 16-07-10 02:22
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
//  如果是BST的话，中序遍历数一定是单调递增的，如果违反了这个规律，就返回false
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
       ArrayList<TreeNode> result = new ArrayList<TreeNode>();
       return helper(root, result);
      
    }
    
    public boolean helper(TreeNode node, ArrayList<TreeNode> list) {
        if (node == null) return true;
        //inorder traverse
        boolean left = helper(node.left, list);
        // check if the arraylist is in ascending order
        if((!list.isEmpty() )&& (list.get(list.size()-1).val>=node.val)) {
            return false;
        }
        list.add(node);
        boolean right = helper(node.right, list);
        return left&& right;
        
    }
}