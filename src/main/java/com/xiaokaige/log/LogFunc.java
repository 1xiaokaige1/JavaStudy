package com.xiaokaige.log;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author: zk
 * Date: 2021/10/8
 * Time: 14:26
 */
public class LogFunc {
    public static final Logger logger = Logger.getLogger("com.xiaokaige.log.LogFunc");

    public static void main(String[] args) {
        logger.log(Level.INFO, "程序开始运行...");
        for (int i = 0; i < 100; i++) {
        }
        logger.log(Level.INFO, "程序运行结束");
    }
}
