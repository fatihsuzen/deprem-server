package androidx.room.support;

import W2.J;
import W2.u;
import X2.C2250q;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.room.support.QueryInterceptorDatabase$beginTransactionNonExclusive$1", f = "QueryInterceptorDatabase.android.kt", l = {}, m = "invokeSuspend")
final class QueryInterceptorDatabase$beginTransactionNonExclusive$1 extends l implements p {
    int label;
    final /* synthetic */ QueryInterceptorDatabase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryInterceptorDatabase$beginTransactionNonExclusive$1(QueryInterceptorDatabase queryInterceptorDatabase, C2308e eVar) {
        super(2, eVar);
        this.this$0 = queryInterceptorDatabase;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new QueryInterceptorDatabase$beginTransactionNonExclusive$1(this.this$0, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        if (this.label == 0) {
            u.b(obj);
            this.this$0.queryCallback.onQuery("BEGIN IMMEDIATE TRANSACTION", C2250q.g());
            return J.f19942a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((QueryInterceptorDatabase$beginTransactionNonExclusive$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
