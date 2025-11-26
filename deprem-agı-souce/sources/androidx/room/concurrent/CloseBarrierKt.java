package androidx.room.concurrent;

import k3.C2616a;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;

public final class CloseBarrierKt {
    public static final void ifNotClosed(CloseBarrier closeBarrier, C2616a aVar) {
        t.e(closeBarrier, "<this>");
        t.e(aVar, "action");
        if (closeBarrier.block$room_runtime_release()) {
            try {
                aVar.invoke();
            } finally {
                r.b(1);
                closeBarrier.unblock$room_runtime_release();
                r.a(1);
            }
        }
    }
}
