package study.kevin.com.studydemo.JavaTest;

import java.util.ArrayList;

/**
 * Created by kevin on 2018/4/14.
 */

public class JavaTest {

    public static void main(String[] args) {
        roundUpInteger();
    }


    /**
     * 向上取整
     */
    private static void roundUpInteger() {
        for (int i = 0; i < 35; i++) {
            double result = Math.ceil((double)i/4);
            System.out.print(result+"\n");
        }
    }
}
