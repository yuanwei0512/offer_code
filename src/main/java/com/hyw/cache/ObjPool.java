package com.hyw;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/17 10:55
 * Description：TODO
 */
public class ObjPool<T, R> {

    private Semaphore semaphore;

    private List<T> objList;

    public ObjPool(int size, T value) {

        this.objList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            objList.add(value);
        }
        semaphore = new Semaphore(size);
    }

    R exec(Function<T, R> func) {
        T obj = null;
        try {
            semaphore.acquire();
            obj = objList.remove(0);
            return func.apply(obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            semaphore.release();
            objList.add(obj);
        }

    }

}
