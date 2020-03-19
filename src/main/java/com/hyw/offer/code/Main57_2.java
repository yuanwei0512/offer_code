package com.hyw.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/8 15:51
 * Description：TODO
 */
public class Main57_2 {

    public static void main(String[] args) {
        Main57_2 main57_2 = new Main57_2();
        System.out.println(main57_2.FindContinuousSequence(15));
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        int l = 1;
        int r = 2;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (l < r && (l + r) <= sum) {

            int curSum = 0;
            for (int i = l; i <= r; i++) {
                curSum += i;
            }
            if (curSum == sum) {
                ArrayList<Integer> segment = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    segment.add(i);
                }
                result.add(segment);
                l++;
                r++;
            } else if (curSum < sum) {
                r++;
            } else {
                l++;
            }


        }
        return result;

    }

}
