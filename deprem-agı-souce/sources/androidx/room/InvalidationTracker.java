package androidx.room;

import W2.J;
import W2.s;
import X2.C2250q;
import X2.M;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.support.AutoCloser;
import androidx.sqlite.SQLiteConnection;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;
import k3.C2616a;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import z3.C2972e;
import z3.C2974g;

public class InvalidationTracker {
    public static final Companion Companion = new Companion((C2633k) null);
    private AutoCloser autoCloser;
    private final RoomDatabase database;
    /* access modifiers changed from: private */
    public final TriggerBasedInvalidationTracker implementation;
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;
    private Intent multiInstanceInvalidationIntent;
    private final Map<Observer, ObserverWrapper> observerMap;
    private final ReentrantLock observerMapLock;
    /* access modifiers changed from: private */
    public final C2616a onRefreshCompleted;
    /* access modifiers changed from: private */
    public final C2616a onRefreshScheduled;
    private final Map<String, String> shadowTablesMap;
    private final String[] tableNames;
    private final Object trackerLock;
    private final Map<String, Set<String>> viewTables;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    private static final class MultiInstanceClientInitState {
        private final Context context;
        private final String name;
        private final Intent serviceIntent;

        public MultiInstanceClientInitState(Context context2, String str, Intent intent) {
            t.e(context2, "context");
            t.e(str, RewardPlus.NAME);
            t.e(intent, "serviceIntent");
            this.context = context2;
            this.name = str;
            this.serviceIntent = intent;
        }

        public static /* synthetic */ MultiInstanceClientInitState copy$default(MultiInstanceClientInitState multiInstanceClientInitState, Context context2, String str, Intent intent, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                context2 = multiInstanceClientInitState.context;
            }
            if ((i5 & 2) != 0) {
                str = multiInstanceClientInitState.name;
            }
            if ((i5 & 4) != 0) {
                intent = multiInstanceClientInitState.serviceIntent;
            }
            return multiInstanceClientInitState.copy(context2, str, intent);
        }

        public final Context component1() {
            return this.context;
        }

        public final String component2() {
            return this.name;
        }

        public final Intent component3() {
            return this.serviceIntent;
        }

