package androidx.datastore.core.okio;

import W2.J;
import androidx.datastore.core.okio.OkioStorage;
import k3.C2616a;
import kotlin.jvm.internal.u;

final class OkioStorage$createConnection$2 extends u implements C2616a {
    final /* synthetic */ OkioStorage<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkioStorage$createConnection$2(OkioStorage<T> okioStorage) {
        super(0);
        this.this$0 = okioStorage;
    }

    public final void invoke() {
        OkioStorage.Companion companion = OkioStorage.Companion;
        Synchronizer activeFilesLock = companion.getActiveFilesLock();
        OkioStorage<T> okioStorage = this.this$0;
        synchronized (activeFilesLock) {
            companion.getActiveFiles$datastore_core_okio().remove(okioStorage.getCanonicalPath().toString());
            J j5 = J.f19942a;
        }
    }
}
