package com.gysoft.annotation;

import java.lang.annotation.*;

/**
 * Create by wws on 2019/5/9
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WController {

 String value() default "";
}
