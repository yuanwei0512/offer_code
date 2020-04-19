package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/30 16:05
 * Description：TODO
 */
public class Main89 {

    public static void main(String[] args) {
        Main89 main89 = new Main89();
        System.out.println(main89.grayCode(4));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }
}
