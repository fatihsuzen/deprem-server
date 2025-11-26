package androidx.room;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2", f = "RoomDatabase.kt", l = {496}, m = "invokeSuspend")
final class RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2 extends l implements p {
    final /* synthetic */ p $block;
    final /* synthetic */ RoomDatabase $this_useWriterConnection;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2(RoomDatabase roomDatabase, p pVar, C2308e eVar) {
        super(2, eVar);
        this.$this_useWriterConnection = roomDatabase;
        this.$block = pVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2(this.$this_useWriterConnection, this.$block, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            RoomDatabase roomDatabase = this.$this_useWriterConnection;
            p pVar = this.$block;
            this.label = 1;
            Object useConnection$room_runtime_release = roomDatabase.useConnection$room_runtime_release(false, pVar, this);
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
        return ((RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
