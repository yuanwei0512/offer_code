package com.hyw.offer.leet.code;

import java.util.LinkedList;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/23 16:24
 * Description：TODO
 */
public class Main208 {

    class Trie {
        private LinkedList<Character> linkedList;

        private String word;

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            linkedList = new LinkedList<Character>();
            char[] chars = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                linkedList.add(chars[i]);
            }
            this.word = word;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            int i = this.word.indexOf(word);
            return i > 0;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            if (chars.length > linkedList.size()) {
                return false;
            }
            int i = 0;
            for (; i < chars.length; i++) {
                Character character = linkedList.get(i);
                if (character != chars[i]) {
                    return false;
                }
            }
            return true;
        }
    }

}
