package com.xiaokaige.obj;

import com.xiaokaige.base.entity.Trader;

import java.util.Arrays;

/**
 * @author: zk
 * Date: 2021/9/29
 * Time: 13:41
 */
public class ComparableSortFunc {
    public static void main(String[] args) {
        //使用Arrays的sort排序方法，必须要求元素实现了comparable接口
        Trader[] traderArr = new Trader[5];
        for (int i = 0; i < traderArr.length; i++) {
            Trader trader = new Trader();
            trader.setName("trader" + i);
            trader.setAddress("address" + i);
            trader.setAddress("age" + i);
            traderArr[i] = trader;
        }
        Arrays.sort(traderArr);
        System.out.println(Arrays.toString(traderArr));
    }
}
