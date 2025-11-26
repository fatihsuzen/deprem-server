package androidx.datastore.core.okio;

import e4.Q;
import k3.C2616a;
import kotlin.jvm.internal.u;

final class OkioStorage$canonicalPath$2 extends u implements C2616a {
    final /* synthetic */ OkioStorage<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkioStorage$canonicalPath$2(OkioStorage<T> okioStorage) {
        super(0);
        this.this$0 = okioStorage;
    }

    public final Q invoke() {
        Q q5 = (Q) this.this$0.producePath.invoke();
        boolean isAbsolute = q5.isAbsolute();
        OkioStorage<T> okioStorage = this.this$0;
        if (isAbsolute) {
            return q5.g();
        }
        throw new IllegalStateException(("OkioStorage requires absolute paths, but did not get an absolute path from producePath = " + okioStorage.producePath + ", instead got " + q5).toString());
    }
}
