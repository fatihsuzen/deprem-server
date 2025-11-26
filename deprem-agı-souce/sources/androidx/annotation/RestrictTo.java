package androidx.annotation;

import d3.C2344a;
import d3.C2345b;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
@Retention(RetentionPolicy.CLASS)
public @interface RestrictTo {

    public enum Scope {
        LIBRARY,
        LIBRARY_GROUP,
        LIBRARY_GROUP_PREFIX,
        GROUP_ID,
        TESTS,
        SUBCLASSES;

        static {
            Scope[] $values;
            $ENTRIES = C2345b.a($values);
        }

        public static C2344a getEntries() {
            return $ENTRIES;
        }
    }

    Scope[] value();
}
