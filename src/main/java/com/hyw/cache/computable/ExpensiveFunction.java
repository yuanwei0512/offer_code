package com.hyw.cache.computable;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/3 21:50
 * Description：TODO
 */
public class ExpensiveFunction implements Computable<String, Integer>{

    @Override
    public Integer compute(String arg) throws Exception {
        System.out.println("执行compute操作");
        Thread.sleep(2000);
        return Integer.valueOf(arg);
    }
}
