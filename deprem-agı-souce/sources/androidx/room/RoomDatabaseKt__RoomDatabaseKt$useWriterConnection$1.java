package androidx.room;

import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.room.RoomDatabaseKt__RoomDatabaseKt", f = "RoomDatabase.kt", l = {496}, m = "useWriterConnection")
final class RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1<R> extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1(C2308e eVar) {
        super(eVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RoomDatabaseKt.useWriterConnection((RoomDatabase) null, (p) null, this);
    }
}
