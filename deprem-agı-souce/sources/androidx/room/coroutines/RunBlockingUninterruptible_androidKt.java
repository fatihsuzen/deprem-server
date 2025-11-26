package androidx.room.coroutines;

import b3.C2308e;
import b3.C2312i;
import k3.p;
import kotlin.jvm.internal.t;

public final class RunBlockingUninterruptible_androidKt {
    public static final <T> T runBlockingUninterruptible(p pVar) {
        t.e(pVar, "block");
        Thread.interrupted();
        return C2874h.b((C2312i) null, new RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1(pVar, (C2308e) null), 1, (Object) null);
    }
}
