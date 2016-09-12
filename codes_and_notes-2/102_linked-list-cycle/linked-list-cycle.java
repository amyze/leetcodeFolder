/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/linked-list-cycle
@Language: Java
@Datetime: 16-06-04 03:49
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
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
       if (head == null) return false;
       ListNode walker = head;
       ListNode runner = head;
       while (runner!=null && runner.next != null) {
           walker= walker.next;
           runner = runner.next.next;
           if (walker == runner) {
               return true;
           }
       }return false;
    }
}
//1->-1->null, no cycle 的情况 while里加runner!=null