package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project：study_996     @author yuanwei
 * DateTime：2020/4/21 19:18
 * Description：TODO
 */
public class Main228 {

    public List<String> summaryRanges(int[] nums) {
        if (nums == null | nums.length == 0) {
            return Collections.emptyList();
        }
        int left = 0;
        int rith = 1;

        List<String> resultList = new ArrayList<>();

        int n = nums.length;
        while (rith < n) {
            if (nums[rith] - 1 != nums[rith - 1]) {
                String temp;
                if (left == rith - 1) {
                    temp = nums[left] + "";
                } else {
                    temp = nums[left] + "->" + nums[rith - 1] + "";
                }
                resultList.add(temp);
                left = rith;
            }
            rith++;
        }
        String temp;
        if (left == rith - 1) {
            temp = nums[left] + "";
        } else {
            temp = nums[left] + "->" + nums[rith - 1] + "";
        }
        resultList.add(temp);
        return resultList;
    }

    public static void main(String[] args) {
        Main228 main228 = new Main228();
        int[] nums ={0,1,2,4,5,7};
        System.out.println(main228.summaryRanges(nums));
    }

}
