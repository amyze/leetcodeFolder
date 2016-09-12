/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/swap-nodes-in-pairs
@Language: Java
@Datetime: 16-07-21 02:39
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        ListNode prehead = new ListNode(-1);
        if (head == null || head.next == null) return head;
        prehead.next = head;
        ListNode pre = prehead;
        while (head!= null && head.next!= null){
            ListNode temp = head.next;
            head.next = temp.next;
            pre.next = temp;
            temp.next = head;
            pre= head;
            head= head.next;
        }
        return prehead.next;
    }
}