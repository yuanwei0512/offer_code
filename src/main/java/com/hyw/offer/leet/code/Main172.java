package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/25 16:01
 * Description：TODO
 */
public class Main172 {

    public static void main(String[] args) {
        Main172 main172 = new Main172();
        System.out.println(main172.trailingZeroes(11));
    }

    public int trailingZeroes(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int cur = i;
            while (cur % 5 == 0) {
                cur = cur / 5;
                count++;
                if (cur < 5) {
                    break;
                }
            }
        }
        return count;
    }

}
