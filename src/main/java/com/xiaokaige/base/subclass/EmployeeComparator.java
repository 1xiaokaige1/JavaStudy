package com.xiaokaige.base.subclass;


import java.util.Comparator;

/**
 * @author: zk
 * Date: 2021/9/29
 * Time: 14:11
 */
public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getAge() - o2.getAge();
    }
}
