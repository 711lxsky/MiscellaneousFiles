package OtherUse;

import java.util.Arrays;
import java.util.Random;

public class SplitTest {

    private static final String ALPHANUMERIC_STRING = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBER_STRING = "0123456789";
    private static final Random RANDOM = new Random();

    public static String generateRandomStringWithRepeatedNumberSuffix(int totalLength) {
        StringBuilder randomPart = new StringBuilder();
        for (int i = 0; i < totalLength - 16; i++) { // 后缀占16个字符（4 * (数字 + ;)）
            int index = RANDOM.nextInt(ALPHANUMERIC_STRING.length());
            char randomChar = ALPHANUMERIC_STRING.charAt(index);
            randomPart.append(randomChar);
        }

        StringBuilder numberSuffix = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = RANDOM.nextInt(NUMBER_STRING.length());
            char randomNumberChar = NUMBER_STRING.charAt(index);
            numberSuffix.append(randomNumberChar).append(';');
        }

        return randomPart.append(numberSuffix).toString();
    }


    public static void main(String[] args) {

        String test = "erew fsdfsrfefefs fefwr34r4f45 @area@ fsdfsfterfef g gb dfg serfte ";
        String[] splits = test.split(" @area@ ");
        System.out.println("splits: "+ Arrays.toString(splits));

        int length = 256;
        int n = 64;
        String[] Xs = new String[n];
        String[] Ys = new String[n];
        for(int i = 0; i < n; i ++){
            Xs[i] = generateRandomStringWithRepeatedNumberSuffix(length);
            System.out.println("----- x : " + Xs[i] );
            Ys[i] = generateRandomStringWithRepeatedNumberSuffix(length);
            System.out.println("+++++ y : " + Ys[i]);
        }
        String area = "#area";
        String areaLabel = "&area&";
        StringBuilder sb = new StringBuilder();
        sb.append(area);
        for(int i = 0; i < n - 1; i ++){
            sb.append(Xs[i]).append(" ");
        }
        sb.append(Xs[n-1]).append(areaLabel);
        for(int j = 0; j < n - 1; j ++){
            sb.append(Ys[j]).append(" ");
        }
        sb.append(Ys[n - 1]);
        System.out.println("sb length : --" + sb.length());
        String s = sb.toString();
        String[] XAndYs = s.split(areaLabel);
        System.out.println("===== Xs and Ys: " + Arrays.toString(XAndYs));
        System.out.println("x and y length : " + XAndYs.length);
    }

}
