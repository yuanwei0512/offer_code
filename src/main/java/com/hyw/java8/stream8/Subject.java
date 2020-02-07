package com.hyw.java8.stream8;

import java.util.ArrayList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/8 20:40
 * Description：TODO
 */
public interface Subject {

    void registerObserver(Observer o);
    void notifyObservers(String s);

    public class Feed implements Subject{

        private List<Observer> observers = new ArrayList<>();

        @Override
        public void registerObserver(Observer o) {
            observers.add(o);
        }

        @Override
        public void notifyObservers(String s) {
            observers.forEach(o -> o.notifySout(s));
        }
    }

}
