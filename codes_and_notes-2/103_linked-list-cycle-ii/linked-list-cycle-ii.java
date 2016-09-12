/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/linked-list-cycle-ii
@Language: Java
@Datetime: 16-07-21 21:02
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
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        ListNode slow = head;
    ListNode fast = head;

    while (true) {
        if (fast == null || fast.next == null) {
            return null;    //遇到null了，说明不存在环
        }
        slow = slow.next;
        fast = fast.next.next;
        if (fast == slow) {
            break;    //第一次相遇在Z点
        }
    }

    slow = head;    //slow从头开始走，
    while (slow != fast) {    //二者相遇在Y点，则退出
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
    }
}
