package com.hyw.offer.leet.code;

import com.hyw.offer.code.Main32;

import java.util.Arrays;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/1 15:40
 * Description：TODO
 */
public class Main322 {

    private int[] memory;

    public int coinChange(int[] coins, int amount) {
        return 0;

    }

    /**
     *          memory = new int[amount + 1];
     *         return tryCoinChange(coins, amount);
     * @param coins
     * @param amount
     * @return
     */
    private int tryCoinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        if (memory[amount] != 0 ) {
            return memory[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = tryCoinChange(coins, amount - coin);
            if (res != -1) {
                min = Math.min(min, tryCoinChange(coins, amount - coin));
            }
        }
        if (min == Integer.MAX_VALUE) {
            memory[amount] = -1;
            return -1;
        }
        memory[amount] = min + 1;
        return memory[amount];

    }

    public static void main(String[] args) {
        Main322 main322 = new Main322();
        int[] nums = {186,419,83,408};
        //int[] nums = {1, 2, 5};
        System.out.println(main322.coinChange(nums, 11));
    }

}
