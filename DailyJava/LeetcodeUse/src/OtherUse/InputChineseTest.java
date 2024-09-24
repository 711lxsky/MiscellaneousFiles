package OtherUse;

import java.util.Scanner;

public class InputChineseTest {

    public static void main(String[] args) {
        String chineseText;
        Scanner input = new Scanner(System.in);
        System.out.print("please input: ");
        chineseText = input.nextLine();
        System.out.println("your input:" + chineseText);
    }

}
