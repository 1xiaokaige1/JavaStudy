package com.xiaokaige.base.funcInterface;

import com.xiaokaige.base.entity.Trader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zk
 * Date: 2021/9/29
 * Time: 14:44
 */
public class FuncTest {
    public static void main(String[] args) {
        FuncTest funcTest = new FuncTest();
        //直接传递行为给到函数式接口
        List<Trader> list = funcTest.getList(ArrayList::new);
        System.out.println("list = " + list);

        funcTest.listTwo(()-> System.out.println("abc"));
    }

    public List<Trader> getList(FuncInterface param){
        return param.test();
    }

    public void listTwo(FunctionInterfaceTwo param){
        param.test();
    }


}
