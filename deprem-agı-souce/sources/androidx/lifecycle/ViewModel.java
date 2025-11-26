package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.viewmodel.internal.ViewModelImpl;
import java.io.Closeable;
import java.util.Arrays;
import kotlin.jvm.internal.t;
import w3.M;

public abstract class ViewModel {
    private final ViewModelImpl impl;

    public ViewModel() {
        this.impl = new ViewModelImpl();
    }

    public final void addCloseable(String str, AutoCloseable autoCloseable) {
        t.e(str, "key");
        t.e(autoCloseable, "closeable");
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.addCloseable(str, autoCloseable);
        }
    }

    @MainThread
    public final void clear$lifecycle_viewmodel_release() {
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.clear();
        }
        onCleared();
    }

    public final <T extends AutoCloseable> T getCloseable(String str) {
        t.e(str, "key");
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            return viewModelImpl.getCloseable(str);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
    }

    public void addCloseable(AutoCloseable autoCloseable) {
        t.e(autoCloseable, "closeable");
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.addCloseable(autoCloseable);
        }
    }

    public ViewModel(M m5) {
        t.e(m5, "viewModelScope");
        this.impl = new ViewModelImpl(m5);
    }

    public /* synthetic */ void addCloseable(Closeable closeable) {
        t.e(closeable, "closeable");
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.addCloseable(closeable);
        }
    }

    public ViewModel(AutoCloseable... autoCloseableArr) {
        t.e(autoCloseableArr, "closeables");
        this.impl = new ViewModelImpl((AutoCloseable[]) Arrays.copyOf(autoCloseableArr, autoCloseableArr.length));
    }

    public ViewModel(M m5, AutoCloseable... autoCloseableArr) {
        t.e(m5, "viewModelScope");
        t.e(autoCloseableArr, "closeables");
        this.impl = new ViewModelImpl(m5, (AutoCloseable[]) Arrays.copyOf(autoCloseableArr, autoCloseableArr.length));
    }

    public /* synthetic */ ViewModel(Closeable... closeableArr) {
        t.e(closeableArr, "closeables");
        this.impl = new ViewModelImpl((AutoCloseable[]) Arrays.copyOf(closeableArr, closeableArr.length));
    }
}
