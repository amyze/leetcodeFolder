/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/construct-binary-tree-from-preorder-and-inorder-traversal
@Language: Java
@Datetime: 16-06-15 18:29
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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
         int preLength = preorder.length;
         int inLength = inorder.length;
        return buildTree(preorder, 0, preLength-1, inorder, 0, inLength-1);
     }
   
    public TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
         if(inStart > inEnd || preStart > preEnd)
             return null;
             
        int rootVal = pre[preStart];
        int rootIndex = 0;
        for(int i = inStart; i <= inEnd; i++){
             if(in[i] == rootVal){
                 rootIndex = i;
                 break;
             }
         }
       
         int len = rootIndex - inStart;
         TreeNode root = new TreeNode(rootVal);
         root.left = buildTree(pre, preStart+1, preStart+len, in, inStart, rootIndex-1);
         root.right = buildTree(pre, preStart+len+1, preEnd, in, rootIndex+1, inEnd);
       
        return root;
     }// write your code here
    
}