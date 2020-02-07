package com.hyw.queue;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/7 9:55
 * Description：TODO
 */
public class MyLinkedListBlockingQueue<T> implements MyQueue<T> {

    private volatile Node<T> head;
    private volatile Node<T> tail;

    /** The capacity bound, or Integer.MAX_VALUE if none */
    private final int capacity;

    /** Current number of elements */
    private final AtomicInteger count = new AtomicInteger();

    /** Lock held by take, poll, etc */
    private final ReentrantLock takeLock = new ReentrantLock();

    /** Wait queue for waiting takes */
    private final Condition notEmpty = takeLock.newCondition();

    /** Lock held by put, offer, etc */
    private final ReentrantLock putLock = new ReentrantLock();

    /** Wait queue for waiting puts */
    private final Condition notFull = putLock.newCondition();

    public MyLinkedListBlockingQueue() {
        this(Integer.MAX_VALUE);
    }

    public MyLinkedListBlockingQueue(Integer size) {
        if (size < 0 || size > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("传入参数过大");
        }
        this.capacity = size;
        head = tail = new Node<T>(null);
    }

    public MyLinkedListBlockingQueue(Collection<T> c) {
        //初始化队列
        this(Integer.MAX_VALUE);
        //判断参数是否过大
        if (c.size() > capacity) {
            throw new IllegalArgumentException("传入参数过大");
        }
        final ReentrantLock putLock = this.putLock;
        putLock.lock();
        try {
            for (T e : c) {
                if (e == null) {
                    throw new NullPointerException();
                }
                tail = tail.next = new Node(e);
            }
            count.set(c.size() );
        } finally {
            putLock.unlock();
        }

    }


    @Override
    public void put(T item) throws InterruptedException {
        if (item == null) {
            throw new IllegalArgumentException("参数为空");
        }
        final ReentrantLock putLock = this.putLock;
        final AtomicInteger count = this.count;
        int c =  - 1;
        putLock.lockInterruptibly();
        try {
            while (count.get() == capacity) {
                System.out.println("阻塞了" + item);
                notFull.await();
            }
            System.out.println("插入了" + item);
            tail = tail.next = new Node(item);
            c = count.incrementAndGet();

            if (c + 1 < capacity) {
                notFull.signal();
            }

        } finally {
            putLock.unlock();
        }
        if (c == 0) {
            signalNotEmpty();
        }

    }

    @Override
    public T take() throws InterruptedException {
        T next;
        final ReentrantLock takeLock = this.takeLock;
        final AtomicInteger count = this.count;
        int c = -1;
        takeLock.lock();
        try {
            while (count.get() == 0) {
                notEmpty.await();
            }
            next = this.head.next.item;
            this.head = this.head.next;
            c = count.getAndDecrement();

            if (c > 1) {
                notEmpty.signal();
            }
        } finally {
            takeLock.unlock();
        }

        if (c == capacity) {
            signalNotFull();
        }
        return next;
    }


    private void signalNotEmpty() {
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try {
            notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
    }

    private void signalNotFull() {
        final ReentrantLock putLock = this.putLock;
        putLock.lock();
        try {
            notFull.signal();
        } finally {
            putLock.unlock();
        }
    }

    public static class Node<T> {
        // 数据本身
        T item;
        // 下一个元素
        Node<T> next;



        // 构造器
        public Node(T item) {
            this.item = item;
        }
    }
    
}
