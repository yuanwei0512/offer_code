package com.hyw.offer.code;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/9 15:48
 * Description：TODO
 */
public class Main62 {

    public int lastRemaining(int n, int m) {

        if (n < 1 || m < 1) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;

    }

    public static void main(String[] args) {
        Main62 main62 = new Main62();
        System.out.println(main62.lastRemaining(5, 3));
    }

}
