package com.xiaokaige.base.enumdata;

/**
 * 新建的枚举类
 */
public enum TestEnum {
    SMALL(0),

    MEDIUM(1),

    LARGE(2),

    EXTRA_LARGE(3);

    private int code;

    TestEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }


}
