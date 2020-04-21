package com.hyw.offer.leet.code;

import java.util.Arrays;

/**
 * Project：study_996     @author yuanwei
 * DateTime：2020/4/21 11:24
 * Description：TODO
 */
public class Main274 {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Main274 main274 = new Main274();
        int[] nums = {3,0,6,1,5};
        System.out.println(main274.hIndex(nums));
    }

}
