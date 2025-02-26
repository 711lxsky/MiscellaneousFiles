package practice;

import java.util.Stack;

public class T1472_250226 {

    class BrowserHistory {

        // 使用栈进行设计
        private Stack<String> back;
        private Stack<String> forward;
        private String homePage;

        public BrowserHistory(String homepage) {
            this.back = new Stack<>();
            this.forward = new Stack<>();
            this.homePage = homepage;
        }

        public void visit(String url) {
            this.back.push(url);
            forward.removeAllElements();
        }

        public String back(int steps) {
            for(int i = 0; i < steps && !back.isEmpty(); i ++){
                forward.push(back.pop());
            }
            return back.isEmpty() ? homePage : back.peek();
        }

        public String forward(int steps) {
            for(int i = 0; i < steps && ! forward.isEmpty(); i ++){
                back.push(forward.pop());
            }
            return back.isEmpty() ? homePage : back.peek();
        }
    }

}
