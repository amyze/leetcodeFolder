/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/swap-two-nodes-in-linked-list
@Language: Java
@Datetime: 16-07-21 14:56
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
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
       ListNode pre = new ListNode(-1);
       pre.next = head;
       if (head == null ) return null;
       ListNode pre1 = pre;
       ListNode pre2 = pre;
       ListNode temp1, temp2;
       while(pre1.next!= null && pre1.next.val !=v1 ) {
           pre1= pre1.next;
           
       }
       
       while(pre2.next!= null && pre2.next.val !=v2 ) {
           pre2= pre2.next;
       }
       // 注意v1= v2的情况
       if(pre1.next== null || pre2.next== null||(pre1.next.val== pre2.next.val)){
           return pre.next;
       }
            temp1= pre1.next;
            temp2 = pre2.next;
            
       if (pre1.next.val == pre2.val){
           temp1.next =  temp2.next;
           temp2.next= temp1;
           pre1.next = temp2;
       } else if(pre2.next.val == pre1.val){
           temp2.next =  temp1.next;
           temp1.next= temp2;
           pre2.next = temp1;
       }else {
          pre1.next = pre1.next.next;
          pre2.next = pre2.next.next;
           temp2.next = pre1.next;
           pre1.next = temp2;
           temp1.next = pre2.next;
           pre2.next= temp1;
           
       } return pre.next;
    }
}