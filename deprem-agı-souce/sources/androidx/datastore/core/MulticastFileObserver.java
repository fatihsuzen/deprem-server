package androidx.datastore.core;

import W2.J;
import android.os.FileObserver;
import androidx.annotation.CheckResult;
import androidx.annotation.VisibleForTesting;
import b3.C2308e;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2869e0;
import z3.C2972e;
import z3.C2974g;

public final class MulticastFileObserver extends FileObserver {
    public static final Companion Companion = new Companion((C2633k) null);
    /* access modifiers changed from: private */
    public static final Object LOCK = new Object();
    /* access modifiers changed from: private */
    public static final Map<String, MulticastFileObserver> fileObservers = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<l> delegates;
    private final String path;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getFileObservers$datastore_core_release$annotations() {
        }

        /* access modifiers changed from: private */
        public static final void observe$lambda$4(String str, l lVar) {
            t.e(lVar, "$observer");
            synchronized (MulticastFileObserver.LOCK) {
                try {
                    Companion companion = MulticastFileObserver.Companion;
                    MulticastFileObserver multicastFileObserver = companion.getFileObservers$datastore_core_release().get(str);
                    if (multicastFileObserver != null) {
                        multicastFileObserver.delegates.remove(lVar);
                        if (multicastFileObserver.delegates.isEmpty()) {
                            companion.getFileObservers$datastore_core_release().remove(str);
                            multicastFileObserver.stopWatching();
                        }
                    }
                    J j5 = J.f19942a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final Map<String, MulticastFileObserver> getFileObservers$datastore_core_release() {
            return MulticastFileObserver.fileObservers;
        }

        @CheckResult
        public final C2972e observe(File file) {
            t.e(file, "file");
            return C2974g.g(new MulticastFileObserver$Companion$observe$1(file, (C2308e) null));
        }

        @VisibleForTesting
        public final void removeAllObservers$datastore_core_release() {
            synchronized (MulticastFileObserver.LOCK) {
                try {
                    for (MulticastFileObserver stopWatching : MulticastFileObserver.Companion.getFileObservers$datastore_core_release().values()) {
                        stopWatching.stopWatching();
                    }
                    MulticastFileObserver.Companion.getFileObservers$datastore_core_release().clear();
                    J j5 = J.f19942a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        @CheckResult
        public final C2869e0 observe(File file, l lVar) {
            String path = file.getCanonicalFile().getPath();
            synchronized (MulticastFileObserver.LOCK) {
                try {
                    Map<String, MulticastFileObserver> fileObservers$datastore_core_release = MulticastFileObserver.Companion.getFileObservers$datastore_core_release();
                    t.d(path, "key");
                    MulticastFileObserver multicastFileObserver = fileObservers$datastore_core_release.get(path);
                    if (multicastFileObserver == null) {
                        multicastFileObserver = new MulticastFileObserver(path, (C2633k) null);
                        fileObservers$datastore_core_release.put(path, multicastFileObserver);
                    }
                    MulticastFileObserver multicastFileObserver2 = multicastFileObserver;
                    multicastFileObserver2.delegates.add(lVar);
                    if (multicastFileObserver2.delegates.size() == 1) {
                        multicastFileObserver2.startWatching();
                    }
                    J j5 = J.f19942a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return new a(path, lVar);
        }
    }

    public /* synthetic */ MulticastFileObserver(String str, C2633k kVar) {
        this(str);
    }

    public final String getPath() {
        return this.path;
    }

    public void onEvent(int i5, String str) {
        for (l invoke : this.delegates) {
            invoke.invoke(str);
        }
    }

    private MulticastFileObserver(String str) {
        super(str, 128);
        this.path = str;
        this.delegates = new CopyOnWriteArrayList<>();
    }
}
