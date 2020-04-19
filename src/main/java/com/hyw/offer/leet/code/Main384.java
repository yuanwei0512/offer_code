package com.hyw.offer.leet.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/28 22:34
 * Description：TODO
 */
public class Main384 {

    private int[] elementData;


    public Main384(int[] nums) {
        elementData = Arrays.copyOf(nums, nums.length);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        int[] result = new int[elementData.length];
        result = Arrays.copyOf(elementData, elementData.length);
        return result;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        List<Integer> list = Arrays.stream(elementData)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(list);
        int[] result = new int[elementData.length];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }



}
