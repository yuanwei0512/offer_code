package com.hyw.offer.leet.code;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/12 16:45
 * Description：TODO
 */
public class Main350 {

    /**
     * 有序数组的交集
     */
    public List intersect2(int[] nums1, int[] nums2) {

        List<Integer> resultList = new ArrayList<>();
        int l = 0;
        int r = 0;
        int lastTemp = -1;
        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] == nums2[r]) {
                lastTemp = nums1[l];
                l++;
                r++;
                continue;
            }
            if ((nums1[l] != lastTemp) && (nums2[r] != lastTemp) && (lastTemp != -1)) {
                resultList.add(lastTemp);

            } else if (nums1[l] > nums2[r]) {
                r++;
            } else {
                l++;
            }
            lastTemp = -1;
        }
        return resultList;

    }

    /**
     * 无序数组的交集
     */
    public List intersect(int[] nums1, int[] nums2) {

        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Long> nums1Map = Arrays.stream(nums1).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> nums2Map = Arrays.stream(nums2).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        nums1Map.forEach((k, v) -> {
            if (nums2Map.containsKey(k)) {
                if (nums2Map.get(k).equals(v)) {
                    for (int i = 0; i < v; i++) {
                        resultList.add(k);
                    }

                }
            }
        });
        return resultList;
    }

    public static void main(String[] args) {
        Main350 main350 = new Main350();
        int[] nums1 = {1, 3, 3, 4, 5, 6};
        int[] nums2 = {0, 2, 3, 3, 3, 4, 6};
        System.out.println(main350.intersect2(nums1, nums2));
    }

}
