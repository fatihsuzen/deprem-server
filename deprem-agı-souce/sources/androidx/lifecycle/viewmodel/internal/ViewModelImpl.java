package androidx.lifecycle.viewmodel.internal;

import W2.J;
import X2.C2250q;
import androidx.annotation.MainThread;
import androidx.core.provider.c;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;
import w3.M;

public final class ViewModelImpl {
    /* access modifiers changed from: private */
    public final Set<AutoCloseable> closeables;
    private volatile boolean isCleared;
    /* access modifiers changed from: private */
    public final Map<String, AutoCloseable> keyToCloseables;
    private final SynchronizedObject lock;

    public ViewModelImpl() {
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        this.closeables = new LinkedHashSet();
    }

    /* access modifiers changed from: private */
    public final void closeWithRuntimeException(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                c.a(autoCloseable);
            } catch (Exception e5) {
                throw new RuntimeException(e5);
            }
        }
    }

    public final void addCloseable(String str, AutoCloseable autoCloseable) {
        AutoCloseable autoCloseable2;
        t.e(str, "key");
        t.e(autoCloseable, "closeable");
        if (this.isCleared) {
            closeWithRuntimeException(autoCloseable);
            return;
        }
        synchronized (this.lock) {
            autoCloseable2 = (AutoCloseable) this.keyToCloseables.put(str, autoCloseable);
        }
        closeWithRuntimeException(autoCloseable2);
    }

    @MainThread
    public final void clear() {
        if (!this.isCleared) {
            this.isCleared = true;
            synchronized (this.lock) {
                try {
                    for (AutoCloseable access$closeWithRuntimeException : this.keyToCloseables.values()) {
                        closeWithRuntimeException(access$closeWithRuntimeException);
                    }
                    for (AutoCloseable access$closeWithRuntimeException2 : this.closeables) {
                        closeWithRuntimeException(access$closeWithRuntimeException2);
                    }
                    this.closeables.clear();
                    J j5 = J.f19942a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final <T extends AutoCloseable> T getCloseable(String str) {
        T t5;
        t.e(str, "key");
        synchronized (this.lock) {
            t5 = (AutoCloseable) this.keyToCloseables.get(str);
        }
        return t5;
    }

    public ViewModelImpl(M m5) {
        t.e(m5, "viewModelScope");
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        this.closeables = new LinkedHashSet();
        addCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY, CloseableCoroutineScopeKt.asCloseable(m5));
    }

    public final void addCloseable(AutoCloseable autoCloseable) {
        t.e(autoCloseable, "closeable");
        if (this.isCleared) {
            closeWithRuntimeException(autoCloseable);
            return;
        }
        synchronized (this.lock) {
            this.closeables.add(autoCloseable);
            J j5 = J.f19942a;
        }
    }

    public ViewModelImpl(AutoCloseable... autoCloseableArr) {
        t.e(autoCloseableArr, "closeables");
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.closeables = linkedHashSet;
        C2250q.v(linkedHashSet, autoCloseableArr);
    }

    public ViewModelImpl(M m5, AutoCloseable... autoCloseableArr) {
        t.e(m5, "viewModelScope");
        t.e(autoCloseableArr, "closeables");
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.closeables = linkedHashSet;
        addCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY, CloseableCoroutineScopeKt.asCloseable(m5));
        C2250q.v(linkedHashSet, autoCloseableArr);
    }
}
