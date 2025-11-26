package androidx.room;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2", f = "RoomDatabase.android.kt", l = {1970}, m = "invokeSuspend")
final class RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2 extends l implements k3.l {
    final /* synthetic */ k3.l $block;
    final /* synthetic */ RoomDatabase $this_withTransaction;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2(RoomDatabase roomDatabase, k3.l lVar, C2308e eVar) {
        super(1, eVar);
        this.$this_withTransaction = roomDatabase;
        this.$block = lVar;
    }

    public final C2308e create(C2308e eVar) {
        return new RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2(this.$this_withTransaction, this.$block, eVar);
    }

    public final Object invoke(C2308e eVar) {
        return ((RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2) create(eVar)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            this.$this_withTransaction.beginTransaction();
            k3.l lVar = this.$block;
            this.label = 1;
            obj = lVar.invoke(this);
            if (obj == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            try {
                u.b(obj);
            } catch (Throwable th) {
                this.$this_withTransaction.endTransaction();
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$this_withTransaction.setTransactionSuccessful();
        this.$this_withTransaction.endTransaction();
        return obj;
    }
}
