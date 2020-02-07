package com.hyw.cart;

import lombok.AccessLevel;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/11/7 16:40
 * Description：TODO
 */
public class User implements Serializable {


    private final String userName = "hhhh";

    private String password;

    public User(String password) {
        this.password = password;
    }
}
