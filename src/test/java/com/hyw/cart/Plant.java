package com.hyw.cart;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/11/20 9:14
 * Description：TODO
 */
public class Plant {

    enum LifeCycle{ANNUAL, PERENNIAL, BIENNIAL}

    private final String name;
    private LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }
}
