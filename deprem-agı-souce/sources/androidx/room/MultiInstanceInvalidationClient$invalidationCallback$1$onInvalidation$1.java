package androidx.room;

import W2.J;
import W2.u;
import X2.T;
import b3.C2308e;
import c3.C2316b;
import java.util.Arrays;
import java.util.Set;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;
import z3.v;

@f(c = "androidx.room.MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1", f = "MultiInstanceInvalidationClient.android.kt", l = {87}, m = "invokeSuspend")
final class MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1 extends l implements p {
    final /* synthetic */ String[] $tables;
    Object L$0;
    int label;
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1(String[] strArr, MultiInstanceInvalidationClient multiInstanceInvalidationClient, C2308e eVar) {
        super(2, eVar);
        this.$tables = strArr;
        this.this$0 = multiInstanceInvalidationClient;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1(this.$tables, this.this$0, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Set set;
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            String[] strArr = this.$tables;
            Set g5 = T.g(Arrays.copyOf(strArr, strArr.length));
            v access$getInvalidatedTables$p = this.this$0.invalidatedTables;
            this.L$0 = g5;
            this.label = 1;
            if (access$getInvalidatedTables$p.emit(g5, this) == f5) {
                return f5;
            }
            set = g5;
        } else if (i5 == 1) {
            set = (Set) this.L$0;
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.getInvalidationTracker().notifyObserversByTableNames$room_runtime_release(set);
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
