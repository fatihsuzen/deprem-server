package com.mbridge.apt_anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface BridgeTest {
    boolean isNeedEnvironment() default false;

    String[] meb() default {};

    String[] testMethod() default {};
}
