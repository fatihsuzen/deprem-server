package androidx.datastore.preferences.core;

import e4.Q;
import java.io.File;
import k3.C2616a;
import kotlin.jvm.internal.u;

final class PreferenceDataStoreFactory$createWithPath$1 extends u implements C2616a {
    final /* synthetic */ C2616a $produceFile;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreferenceDataStoreFactory$createWithPath$1(C2616a aVar) {
        super(0);
        this.$produceFile = aVar;
    }

    public final File invoke() {
        return ((Q) this.$produceFile.invoke()).toFile();
    }
}
