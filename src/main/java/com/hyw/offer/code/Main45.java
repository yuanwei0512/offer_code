package com.hyw.offer.code;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/8 16:04
 * Description：TODO
 */
public class Main45 {

    public static void main(String[] args) {
        Main45 main45 = new Main45();
        int[] nums = {3, 32, 321};
        System.out.println(main45.printMinNumber(nums));

    }

    public String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("非法参数异常");
        }

        int length = numbers.length;
        String[] strNums = new String[length];
        for (int i = 0; i < length; i++) {
            strNums[i] = numbers[i] + "";
        }

        Arrays.sort(strNums, (o1, o2) -> (o1 + o2).compareTo(o2 + o2));

        StringBuilder result = new StringBuilder();
        for (String strNum : strNums) {
            result.append(strNum);
        }
        return result.toString();
    }

}
