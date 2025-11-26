package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ComputableLiveData<T> {
    private final LiveData<T> _liveData;
    private final AtomicBoolean computing;
    private final Executor executor;
    private final AtomicBoolean invalid;
    public final Runnable invalidationRunnable;
    private final LiveData<T> liveData;
    public final Runnable refreshRunnable;

    public ComputableLiveData() {
        this((Executor) null, 1, (C2633k) null);
    }

    @VisibleForTesting
    public static /* synthetic */ void getInvalidationRunnable$lifecycle_livedata_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getRefreshRunnable$lifecycle_livedata_release$annotations() {
    }

    /* access modifiers changed from: private */
    public static final void invalidationRunnable$lambda$1(ComputableLiveData computableLiveData) {
        boolean hasActiveObservers = computableLiveData.getLiveData().hasActiveObservers();
        if (computableLiveData.invalid.compareAndSet(false, true) && hasActiveObservers) {
            computableLiveData.executor.execute(computableLiveData.refreshRunnable);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void refreshRunnable$lambda$0(androidx.lifecycle.ComputableLiveData r5) {
        /*
        L_0x0000:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.computing
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x0032
            r0 = 0
            r3 = r1
        L_0x000c:
            java.util.concurrent.atomic.AtomicBoolean r4 = r5.invalid     // Catch:{ all -> 0x001a }
            boolean r4 = r4.compareAndSet(r2, r1)     // Catch:{ all -> 0x001a }
            if (r4 == 0) goto L_0x001c
            java.lang.Object r0 = r5.compute()     // Catch:{ all -> 0x001a }
            r3 = r2
            goto L_0x000c
        L_0x001a:
            r0 = move-exception
            goto L_0x002c
        L_0x001c:
            if (r3 == 0) goto L_0x0025
            androidx.lifecycle.LiveData r2 = r5.getLiveData()     // Catch:{ all -> 0x001a }
            r2.postValue(r0)     // Catch:{ all -> 0x001a }
        L_0x0025:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.computing
            r0.set(r1)
            r1 = r3
            goto L_0x0032
        L_0x002c:
            java.util.concurrent.atomic.AtomicBoolean r5 = r5.computing
            r5.set(r1)
            throw r0
        L_0x0032:
            if (r1 == 0) goto L_0x003c
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.invalid
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x0000
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ComputableLiveData.refreshRunnable$lambda$0(androidx.lifecycle.ComputableLiveData):void");
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public abstract T compute();

    public final AtomicBoolean getComputing$lifecycle_livedata_release() {
        return this.computing;
    }

    public final Executor getExecutor$lifecycle_livedata_release() {
        return this.executor;
    }

    public final AtomicBoolean getInvalid$lifecycle_livedata_release() {
        return this.invalid;
    }

    public LiveData<T> getLiveData() {
        return this.liveData;
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.invalidationRunnable);
    }

    public ComputableLiveData(Executor executor2) {
        t.e(executor2, "executor");
        this.executor = executor2;
        ComputableLiveData$_liveData$1 computableLiveData$_liveData$1 = new ComputableLiveData$_liveData$1(this);
        this._liveData = computableLiveData$_liveData$1;
        this.liveData = computableLiveData$_liveData$1;
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.refreshRunnable = new b(this);
        this.invalidationRunnable = new c(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ComputableLiveData(Executor executor2, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? ArchTaskExecutor.getIOThreadExecutor() : executor2);
    }
}
