package com.xiaokaige.obj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zk
 * Date: 2021/9/29
 * Time: 9:42
 */
public class ChangeParam {

    //可变参数，接收参数的时候使用的数组的形式
    public static void main(String[] args) {
        double oneParam = 1.0;
        double[] arr = {2.0, 3.0};
        List<String> list = new ArrayList<>();
        list.add("1");
        methodOne(arr, list, oneParam);
    }


    private static void methodOne(Object... values) {
        System.out.println(values.getClass().getTypeName());
    }
}
