package androidx.work.impl;

import W2.J;
import W2.u;
import androidx.work.Logger;
import b3.C2308e;
import c3.C2316b;
import k3.r;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.X;
import z3.C2973f;

@f(c = "androidx.work.impl.UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1", f = "UnfinishedWorkListener.kt", l = {59}, m = "invokeSuspend")
final class UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1 extends l implements r {
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1(C2308e eVar) {
        super(4, eVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke((C2973f) obj, (Throwable) obj2, ((Number) obj3).longValue(), (C2308e) obj4);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            long j5 = this.J$0;
            Logger.get().error(UnfinishedWorkListenerKt.TAG, "Cannot check for unfinished work", (Throwable) this.L$0);
            long min = Math.min(j5 * ((long) 30000), UnfinishedWorkListenerKt.MAX_DELAY_MS);
            this.label = 1;
            if (X.b(min, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return b.a(true);
    }

    public final Object invoke(C2973f fVar, Throwable th, long j5, C2308e eVar) {
        UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1 unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1 = new UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1(eVar);
        unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1.L$0 = th;
        unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1.J$0 = j5;
        return unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1.invokeSuspend(J.f19942a);
    }
}
