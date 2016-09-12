/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/binary-tree-level-order-traversal-ii
@Language: Java
@Datetime: 16-07-15 15:12
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
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
       
        while(!queue.isEmpty()){
             int size = queue.size();
             ArrayList<Integer> level = new  ArrayList<>();
             for(int i=0;i<size;i++){
            TreeNode node= queue.poll();
            level.add(node.val);
            if(node.left!= null) queue.offer(node.left);
            if(node.right!= null) queue.offer(node.right);
             }
        result.add(0,level);
            
            
        }
        return result;
        
    }
}