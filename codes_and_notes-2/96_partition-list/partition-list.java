/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/partition-list
@Language: Java
@Datetime: 16-06-04 02:09
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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
       if (head == null || head.next == null) return head;
       ListNode preSmallHead = new ListNode(0);
       ListNode preSmallTra = new ListNode(0);
       preSmallTra= preSmallHead;
       
       ListNode preLargeHead = new ListNode(0);
       ListNode cur = new ListNode(0);
       preLargeHead.next = head;
       cur=preLargeHead ;
       
       while(cur.next!= null) {
         if(cur.next.val < x) {
            preSmallTra.next = cur.next;
            preSmallTra= preSmallTra.next;
            cur.next = cur.next.next; 
         } else {
            cur= cur.next;
         } 
       }
       preSmallTra.next = preLargeHead.next;
       return preSmallHead.next;
       
    }
}
