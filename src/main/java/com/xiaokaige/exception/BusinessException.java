package com.xiaokaige.exception;

/**
 * @author: zk
 * Date: 2021/10/8
 * Time: 14:05
 */
public class BusinessException extends RuntimeException {
    private int code;

    private String message;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
