package androidx.lifecycle.viewmodel.internal;

import W2.r;
import b3.C2312i;
import b3.C2313j;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import w3.T0;

public final class CloseableCoroutineScopeKt {
    public static final String VIEW_MODEL_SCOPE_KEY = "androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY";

    public static final CloseableCoroutineScope asCloseable(M m5) {
        t.e(m5, "<this>");
        return new CloseableCoroutineScope(m5);
    }

    public static final CloseableCoroutineScope createViewModelScope() {
        C2312i iVar;
        try {
            iVar = C2865c0.c().F();
        } catch (r unused) {
            iVar = C2313j.f20794a;
        } catch (IllegalStateException unused2) {
            iVar = C2313j.f20794a;
        }
        return new CloseableCoroutineScope(iVar.plus(T0.b((C2908y0) null, 1, (Object) null)));
    }
}
