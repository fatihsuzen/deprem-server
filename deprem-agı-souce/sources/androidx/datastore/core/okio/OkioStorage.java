package androidx.datastore.core.okio;

import W2.C2223l;
import W2.m;
import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.Storage;
import androidx.datastore.core.StorageConnection;
import e4.C2362k;
import e4.Q;
import java.util.LinkedHashSet;
import java.util.Set;
import k3.C2616a;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class OkioStorage<T> implements Storage<T> {
    public static final Companion Companion = new Companion((C2633k) null);
    /* access modifiers changed from: private */
    public static final Set<String> activeFiles = new LinkedHashSet();
    /* access modifiers changed from: private */
    public static final Synchronizer activeFilesLock = new Synchronizer();
    private final C2223l canonicalPath$delegate;
    private final p coordinatorProducer;
    private final C2362k fileSystem;
    /* access modifiers changed from: private */
    public final C2616a producePath;
    private final OkioSerializer<T> serializer;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final Set<String> getActiveFiles$datastore_core_okio() {
            return OkioStorage.activeFiles;
        }

        public final Synchronizer getActiveFilesLock() {
            return OkioStorage.activeFilesLock;
        }

        private Companion() {
        }
    }

    public OkioStorage(C2362k kVar, OkioSerializer<T> okioSerializer, p pVar, C2616a aVar) {
        t.e(kVar, "fileSystem");
        t.e(okioSerializer, "serializer");
        t.e(pVar, "coordinatorProducer");
        t.e(aVar, "producePath");
        this.fileSystem = kVar;
        this.serializer = okioSerializer;
        this.coordinatorProducer = pVar;
        this.producePath = aVar;
        this.canonicalPath$delegate = m.b(new OkioStorage$canonicalPath$2(this));
    }

    /* access modifiers changed from: private */
    public final Q getCanonicalPath() {
        return (Q) this.canonicalPath$delegate.getValue();
    }

    public StorageConnection<T> createConnection() {
        String q5 = getCanonicalPath().toString();
        synchronized (activeFilesLock) {
            Set<String> set = activeFiles;
            if (!set.contains(q5)) {
                set.add(q5);
            } else {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + q5 + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
        }
        return new OkioStorageConnection(this.fileSystem, getCanonicalPath(), this.serializer, (InterProcessCoordinator) this.coordinatorProducer.invoke(getCanonicalPath(), this.fileSystem), new OkioStorage$createConnection$2(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OkioStorage(C2362k kVar, OkioSerializer okioSerializer, p pVar, C2616a aVar, int i5, C2633k kVar2) {
        this(kVar, okioSerializer, (i5 & 4) != 0 ? AnonymousClass1.INSTANCE : pVar, aVar);
    }
}
