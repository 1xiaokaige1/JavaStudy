package com.xiaokaige.base.subclass;

import java.util.Comparator;

/**
 * @author: zk
 * Date: 2021/9/29
 * Time: 14:17
 */
public class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
