package androidx.datastore.core;

import androidx.datastore.core.MultiProcessCoordinator;
import b3.C2308e;
import java.io.FileOutputStream;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.core.MultiProcessCoordinator$Companion", f = "MultiProcessCoordinator.android.kt", l = {182}, m = "getExclusiveFileLockWithRetryIfDeadlock")
final class MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 extends d {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiProcessCoordinator.Companion this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1(MultiProcessCoordinator.Companion companion, C2308e eVar) {
        super(eVar);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getExclusiveFileLockWithRetryIfDeadlock((FileOutputStream) null, this);
    }
}
