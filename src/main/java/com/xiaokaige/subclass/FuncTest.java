package com.xiaokaige.subclass;

/**
 * @author: zk
 * Date: 2021/9/28
 * Time: 16:25
 */
public class FuncTest {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setSalary(100.0);

        Employee employeeTwo = new Employee();
        employeeTwo.setSalary(200.0);
        System.out.println("employee salary:" + employee.getSalary());
        //由固定薪资和奖金津贴构成
        Manager manager = new Manager();
        manager.setSalary(200.0);
        manager.setBonus(50.0);
        System.out.println("manager salary:" + manager.getSalary());
        //多态，如果子类中有和父类中的public修饰的同名的但是方法签名不同的方法，在选择使用哪个方法进行调用的时候就会进行方法的重载解析
        //如果是private、static、final修饰的方法，那编译器知道使用哪个方法，即静态绑定
        //如果子类重写了父类的方法，那需要根据对象的实际类型来决定调用哪个方法，即会完成运行时的动态绑定
        //每个类在虚拟机中都会有对应的方法表，在实际调用某个方法的时候，就会直接去查询该类的方法表
        Employee[] arr = new Employee[]{employee, employeeTwo, manager};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getSalary());
        }
    }
}
