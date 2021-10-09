package com.xiaokaige.leetcode;

import java.util.*;

/**
 * @author: zk
 * Date: 2021/10/8
 * Time: 16:26
 */
public class FindArr {
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2};
        List<List<Integer>> lists = fourSum(arr, 0);
        System.out.println("lists = " + lists);

        List<List<Integer>> listResult = fourSumAnswer(arr, 8);
        System.out.println("listResult = " + listResult);
    }

    /**
     * stupid
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int size = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> integerList = new ArrayList<>();
            integerList.add(i);
            for (int j = 0; j < size; j++) {
                if (j == i) {
                    continue;
                }
                if (integerList.size() == 4) {
                    integerList.remove(1);
                    integerList.remove(1);
                    integerList.remove(1);
                }
                integerList.add(j);
                for (int k = 0; k < size; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    if (integerList.size() == 4) {
                        integerList.remove(2);
                        integerList.remove(2);
                    }
                    integerList.add(k);
                    for (int l = 0; l < size; l++) {
                        if (l == i || l == k || l == j) {
                            continue;
                        }
                        if (integerList.size() == 4) {
                            integerList.remove(3);
                        }
                        integerList.add(l);
                        ArrayList<Integer> collectList = new ArrayList<>(integerList);
                        list.add(collectList);
                    }
                }
            }
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();
        for (List<Integer> integers : list) {
            Set<Integer> set = new HashSet<>();
            List<Integer> listTwo = new ArrayList<>();
            set.add(integers.get(0));
            set.add(integers.get(1));
            set.add(integers.get(2));
            set.add(integers.get(3));
            if (set.size() < 4) {
                continue;
            }
            listTwo.add(nums[integers.get(0)]);
            listTwo.add(nums[integers.get(1)]);
            listTwo.add(nums[integers.get(2)]);
            listTwo.add(nums[integers.get(3)]);
            listTwo.sort(Comparator.comparingInt(a -> a));
            if (!resultSet.add(listTwo)) {
                continue;
            }

            if (nums[integers.get(0)] + nums[integers.get(1)] + nums[integers.get(2)] + nums[integers.get(3)] == target) {
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(nums[integers.get(0)]);
                tmpList.add(nums[integers.get(1)]);
                tmpList.add(nums[integers.get(2)]);
                tmpList.add(nums[integers.get(3)]);
                resultList.add(tmpList);
            }
        }
        return resultList;
    }

    /**
     * smart
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSumAnswer(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}