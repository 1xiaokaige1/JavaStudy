package com.xiaokaige.base.innerclass;

/**
 * @author: zk
 * Date: 2021/10/8
 * Time: 9:46
 */
public class Student {
    private String name;

    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    class Address {
        private String province;

        private String city;

        public Address(){}

        public Address(String province, String city){}

        public void test(){
            if("test".equals(name)){
                System.out.println("i am is inner class");
            }
        }
    }

    public static void main(String[] args) {
        Student student = new Student("test", 18);
        Student.Address address = student.new Address();
        address.test();
    }
}
