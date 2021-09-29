package com.xiaokaige.base.objconstruct;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zk
 * Date: 2021/9/28
 * Time: 14:42
 */
public class Employee {
    private static final AtomicInteger nextId = new AtomicInteger(1);

    private static int anotherNextId = 1;

    private int id = assignId();

    private int anotherId = anotherAssignId();

    //线程安全的方法
    private static int assignId() {
        return nextId.getAndIncrement();
    }

    public int getId() {
        return id;
    }

    //线程安全的方法
    private synchronized static int anotherAssignId() {
        int r = anotherNextId;
        try {
            TimeUnit.MICROSECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        anotherNextId++;
        return r;
    }

    //非线程安全的方法
    private static int anotherAssignIdTwo() {
        int r = anotherNextId;
        try {
            TimeUnit.MICROSECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        anotherNextId++;
        return r;
    }

    public int getAnotherId() {
        return anotherId;
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        System.out.println(employee.getId());
        Employee employeeTwo = new Employee();
        System.out.println(employeeTwo.getId());

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Employee employeeTmp = new Employee();
                System.out.println(employeeTmp.getId());
            }).start();
        }

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Employee employeeTmp = new Employee();
                System.out.println(employeeTmp.getAnotherId());
            }).start();
        }
    }
}
