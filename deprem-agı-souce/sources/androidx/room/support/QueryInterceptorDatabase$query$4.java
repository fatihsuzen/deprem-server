package androidx.room.support;

import W2.J;
import W2.u;
import androidx.sqlite.db.SupportSQLiteQuery;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.room.support.QueryInterceptorDatabase$query$4", f = "QueryInterceptorDatabase.android.kt", l = {}, m = "invokeSuspend")
final class QueryInterceptorDatabase$query$4 extends l implements p {
    final /* synthetic */ SupportSQLiteQuery $query;
    final /* synthetic */ QueryInterceptorProgram $queryInterceptorProgram;
    int label;
    final /* synthetic */ QueryInterceptorDatabase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryInterceptorDatabase$query$4(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram, C2308e eVar) {
        super(2, eVar);
        this.this$0 = queryInterceptorDatabase;
        this.$query = supportSQLiteQuery;
        this.$queryInterceptorProgram = queryInterceptorProgram;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new QueryInterceptorDatabase$query$4(this.this$0, this.$query, this.$queryInterceptorProgram, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        if (this.label == 0) {
            u.b(obj);
            this.this$0.queryCallback.onQuery(this.$query.getSql(), this.$queryInterceptorProgram.getBindArgsCache$room_runtime_release());
            return J.f19942a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((QueryInterceptorDatabase$query$4) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
