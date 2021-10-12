package com.xiaokaige.proxy;

/**
 * @author: zk
 * Date: 2021/10/8
 * Time: 11:11
 */
public class Student implements Person, Comparable<Student> {

    private Integer age;

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public Student(){}

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }

    public Student(Integer age){
        this.age = age;
    }

    @Override
    public String eat() {
        System.out.println("i am eating");
        return "method has invoked";
    }


    @Override
    public int compareTo(Student o) {
        return o.getAge();
    }
}
