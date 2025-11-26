package g1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* renamed from: g1.a  reason: case insensitive filesystem */
public @interface C1665a {
    boolean deserialize() default true;

    boolean serialize() default true;
}
