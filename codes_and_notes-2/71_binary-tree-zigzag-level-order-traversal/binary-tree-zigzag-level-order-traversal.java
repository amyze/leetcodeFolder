/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/binary-tree-zigzag-level-order-traversal
@Language: Java
@Datetime: 16-07-15 23:21
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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root ==null) return result;
        
        helper(result,  root);
        return result;
    }
    
    public void helper(ArrayList<ArrayList<Integer>>result, TreeNode root){
        Boolean flag = false;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i=0;i< size;i++){
                
                if(flag){
                    TreeNode node = queue.pollLast();
                    level.add(0,node.val);
                    if(node.left!=null) queue.offerFirst(node.left);
                    if(node.right!=null) queue.offerFirst(node.right);
                }else{
                    TreeNode node = queue.pollFirst();
                    level.add(0,node.val);
                    if(node.right!=null) queue.offer(node.right);
                    if(node.left!=null) queue.offer(node.left);
                }
            }
            result.add(level);
            flag=!flag;
            
        }
    }
}