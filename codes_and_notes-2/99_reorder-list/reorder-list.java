/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/reorder-list
@Language: Java
@Datetime: 16-06-14 01:26
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
     * @return: void
     */
    public void reorderList(ListNode head) {  
        // case: null/one node/ two nodes
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        //split in the mid
        ListNode walker = head;
        ListNode runner = head;
        while (runner!= null && runner.next!= null ) {
            runner= runner.next.next;
            walker= walker.next;
        }
        ListNode left = walker.next;
        walker.next = null;
         left = reverse(left);
        // creat the pointer
        ListNode p = head;
        
       while(p!=null && left!= null){
           ListNode temp = left.next;
           left.next = p.next;
           p.next = left;
           p= left.next;
           left= temp;
       }
        
    }
    // public ListNode reverse(ListNode head) {
    //     if (head == null || head.next ==null) return head;
    //     // preHead is the prehead for the given Linkedlist
    //     ListNode preHead = new ListNode(0);
        
    //     preHead.next = head;
        
    //     // preHeadNew is the prehead for the newly constructed linkedlist
    //     ListNode preHeadNew = new ListNode(0);
        
        
    //     while(preHead.next!=null){
    //         ListNode temp = preHead.next;
    //         preHead.next = preHead.next.next;
    //         temp.next = preHeadNew.next;
    //         preHeadNew.next = temp;
    //     }
    //     return preHeadNew.next;
    // }
    private ListNode reverse(ListNode head)  
{  
    ListNode pre = null;  
    ListNode cur = head;  
    while(cur!=null)  
    {  
        ListNode next = cur.next;  
        cur.next = pre;  
        pre = cur;  
        cur = next;  
    }  
    return pre;  
}  
}
