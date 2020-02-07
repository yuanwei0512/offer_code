package com.hyw.java8.stream8;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/8 20:55
 * Description：TODO
 */
public abstract class ProcessingObject<T> {

    private ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor){
        this.successor = successor;
    }

    public T handler(T input) {
        T r = handlerWork(input);
        if (successor != null) {
            return successor.handler(r);
        }
        return r;
    }

    abstract protected T handlerWork(T input);

}
