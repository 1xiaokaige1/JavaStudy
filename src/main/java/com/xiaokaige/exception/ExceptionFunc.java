package com.xiaokaige.exception;

/**
 * @author: zk
 * Date: 2021/10/8
 * Time: 14:07
 */
public class ExceptionFunc {
    public static void main(String[] args) {
        //int i = 10 / 2;
        throw new BusinessException(500, "Internal Server Exception");
    }
}
