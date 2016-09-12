/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/binary-search-tree-iterator
@Language: Java
@Datetime: 16-07-12 03:38
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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    //@param root: The root of binary tree.
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while(root!=null){
            stack.push(root);
            root= root.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return !stack.empty();
    }
    
    //@return: return next node
    public TreeNode next() {
        TreeNode node = stack.pop();
        TreeNode temp= node;
        if(node.right!=null){
            node=node.right;
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
        }
        return temp;
    }
}

// 需要内置一个栈，一开始先存储到最左叶子节点的路径。在遍历的过程中，只要当前节点存在右孩子，则进入右孩子，存储从此处开始到当前子树里最左叶子节点的路径。