/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/rehashing
@Language: Java
@Datetime: 16-08-09 21:13
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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        
        if (hashTable == null ) {
            return null;
        }
         int size = hashTable.length;
        ListNode[] res = new ListNode[2*size];
       
        
        for(int i=0;i<size;i++){
            ListNode cur = hashTable[i];
            while (cur!= null){
                ListNode head = cur;
                int index = (head.val% (2*size)+(2*size))%(2*size);
                ListNode node = res[index];
                if(node==null){
                    res[index]= new ListNode(head.val);
                }else{
                    while (node.next!=null){
                        node = node.next;
                    }
                    node.next = new ListNode(head.val);
                }
                cur = cur.next;
            }
        }
        return res;
    }
};
