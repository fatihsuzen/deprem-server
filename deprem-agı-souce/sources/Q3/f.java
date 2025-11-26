package q3;

import kotlin.jvm.internal.t;

abstract class f {
    public static final void a(boolean z4, Number number) {
        t.e(number, "step");
        if (!z4) {
            throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
        }
    }
}
