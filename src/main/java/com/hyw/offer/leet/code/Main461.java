package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/4/7 15:11
 * Description：TODO
 */
public class Main461 {

    public static void main(String[] args) {
        Main461 main461 = new Main461();
        System.out.println(main461.hammingDistance(7, 4));
    }

    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        int temp;
        while (n > 0) {
            temp = n & 1;
            if (temp == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

}
