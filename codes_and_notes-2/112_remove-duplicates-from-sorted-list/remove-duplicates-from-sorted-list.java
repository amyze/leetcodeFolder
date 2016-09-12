/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-list
@Language: Java
@Datetime: 16-06-03 21:09
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
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        if(head== null || head.next ==null) return head;
        ListNode cur = head;
        while(cur.next!= null){
            if(cur.val == cur.next.val) {
                cur.next=cur.next.next;
            }else {
                cur= cur.next;
            }
        }  return head;
    }
}