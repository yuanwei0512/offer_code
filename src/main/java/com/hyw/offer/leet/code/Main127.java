package com.hyw.offer.leet.code;


import java.util.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/10 16:05
 * Description：TODO
 */
public class Main127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            ++count;
            for (int i = 0; i < size; ++i) {
                String start = queue.poll();
                for (String s : wordList) {
                    // 已经遍历的不再重复遍历
                    if (visited.contains(s)) {
                        continue;
                    }
                    // 不能转换的直接跳过
                    if (!canConvert(start, s)) {
                        continue;
                    }
                    // 用于调试
                    // System.out.println(count + ": " + start + "->" + s);
                    // 可以转换，并且能转换成endWord，则返回count
                    if (s.equals(endWord)) {
                        return count + 1;
                    }
                    // 保存访问过的单词，同时把单词放进队列，用于下一层的访问
                    visited.add(s);
                    queue.offer(s);
                }

            }

        }

        return 0;
    }

    public boolean canConvert(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++count;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }



    public static void main(String[] args) {
        Main127 main127 = new Main127();
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(main127.ladderLength("hit", "cog", wordList));

    }

}
