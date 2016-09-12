/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/implement-queue-by-two-stacks
@Language: Java
@Datetime: 16-07-01 22:36
*/

public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int element) {
        stack2.push(element);
    }

    public int pop() {
      if(!stack1.empty()) {
            return stack1.pop();
        }else{
        stack2toStack1();
        return stack1.pop();
        } 
    }

    public int top() {
        if(!stack1.empty()) {
          return stack1.peek();
        }else{
        stack2toStack1();
        return stack1.peek();
        }
    }
    
    public void stack2toStack1() {
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
    }

}