/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/merge-two-sorted-lists
@Language: Java
@Datetime: 16-06-03 19:50
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
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // if (l1 == null && l2== null) return null;
       
        ListNode preNode = new ListNode(0);
        ListNode cur = new ListNode(0);
        cur = preNode;
        // ListNode cur1 = l1, cur2 = l2;
        while (l1!=null && l2!= null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1= l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur= cur.next;
        }
        if (l1!= null){
            cur.next = l1;
        }
        if (l2!= null) {
            cur.next = l2;
        }
         return preNode.next;
    }
}