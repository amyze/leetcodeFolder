/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/reverse-linked-list
@Language: Java
@Datetime: 16-06-04 02:47
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
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next ==null) return head;
        // preHead is the prehead for the given Linkedlist, cur the pointer is for traverse
        ListNode preHead = new ListNode(0);
        
        preHead.next = head;
        
        // preHeadNew is the prehead for the newly constructed linkedlist, curNew is the pointer for traverse
        ListNode preHeadNew = new ListNode(0);
        
        
        while(preHead.next!=null){
            ListNode temp = preHead.next;
            preHead.next = preHead.next.next;
            temp.next = preHeadNew.next;
            preHeadNew.next = temp;
        }
        return preHeadNew.next;
    }
}
