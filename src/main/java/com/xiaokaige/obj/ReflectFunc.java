package com.xiaokaige.obj;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: zk
 * Date: 2021/9/29
 * Time: 10:19
 */
public class ReflectFunc {
    public static void main(String[] args) throws Exception{
        //反射获取一个类中的各种信息
        //使用对象获取到字节码对象
        DemoClass demoClass = new DemoClass();
        Class<? extends DemoClass> clazz = demoClass.getClass();
        //使用全类名获取字节码对象
        Class<?> classObj = Class.forName("com.xiaokaige.obj.DemoClass");
        Constructor<?> constructor = classObj.getDeclaredConstructor();
        DemoClass instanceObj = (DemoClass) constructor.newInstance();
        instanceObj.setName("无名氏");
        System.out.println("instanceObj = " + instanceObj);

        Field address = clazz.getDeclaredField("address");
        address.setAccessible(true);
        address.set(demoClass, "贫民窟");
        System.out.println(demoClass);

        Method test = clazz.getMethod("test");
        Object object = test.invoke(demoClass);
        System.out.println(object);
    }
}


class DemoClass{
    private String name;

    private String address;

    private Integer age;

    public DemoClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void test(){
        System.out.println("测试一下");
    }

    @Override
    public String toString() {
        return "DemoClass{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
