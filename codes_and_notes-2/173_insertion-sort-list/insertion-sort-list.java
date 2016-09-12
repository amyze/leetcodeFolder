/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/insertion-sort-list
@Language: Java
@Datetime: 16-07-21 01:46
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
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
     // not in place
    public ListNode insertionSortList(ListNode head) {
       ListNode dummy = new ListNode(-1);
       if (head == null || head.next== null) return head;
       while (head!= null) {
           ListNode node = dummy;
           // node 是每次从新list的头开始找，到要插入 节点的prev 节点
           while (node.next!= null && (node.next.val <head.val)){
               node = node.next;
           }
           ListNode temp  =  head.next;
           head.next = node.next;
           node.next = head;
           head = temp;
       }
       return dummy.next;
    }
}