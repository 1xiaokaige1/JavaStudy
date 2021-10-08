package com.xiaokaige.base.innerclass;

/**
 * @author: zk
 * Date: 2021/10/8
 * Time: 10:29
 */
public class LocalItyInnerClass {

    private String name;

    private Integer age;

    public void test() {
        class Address {
            private String province;

            private String city;

            public void test() {
                if ("test".equals(name)) {
                    System.out.println("i am localIty class");
                }
            }

            public Address getAddress() {
                return new Address();
            }
        }
        Address address = new Address();
        address.test();
    }

    public static void main(String[] args) {
        LocalItyInnerClass localItyInnerClass = new LocalItyInnerClass();
        localItyInnerClass.name = "test";
        localItyInnerClass.test();
    }
}
