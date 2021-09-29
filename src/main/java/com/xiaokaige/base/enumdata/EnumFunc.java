package com.xiaokaige.base.enumdata;

/**
 * 测试枚举类
 */
public class EnumFunc {
    public static void main(String[] args) {
        TestEnum testEnum = TestEnum.LARGE;
        int code = testEnum.getCode();
        System.out.println("code = " + code);

        //可直接获取到枚举值的常量字符串
        String s = TestEnum.LARGE.toString();
        System.out.println("s = " + s);

        //比较两个枚举是否相等直接使用==号即可
        TestEnum small = Enum.valueOf(TestEnum.class, "SMALL");
        boolean flag = small == TestEnum.SMALL;
        System.out.println("flag = " + flag);
    }
}
