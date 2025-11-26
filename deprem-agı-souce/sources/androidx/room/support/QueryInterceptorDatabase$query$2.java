package androidx.room.support;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import java.util.List;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.room.support.QueryInterceptorDatabase$query$2", f = "QueryInterceptorDatabase.android.kt", l = {}, m = "invokeSuspend")
final class QueryInterceptorDatabase$query$2 extends l implements p {
    final /* synthetic */ List<Object> $argsCopy;
    final /* synthetic */ String $query;
    int label;
    final /* synthetic */ QueryInterceptorDatabase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryInterceptorDatabase$query$2(QueryInterceptorDatabase queryInterceptorDatabase, String str, List<? extends Object> list, C2308e eVar) {
        super(2, eVar);
        this.this$0 = queryInterceptorDatabase;
        this.$query = str;
        this.$argsCopy = list;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new QueryInterceptorDatabase$query$2(this.this$0, this.$query, this.$argsCopy, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        if (this.label == 0) {
            u.b(obj);
            this.this$0.queryCallback.onQuery(this.$query, this.$argsCopy);
            return J.f19942a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((QueryInterceptorDatabase$query$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
