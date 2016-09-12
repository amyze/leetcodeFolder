/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/binary-tree-serialization
@Language: Java
@Datetime: 16-06-17 18:31
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    // public static final String X ="#";
    // public static final String parse =",";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(root);
        
        while (!temp.isEmpty()) {
            TreeNode head = temp.poll();
            if (head == null) {
                sb.append("#"+",");
            }else {
                sb.append(head.val+",");
                temp.offer(head.left);
                temp.offer(head.right);
            }
            
        } 
      
        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data == null ||data.length()==0) {
            return null;
        }
        String[] vals = data.split(",");
        
        TreeNode[] nodes = new TreeNode[vals.length];
        
        int [] nulls = new int[vals.length];
        
        // count the number of null and create an array of treeNode
        int count =0;
        for (int i=0;i<vals.length;i++) {
            if(vals[i].equals("#")) {
                nodes[i] = null;
                nulls[i]=count;
                count++;
            }else {
                nodes[i]= new TreeNode(Integer.parseInt(vals[i]));
                nulls[i]=count;
            }
        }
        for(int i=0;i<vals.length;i++) {
            if(nodes[i]==null){
                continue;
            }
            nodes[i].left =nodes[2*(i-nulls[i])+1];
            nodes[i].right =nodes[2*(i-nulls[i])+2];
        } return nodes[0];
}
}