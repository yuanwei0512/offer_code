package com.hyw.offer;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/16 13:59
 * Description：TODO
 */
public class Apple {

    @AnnotationStudy(id = 1, name = "honfus")
    private String appleProvider;

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public static void main(String[] args) {
        Apple a = new Apple();
        System.out.println(a.getAppleProvider());
    }
}
