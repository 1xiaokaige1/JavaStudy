package com.xiaokaige.arrdata;

import java.util.Arrays;

public class ArrayFunc {
    public static void main(String[] args) {
        int[] arr = new int[0];
        System.out.println(Arrays.toString(arr));
        int[] arrTwo = null;
        System.out.println("arrTwo = " + arrTwo);

        int[][] arrThree = new int[2][2];
        int outLength = arrThree.length;
        for (int i = 0; i < outLength; i++) {
            int innerLength = arrThree[i].length;
            for (int j = 0; j < innerLength; j++) {
                arrThree[i][j] = j;
            }
        }

        for (int i = 0; i < outLength; i++) {
            System.out.println(Arrays.toString(arrThree[i]));
        }
    }
}
