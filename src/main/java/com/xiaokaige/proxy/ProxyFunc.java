package com.xiaokaige.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: zk
 * Date: 2021/10/8
 * Time: 13:40
 */
public class ProxyFunc {
    public static void main(String[] args) throws Throwable {
        Student student = new Student();
        Method method = student.getClass().getMethod("eat");
        StudentProxy studentProxy = new StudentProxy(student);
        Object obj = studentProxy.invoke(studentProxy, method, null);
        System.out.println("obj = " + obj);

        Class<?> proxyClass = Proxy.getProxyClass(student.getClass().getClassLoader(), Person.class);
        System.out.println("proxyClass = " + proxyClass);
        
        boolean flag = Proxy.isProxyClass(proxyClass);
        System.out.println("flag = " + flag);
    }
}
