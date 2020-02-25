package com.hyw;

import javafx.scene.layout.Priority;

import java.util.*;
import java.util.concurrent.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/7 22:14
 * Description：TODO
 */
public class TestMain {

    private long fib(int n) {
        long[] nums = new long[n + 1];

        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];

    }

    public static void main(String[] args) {
        System.out.println(new TestMain().fib(50));
    }

}
