package androidx.room.driver;

import androidx.room.Transactor;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.room.driver.SupportSQLitePooledConnection", f = "SupportSQLiteConnectionPool.android.kt", l = {83}, m = "transaction")
final class SupportSQLitePooledConnection$transaction$1<R> extends d {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SupportSQLitePooledConnection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SupportSQLitePooledConnection$transaction$1(SupportSQLitePooledConnection supportSQLitePooledConnection, C2308e eVar) {
        super(eVar);
        this.this$0 = supportSQLitePooledConnection;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.transaction((Transactor.SQLiteTransactionType) null, (p) null, this);
    }
}
