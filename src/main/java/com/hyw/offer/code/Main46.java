package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/6 14:50
 * Description：TODO
 */
public class Main46 {

    private int[] memory;

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];

        dp[0] = 1;
        Integer preTwo = Integer.valueOf(s.substring(0, 2));
        if (preTwo >= 0 || preTwo <= 25) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i - 1) - '0' == 1) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else if (s.charAt(i - 1) - '0' == 2 && i < 6) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }

        }
        return dp[s.length() - 1];
    }

    /**
     * if (s == null || s.length() == 0) {
     * return 0;
     * }
     * memory = new int[s.length()];
     * return tryNumDecodings(s, 0);
     */
    private int tryNumDecodings(String s, int index) {

        if (index >= s.length()) {
            return 1;
        }

        if (memory[index] != 0) {
            return memory[index];
        }

        int result = 0;
        result += tryNumDecodings(s, index + 1);

        if (index + 1 < s.length()) {
            Integer two = Integer.valueOf(s.substring(index, index + 2));
            if (two >= 0 && two <= 25) {
                result += tryNumDecodings(s, index + 2);
            }
        }
        return memory[index] = result;
    }

    public static void main(String[] args) {
        Main46 main46 = new Main46();
        System.out.println(main46.numDecodings("122512"));
    }

}
