package androidx.datastore.core;

import b3.C2308e;
import k3.q;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.core.FileStorageConnection", f = "FileStorage.kt", l = {101}, m = "readScope")
final class FileStorageConnection$readScope$1<R> extends d {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileStorageConnection<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileStorageConnection$readScope$1(FileStorageConnection<T> fileStorageConnection, C2308e eVar) {
        super(eVar);
        this.this$0 = fileStorageConnection;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.readScope((q) null, this);
    }
}
