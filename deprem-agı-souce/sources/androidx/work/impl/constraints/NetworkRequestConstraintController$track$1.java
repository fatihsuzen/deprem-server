package androidx.work.impl.constraints;

import W2.J;
import W2.u;
import android.net.NetworkRequest;
import android.os.Build;
import androidx.work.Constraints;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.util.concurrent.CancellationException;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.C2908y0;
import w3.O;
import y3.t;
import y3.v;
import y3.y;

@f(c = "androidx.work.impl.constraints.NetworkRequestConstraintController$track$1", f = "WorkConstraintsTracker.kt", l = {180}, m = "invokeSuspend")
final class NetworkRequestConstraintController$track$1 extends l implements p {
    final /* synthetic */ Constraints $constraints;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NetworkRequestConstraintController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetworkRequestConstraintController$track$1(Constraints constraints, NetworkRequestConstraintController networkRequestConstraintController, C2308e eVar) {
        super(2, eVar);
        this.$constraints = constraints;
        this.this$0 = networkRequestConstraintController;
    }

    /* access modifiers changed from: private */
    public static final J invokeSuspend$lambda$0(C2908y0 y0Var, v vVar, ConstraintsState constraintsState) {
        C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
        vVar.r(constraintsState);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J invokeSuspend$lambda$1(C2616a aVar) {
        aVar.invoke();
        return J.f19942a;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        NetworkRequestConstraintController$track$1 networkRequestConstraintController$track$1 = new NetworkRequestConstraintController$track$1(this.$constraints, this.this$0, eVar);
        networkRequestConstraintController$track$1.L$0 = obj;
        return networkRequestConstraintController$track$1;
    }

    public final Object invokeSuspend(Object obj) {
        C2616a aVar;
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            v vVar = (v) this.L$0;
            NetworkRequest requiredNetworkRequest = this.$constraints.getRequiredNetworkRequest();
            if (requiredNetworkRequest == null) {
                y.a.a(vVar.o(), (Throwable) null, 1, (Object) null);
                return J.f19942a;
            }
            b bVar = new b(C2876i.d(vVar, (C2312i) null, (O) null, new NetworkRequestConstraintController$track$1$timeoutJob$1(this.this$0, vVar, (C2308e) null), 3, (Object) null), vVar);
            if (Build.VERSION.SDK_INT >= 30) {
                aVar = SharedNetworkCallback.INSTANCE.addCallback(this.this$0.connManager, requiredNetworkRequest, bVar);
            } else {
                aVar = IndividualNetworkCallback.Companion.addCallback(this.this$0.connManager, requiredNetworkRequest, bVar);
            }
            c cVar = new c(aVar);
            this.label = 1;
            if (t.a(vVar, cVar, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }

    public final Object invoke(v vVar, C2308e eVar) {
        return ((NetworkRequestConstraintController$track$1) create(vVar, eVar)).invokeSuspend(J.f19942a);
    }
}
