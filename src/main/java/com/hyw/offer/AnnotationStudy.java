package com.hyw.offer;

import java.lang.annotation.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/16 13:56
 * Description：TODO
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnnotationStudy {

    public int id() default -1;
    public String name() default "";



}
