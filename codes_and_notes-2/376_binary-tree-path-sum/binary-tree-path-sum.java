/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum
@Language: Java
@Datetime: 16-07-15 18:18
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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
     
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        helper(root, path, root.val, target, result);
        return result;
    }
    
    public void helper(TreeNode node, ArrayList<Integer>path, int sum,
    int target,List<List<Integer>> result) {
        // get to the leaf
        if (node.left==null && node.right  == null){
            if (sum== target){
                result.add(new ArrayList<Integer>(path));
                return;
            }
        }
        // go left
        if (node.left!=null){
            // if (sum<target){
                path.add(node.left.val);
                helper(node.left,path,sum+node.left.val,target, result);
                path.remove(path.size() - 1);
            // }
        }
        if (node.right != null) {
            path.add(node.right.val);
            helper(node.right, path, sum + node.right.val, target, result);
            path.remove(path.size() - 1);
        }
    }
}