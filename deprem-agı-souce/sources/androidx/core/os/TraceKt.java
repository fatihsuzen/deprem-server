package androidx.core.os;

import android.os.Trace;
import k3.C2616a;
import kotlin.jvm.internal.r;

public final class TraceKt {
    public static final <T> T trace(String str, C2616a aVar) {
        Trace.beginSection(str);
        try {
            return aVar.invoke();
        } finally {
            r.b(1);
            Trace.endSection();
            r.a(1);
        }
    }
}
