package com.xiaokaige.generateid;

import org.apache.commons.lang3.StringUtils;

import javax.annotation.PostConstruct;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;

/**
 * @author zengkai
 * @date 2021/7/6 14:20
 */
public class SnowFlake {

    /**
     * 起始的时间戳
     */
    private final static long START_STMP = 1480166465631L;

    /**
     * 每一部分占用的位数
     */
    private final static long SEQUENCE_BIT = 12; //序列号占用的位数
    private final static long MACHINE_BIT = 4;  //机器标识占用的位数
    private final static long PROJECT_BIT = 4; //项目标识占用的位数
    private final static long ENVIRONMENT_BIT = 2; //环境标识占用的位数

    /**
     * 每一部分的最大值
     */
    private final static long MAX_PROJECT_NUM = -1L ^ (-1L << PROJECT_BIT);
    private final static long MAX_ENVIRONMENT_NUM = -1L ^ (-1L << ENVIRONMENT_BIT);
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移
     */
    private final static long ENVIRONMENT_LEFT = SEQUENCE_BIT;
    private final static long PROJECT_LEFT = ENVIRONMENT_BIT + ENVIRONMENT_LEFT;
    private final static long MACHINE_LEFT = PROJECT_BIT + PROJECT_LEFT;
    private final static long TIMESTMP_LEFT = MACHINE_BIT + MACHINE_LEFT;

    private long projectId = 0; //配置文件中的项目标识
    private long environmentId = 0; //配置文件中的环境标识

    private long machineId;    //机器标识

    private long sequence = 0L; //序列号

    private long lastStmp = -1L;//上一次时间戳

    private Random random = new Random();


    /**
     * 校验项目值、环境值和机器值
     *
     * @throws UnknownHostException
     */
    @PostConstruct
    public void verify() throws UnknownHostException {
        if (projectId > MAX_PROJECT_NUM || projectId < 0) {
            throw new IllegalArgumentException("项目值超过最大值");
        }

        if (environmentId > MAX_ENVIRONMENT_NUM || environmentId < 0) {
            throw new IllegalArgumentException("环境值超过最大值");
        }

        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("机器ID值超过最大值");
        }
        machineId = getMachineId();
    }

    /**
     * 产生下一个ID
     *
     * @return long
     */
    public synchronized long nextId() {
        long currStamp = getNewStamp();

        if (currStamp < lastStmp) {
            throw new RuntimeException("时钟回拨异常");
        }

        /*
        //采用自增的方式生成序列号
        if (currStmp == lastStmp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currStmp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }

        lastStmp = currStmp;*/

        //采用4096内的随机数生成序列号
        sequence = random.nextInt(4096);

        return (currStamp - START_STMP) << TIMESTMP_LEFT //时间戳部分
                | machineId << MACHINE_LEFT            //机器标识部分
                | projectId << PROJECT_LEFT            //项目标识部分
                | environmentId << ENVIRONMENT_LEFT    //环境标识部分
                | sequence;                            //序列号部分
    }


    /**
     * 产生指定时间戳内的id
     *
     * @return long
     */
    public synchronized long nextId(long milliseconds) {

        //采用4096内的随机数生成序列号
        sequence = random.nextInt(4096);

        return (milliseconds - START_STMP) << TIMESTMP_LEFT //时间戳部分
                | machineId << MACHINE_LEFT            //机器标识部分
                | projectId << PROJECT_LEFT            //项目标识部分
                | environmentId << ENVIRONMENT_LEFT    //环境标识部分
                | sequence;                            //序列号部分
    }

    /**
     * 产生指定LocalDateTime内的id
     *
     * @return
     */
    public synchronized long nextId(LocalDateTime localDateTime) {

        //采用4096内的随机数生成序列号
        sequence = random.nextInt(4096);

        long milliseconds = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();

        return (milliseconds - START_STMP) << TIMESTMP_LEFT //时间戳部分
                | machineId << MACHINE_LEFT            //机器标识部分
                | projectId << PROJECT_LEFT            //项目标识部分
                | environmentId << ENVIRONMENT_LEFT    //环境标识部分
                | sequence;                            //序列号部分
    }


    private long getNextMill() {
        long mill = getNewStamp();
        while (mill <= lastStmp) {
            mill = getNewStamp();
        }
        return mill;
    }

    private Long getMachineId() throws UnknownHostException {
        String hostAddress = Inet4Address.getLocalHost().getHostAddress();
        int[] ints = StringUtils.toCodePoints(hostAddress);
        int sums = 0;
        for (int b : ints) {
            sums += b;
        }
        return (long) (sums % 16);
    }

    private long getNewStamp() {
        return System.currentTimeMillis();
    }

}





