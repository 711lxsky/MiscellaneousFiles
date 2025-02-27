package practice;

public class T2296_250227 {

    class TextEditor {

        private StringBuilder left;
        private StringBuilder right;

        public TextEditor() {
            left = new StringBuilder();
            right = new StringBuilder();
        }

        public void addText(String text) {
            left.append(text);
        }

        public int deleteText(int k) {
            k = Math.min(k, left.length());
            left.setLength(left.length() - k);
            return k;
        }

        private String getText(){
            return left.substring(Math.max(left.length() - 10, 0));
        }


        public String cursorLeft(int k) {
            while(k > 0 && left.length() != 0){
                right.append(left.charAt(left.length() - 1));
                left.setLength(left.length() - 1);
                k --;
            }
            return getText();
        }

        public String cursorRight(int k) {
            while(k > 0 && right.length() != 0){
                left.append(right.charAt(right.length() - 1));
                right.setLength(right.length() - 1);
                k --;
            }
            return getText();
        }
    }

}
