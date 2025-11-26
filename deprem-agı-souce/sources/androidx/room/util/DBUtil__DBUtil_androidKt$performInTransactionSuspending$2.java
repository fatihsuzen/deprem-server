package androidx.room.util;

import W2.J;
import W2.u;
import androidx.room.RoomDatabase;
import b3.C2308e;
import c3.C2316b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2", f = "DBUtil.android.kt", l = {243}, m = "invokeSuspend")
final class DBUtil__DBUtil_androidKt$performInTransactionSuspending$2 extends l implements k3.l {
    final /* synthetic */ k3.l $block;
    final /* synthetic */ RoomDatabase $db;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DBUtil__DBUtil_androidKt$performInTransactionSuspending$2(RoomDatabase roomDatabase, k3.l lVar, C2308e eVar) {
        super(1, eVar);
        this.$db = roomDatabase;
        this.$block = lVar;
    }

    public final C2308e create(C2308e eVar) {
        return new DBUtil__DBUtil_androidKt$performInTransactionSuspending$2(this.$db, this.$block, eVar);
    }

    public final Object invoke(C2308e eVar) {
        return ((DBUtil__DBUtil_androidKt$performInTransactionSuspending$2) create(eVar)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            RoomDatabase roomDatabase = this.$db;
            DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1(true, false, roomDatabase, (C2308e) null, this.$block);
            this.label = 1;
            Object useConnection$room_runtime_release = roomDatabase.useConnection$room_runtime_release(false, dBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1, this);
            if (useConnection$room_runtime_release == f5) {
                return f5;
            }
            return useConnection$room_runtime_release;
        } else if (i5 == 1) {
            u.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
