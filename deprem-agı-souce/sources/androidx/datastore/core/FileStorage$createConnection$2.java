package androidx.datastore.core;

import W2.J;
import androidx.datastore.core.FileStorage;
import java.io.File;
import k3.C2616a;
import kotlin.jvm.internal.u;

final class FileStorage$createConnection$2 extends u implements C2616a {
    final /* synthetic */ File $file;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileStorage$createConnection$2(File file) {
        super(0);
        this.$file = file;
    }

    public final void invoke() {
        FileStorage.Companion companion = FileStorage.Companion;
        Object activeFilesLock$datastore_core_release = companion.getActiveFilesLock$datastore_core_release();
        File file = this.$file;
        synchronized (activeFilesLock$datastore_core_release) {
            companion.getActiveFiles$datastore_core_release().remove(file.getAbsolutePath());
            J j5 = J.f19942a;
        }
    }
}
