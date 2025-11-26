package androidx.room;

import W2.J;
import W2.t;
import W2.u;
import b3.C2308e;
import b3.C2309f;
import b3.C2312i;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import w3.C2872g;
import w3.C2882l;
import w3.M;

final class RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1 implements Runnable {
    final /* synthetic */ C2312i $context;
    final /* synthetic */ C2882l $continuation;
    final /* synthetic */ RoomDatabase $this_startTransactionCoroutine;
    final /* synthetic */ p $transactionBlock;

    @f(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1$1", f = "RoomDatabase.android.kt", l = {2017}, m = "invokeSuspend")
    /* renamed from: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends l implements p {
        private /* synthetic */ Object L$0;
        int label;

        public final C2308e create(Object obj, C2308e eVar) {
            AnonymousClass1 r02 = new AnonymousClass1(roomDatabase, lVar, pVar, eVar);
            r02.L$0 = obj;
            return r02;
        }

        public final Object invokeSuspend(Object obj) {
            C2308e eVar;
            Object f5 = C2316b.f();
            int i5 = this.label;
            if (i5 == 0) {
                u.b(obj);
                C2312i.b bVar = ((M) this.L$0).getCoroutineContext().get(C2309f.f20792a0);
                t.b(bVar);
                C2312i access$createTransactionContext = RoomDatabaseKt__RoomDatabase_androidKt.createTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt(roomDatabase, (C2309f) bVar);
                C2882l lVar = lVar;
                t.a aVar = W2.t.f19966b;
                p pVar = pVar;
                this.L$0 = lVar;
                this.label = 1;
                obj = C2872g.g(access$createTransactionContext, pVar, this);
                if (obj == f5) {
                    return f5;
                }
                eVar = lVar;
            } else if (i5 == 1) {
                eVar = (C2308e) this.L$0;
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            eVar.resumeWith(W2.t.b(obj));
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((AnonymousClass1) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1(C2312i iVar, C2882l lVar, RoomDatabase roomDatabase, p pVar) {
        this.$context = iVar;
        this.$continuation = lVar;
        this.$this_startTransactionCoroutine = roomDatabase;
        this.$transactionBlock = pVar;
    }

    public final void run() {
        try {
            C2312i minusKey = this.$context.minusKey(C2309f.f20792a0);
            final RoomDatabase roomDatabase = this.$this_startTransactionCoroutine;
            final C2882l lVar = this.$continuation;
            final p pVar = this.$transactionBlock;
            C2872g.e(minusKey, new AnonymousClass1((C2308e) null));
        } catch (Throwable th) {
            this.$continuation.k(th);
        }
    }
}
