package com.xiaokaige.base.stringdata;

import java.util.List;
import java.util.stream.Collectors;

public class StringFunc {
    public static void main(String[] args) {
        String testStr = "abc";
        //获取指定位置码点
        int number = testStr.codePointAt(0);
        //获取指定位置的码点的索引
        int specialNumber = testStr.offsetByCodePoints(0, 2);
        //获取指定索引的字符
        char c = testStr.charAt(0);
        //转换成包装流进行收集
        List<String> collect = testStr
                .codePoints()
                .boxed()
                .map(Object::toString)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
        System.out.println("specialNumber = " + specialNumber);
        System.out.println("c = " + c);
        System.out.println("number = " + number);

        //使用码点数组构造一个新的字符串
        int[] codePoints = {1,97,98,4};
        String newStr = new String(codePoints, 1, 2);
        System.out.println("newStr = " + newStr);

    }
}
