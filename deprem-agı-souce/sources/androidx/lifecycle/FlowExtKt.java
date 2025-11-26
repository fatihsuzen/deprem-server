package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import b3.C2308e;
import kotlin.jvm.internal.t;
import z3.C2972e;
import z3.C2974g;

public final class FlowExtKt {
    public static final <T> C2972e flowWithLifecycle(C2972e eVar, Lifecycle lifecycle, Lifecycle.State state) {
        t.e(eVar, "<this>");
        t.e(lifecycle, "lifecycle");
        t.e(state, "minActiveState");
        return C2974g.d(new FlowExtKt$flowWithLifecycle$1(lifecycle, state, eVar, (C2308e) null));
    }

    public static /* synthetic */ C2972e flowWithLifecycle$default(C2972e eVar, Lifecycle lifecycle, Lifecycle.State state, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return flowWithLifecycle(eVar, lifecycle, state);
    }
}
