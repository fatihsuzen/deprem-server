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

@f(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1", f = "DBUtil.android.kt", l = {109}, m = "invokeSuspend")
public final class DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1 extends l implements p {
    final /* synthetic */ k3.l $block$inlined;
    final /* synthetic */ RoomDatabase $db$inlined;
    final /* synthetic */ boolean $inTransaction$inlined;
    final /* synthetic */ boolean $isReadOnly$inlined;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1(C2308e eVar, RoomDatabase roomDatabase, boolean z4, boolean z5, k3.l lVar) {
        super(2, eVar);
        this.$db$inlined = roomDatabase;
        this.$isReadOnly$inlined = z4;
        this.$inTransaction$inlined = z5;
        this.$block$inlined = lVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1(eVar, this.$db$inlined, this.$isReadOnly$inlined, this.$inTransaction$inlined, this.$block$inlined);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            RoomDatabase roomDatabase = this.$db$inlined;
            boolean z4 = this.$isReadOnly$inlined;
            DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1(this.$inTransaction$inlined, z4, roomDatabase, (C2308e) null, this.$block$inlined);
            this.label = 1;
            Object useConnection$room_runtime_release = roomDatabase.useConnection$room_runtime_release(z4, dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1, this);
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
        return ((DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
