package com.hyw.cache.computable;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/3 21:49
 * Description：TODO
 */
public interface Computable<A, V> {

    V compute(A arg) throws Exception;
}
