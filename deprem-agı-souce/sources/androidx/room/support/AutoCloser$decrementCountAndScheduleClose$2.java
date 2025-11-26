package androidx.room.support;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;
import w3.X;

@f(c = "androidx.room.support.AutoCloser$decrementCountAndScheduleClose$2", f = "AutoCloser.android.kt", l = {167}, m = "invokeSuspend")
final class AutoCloser$decrementCountAndScheduleClose$2 extends l implements p {
    int label;
    final /* synthetic */ AutoCloser this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AutoCloser$decrementCountAndScheduleClose$2(AutoCloser autoCloser, C2308e eVar) {
        super(2, eVar);
        this.this$0 = autoCloser;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new AutoCloser$decrementCountAndScheduleClose$2(this.this$0, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            long access$getAutoCloseTimeoutInMs$p = this.this$0.autoCloseTimeoutInMs;
            this.label = 1;
            if (X.b(access$getAutoCloseTimeoutInMs$p, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.autoCloseDatabase();
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((AutoCloser$decrementCountAndScheduleClose$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
