/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/convert-sorted-list-to-balanced-bst
@Language: Java
@Datetime: 16-06-14 00:20
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        if(head== null) return null;
       
        // get the listNode pre of middle node
        ListNode runner = head;
        ListNode walker = new ListNode(0);
        walker.next = head;
        while(runner!= null && runner.next!=null) {
            runner= runner.next.next;
            walker = walker.next;
        }
        
        // recursive to transfer to BST
        
        TreeNode newhead = new TreeNode(walker.next.val);
       
        newhead.right=sortedListToBST(walker.next.next);
        // 特殊情况是walker任然在prehead，此时不返回prehead，而是直接返回null
        if(walker.next!=head){
        walker.next = null;
        newhead.left =sortedListToBST(head);
        }else{
            newhead.left =null;
        }
        return newhead;
    }
}
