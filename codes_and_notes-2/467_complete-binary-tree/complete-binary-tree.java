/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/complete-binary-tree
@Language: Java
@Datetime: 16-07-14 20:14
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
 
//  The method 2 of level order traversal post can be easily modified to check whether a tree is Complete or not. To understand the approach, let us first define a term ‘Full Node’. A node is ‘Full Node’ if both left and right children are not empty (or not NULL).
// The approach is to do a level order traversal starting from root. In the traversal, once a node is found which is NOT a Full Node, all the following nodes must be leaf nodes.
// Also, one more thing needs to be checked to handle the below case: If a node has empty left child, then the right child must be empty.
public class Solution {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
       if (root == null) return true;
       Boolean isFullN = true;
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       while(!queue.isEmpty()) {
           TreeNode node = queue.poll();
           if (isFullN) {
               if (node.left!=null ){
                    queue.offer(node.left);
                    if (node.right!=null){
                        queue.offer(node.right);
                    }else{
                        isFullN= false;
                    }
               }else {
                   if(node.right!=null) 
                       return false;
               }
           }else {
               if(node.left!=null || node.right!=null){
                   return false;
               }
           }
       }return true;
    }
}
