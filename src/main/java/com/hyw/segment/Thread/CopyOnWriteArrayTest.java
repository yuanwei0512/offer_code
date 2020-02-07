package com.hyw.segment.Thread;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/3 15:51
 * Description：TODO
 */
public class CopyOnWriteArrayTest {

    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    static{
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
    }

    public static void main(String[] args) {
        for (String s : list) {
            System.out.println(s);
            list.add("test");
        }

        for (String s : list) {
            System.out.print(s + " ");

        }
    }

}
