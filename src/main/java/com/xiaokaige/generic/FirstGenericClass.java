package com.xiaokaige.generic;

/**
 * @author: zk
 * Date: 2021/10/8
 * Time: 14:59
 */
public class FirstGenericClass<T> {
    private T first;

    private T second;

    public FirstGenericClass(T first, T second){
        this.first = first;
        this.second = second;
    }

    public FirstGenericClass(){}

    @Override
    public String toString() {
        return "FirstGenericClass{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
