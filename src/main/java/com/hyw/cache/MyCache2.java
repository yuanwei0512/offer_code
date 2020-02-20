package com.hyw.cache;

import com.hyw.cache.computable.Computable;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/3 21:21
 * Description：TODO
 */
public class MyCache2<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public MyCache2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        r.lock();
        try {
            V v = cache.get(arg);
            if (null != v) {
                return v;
            }
        } finally {
            r.unlock();
        }

        while (true) {
            w.lock();
            try {
                V v = cache.get(arg);
                if (v == null) {
                    FutureTask<V> futureTask = new FutureTask<>(() -> c.compute(arg));
                    futureTask.run();
                    v = futureTask.get();
                    cache.put(arg, v);
                }
                return v;

            } catch (InterruptedException e) {
                throw e;
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                w.unlock();
            }
        }

    }


}
