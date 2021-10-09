package com.xiaokaige.sort;

import java.util.Arrays;

/**
 * @author: zk
 * Date: 2021/10/8
 * Time: 15:43
 */
public class PopSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 7};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println("arr: " + Arrays.toString(arr));
    }
}
