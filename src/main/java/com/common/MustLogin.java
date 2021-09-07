package com.common;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MustLogin {
    int[] rolerequired() default 0;//0：全部都可访问;
}
