package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/28 15:19
 * Description：TODO
 */
public class Main122 {

    public int maxProfit(int[] prices) {
        int maxValue = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                maxValue += prices[i] - prices[i - 1];
            }
        }
        return maxValue;
    }



}
