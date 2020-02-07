package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/16 11:14
 * Description：TODO
 */
public class Main15 {

    public static void main(String[] args) {
        System.out.println(numberOf1(9));
        System.out.println(numberOf2(9));
    }

    public static int numberOf2(int n) {
        int count = 0;
        //看书
        while (n > 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }


    public static int numberOf1(int n) {

        int count = 0;
        int flag = 1;

        while (flag < n) {

            if ((flag & n) > 0) {
                count++;
            }
            //flag 从 0001 -> 0010 -> 0100
            flag = flag << 1;
        }
        return count;
    }

}
