package androidx.datastore.core;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.core.FileReadScope", f = "FileStorage.kt", l = {169, 178}, m = "readData$suspendImpl")
final class FileReadScope$readData$1<T> extends d {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileReadScope<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileReadScope$readData$1(FileReadScope<T> fileReadScope, C2308e eVar) {
        super(eVar);
        this.this$0 = fileReadScope;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FileReadScope.readData$suspendImpl(this.this$0, this);
    }
}
