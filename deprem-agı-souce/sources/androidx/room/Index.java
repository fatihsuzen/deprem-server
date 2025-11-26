package androidx.room;

import d3.C2344a;
import d3.C2345b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({})
@Retention(RetentionPolicy.CLASS)
public @interface Index {

    public enum Order {
        ASC,
        DESC;

        static {
            Order[] $values;
            $ENTRIES = C2345b.a($values);
        }

        public static C2344a getEntries() {
            return $ENTRIES;
        }
    }

    String name() default "";

    Order[] orders() default {};

    boolean unique() default false;

    String[] value();
}
