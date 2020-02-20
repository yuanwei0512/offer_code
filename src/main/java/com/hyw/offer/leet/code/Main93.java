package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/18 15:52
 * Description：TODO
 */
public class Main93 {

    private String s;
    private int count;
    private LinkedList<String> segmenList = new LinkedList<>();
    private List<String> resultList = new ArrayList<>();


    private void dfs(int start, int dotNum) {
        int ceil = Math.min(4, s.length() - start + 1);
        for (int i = 1; i < ceil; i++) {
            String segment = s.substring(start, start + i);

            //减枝
            int remainLength = s.length() - start - i;
            if (dotNum != 1 && remainLength / (dotNum - 1) > 3) {
                continue;
            }

            if (validate(segment)) {
                segmenList.add(segment);
                if (dotNum - 1 == 0) {
                    count++;
                    if (segment.equals(s.substring(start))) {
                        resultList.add(String.join(".", segmenList));
                    }
                } else {
                    dfs(start + i, dotNum - 1);
                }

                segmenList.removeLast();

            }
        }

    }


    private boolean validate(String segment) {
        if (segment.length() > 3 ){
            return false;
        }
        return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (segment.length() ==  1);

    }

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        dfs(0, 4);
        return resultList;
    }


    public static void main(String[] args) {
        Main93 main93 = new Main93();
        System.out.println(main93.restoreIpAddresses("25525511135"));
        System.out.println(main93.count);
    }


}
