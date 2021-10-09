package com.xiaokaige.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: zk
 * Date: 2021/10/8
 * Time: 17:38
 */
public class TestSet {
    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> setOne = new ArrayList<>();
        List<Integer> setTwo = new ArrayList<>();
        setOne.add(1);
        setOne.add(2);
        setTwo.add(1);
        setTwo.add(2);
        set.add(setOne);
        set.add(setTwo);
        System.out.println(set);
    }
}
