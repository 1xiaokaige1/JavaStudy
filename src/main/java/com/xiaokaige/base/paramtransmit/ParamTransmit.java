package com.xiaokaige.base.paramtransmit;

import com.xiaokaige.base.entity.Trader;

/**
 * @author: zk
 * Date: 2021/9/28
 * Time: 14:16
 */
public class ParamTransmit {
    public static void main(String[] args) {
        int original = 3;
        int result = changeData(original);
        System.out.println("original = " + original);

        String originalStr = "aba";
        String secondResult = changeData(originalStr);
        System.out.println("originalStr = " + originalStr);

        Trader trader = new Trader();
        changeTraderData(trader);
        System.out.println("trader = " + trader);

        Integer tmp = 5;
        Integer thirdResult = changeIntegerData(tmp);
        System.out.println("tmp = " + tmp);

    }

    //基本类型传递
    public static int changeData(int param) {
        return param * 2;
    }

    public static String changeData(String param) {
        return param + "a";
    }

    public static Integer changeIntegerData(Integer param) {
        return param * 2;
    }

    //引用类型传递
    public static Trader changeTraderData(Trader trader) {
        trader.setAddress("无人小岛");
        return trader;
    }

}
