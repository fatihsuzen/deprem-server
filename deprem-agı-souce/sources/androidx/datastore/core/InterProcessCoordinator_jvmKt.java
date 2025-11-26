package androidx.datastore.core;

import java.io.File;
import kotlin.jvm.internal.t;

public final class InterProcessCoordinator_jvmKt {
    public static final InterProcessCoordinator createSingleProcessCoordinator(File file) {
        t.e(file, "file");
        String absolutePath = file.getCanonicalFile().getAbsolutePath();
        t.d(absolutePath, "file.canonicalFile.absolutePath");
        return InterProcessCoordinatorKt.createSingleProcessCoordinator(absolutePath);
    }
}
