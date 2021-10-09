package com.xiaokaige.generic;

import com.xiaokaige.innerclass.Student;

/**
 * @author: zk
 * Date: 2021/10/8
 * Time: 15:00
 */
public class GenericFunc {
    public static void main(String[] args) {
        Student first = new Student();
        Student second = new Student();
        FirstGenericClass<Student> firstGenericClass = new FirstGenericClass<>(first, second);
        System.out.println("firstGenericClass = " + firstGenericClass);
    }
}
