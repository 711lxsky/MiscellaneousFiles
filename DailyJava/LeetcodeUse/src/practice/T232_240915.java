package practice;

import java.util.Stack;

public class T232_240915 {

    class MyQueue {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if(stack2.isEmpty()){
                popInToOut();
            }
            return stack2.pop();
        }

        private void popInToOut(){
            while(! stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        public int peek() {
            if(stack2.isEmpty()){
                popInToOut();
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

}
