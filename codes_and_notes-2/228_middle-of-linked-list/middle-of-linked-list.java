/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/middle-of-linked-list
@Language: Java
@Datetime: 16-07-21 03:18
*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) { 
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}