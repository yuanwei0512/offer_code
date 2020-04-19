package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/24 15:04
 * Description：TODO
 */
public class Main134 {

    public static void main(String[] args) {
        Main134 main134 = new Main134();
        int[] gas = {1, 2, 3, 4, 5};
        int[] gas2 = {3, 4, 5, 1, 2};
        System.out.println(main134.canCompleteCircuit(gas, gas2));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }
        int lastContain = 0;
        int currentContian = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            lastContain = lastContain + gas[i] - cost[i];
            currentContian = currentContian + gas[i] - cost[i];
            if (currentContian < 0) {
                start = i + 1;
                currentContian = 0;
            }
        }
        return lastContain >= 0 ? start : -1;


    }

}
