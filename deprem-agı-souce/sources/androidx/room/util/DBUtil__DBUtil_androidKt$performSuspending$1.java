package androidx.room.util;

import androidx.room.RoomDatabase;
import b3.C2308e;
import k3.l;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.room.util.DBUtil__DBUtil_androidKt", f = "DBUtil.android.kt", l = {245, 247, 247}, m = "performSuspending")
final class DBUtil__DBUtil_androidKt$performSuspending$1<R> extends d {
    Object L$0;
    Object L$1;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;

    DBUtil__DBUtil_androidKt$performSuspending$1(C2308e eVar) {
        super(eVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DBUtil.performSuspending((RoomDatabase) null, false, false, (l) null, this);
    }
}
