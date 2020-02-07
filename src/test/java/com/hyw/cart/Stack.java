package com.hyw.cart;

import org.omg.CORBA.Object;

import java.util.Collection;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.Set;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/11/18 8:58
 * Description：TODO
 */
public class Stack<E> {

    private int size;
    private E[] element;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack(){
        element = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void pushAll(Iterable<? extends E> src){

    }


}