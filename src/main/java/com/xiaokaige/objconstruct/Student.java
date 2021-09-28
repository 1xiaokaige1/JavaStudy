package com.xiaokaige.objconstruct;

import java.util.Random;

/**
 * @author: zk
 * Date: 2021/9/28
 * Time: 15:31
 */
public class Student {
    private String name;

    private String address;

    private static Integer age;

    //普通代码块会优先与构造方法执行，不过一般这样的代码块会直接放入到构造方法中
    {
        name = "小曾";
    }

    static {
        age = new Random().nextInt(100);
    }

    public Student(){
        System.out.println("无参构造执行...");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println("student = " + student);

        Student studentTwo = new Student();
        System.out.println("studentTwo = " + studentTwo);
    }


}
