package com.xiaokaige.queue;

import com.xiaokaige.proxy.Student;

import java.util.*;

/**
 * @author: zk
 * Date: 2021/10/11
 * Time: 15:39
 */
public class ListFunc {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("a");
        //该方法做了点优化，如果目标索引大于size/2，那会从链表尾部对链表进行遍历
        String s = list.get(0);
        System.out.println("s = " + s);

        //treeSet中的元素必须要实现了Comparable接口
        TreeSet<Student> set = new TreeSet<>();
        Student student = new Student();
        student.setAge(18);
        set.add(student);

        //优先级队列，在进行迭代器迭代的时候总是会优先移除按比较器比较较小的元素
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();
        Student twoStudent = new Student(20);
        Student oneStudent = new Student(10);
        Student thirdStudent = new Student(30);
        priorityQueue.add(oneStudent);
        priorityQueue.add(twoStudent);
        priorityQueue.add(thirdStudent);
        //测试移除优先队列中的元素
        Iterator<Student> priorityIterator = priorityQueue.iterator();
        priorityIterator.next();
        priorityIterator.remove();
        System.out.println("priorityQueue = " + priorityQueue);
    }
}
