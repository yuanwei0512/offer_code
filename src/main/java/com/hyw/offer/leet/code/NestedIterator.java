package com.hyw.offer.leet.code;

import java.util.Iterator;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/15 20:37
 * Description：TODO
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list;
    private int index = -1;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = integerIterator(nestedList);
    }

    private List<Integer> integerIterator(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                list.addAll(integerIterator(nestedInteger.getList()));
            }
        }
        return list;
    }

    @Override
    public Integer next() {
        if (index + 1 < list.size()) {
            return list.get(++index);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (index + 1 < list.size()) {
            return true;
        }
        return false;
    }
}

interface NestedInteger {
    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}