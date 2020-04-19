package com.hyw.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/4/12 14:54
 * Description：TODO
 */
public class ObserverAction {

    private Object target;
    private Method method;

    public ObserverAction(Object target, Method method) {
        this.target = target;
        this.method = method;
    }

    public void execute(Object object) {
        try {
            method.invoke(target, object);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
