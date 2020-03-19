package com.hyw.offer.leet.code;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/2 16:18
 * Description：TODO
 */
public class Main139 {

    private int[] memory;

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        Set<String> wordSet = new HashSet<>(wordDict);

        dp[0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];

    }


    /**
     * if (s == null || s.trim().length() == 0 || wordDict.size() == 0) {
     * return false;
     * }
     * memory = new int[s.length() + 1];
     * return wordBreak(s, new HashSet<String>(wordDict), 0);
     */
    private boolean wordBreak(String s, Set<String> wordDict, int index) {

        if (index == s.length()) {
            return true;
        }

        if (memory[index] != 0) {
            return memory[index] != 1;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(index, i)) && wordBreak(s, wordDict, i)) {
                memory[index] = 2;
                return true;
            }
        }
        memory[index] = 1;
        return false;
    }

    public static void main(String[] args) {
        Main139 main139 = new Main139();
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");
        System.out.println(main139.wordBreak(s, wordDict));
    }

}
