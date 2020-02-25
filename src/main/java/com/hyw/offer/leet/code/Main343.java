package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/25 16:49
 * Description：TODO
 */
public class Main343 {
    private int[] memory;
    private int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n - 1; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * breakInteger(n - i)));
        }
        memory[n] = res;
        return res;

    }

    public int integerBreak(int n) {
        if (n == 2) {
            return n;
        }
        int[] memory = new int[n + 1];

        memory[1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                memory[i] = Math.max(memory[i], Math.max(j * (i - j), j*(memory[i - j])));

            }
        }

        return memory[n];

    }

    public static void main(String[] args) {
        Main343 main343 = new Main343();
        System.out.println(main343.integerBreak(10));
    }

}
