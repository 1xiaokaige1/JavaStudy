package com.xiaokaige.proxy;

/**
 * @author: zk
 * Date: 2021/10/8
 * Time: 11:11
 */
public class Student implements Person {
    @Override
    public String eat() {
        System.out.println("i am eating");
        return "method has invoked";
    }
}
