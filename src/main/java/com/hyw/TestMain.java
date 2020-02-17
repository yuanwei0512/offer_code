package com.hyw;

import javafx.scene.layout.Priority;

import java.util.*;
import java.util.concurrent.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/7 22:14
 * Description：TODO
 */
public class TestMain {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();

        while (thread.isInterrupted()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                thread.interrupt();
                e.printStackTrace();
            }
        }
    }

}
