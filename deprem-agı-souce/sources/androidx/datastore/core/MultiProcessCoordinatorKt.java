package androidx.datastore.core;

import b3.C2312i;
import java.io.File;
import kotlin.jvm.internal.t;

public final class MultiProcessCoordinatorKt {
    public static final InterProcessCoordinator createMultiProcessCoordinator(C2312i iVar, File file) {
        t.e(iVar, "context");
        t.e(file, "file");
        return new MultiProcessCoordinator(iVar, file);
    }
}
