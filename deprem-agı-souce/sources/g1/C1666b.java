package g1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* renamed from: g1.b  reason: case insensitive filesystem */
public @interface C1666b {
    boolean nullSafe() default true;

    Class value();
}
