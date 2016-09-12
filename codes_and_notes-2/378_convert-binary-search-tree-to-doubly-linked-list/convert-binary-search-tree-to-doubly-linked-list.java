/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/convert-binary-search-tree-to-doubly-linked-list
@Language: Java
@Datetime: 16-07-21 00:17
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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }.../
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
     public  DoublyListNode Listhead;
     public  DoublyListNode pre;
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        
        helper(root);
        return Listhead;
    }
    
    public void helper(TreeNode node){
        if (node == null) return;
         helper(node.left);
         DoublyListNode p = new DoublyListNode(node.val);
         if(Listhead==null){
             Listhead = p;
         }
         if (pre == null) {
             pre = p;
         }else {
             pre.next=p;
             p.prev= pre;
             pre = p;
         }
        
        
        helper(node.right);
    }
}
