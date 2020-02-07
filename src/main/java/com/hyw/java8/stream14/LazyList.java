package com.hyw.java8.stream14;

import java.util.function.Supplier;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/15 8:50
 * Description：TODO
 */
public class LazyList<T> implements MyList<T> {

    private final T head;
    private final Supplier<MyList<T>> tail;

    public LazyList(T head, Supplier<MyList<T>> tail) {
        this.head = head;
        this.tail = tail;
    }

    public static LazyList<Integer> from(int n) {
        return new LazyList<Integer>(n, () -> from(n + 1));
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public MyList<T> tail() {
        return tail.get();
    }
}
