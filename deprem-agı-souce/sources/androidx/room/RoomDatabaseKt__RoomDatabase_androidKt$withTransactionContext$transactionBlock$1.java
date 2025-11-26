package androidx.room;

import W2.J;
import W2.u;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import w3.M;

@f(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1", f = "RoomDatabase.android.kt", l = {1984}, m = "invokeSuspend")
final class RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 extends l implements p {
    final /* synthetic */ k3.l $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(k3.l lVar, C2308e eVar) {
        super(2, eVar);
        this.$block = lVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(this.$block, eVar);
        roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1.L$0 = obj;
        return roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1;
    }

    public final Object invokeSuspend(Object obj) {
        Throwable th;
        TransactionElement transactionElement;
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            C2312i.b bVar = ((M) this.L$0).getCoroutineContext().get(TransactionElement.Key);
            t.b(bVar);
            TransactionElement transactionElement2 = (TransactionElement) bVar;
            transactionElement2.acquire();
            try {
                k3.l lVar = this.$block;
                this.L$0 = transactionElement2;
                this.label = 1;
                Object invoke = lVar.invoke(this);
                if (invoke == f5) {
                    return f5;
                }
                transactionElement = transactionElement2;
                obj = invoke;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                transactionElement = transactionElement2;
                th = th3;
                transactionElement.release();
                throw th;
            }
        } else if (i5 == 1) {
            transactionElement = (TransactionElement) this.L$0;
            try {
                u.b(obj);
            } catch (Throwable th4) {
                th = th4;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        transactionElement.release();
        return obj;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
