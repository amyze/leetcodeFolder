/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/search-range-in-binary-search-tree
@Language: Java
@Datetime: 16-06-16 02:43
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
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
     ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        
        if (root == null) return result;
         helper(result, root, k1, k2);
         return result;
    }
    public void helper(ArrayList<Integer> result,TreeNode node, int k1, int k2 ){
        if (node == null) return;
        helper(result, node.left,k1, k2);
        if (node.val<=k2 && node.val>=k1) {
            result.add(node.val);
        }
         helper(result, node.right,k1, k2);
        
    }
    
    
}