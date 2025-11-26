package androidx.room.util;

import W2.J;
import W2.u;
import androidx.room.RoomDatabase;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performBlocking$1", f = "DBUtil.android.kt", l = {243}, m = "invokeSuspend")
final class DBUtil__DBUtil_androidKt$performBlocking$1 extends l implements p {
    final /* synthetic */ k3.l $block;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ boolean $isReadOnly;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DBUtil__DBUtil_androidKt$performBlocking$1(RoomDatabase roomDatabase, boolean z4, boolean z5, k3.l lVar, C2308e eVar) {
        super(2, eVar);
        this.$db = roomDatabase;
        this.$isReadOnly = z4;
        this.$inTransaction = z5;
        this.$block = lVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new DBUtil__DBUtil_androidKt$performBlocking$1(this.$db, this.$isReadOnly, this.$inTransaction, this.$block, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            RoomDatabase roomDatabase = this.$db;
            boolean z4 = this.$isReadOnly;
            DBUtil__DBUtil_androidKt$performBlocking$1$invokeSuspend$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performBlocking$1$invokeSuspend$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performBlocking$1$invokeSuspend$$inlined$internalPerform$1(this.$inTransaction, z4, roomDatabase, (C2308e) null, this.$block);
            this.label = 1;
            Object useConnection$room_runtime_release = roomDatabase.useConnection$room_runtime_release(z4, dBUtil__DBUtil_androidKt$performBlocking$1$invokeSuspend$$inlined$internalPerform$1, this);
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

    public final Object invoke(M m5, C2308e eVar) {
        return ((DBUtil__DBUtil_androidKt$performBlocking$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
