package com.xiaokaige.obj;

import com.xiaokaige.base.subclass.Employee;
import com.xiaokaige.base.subclass.EmployeeComparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: zk
 * Date: 2021/9/29
 * Time: 14:07
 */
public class ComparatorSortFunc {
    public static void main(String[] args) {
        Employee[] employeeArr = new Employee[3];
        for (int i = 0; i < employeeArr.length; i++) {
            Employee employee = new Employee();
            employee.setName("employee" + i);
            employee.setAddress("address" + i);
            employee.setAge(i);
            employee.setSalary(10.0);
            employeeArr[i] = employee;
        }
        Arrays.sort(employeeArr, new EmployeeComparator());
        //直接传入实例化的比较器
        Arrays.sort(employeeArr, Comparator.comparing(Employee::getAddress));
    }
}
