/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/add-two-numbers
@Language: Java
@Datetime: 16-07-19 18:32
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
     //此题不用reverse
    public ListNode addLists(ListNode l1, ListNode l2) {
        if (l1== null && l2== null)return null;
        if (l1== null) return l2;
        if (l2== null) return l1;
        
        ListNode rst = new ListNode(0);
        ListNode cur3= rst;
        int carry=0;
        while(l1!=null|| l2!=null){
            
            if (l1!=null){
                carry += l1.val;
                l1= l1.next;
            }
           
           if (l2!=null){
                carry += l2.val;
                l2=l2.next;
            }
            
            
            
            ListNode node = new ListNode(carry%10);
            carry=carry/10;
            cur3.next= node;
            cur3= cur3.next;
            
            
        }
        if (carry ==1)
        cur3.next = new ListNode(1);
        return rst.next;
    }
    
}