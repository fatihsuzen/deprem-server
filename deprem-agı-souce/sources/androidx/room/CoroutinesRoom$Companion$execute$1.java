package androidx.room;

import androidx.room.CoroutinesRoom;
import b3.C2308e;
import java.util.concurrent.Callable;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.room.CoroutinesRoom$Companion", f = "CoroutinesRoom.android.kt", l = {48, 49}, m = "execute")
final class CoroutinesRoom$Companion$execute$1<R> extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoroutinesRoom.Companion this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutinesRoom$Companion$execute$1(CoroutinesRoom.Companion companion, C2308e eVar) {
        super(eVar);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute((RoomDatabase) null, false, (Callable) null, this);
    }
}
