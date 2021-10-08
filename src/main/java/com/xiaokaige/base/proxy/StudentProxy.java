package com.xiaokaige.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: zk
 * Date: 2021/10/8
 * Time: 13:35
 */
public class StudentProxy implements InvocationHandler {

    private Student student;

    public StudentProxy(Student student){
        this.student = student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行前...");
        Object obj = method.invoke(student, args);
        System.out.println("方法执行后...");
        return obj;
    }
}
