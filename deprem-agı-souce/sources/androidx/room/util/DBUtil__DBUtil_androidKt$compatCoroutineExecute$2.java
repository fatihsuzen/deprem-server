package androidx.room.util;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.room.util.DBUtil__DBUtil_androidKt$compatCoroutineExecute$2", f = "DBUtil.android.kt", l = {107}, m = "invokeSuspend")
public final class DBUtil__DBUtil_androidKt$compatCoroutineExecute$2 extends l implements p {
    final /* synthetic */ k3.l $block;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DBUtil__DBUtil_androidKt$compatCoroutineExecute$2(k3.l lVar, C2308e eVar) {
        super(2, eVar);
        this.$block = lVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new DBUtil__DBUtil_androidKt$compatCoroutineExecute$2(this.$block, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            k3.l lVar = this.$block;
            this.label = 1;
            Object invoke = lVar.invoke(this);
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
        return this.$block.invoke(this);
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((DBUtil__DBUtil_androidKt$compatCoroutineExecute$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
