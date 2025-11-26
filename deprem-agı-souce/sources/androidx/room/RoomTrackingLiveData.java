package androidx.room;

import androidx.annotation.MainThread;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import b3.C2308e;
import b3.C2312i;
import b3.C2313j;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.C2633k;
import w3.C2908y0;
import w3.O;

public abstract class RoomTrackingLiveData<T> extends LiveData<T> {
    private final AtomicBoolean computing;
    private final InvalidationLiveDataContainer container;
    private final RoomDatabase database;
    private final boolean inTransaction;
    private final AtomicBoolean invalid;
    private final C2312i launchContext;
    private final InvalidationTracker.Observer observer;
    private final AtomicBoolean registeredObserver;

    public /* synthetic */ RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z4, String[] strArr, C2633k kVar) {
        this(roomDatabase, invalidationLiveDataContainer, z4, strArr);
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void invalidated() {
        boolean hasActiveObservers = hasActiveObservers();
        if (this.invalid.compareAndSet(false, true) && hasActiveObservers) {
            C2908y0 unused = C2876i.d(this.database.getCoroutineScope(), this.launchContext, (O) null, new RoomTrackingLiveData$invalidated$1(this, (C2308e) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0081, code lost:
        if (r9 == 0) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0083, code lost:
        r5.postValue(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0086, code lost:
        r5.computing.set(false);
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0076 A[LOOP:0: B:24:0x0061->B:31:0x0076, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0075 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0081 A[EDGE_INSN: B:48:0x0081->B:35:0x0081 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object refresh(b3.C2308e r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof androidx.room.RoomTrackingLiveData$refresh$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            androidx.room.RoomTrackingLiveData$refresh$1 r0 = (androidx.room.RoomTrackingLiveData$refresh$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.room.RoomTrackingLiveData$refresh$1 r0 = new androidx.room.RoomTrackingLiveData$refresh$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r4) goto L_0x0037
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$0
            androidx.room.RoomTrackingLiveData r5 = (androidx.room.RoomTrackingLiveData) r5
            W2.u.b(r9)     // Catch:{ Exception -> 0x0035 }
            r7 = r2
            r2 = r9
            r9 = r7
            goto L_0x0061
        L_0x0033:
            r9 = move-exception
            goto L_0x008c
        L_0x0035:
            r9 = move-exception
            goto L_0x0079
        L_0x0037:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x003f:
            W2.u.b(r9)
            java.util.concurrent.atomic.AtomicBoolean r9 = r8.registeredObserver
            boolean r9 = r9.compareAndSet(r3, r4)
            if (r9 == 0) goto L_0x0055
            androidx.room.RoomDatabase r9 = r8.database
            androidx.room.InvalidationTracker r9 = r9.getInvalidationTracker()
            androidx.room.InvalidationTracker$Observer r2 = r8.observer
            r9.addWeakObserver(r2)
        L_0x0055:
            r9 = r8
        L_0x0056:
            java.util.concurrent.atomic.AtomicBoolean r2 = r9.computing
            boolean r2 = r2.compareAndSet(r3, r4)
            if (r2 == 0) goto L_0x0092
            r2 = 0
            r5 = r9
            r9 = r3
        L_0x0061:
            java.util.concurrent.atomic.AtomicBoolean r6 = r5.invalid     // Catch:{ all -> 0x0033 }
            boolean r6 = r6.compareAndSet(r4, r3)     // Catch:{ all -> 0x0033 }
            if (r6 == 0) goto L_0x0081
            r0.L$0 = r5     // Catch:{ Exception -> 0x0035 }
            r0.I$0 = r4     // Catch:{ Exception -> 0x0035 }
            r0.label = r4     // Catch:{ Exception -> 0x0035 }
            java.lang.Object r9 = r5.compute(r0)     // Catch:{ Exception -> 0x0035 }
            if (r9 != r1) goto L_0x0076
            return r1
        L_0x0076:
            r2 = r9
            r9 = r4
            goto L_0x0061
        L_0x0079:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0033 }
            java.lang.String r1 = "Exception while computing database live data."
            r0.<init>(r1, r9)     // Catch:{ all -> 0x0033 }
            throw r0     // Catch:{ all -> 0x0033 }
        L_0x0081:
            if (r9 == 0) goto L_0x0086
            r5.postValue(r2)     // Catch:{ all -> 0x0033 }
        L_0x0086:
            java.util.concurrent.atomic.AtomicBoolean r2 = r5.computing
            r2.set(r3)
            goto L_0x0094
        L_0x008c:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.computing
            r0.set(r3)
            throw r9
        L_0x0092:
            r5 = r9
            r9 = r3
        L_0x0094:
            if (r9 == 0) goto L_0x00a1
            java.util.concurrent.atomic.AtomicBoolean r9 = r5.invalid
            boolean r9 = r9.get()
            if (r9 != 0) goto L_0x009f
            goto L_0x00a1
        L_0x009f:
            r9 = r5
            goto L_0x0056
        L_0x00a1:
            W2.J r9 = W2.J.f19942a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomTrackingLiveData.refresh(b3.e):java.lang.Object");
    }

    public abstract Object compute(C2308e eVar);

    /* access modifiers changed from: protected */
    public final RoomDatabase getDatabase() {
        return this.database;
    }

    /* access modifiers changed from: protected */
    public final boolean getInTransaction() {
        return this.inTransaction;
    }

    /* access modifiers changed from: protected */
    public void onActive() {
        super.onActive();
        this.container.onActive(this);
        C2908y0 unused = C2876i.d(this.database.getCoroutineScope(), this.launchContext, (O) null, new RoomTrackingLiveData$onActive$1(this, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onInactive() {
        super.onInactive();
        this.container.onInactive(this);
    }

    private RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z4, String[] strArr) {
        C2312i iVar;
        this.database = roomDatabase;
        this.container = invalidationLiveDataContainer;
        this.inTransaction = z4;
        this.observer = new RoomTrackingLiveData$observer$1(strArr, this);
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.registeredObserver = new AtomicBoolean(false);
        if (!roomDatabase.inCompatibilityMode$room_runtime_release()) {
            iVar = C2313j.f20794a;
        } else if (z4) {
            iVar = roomDatabase.getTransactionContext$room_runtime_release();
        } else {
            iVar = roomDatabase.getQueryContext();
        }
        this.launchContext = iVar;
    }
}
