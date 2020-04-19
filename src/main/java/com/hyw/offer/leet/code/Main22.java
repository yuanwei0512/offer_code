package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/24 14:51
 * Description：TODO
 */
public class Main22 {

    private List<String> resultList;

    public static void main(String[] args) {
        Main22 main22 = new Main22();
        System.out.println(main22.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {

        if (n <= 0) {
            return Collections.emptyList();
        }
        resultList = new ArrayList<>();
        tryGenerate("", 0, 0, n);
        return resultList;
    }

    private void tryGenerate(String s, int left, int right, int lenght) {

        if (right > left || left > lenght || right > lenght) {
            return;
        }
        if (left == lenght && right == lenght) {
            resultList.add(s);
        }
        tryGenerate(s + "(", left + 1, right, lenght);
        tryGenerate(s + ")", left, right + 1, lenght);
    }

}
