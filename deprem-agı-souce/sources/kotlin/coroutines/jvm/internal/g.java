package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import kotlin.jvm.internal.t;

public abstract class g {
    private static final void a(int i5, int i6) {
        if (i6 > i5) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i5 + ", got " + i6 + ". Please update the Kotlin standard library.").toString());
        }
    }

    private static final f b(a aVar) {
        return (f) aVar.getClass().getAnnotation(f.class);
    }

    private static final int c(a aVar) {
        Integer num;
        int i5;
        try {
            Field declaredField = aVar.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(aVar);
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            if (num != null) {
                i5 = num.intValue();
            } else {
                i5 = 0;
            }
            return i5 - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(a aVar) {
        int i5;
        String str;
        t.e(aVar, "<this>");
        f b5 = b(aVar);
        if (b5 == null) {
            return null;
        }
        a(1, b5.v());
        int c5 = c(aVar);
        if (c5 < 0) {
            i5 = -1;
        } else {
            i5 = b5.l()[c5];
        }
        String b6 = i.f24679a.b(aVar);
        if (b6 == null) {
            str = b5.c();
        } else {
            str = b6 + '/' + b5.c();
        }
        return new StackTraceElement(str, b5.m(), b5.f(), i5);
    }
}
