/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/binary-tree-level-order-traversal
@Language: Java
@Datetime: 16-06-16 02:01
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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       if (root == null) {
           return result;
       }
    
   
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size() ;
            for(int i =0; i< size; i++) {
                // pop & get the head
                TreeNode head = queue.poll();
                level.add(head.val);
                // offer head.left and head.right
                if(head.left!= null){
                    queue.add(head.left);
                }
                if(head.right!= null){
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }return result;
    }
}