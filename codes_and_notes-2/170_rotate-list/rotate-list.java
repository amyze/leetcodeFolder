/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/rotate-list
@Language: Java
@Datetime: 16-06-12 20:13
*/

/**
 * Definition for singly-linked list.
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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
    //     if (head == null || k ==0) return head;
    //     ListNode prehead1 = new ListNode(-1);
    //     ListNode prehead2 = new ListNode(-2);
    //     prehead1.next = head;
    //     // two pointer, runner walks  k steps ahead than walker
    //     ListNode runner = prehead1;
    //     ListNode walker = prehead1;
    //     ListNode p = head;
    //     int count=0;
    //     while(p!=null) {
    //         p= p.next;
    //         count++;
    //     }
        
    //     int i = k%count;
    //     if (count ==1 || i==0) return head;
    //     while(runner.next!=null){
    //         while( i>0){
    //             if(runner == null) {
    //                 return head;
    //             }
    //             runner = runner.next;
    //             i--;
                
    //         }
    //         if (runner.next!=null) {
    //         runner= runner.next;
    //         walker= walker.next;
    //         }
    //     }
    //     prehead2.next = walker.next;
    //     ListNode temp = walker;
    //     walker = walker.next;
    //     temp.next = null;
    //     while(walker!=null && walker.next!= null){
    //         walker = walker.next;
    //     }
    //     walker.next = prehead1.next;
    //     return prehead2.next;
    // }
    
        if(head==null||head.next==null||k==0)
            return head;
        ListNode fast = head, slow = head,countlen = head;
        ListNode newhead = new ListNode(-1);
        int len = 0;
        
        while(countlen!=null){
            len++;
            countlen = countlen.next;
        }
        
        k = k%len;
        if(k==0)
            return head;
        
        for(int i = 0; i < k; i++)
            fast = fast.next;
        
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        newhead = slow.next;
        fast.next = head;
        slow.next = null;
        
        return newhead;
    
}
}