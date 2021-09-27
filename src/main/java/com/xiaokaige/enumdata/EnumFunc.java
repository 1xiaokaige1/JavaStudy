package com.xiaokaige.enumdata;

/**
 * 测试枚举类
 */
public class EnumFunc {
    public static void main(String[] args) {
        TestEnum testEnum = TestEnum.LARGE;
        int code = testEnum.getCode();
        System.out.println("code = " + code);
    }
}
