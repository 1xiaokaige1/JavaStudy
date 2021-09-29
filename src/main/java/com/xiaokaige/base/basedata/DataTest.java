package com.xiaokaige.base.basedata;

import java.util.ArrayList;
import java.util.List;

public class DataTest {
    //一个类常量，可以在多个类中使用
    public static final String CLASS_CONSTANT = "this is a class constant";

    public static void main(String[] args) {
        //变量必须要进行初始化才能使用
        List<String> list = new ArrayList<>();
        System.out.println(list);

        //局部常量
        final String TEST_STR = "study";
        System.out.println("testStr = " + TEST_STR);

        //无论正负总会得到一个介于0-X之间的数
        int result = Math.floorMod(-12, 12);
        System.out.println("result = " + result);

        int x = 10;
        int y = -10;
        String binaryX = Integer.toBinaryString(x);
        String binaryY = Integer.toBinaryString(y);
        System.out.println("binaryX = " + binaryX);
        System.out.println("binaryY = " + binaryY);

        int one = x>>>2;
        int two = x>>2;
        System.out.println("one = " + one);
        System.out.println("two = " + two);

        int three = y >>>2;
        int four = y>>2;
        System.out.println("three = " + three);
        System.out.println("four = " + four);

        int c = 1001 | 1010;
        System.out.println("c = " + c);

    }
}
