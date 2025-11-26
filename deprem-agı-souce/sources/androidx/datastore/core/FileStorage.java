package androidx.datastore.core;

import androidx.annotation.GuardedBy;
import com.mbridge.msdk.MBridgeConstans;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import k3.C2616a;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class FileStorage<T> implements Storage<T> {
    public static final Companion Companion = new Companion((C2633k) null);
    /* access modifiers changed from: private */
    @GuardedBy("activeFilesLock")
    public static final Set<String> activeFiles = new LinkedHashSet();
    /* access modifiers changed from: private */
    public static final Object activeFilesLock = new Object();
    private final l coordinatorProducer;
    private final C2616a produceFile;
    private final Serializer<T> serializer;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final Set<String> getActiveFiles$datastore_core_release() {
            return FileStorage.activeFiles;
        }

        public final Object getActiveFilesLock$datastore_core_release() {
            return FileStorage.activeFilesLock;
        }

        private Companion() {
        }
    }

    public FileStorage(Serializer<T> serializer2, l lVar, C2616a aVar) {
        t.e(serializer2, "serializer");
        t.e(lVar, "coordinatorProducer");
        t.e(aVar, "produceFile");
        this.serializer = serializer2;
        this.coordinatorProducer = lVar;
        this.produceFile = aVar;
    }

    public StorageConnection<T> createConnection() {
        File canonicalFile = ((File) this.produceFile.invoke()).getCanonicalFile();
        synchronized (activeFilesLock) {
            String absolutePath = canonicalFile.getAbsolutePath();
            Set<String> set = activeFiles;
            if (!set.contains(absolutePath)) {
                t.d(absolutePath, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                set.add(absolutePath);
            } else {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + absolutePath + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
        }
        t.d(canonicalFile, "file");
        return new FileStorageConnection(canonicalFile, this.serializer, (InterProcessCoordinator) this.coordinatorProducer.invoke(canonicalFile), new FileStorage$createConnection$2(canonicalFile));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileStorage(Serializer serializer2, l lVar, C2616a aVar, int i5, C2633k kVar) {
        this(serializer2, (i5 & 2) != 0 ? AnonymousClass1.INSTANCE : lVar, aVar);
    }
}
