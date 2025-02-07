package practice;

import java.util.Arrays;

public class Test_240616 {

    public static void main(String[] args) {
       int [] array = {5, 3, 8, 1, 2};
       Integer [] arrayBoxed = Arrays.stream(array).boxed().toArray(Integer[]::new);
        Arrays.sort(arrayBoxed,(a,b)-> b-a);
//        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
