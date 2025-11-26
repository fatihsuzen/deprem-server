package androidx.work;

import k3.C2616a;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;

public final class TracerKt {
    public static final <T> T traced(Tracer tracer, String str, C2616a aVar) {
        t.e(tracer, "<this>");
        t.e(str, "label");
        t.e(aVar, "block");
        boolean isEnabled = tracer.isEnabled();
        if (isEnabled) {
            try {
                tracer.beginSection(str);
            } catch (Throwable th) {
                r.b(1);
                if (isEnabled) {
                    tracer.endSection();
                }
                r.a(1);
                throw th;
            }
        }
        T invoke = aVar.invoke();
        r.b(1);
        if (isEnabled) {
            tracer.endSection();
        }
        r.a(1);
        return invoke;
    }
}
