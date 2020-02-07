package com.hyw.queue;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/7 9:53
 * Description：TODO
 */
public interface MyQueue<T> {

    /**
     * @param item 放入队列的数据
     * @return 是否放入成功
     */
    void put(T item) throws InterruptedException;

    T take() throws InterruptedException;



}
