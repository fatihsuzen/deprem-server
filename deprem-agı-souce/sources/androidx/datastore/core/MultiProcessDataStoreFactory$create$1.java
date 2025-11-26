package androidx.datastore.core;

import java.io.File;
import k3.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;
import w3.M;

final class MultiProcessDataStoreFactory$create$1 extends u implements l {
    final /* synthetic */ M $scope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiProcessDataStoreFactory$create$1(M m5) {
        super(1);
        this.$scope = m5;
    }

    public final InterProcessCoordinator invoke(File file) {
        t.e(file, "it");
        return new MultiProcessCoordinator(this.$scope.getCoroutineContext(), file);
    }
}
