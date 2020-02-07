package com.hyw.cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/11/19 9:56
 * Description：TODO
 */
public class Favorites {

    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance){
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type){
        return type.cast(favorites.get(type));
    }

    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "java");
        f.putFavorite(Integer.class, 0xcafebabe);
        System.out.println(f.getFavorite(Integer.class));
    }

}
