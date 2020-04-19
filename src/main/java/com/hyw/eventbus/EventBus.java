package com.hyw.eventbus;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/4/12 14:51
 * Description：TODO
 */
public class EventBus {

    private Executor executor;
    private ObserverRegister register;

    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    protected EventBus(Executor executor) {
        this.executor = executor;
    }

    public void register(Object object) {
        register.register(object);
    }

    public void post(Object parameter) {
        List<ObserverAction> observerActions = register.getObserverActions(parameter);
        for (ObserverAction observerAction : observerActions) {
            executor.execute(() -> observerAction.execute(parameter));
        }
    }

}
