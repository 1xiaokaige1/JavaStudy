package com.xiaokaige.interfaces;

/**
 * @author: zk
 * Date: 2021/9/29
 * Time: 13:50
 */
public interface StudentInterface {
     default void test(){
          System.out.println("it is interface");
     }
}
