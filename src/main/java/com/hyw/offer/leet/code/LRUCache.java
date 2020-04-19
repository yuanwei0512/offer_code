package com.hyw.offer.leet.code;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/22 14:50
 * Description：TODO
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity);
        this.capacity = capacity;
    }


    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        this.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size() > capacity;
    }
}
