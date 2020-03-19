package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/26 15:51
 * Description：TODO
 */
public class Main91 {

    private int[] memory;

    public int numDecodings(String s) {

        int[] memory = new int[s.length() + 1];
        memory[s.length()] = 1;
        if (s.charAt(s.length() - 1) == '0') {
            memory[s.length() - 1] = 0;
        } else {
            memory[s.length() - 1] = 1;
        }

        for (int i = s.length() - 2; i >= 0; i--) {
            int ten = (s.charAt(i) - '0') * 10;
            int one = (s.charAt(i + 1) - '0');
            if (ten + one <= 26) {
                memory[i] = memory[i + 1] + memory[i + 2];
            } else {
                memory[i] = memory[i + 1];
            }
        }
        return memory[0];


    }


    /**
     * if (s == null || s.trim().length() == 0) {
     * return 0;
     * }
     * memory = new int[s.length()];
     * return numDecodings(s, 0);
     *
     * @param s
     * @param index
     * @return
     */
    private int numDecodings(String s, int index) {

        if (s.length() == index) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }

        if (memory[index] != 0) {
            return memory[index];
        }

        int sum = 0;
        //计算个位数
        sum += numDecodings(s, index + 1);
        //计算两位数的
        if (s.length() - 1 > index) {
            int ten = (s.charAt(index) - '0') * 10;
            int one = (s.charAt(index + 1) - '0');
            if (ten + one <= 26) {
                sum += numDecodings(s, index + 2);
            }
        }

        memory[index] = sum;

        return sum;

    }

    public static void main(String[] args) {
        Main91 main91 = new Main91();
        System.out.println(main91.numDecodings("226"));
    }

}
