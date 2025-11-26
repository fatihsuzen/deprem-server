package androidx.work;

import androidx.tracing.Trace;
import kotlin.jvm.internal.t;

public final class ConfigurationKt$createDefaultTracer$tracer$1 implements Tracer {
    ConfigurationKt$createDefaultTracer$tracer$1() {
    }

    public void beginAsyncSection(String str, int i5) {
        t.e(str, "methodName");
        Trace.beginAsyncSection(str, i5);
    }

    public void beginSection(String str) {
        t.e(str, "label");
        Trace.beginSection(str);
    }

    public void endAsyncSection(String str, int i5) {
        t.e(str, "methodName");
        Trace.endAsyncSection(str, i5);
    }

    public void endSection() {
        Trace.endSection();
    }

    public boolean isEnabled() {
        return Trace.isEnabled();
    }
}
