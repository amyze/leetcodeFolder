/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/min-stack
@Language: Java
@Datetime: 16-07-03 03:20
*/

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;
    
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int number) {
        stack.push(number);
        if (min.empty()) {
            min.push(number);
        }
        else if (number<= min.peek()) {
            min.push(number);
        }
    }

    public int pop() {
        if (stack.peek().equals(min.peek())) {
            min.pop();
        }
        return stack.pop();
    }

    public int min() {
        return min.peek();
    }
}
