package com.xiaokaige.queue;

import com.xiaokaige.proxy.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zk
 * Date: 2021/10/11
 * Time: 17:27
 */
public class MapFunc {
    public static void main(String[] args) {
        Map<String, Student> map = new HashMap<>();
        Student oneStudent = new Student(12);
        Student twoStudent = new Student(15);
        map.put("A", oneStudent);
        map.put("B", twoStudent);
        Student studentResult = map.getOrDefault("B", new Student());
        System.out.println("studentResult = " + studentResult);

        map.forEach((k, v) -> System.out.println(k + "--->" + v));
    }
}
