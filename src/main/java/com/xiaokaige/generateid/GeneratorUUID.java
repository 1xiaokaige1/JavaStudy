package com.xiaokaige.generateid;

/**
 * @author zengkai
 * @date 2021/7/6 14:20
 */
public class GeneratorUUID {


    public static Long getUid() {
        SnowFlake snowFlake = new SnowFlake();
        return snowFlake.nextId();
    }

    public static Long getUid(long milliseconds){
        SnowFlake snowFlake = new SnowFlake();
        return snowFlake.nextId(milliseconds);
    }
}