        public final MultiInstanceClientInitState copy(Context context2, String str, Intent intent) {
            t.e(context2, "context");
            t.e(str, RewardPlus.NAME);
            t.e(intent, "serviceIntent");
            return new MultiInstanceClientInitState(context2, str, intent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MultiInstanceClientInitState)) {
                return false;
            }
            MultiInstanceClientInitState multiInstanceClientInitState = (MultiInstanceClientInitState) obj;
            return t.a(this.context, multiInstanceClientInitState.context) && t.a(this.name, multiInstanceClientInitState.name) && t.a(this.serviceIntent, multiInstanceClientInitState.serviceIntent);
        }

        public final Context getContext() {
            return this.context;
        }

        public final String getName() {
            return this.name;
        }

        public final Intent getServiceIntent() {
            return this.serviceIntent;
        }

        public int hashCode() {
            return (((this.context.hashCode() * 31) + this.name.hashCode()) * 31) + this.serviceIntent.hashCode();
        }

        public String toString() {
            return "MultiInstanceClientInitState(context=" + this.context + ", name=" + this.name + ", serviceIntent=" + this.serviceIntent + ')';
        }
    }

    public static abstract class Observer {
        private final String[] tables;

        public Observer(String[] strArr) {
            t.e(strArr, "tables");
            this.tables = strArr;
        }

        public final String[] getTables$room_runtime_release() {
            return this.tables;
        }

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(Set<String> set);

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected Observer(java.lang.String r3, java.lang.String... r4) {
            /*
                r2 = this;
                java.lang.String r0 = "firstTable"
                kotlin.jvm.internal.t.e(r3, r0)
                java.lang.String r0 = "rest"
                kotlin.jvm.internal.t.e(r4, r0)
                kotlin.jvm.internal.P r0 = new kotlin.jvm.internal.P
                r1 = 2
                r0.<init>(r1)
                r0.a(r3)
                r0.b(r4)
                int r3 = r0.c()
                java.lang.String[] r3 = new java.lang.String[r3]
                java.lang.Object[] r3 = r0.d(r3)
                java.lang.String[] r3 = (java.lang.String[]) r3
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker.Observer.<init>(java.lang.String, java.lang.String[]):void");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        t.e(roomDatabase, "database");
        t.e(map, "shadowTablesMap");
        t.e(map2, "viewTables");
        t.e(strArr, "tableNames");
        this.database = roomDatabase;
        this.shadowTablesMap = map;
        this.viewTables = map2;
        this.tableNames = strArr;
        RoomDatabase roomDatabase2 = roomDatabase;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = new TriggerBasedInvalidationTracker(roomDatabase2, map, map2, strArr, roomDatabase.getUseTempTrackingTable$room_runtime_release(), new InvalidationTracker$implementation$1(this));
        this.implementation = triggerBasedInvalidationTracker;
        this.observerMap = new LinkedHashMap();
        this.observerMapLock = new ReentrantLock();
        this.onRefreshScheduled = new f(this);
        this.onRefreshCompleted = new g(this);
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(roomDatabase2);
        this.trackerLock = new Object();
        triggerBasedInvalidationTracker.setOnAllowRefresh$room_runtime_release(new h(this));
    }

    /* access modifiers changed from: private */
    public static final boolean _init_$lambda$2(InvalidationTracker invalidationTracker) {
        if (!invalidationTracker.database.inCompatibilityMode$room_runtime_release() || invalidationTracker.database.isOpenInternal()) {
            return true;
        }
        return false;
    }

    private final boolean addObserverOnly(Observer observer) {
        ObserverWrapper observerWrapper;
        s validateTableNames$room_runtime_release = this.implementation.validateTableNames$room_runtime_release(observer.getTables$room_runtime_release());
        int[] iArr = (int[]) validateTableNames$room_runtime_release.b();
        ObserverWrapper observerWrapper2 = new ObserverWrapper(observer, iArr, (String[]) validateTableNames$room_runtime_release.a());
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            if (this.observerMap.containsKey(observer)) {
                observerWrapper = (ObserverWrapper) M.i(this.observerMap, observer);
            } else {
                observerWrapper = this.observerMap.put(observer, observerWrapper2);
            }
            if (observerWrapper != null || !this.implementation.onObserverAdded$room_runtime_release(iArr)) {
                return false;
            }
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static /* synthetic */ C2972e createFlow$default(InvalidationTracker invalidationTracker, String[] strArr, boolean z4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 2) != 0) {
                z4 = true;
            }
            return invalidationTracker.createFlow(strArr, z4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createFlow");
    }

    private final List<Observer> getAllObservers() {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            return C2250q.n0(this.observerMap.keySet());
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public final void notifyInvalidatedObservers(Set<Integer> set) {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            List<ObserverWrapper> n02 = C2250q.n0(this.observerMap.values());
            reentrantLock.unlock();
            for (ObserverWrapper notifyByTableIds$room_runtime_release : n02) {
                notifyByTableIds$room_runtime_release.notifyByTableIds$room_runtime_release(set);
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final void onAutoCloseCallback() {
        synchronized (this.trackerLock) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = this.multiInstanceInvalidationClient;
                if (multiInstanceInvalidationClient2 != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Object next : getAllObservers()) {
                        if (!((Observer) next).isRemote$room_runtime_release()) {
                            arrayList.add(next);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        multiInstanceInvalidationClient2.stop();
                    }
                }
                this.implementation.resetSync$room_runtime_release();
                J j5 = J.f19942a;
            } finally {
            }
        }
    }

    /* access modifiers changed from: private */
    public static final J onRefreshCompleted$lambda$1(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser2 = invalidationTracker.autoCloser;
        if (autoCloser2 != null) {
            autoCloser2.decrementCountAndScheduleClose();
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J onRefreshScheduled$lambda$0(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser2 = invalidationTracker.autoCloser;
        if (autoCloser2 != null) {
            autoCloser2.incrementCountAndEnsureDbIsOpen();
        }
        return J.f19942a;
    }

    private final boolean removeObserverOnly(Observer observer) {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            ObserverWrapper remove = this.observerMap.remove(observer);
            if (remove == null || !this.implementation.onObserverRemoved$room_runtime_release(remove.getTableIds$room_runtime_release())) {
                return false;
            }
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    @WorkerThread
    public void addObserver(Observer observer) {
        t.e(observer, "observer");
        if (addObserverOnly(observer)) {
            RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new InvalidationTracker$addObserver$1(this, (C2308e) null));
        }
    }

    public final void addRemoteObserver$room_runtime_release(Observer observer) {
        t.e(observer, "observer");
        if (observer.isRemote$room_runtime_release()) {
            addObserverOnly(observer);
            return;
        }
        throw new IllegalStateException("isRemote was false of observer argument");
    }

    @WorkerThread
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addWeakObserver(Observer observer) {
        t.e(observer, "observer");
        addObserver(new WeakObserver(this, observer));
    }

    public final C2972e createFlow(String... strArr) {
        t.e(strArr, "tables");
        return createFlow$default(this, strArr, false, 2, (Object) null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] strArr, Callable<T> callable) {
        t.e(strArr, "tableNames");
        t.e(callable, "computeFunction");
        return createLiveData(strArr, false, callable);
    }

    public final RoomDatabase getDatabase$room_runtime_release() {
        return this.database;
    }

    public final String[] getTableNames$room_runtime_release() {
        return this.tableNames;
    }

    public final void initMultiInstanceInvalidation$room_runtime_release(Context context, String str, Intent intent) {
        t.e(context, "context");
        t.e(str, RewardPlus.NAME);
        t.e(intent, "serviceIntent");
        this.multiInstanceInvalidationIntent = intent;
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, str, this);
    }

    public final void internalInit$room_runtime_release(SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "connection");
        this.implementation.configureConnection(sQLiteConnection);
        synchronized (this.trackerLock) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = this.multiInstanceInvalidationClient;
                if (multiInstanceInvalidationClient2 != null) {
                    Intent intent = this.multiInstanceInvalidationIntent;
                    if (intent != null) {
                        multiInstanceInvalidationClient2.start(intent);
                        J j5 = J.f19942a;
                    } else {
                        throw new IllegalStateException("Required value was null.");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public final void notifyObserversByTableNames$room_runtime_release(Set<String> set) {
        t.e(set, "tables");
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            List<ObserverWrapper> n02 = C2250q.n0(this.observerMap.values());
            reentrantLock.unlock();
            for (ObserverWrapper observerWrapper : n02) {
                if (!observerWrapper.getObserver$room_runtime_release().isRemote$room_runtime_release()) {
                    observerWrapper.notifyByTableNames$room_runtime_release(set);
                }
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Object refresh(String[] strArr, C2308e eVar) {
        return this.implementation.refreshInvalidation$room_runtime_release(strArr, this.onRefreshScheduled, this.onRefreshCompleted, eVar);
    }

    public final void refreshAsync() {
        this.implementation.refreshInvalidationAsync$room_runtime_release(this.onRefreshScheduled, this.onRefreshCompleted);
    }

    public void refreshVersionsAsync() {
        this.implementation.refreshInvalidationAsync$room_runtime_release(this.onRefreshScheduled, this.onRefreshCompleted);
    }

    @WorkerThread
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void refreshVersionsSync() {
        RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new InvalidationTracker$refreshVersionsSync$1(this, (C2308e) null));
    }

    @WorkerThread
    public void removeObserver(Observer observer) {
        t.e(observer, "observer");
        if (removeObserverOnly(observer)) {
            RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new InvalidationTracker$removeObserver$1(this, (C2308e) null));
        }
    }

    public final void setAutoCloser$room_runtime_release(AutoCloser autoCloser2) {
        t.e(autoCloser2, "autoCloser");
        this.autoCloser = autoCloser2;
        autoCloser2.setAutoCloseCallback(new InvalidationTracker$setAutoCloser$1(this));
    }

    public final void stop$room_runtime_release() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = this.multiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient2 != null) {
            multiInstanceInvalidationClient2.stop();
        }
    }

    public final Object sync$room_runtime_release(C2308e eVar) {
        if (this.database.inCompatibilityMode$room_runtime_release() && !this.database.isOpenInternal()) {
            return J.f19942a;
        }
        Object syncTriggers$room_runtime_release = this.implementation.syncTriggers$room_runtime_release(eVar);
        if (syncTriggers$room_runtime_release == C2316b.f()) {
            return syncTriggers$room_runtime_release;
        }
        return J.f19942a;
    }

    @WorkerThread
    public final void syncBlocking$room_runtime_release() {
        RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new InvalidationTracker$syncBlocking$1(this, (C2308e) null));
    }

    public final C2972e createFlow(String[] strArr, boolean z4) {
        t.e(strArr, "tables");
        s validateTableNames$room_runtime_release = this.implementation.validateTableNames$room_runtime_release(strArr);
        String[] strArr2 = (String[]) validateTableNames$room_runtime_release.a();
        C2972e createFlow$room_runtime_release = this.implementation.createFlow$room_runtime_release(strArr2, (int[]) validateTableNames$room_runtime_release.b(), z4);
        MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = this.multiInstanceInvalidationClient;
        C2972e createFlow = multiInstanceInvalidationClient2 != null ? multiInstanceInvalidationClient2.createFlow(strArr2) : null;
        if (createFlow == null) {
            return createFlow$room_runtime_release;
        }
        return C2974g.u(createFlow$room_runtime_release, createFlow);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] strArr, boolean z4, Callable<T> callable) {
        t.e(strArr, "tableNames");
        t.e(callable, "computeFunction");
        this.implementation.validateTableNames$room_runtime_release(strArr);
        return this.invalidationLiveDataContainer.create(strArr, z4, callable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final <T> LiveData<T> createLiveData(String[] strArr, boolean z4, l lVar) {
        t.e(strArr, "tableNames");
        t.e(lVar, "computeFunction");
        this.implementation.validateTableNames$room_runtime_release(strArr);
        return this.invalidationLiveDataContainer.create(strArr, z4, lVar);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase roomDatabase, String... strArr) {
        this(roomDatabase, M.h(), M.h(), (String[]) Arrays.copyOf(strArr, strArr.length));
        t.e(roomDatabase, "database");
        t.e(strArr, "tableNames");
    }
}
