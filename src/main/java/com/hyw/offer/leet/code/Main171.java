package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/25 17:14
 * Description：TODO
 */
public class Main171 {


    public static void main(String[] args) {
        Main171 main171 = new Main171();
        System.out.println(main171.titleToNumber("ZY"));
    }

    public int titleToNumber(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int cur = chars[i] - 'A' + 1;
            result = result * 26 + cur;
        }
        return result;
    }

}
