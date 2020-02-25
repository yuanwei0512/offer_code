package com.hyw.cache.mq;

import sun.plugin2.message.Message;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/21 10:06
 * Description：TODO
 */
public class GuardedObject<T> {

    private T obj;
    private final Lock lock = new ReentrantLock();
    private final Condition done = lock.newCondition();

    private static final ConcurrentHashMap<Object, GuardedObject> gos = new ConcurrentHashMap<>();

    public static <K> GuardedObject create(K key) {
        GuardedObject guardedObject = new GuardedObject();
        gos.put(key, guardedObject);
        return guardedObject;
    }

    public static <K, T> void fireEvent(K key, T value) {
        GuardedObject go = gos.remove(key);
        if (go != null) {
            go.onChange(value);
        }
    }

    private T get(Predicate<T> p) {
        lock.lock();
        try {

            while (!p.test(obj)) {
                done.await(2, TimeUnit.SECONDS);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return this.obj;
    }


    private void onChange(T obj) {
        lock.lock();
        try {
            this.obj = obj;
            done.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        String id = UUID.randomUUID().toString();


        GuardedObject guardedObject = GuardedObject.create(id);
        guardedObject.get(Objects::nonNull);

        //TODO 发送消息
        Message message = new Message(id);
        GuardedObject.fireEvent(message.id, message);

    }

    public static class Message {
        private String id;

        public Message(String id) {
            this.id = id;
        }
    }

}
