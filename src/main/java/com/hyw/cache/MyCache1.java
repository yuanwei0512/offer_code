package com.hyw.cache;

import com.hyw.cache.computable.Computable;
import com.hyw.cache.computable.ExpensiveFunction;
import com.hyw.cache.computable.MayFail;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/3 21:21
 * Description：TODO
 */
public class MyCache1<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    public MyCache1(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(arg);
            if (null == f) {
                FutureTask<V> futureTask = new FutureTask<>(() -> c.compute(arg));
                f = cache.putIfAbsent(arg, futureTask);
                if (f == null) {
                    f = futureTask;
                    futureTask.run();
                }
            }

            try {
                return f.get();
            } catch (InterruptedException | CancellationException e) {
                cache.remove(arg);
                throw e;
            } catch (ExecutionException e) {
                cache.remove(arg);
            }
        }

    }


}
