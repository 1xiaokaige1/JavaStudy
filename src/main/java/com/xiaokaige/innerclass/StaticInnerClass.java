package com.xiaokaige.innerclass;

/**
 * @author: zk
 * Date: 2021/10/8
 * Time: 10:57
 */
public class StaticInnerClass {
    private String name;

    private Integer age;

    public static class Address {

    }

    public static Address getAddress(){
        return new Address();
    }
}
