package androidx.room.util;

import W2.J;
import W2.u;
import androidx.room.TransactionScope;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.room.util.DBUtil__DBUtilKt$internalPerform$2$result$1", f = "DBUtil.kt", l = {59}, m = "invokeSuspend")
public final class DBUtil__DBUtilKt$internalPerform$2$result$1 extends l implements p {
    final /* synthetic */ p $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DBUtil__DBUtilKt$internalPerform$2$result$1(p pVar, C2308e eVar) {
        super(2, eVar);
        this.$block = pVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        DBUtil__DBUtilKt$internalPerform$2$result$1 dBUtil__DBUtilKt$internalPerform$2$result$1 = new DBUtil__DBUtilKt$internalPerform$2$result$1(this.$block, eVar);
        dBUtil__DBUtilKt$internalPerform$2$result$1.L$0 = obj;
        return dBUtil__DBUtilKt$internalPerform$2$result$1;
    }

    public final Object invoke(TransactionScope<R> transactionScope, C2308e eVar) {
        return ((DBUtil__DBUtilKt$internalPerform$2$result$1) create(transactionScope, eVar)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            p pVar = this.$block;
            this.label = 1;
            Object invoke = pVar.invoke((TransactionScope) this.L$0, this);
            if (invoke == f5) {
                return f5;
            }
            return invoke;
        } else if (i5 == 1) {
            u.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        return this.$block.invoke((TransactionScope) this.L$0, this);
    }
}
