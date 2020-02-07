package com.hyw.java8.stream14;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/15 8:53
 * Description：TODO
 */
public class Empty<T> implements MyList<T> {

    @Override
    public T head() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MyList<T> tail() {
        throw new UnsupportedOperationException();
    }
}
