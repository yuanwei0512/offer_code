package com.hyw.eventbus;

import com.google.common.base.Preconditions;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/4/12 14:52
 * Description：TODO
 */
public class ObserverRegister {

    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    public void register(Object observer) {

        Class<?> clazz = observer.getClass();
        //获取加了Subscribe注解的方法，，参数只能是一个
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument(parameterTypes.length == 1,
                        "Method %s has @Subscribe annotation but has %s parameters."
                                + "Subscriber methods must have exactly 1 parameter.",
                        method, parameterTypes.length);
                annotatedMethods.add(method);
            }
        }
        //key:参数类型   value:ObserverAction集合
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        for (Method method : annotatedMethods) {
            Class<?> parameterType = method.getParameterTypes()[0];
            if (!observerActions.containsKey(parameterType)) {
                observerActions.put(parameterType, new ArrayList<>());
            }
            observerActions.get(parameterType).add(new ObserverAction(parameterType, method));
        }
        //  key:参数类型   value:ObserverAction集合 加入到总的registry中
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            Class<?> parameterType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> registeredEventActions = registry.get(parameterType);
            if (registeredEventActions == null) {
                registry.put(parameterType, new CopyOnWriteArraySet<ObserverAction>());
                registeredEventActions = registry.get(parameterType);
            }
            registeredEventActions.addAll(eventActions);
        }
    }

    //根据参数类型获取所有对应的观察者需要执行的方法
    public List<ObserverAction> getObserverActions(Object parameter) {
        List<ObserverAction> matchedObservers = new ArrayList<>();
        Class<?> parameterType = parameter.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            Class<?> type = entry.getKey();
            CopyOnWriteArraySet<ObserverAction> methods = entry.getValue();
            if (type.isAssignableFrom(parameterType)) {
                matchedObservers.addAll(methods);
            }
        }
        return matchedObservers;
    }

}
