package com.mbridge.msdk.newreward.function.command.retention;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class ReportAnnotation {

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ClassInfo {
        String value();
    }

    @Target({ElementType.LOCAL_VARIABLE, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldInfo {
        int[] value();
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MethodInfo {
        String className() default "-1";

        boolean isParameter() default false;

        String key() default "-1";

        String methodName() default "-1";

        String methodParameter() default "-1";

        String reportType() default "-1";
    }

    @Target({ElementType.PACKAGE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PackageInfo {
        String value();
    }
}
