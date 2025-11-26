package androidx.room.coroutines;

import androidx.room.Transactor;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.room.coroutines.AndroidSQLiteDriverPooledConnection", f = "AndroidSQLiteDriverConnectionPool.android.kt", l = {87}, m = "transaction")
final class AndroidSQLiteDriverPooledConnection$transaction$1<R> extends d {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidSQLiteDriverPooledConnection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSQLiteDriverPooledConnection$transaction$1(AndroidSQLiteDriverPooledConnection androidSQLiteDriverPooledConnection, C2308e eVar) {
        super(eVar);
        this.this$0 = androidSQLiteDriverPooledConnection;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.transaction((Transactor.SQLiteTransactionType) null, (p) null, this);
    }
}
