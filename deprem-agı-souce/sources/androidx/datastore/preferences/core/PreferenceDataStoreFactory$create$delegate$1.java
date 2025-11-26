package androidx.datastore.preferences.core;

import h3.C2454c;
import java.io.File;
import k3.C2616a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

final class PreferenceDataStoreFactory$create$delegate$1 extends u implements C2616a {
    final /* synthetic */ C2616a $produceFile;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreferenceDataStoreFactory$create$delegate$1(C2616a aVar) {
        super(0);
        this.$produceFile = aVar;
    }

    public final File invoke() {
        File file = (File) this.$produceFile.invoke();
        if (t.a(C2454c.a(file), "preferences_pb")) {
            File absoluteFile = file.getAbsoluteFile();
            t.d(absoluteFile, "file.absoluteFile");
            return absoluteFile;
        }
        throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: preferences_pb").toString());
    }
}
