/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/nth-to-last-node-in-list
@Language: Java
@Datetime: 16-07-18 21:37
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
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
       ListNode pre = new ListNode(0);
       pre.next= head;
       int i = n;
       ListNode runner = pre;
       ListNode walker = pre;
       while(i>0 && runner!=null){
           runner= runner.next;
           i--;
       }
       if(i>0){
           return null;
       }else{
            while(runner!=null){
                runner= runner.next;
                walker= walker.next;
             }
           return walker;
       }
    }
}
