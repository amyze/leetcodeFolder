/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/copy-list-with-random-pointer
@Language: Java
@Datetime: 16-06-13 03:33
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
      //insert a new node after each node
      
      if(head == null) return null;
      RandomListNode cur = head;
      while(cur!= null){
          RandomListNode copy = new RandomListNode(cur.label);
          copy.next = cur.next;
          copy.random = cur.random;
          cur.next = copy;
          cur= cur.next.next;
      }
      //copy the random pointer
      RandomListNode curr = head;
      while (curr!=null){
          if(curr.next.random!=null){
          curr.next.random = curr.random.next;
          }
          curr= curr.next.next;
      }
      //decouple the pairs
      
      RandomListNode newhead = head.next;
      RandomListNode originalp = head;
      
      while (originalp!=null){
          RandomListNode temp = originalp.next;
          originalp.next = temp.next;
          originalp = originalp.next;
          if(temp.next!=null){
              temp.next=temp.next.next;
          }
          
          
      }return newhead;
    }
}