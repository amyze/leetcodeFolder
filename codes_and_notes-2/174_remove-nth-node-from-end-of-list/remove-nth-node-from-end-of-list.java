/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/remove-nth-node-from-end-of-list
@Language: Java
@Datetime: 16-06-03 19:26
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
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
       if (head == null) return null;
       //注意这里的构造器
       ListNode prehead = new ListNode(0);
       prehead.next = head;
       if ( n<=0) return head;
       ListNode runner = prehead;
       ListNode walker = prehead;
       int counter = n;
       
        while ( counter >0){
           runner = runner.next;
           counter--;
        }
        //避免了1->null, n=1 要删除头节点的情况
       while (runner.next!= null) {
        runner = runner.next;
        walker = walker.next;
       }
       walker.next = walker.next.next;
       return prehead.next;
    }
}
