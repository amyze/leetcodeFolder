/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/inorder-successor-in-binary-search-tree
@Language: Java
@Datetime: 16-07-11 21:28
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p== null) return null;
        if(p.right!=null){
            p=p.right;
            while(p.left!=null){
                p=p.left;
            }
            return p;
        }
        else{
            TreeNode next=null;
            while(root.val!=p.val){
                if(p.val<root.val){
                    next=root;
                    root=root.left; 
                }
                else{
                    root=root.right; 
                } 
            }
            return next;
        }
    }
    
   
}