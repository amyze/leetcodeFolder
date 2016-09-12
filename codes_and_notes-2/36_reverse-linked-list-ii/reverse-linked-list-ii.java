/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/reverse-linked-list-ii
@Language: Java
@Datetime: 16-07-18 20:42
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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if(head== null || head.next== null) return head;
        ListNode prehead = new ListNode(0);
        prehead.next =head;
        ListNode pre = prehead;
        ListNode cur = prehead;
        int i =1;
        while (i<m){
            pre = pre.next;
            cur = cur.next;
            i++;
        }
        cur= cur.next;
        while(i<n){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            i++;
        }
       return prehead.next; 
    }
}