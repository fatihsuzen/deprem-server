package androidx.graphics.shapes;

import java.util.Arrays;
import kotlin.jvm.internal.t;

public final class Format_jvmKt {
    public static final String toStringWithLessPrecision(float f5) {
        String format = String.format("%.3f", Arrays.copyOf(new Object[]{Float.valueOf(f5)}, 1));
        t.d(format, "format(this, *args)");
        return format;
    }
}
