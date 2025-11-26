package androidx.datastore.core;

import F3.a;
import F3.g;
import W2.C2223l;
import W2.m;
import X2.C2250q;
import androidx.datastore.core.Message;
import androidx.datastore.core.UpdatingDataContextElement;
import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import b3.C2308e;
import b3.C2312i;
import java.util.List;
import k3.l;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.T0;
import z3.C2972e;
import z3.C2974g;

public final class DataStoreImpl<T> implements DataStore<T> {
    private static final String BUG_MESSAGE = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542";
    public static final Companion Companion = new Companion((C2633k) null);
    private int collectorCounter;
    private C2908y0 collectorJob;
    private final a collectorMutex;
    private final C2223l coordinator$delegate;
    private final CorruptionHandler<T> corruptionHandler;
    private final C2972e data;
    /* access modifiers changed from: private */
    public final DataStoreInMemoryCache<T> inMemoryCache;
    /* access modifiers changed from: private */
    public final DataStoreImpl<T>.InitDataStore readAndInit;
    private final M scope;
    /* access modifiers changed from: private */
    public final Storage<T> storage;
    /* access modifiers changed from: private */
    public final C2223l storageConnectionDelegate;
    /* access modifiers changed from: private */
    public final SimpleActor<Message.Update<T>> writeActor;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    private final class InitDataStore extends RunOnce {
        /* access modifiers changed from: private */
        public List<? extends p> initTasks;
        final /* synthetic */ DataStoreImpl<T> this$0;

        public InitDataStore(DataStoreImpl dataStoreImpl, List<? extends p> list) {
            t.e(list, "initTasksList");
            this.this$0 = dataStoreImpl;
            this.initTasks = C2250q.n0(list);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object doRun(b3.C2308e r7) {
            /*
                r6 = this;
                boolean r0 = r7 instanceof androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1
                if (r0 == 0) goto L_0x0013
                r0 = r7
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1 r0 = (androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1 r0 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1
                r0.<init>(r6, r7)
            L_0x0018:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x0040
                if (r2 == r4) goto L_0x0038
                if (r2 != r3) goto L_0x0030
                java.lang.Object r0 = r0.L$0
                androidx.datastore.core.DataStoreImpl$InitDataStore r0 = (androidx.datastore.core.DataStoreImpl.InitDataStore) r0
                W2.u.b(r7)
                goto L_0x006b
            L_0x0030:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x0038:
                java.lang.Object r0 = r0.L$0
                androidx.datastore.core.DataStoreImpl$InitDataStore r0 = (androidx.datastore.core.DataStoreImpl.InitDataStore) r0
                W2.u.b(r7)
                goto L_0x007d
            L_0x0040:
                W2.u.b(r7)
                java.util.List<? extends k3.p> r7 = r6.initTasks
                if (r7 == 0) goto L_0x006e
                kotlin.jvm.internal.t.b(r7)
                boolean r7 = r7.isEmpty()
                if (r7 == 0) goto L_0x0051
                goto L_0x006e
            L_0x0051:
                androidx.datastore.core.DataStoreImpl<T> r7 = r6.this$0
                androidx.datastore.core.InterProcessCoordinator r7 = r7.getCoordinator()
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1 r2 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1
                androidx.datastore.core.DataStoreImpl<T> r4 = r6.this$0
                r5 = 0
                r2.<init>(r4, r6, r5)
                r0.L$0 = r6
                r0.label = r3
                java.lang.Object r7 = r7.lock(r2, r0)
                if (r7 != r1) goto L_0x006a
                goto L_0x007b
            L_0x006a:
                r0 = r6
            L_0x006b:
                androidx.datastore.core.Data r7 = (androidx.datastore.core.Data) r7
                goto L_0x007f
            L_0x006e:
                androidx.datastore.core.DataStoreImpl<T> r7 = r6.this$0
                r0.L$0 = r6
                r0.label = r4
                r2 = 0
                java.lang.Object r7 = r7.readDataOrHandleCorruption(r2, r0)
                if (r7 != r1) goto L_0x007c
            L_0x007b:
                return r1
            L_0x007c:
                r0 = r6
            L_0x007d:
                androidx.datastore.core.Data r7 = (androidx.datastore.core.Data) r7
            L_0x007f:
                androidx.datastore.core.DataStoreImpl<T> r0 = r0.this$0
                androidx.datastore.core.DataStoreInMemoryCache r0 = r0.inMemoryCache
                r0.tryUpdate(r7)
                W2.J r7 = W2.J.f19942a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.InitDataStore.doRun(b3.e):java.lang.Object");
        }
    }

    public DataStoreImpl(Storage<T> storage2, List<? extends p> list, CorruptionHandler<T> corruptionHandler2, M m5) {
        t.e(storage2, "storage");
        t.e(list, "initTasksList");
        t.e(corruptionHandler2, "corruptionHandler");
        t.e(m5, "scope");
        this.storage = storage2;
        this.corruptionHandler = corruptionHandler2;
        this.scope = m5;
        this.data = C2974g.q(new DataStoreImpl$data$1(this, (C2308e) null));
        this.collectorMutex = g.b(false, 1, (Object) null);
        this.inMemoryCache = new DataStoreInMemoryCache<>();
        this.readAndInit = new InitDataStore(this, list);
        this.storageConnectionDelegate = m.b(new DataStoreImpl$storageConnectionDelegate$1(this));
        this.coordinator$delegate = m.b(new DataStoreImpl$coordinator$2(this));
        this.writeActor = new SimpleActor<>(m5, new DataStoreImpl$writeActor$1(this), DataStoreImpl$writeActor$2.INSTANCE, new DataStoreImpl$writeActor$3(this, (C2308e) null));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056 A[Catch:{ all -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object decrementCollector(b3.C2308e r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.DataStoreImpl$decrementCollector$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.datastore.core.DataStoreImpl$decrementCollector$1 r0 = (androidx.datastore.core.DataStoreImpl$decrementCollector$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.DataStoreImpl$decrementCollector$1 r0 = new androidx.datastore.core.DataStoreImpl$decrementCollector$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r1 = r0.L$1
            F3.a r1 = (F3.a) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            W2.u.b(r6)
            goto L_0x004e
        L_0x0032:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x003a:
            W2.u.b(r6)
            F3.a r6 = r5.collectorMutex
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r0 = r6.lock(r4, r0)
            if (r0 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r0 = r5
            r1 = r6
        L_0x004e:
            int r6 = r0.collectorCounter     // Catch:{ all -> 0x005e }
            int r6 = r6 + -1
            r0.collectorCounter = r6     // Catch:{ all -> 0x005e }
            if (r6 != 0) goto L_0x0062
            w3.y0 r6 = r0.collectorJob     // Catch:{ all -> 0x005e }
            if (r6 == 0) goto L_0x0060
            w3.C2908y0.a.a(r6, r4, r3, r4)     // Catch:{ all -> 0x005e }
            goto L_0x0060
        L_0x005e:
            r6 = move-exception
            goto L_0x006a
        L_0x0060:
            r0.collectorJob = r4     // Catch:{ all -> 0x005e }
        L_0x0062:
            W2.J r6 = W2.J.f19942a     // Catch:{ all -> 0x005e }
            r1.unlock(r4)
            W2.J r6 = W2.J.f19942a
            return r6
        L_0x006a:
            r1.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.decrementCollector(b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final <R> Object doWithWriteFileLock(boolean z4, l lVar, C2308e eVar) {
        if (z4) {
            return lVar.invoke(eVar);
        }
        return getCoordinator().lock(new DataStoreImpl$doWithWriteFileLock$3(lVar, (C2308e) null), eVar);
    }

    /* access modifiers changed from: private */
    public final InterProcessCoordinator getCoordinator() {
        return (InterProcessCoordinator) this.coordinator$delegate.getValue();
    }

    private static Object getStorageConnection$datastore_core_release$delegate(DataStoreImpl<Object> dataStoreImpl) {
        return dataStoreImpl.storageConnectionDelegate;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b9, code lost:
        if (r9 != r1) goto L_0x007c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handleUpdate(androidx.datastore.core.Message.Update<T> r9, b3.C2308e r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.DataStoreImpl$handleUpdate$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.datastore.core.DataStoreImpl$handleUpdate$1 r0 = (androidx.datastore.core.DataStoreImpl$handleUpdate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.DataStoreImpl$handleUpdate$1 r0 = new androidx.datastore.core.DataStoreImpl$handleUpdate$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r5) goto L_0x0051
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r9 = r0.L$0
            w3.v r9 = (w3.C2901v) r9
        L_0x002f:
            W2.u.b(r10)     // Catch:{ all -> 0x0034 }
            goto L_0x00bc
        L_0x0034:
            r10 = move-exception
            goto L_0x00de
        L_0x0037:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003f:
            java.lang.Object r9 = r0.L$2
            w3.v r9 = (w3.C2901v) r9
            java.lang.Object r2 = r0.L$1
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            java.lang.Object r4 = r0.L$0
            androidx.datastore.core.Message$Update r4 = (androidx.datastore.core.Message.Update) r4
            W2.u.b(r10)     // Catch:{ all -> 0x0034 }
            r10 = r9
            r9 = r4
            goto L_0x00a4
        L_0x0051:
            java.lang.Object r9 = r0.L$0
            w3.v r9 = (w3.C2901v) r9
            goto L_0x002f
        L_0x0056:
            W2.u.b(r10)
            w3.v r10 = r9.getAck()
            W2.t$a r2 = W2.t.f19966b     // Catch:{ all -> 0x0080 }
            androidx.datastore.core.DataStoreInMemoryCache<T> r2 = r8.inMemoryCache     // Catch:{ all -> 0x0080 }
            androidx.datastore.core.State r2 = r2.getCurrentState()     // Catch:{ all -> 0x0080 }
            boolean r6 = r2 instanceof androidx.datastore.core.Data     // Catch:{ all -> 0x0080 }
            if (r6 == 0) goto L_0x0085
            k3.p r2 = r9.getTransform()     // Catch:{ all -> 0x0080 }
            b3.i r9 = r9.getCallerContext()     // Catch:{ all -> 0x0080 }
            r0.L$0 = r10     // Catch:{ all -> 0x0080 }
            r0.label = r5     // Catch:{ all -> 0x0080 }
            java.lang.Object r9 = r8.transformAndWrite(r2, r9, r0)     // Catch:{ all -> 0x0080 }
            if (r9 != r1) goto L_0x007c
            goto L_0x00bb
        L_0x007c:
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x00bc
        L_0x0080:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x00de
        L_0x0085:
            boolean r6 = r2 instanceof androidx.datastore.core.ReadException     // Catch:{ all -> 0x0080 }
            if (r6 == 0) goto L_0x008a
            goto L_0x008c
        L_0x008a:
            boolean r5 = r2 instanceof androidx.datastore.core.UnInitialized     // Catch:{ all -> 0x0080 }
        L_0x008c:
            if (r5 == 0) goto L_0x00cd
            androidx.datastore.core.State r5 = r9.getLastState()     // Catch:{ all -> 0x0080 }
            if (r2 != r5) goto L_0x00c1
            r0.L$0 = r9     // Catch:{ all -> 0x0080 }
            r0.L$1 = r8     // Catch:{ all -> 0x0080 }
            r0.L$2 = r10     // Catch:{ all -> 0x0080 }
            r0.label = r4     // Catch:{ all -> 0x0080 }
            java.lang.Object r2 = r8.readAndInitOrPropagateAndThrowFailure(r0)     // Catch:{ all -> 0x0080 }
            if (r2 != r1) goto L_0x00a3
            goto L_0x00bb
        L_0x00a3:
            r2 = r8
        L_0x00a4:
            k3.p r4 = r9.getTransform()     // Catch:{ all -> 0x0080 }
            b3.i r9 = r9.getCallerContext()     // Catch:{ all -> 0x0080 }
            r0.L$0 = r10     // Catch:{ all -> 0x0080 }
            r5 = 0
            r0.L$1 = r5     // Catch:{ all -> 0x0080 }
            r0.L$2 = r5     // Catch:{ all -> 0x0080 }
            r0.label = r3     // Catch:{ all -> 0x0080 }
            java.lang.Object r9 = r2.transformAndWrite(r4, r9, r0)     // Catch:{ all -> 0x0080 }
            if (r9 != r1) goto L_0x007c
        L_0x00bb:
            return r1
        L_0x00bc:
            java.lang.Object r10 = W2.t.b(r10)     // Catch:{ all -> 0x0034 }
            goto L_0x00e8
        L_0x00c1:
            java.lang.String r9 = "null cannot be cast to non-null type androidx.datastore.core.ReadException<T of androidx.datastore.core.DataStoreImpl.handleUpdate$lambda$2>"
            kotlin.jvm.internal.t.c(r2, r9)     // Catch:{ all -> 0x0080 }
            androidx.datastore.core.ReadException r2 = (androidx.datastore.core.ReadException) r2     // Catch:{ all -> 0x0080 }
            java.lang.Throwable r9 = r2.getReadException()     // Catch:{ all -> 0x0080 }
            throw r9     // Catch:{ all -> 0x0080 }
        L_0x00cd:
            boolean r9 = r2 instanceof androidx.datastore.core.Final     // Catch:{ all -> 0x0080 }
            if (r9 == 0) goto L_0x00d8
            androidx.datastore.core.Final r2 = (androidx.datastore.core.Final) r2     // Catch:{ all -> 0x0080 }
            java.lang.Throwable r9 = r2.getFinalException()     // Catch:{ all -> 0x0080 }
            throw r9     // Catch:{ all -> 0x0080 }
        L_0x00d8:
            W2.q r9 = new W2.q     // Catch:{ all -> 0x0080 }
            r9.<init>()     // Catch:{ all -> 0x0080 }
            throw r9     // Catch:{ all -> 0x0080 }
        L_0x00de:
            W2.t$a r0 = W2.t.f19966b
            java.lang.Object r10 = W2.u.a(r10)
            java.lang.Object r10 = W2.t.b(r10)
        L_0x00e8:
            w3.C2905x.c(r9, r10)
            W2.J r9 = W2.J.f19942a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.handleUpdate(androidx.datastore.core.Message$Update, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055 A[Catch:{ all -> 0x0067 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object incrementCollector(b3.C2308e r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof androidx.datastore.core.DataStoreImpl$incrementCollector$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            androidx.datastore.core.DataStoreImpl$incrementCollector$1 r0 = (androidx.datastore.core.DataStoreImpl$incrementCollector$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.DataStoreImpl$incrementCollector$1 r0 = new androidx.datastore.core.DataStoreImpl$incrementCollector$1
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r1 = r0.L$1
            F3.a r1 = (F3.a) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            W2.u.b(r12)
            goto L_0x004e
        L_0x0032:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x003a:
            W2.u.b(r12)
            F3.a r12 = r11.collectorMutex
            r0.L$0 = r11
            r0.L$1 = r12
            r0.label = r3
            java.lang.Object r0 = r12.lock(r4, r0)
            if (r0 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r0 = r11
            r1 = r12
        L_0x004e:
            int r12 = r0.collectorCounter     // Catch:{ all -> 0x0067 }
            int r12 = r12 + r3
            r0.collectorCounter = r12     // Catch:{ all -> 0x0067 }
            if (r12 != r3) goto L_0x006a
            w3.M r5 = r0.scope     // Catch:{ all -> 0x0067 }
            androidx.datastore.core.DataStoreImpl$incrementCollector$2$1 r8 = new androidx.datastore.core.DataStoreImpl$incrementCollector$2$1     // Catch:{ all -> 0x0067 }
            r8.<init>(r0, r4)     // Catch:{ all -> 0x0067 }
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            w3.y0 r12 = w3.C2876i.d(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0067 }
            r0.collectorJob = r12     // Catch:{ all -> 0x0067 }
            goto L_0x006a
        L_0x0067:
            r0 = move-exception
            r12 = r0
            goto L_0x0072
        L_0x006a:
            W2.J r12 = W2.J.f19942a     // Catch:{ all -> 0x0067 }
            r1.unlock(r4)
            W2.J r12 = W2.J.f19942a
            return r12
        L_0x0072:
            r1.unlock(r4)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.incrementCollector(b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0069, code lost:
        if (r4.runIfNeeded(r0) != r1) goto L_0x006c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readAndInitOrPropagateAndThrowFailure(b3.C2308e r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            int r1 = r0.I$0
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            W2.u.b(r6)     // Catch:{ all -> 0x0032 }
            goto L_0x006c
        L_0x0032:
            r6 = move-exception
            goto L_0x0073
        L_0x0034:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x003c:
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            W2.u.b(r6)
            goto L_0x0057
        L_0x0044:
            W2.u.b(r6)
            androidx.datastore.core.InterProcessCoordinator r6 = r5.getCoordinator()
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.getVersion(r0)
            if (r6 != r1) goto L_0x0056
            goto L_0x006b
        L_0x0056:
            r2 = r5
        L_0x0057:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            androidx.datastore.core.DataStoreImpl<T>$InitDataStore r4 = r2.readAndInit     // Catch:{ all -> 0x006f }
            r0.L$0 = r2     // Catch:{ all -> 0x006f }
            r0.I$0 = r6     // Catch:{ all -> 0x006f }
            r0.label = r3     // Catch:{ all -> 0x006f }
            java.lang.Object r6 = r4.runIfNeeded(r0)     // Catch:{ all -> 0x006f }
            if (r6 != r1) goto L_0x006c
        L_0x006b:
            return r1
        L_0x006c:
            W2.J r6 = W2.J.f19942a
            return r6
        L_0x006f:
            r0 = move-exception
            r1 = r6
            r6 = r0
            r0 = r2
        L_0x0073:
            androidx.datastore.core.DataStoreInMemoryCache<T> r0 = r0.inMemoryCache
            androidx.datastore.core.ReadException r2 = new androidx.datastore.core.ReadException
            r2.<init>(r6, r1)
            r0.tryUpdate(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readAndInitOrPropagateAndThrowFailure(b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a7, code lost:
        if (r11 == r1) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c0, code lost:
        if (r11 == r1) goto L_0x00c2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readDataAndUpdateCache(boolean r10, b3.C2308e r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1 r0 = (androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1 r0 = new androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0058
            if (r2 == r5) goto L_0x0045
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r10 = r0.L$0
            androidx.datastore.core.DataStoreImpl r10 = (androidx.datastore.core.DataStoreImpl) r10
            W2.u.b(r11)
            goto L_0x00c3
        L_0x0034:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003c:
            java.lang.Object r10 = r0.L$0
            androidx.datastore.core.DataStoreImpl r10 = (androidx.datastore.core.DataStoreImpl) r10
            W2.u.b(r11)
            goto L_0x00aa
        L_0x0045:
            boolean r10 = r0.Z$0
            java.lang.Object r2 = r0.L$1
            androidx.datastore.core.State r2 = (androidx.datastore.core.State) r2
            java.lang.Object r5 = r0.L$0
            androidx.datastore.core.DataStoreImpl r5 = (androidx.datastore.core.DataStoreImpl) r5
            W2.u.b(r11)
            r8 = r11
            r11 = r10
            r10 = r5
            r5 = r2
            r2 = r8
            goto L_0x007c
        L_0x0058:
            W2.u.b(r11)
            androidx.datastore.core.DataStoreInMemoryCache<T> r11 = r9.inMemoryCache
            androidx.datastore.core.State r2 = r11.getCurrentState()
            boolean r11 = r2 instanceof androidx.datastore.core.UnInitialized
            if (r11 != 0) goto L_0x00dd
            androidx.datastore.core.InterProcessCoordinator r11 = r9.getCoordinator()
            r0.L$0 = r9
            r0.L$1 = r2
            r0.Z$0 = r10
            r0.label = r5
            java.lang.Object r11 = r11.getVersion(r0)
            if (r11 != r1) goto L_0x0078
            goto L_0x00c2
        L_0x0078:
            r5 = r2
            r2 = r11
            r11 = r10
            r10 = r9
        L_0x007c:
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            boolean r6 = r5 instanceof androidx.datastore.core.Data
            if (r6 == 0) goto L_0x008b
            int r7 = r5.getVersion()
            goto L_0x008c
        L_0x008b:
            r7 = -1
        L_0x008c:
            if (r6 == 0) goto L_0x0091
            if (r2 != r7) goto L_0x0091
            return r5
        L_0x0091:
            r2 = 0
            if (r11 == 0) goto L_0x00ad
            androidx.datastore.core.InterProcessCoordinator r11 = r10.getCoordinator()
            androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3 r3 = new androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3
            r3.<init>(r10, r2)
            r0.L$0 = r10
            r0.L$1 = r2
            r0.label = r4
            java.lang.Object r11 = r11.lock(r3, r0)
            if (r11 != r1) goto L_0x00aa
            goto L_0x00c2
        L_0x00aa:
            W2.s r11 = (W2.s) r11
            goto L_0x00c5
        L_0x00ad:
            androidx.datastore.core.InterProcessCoordinator r11 = r10.getCoordinator()
            androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4 r4 = new androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4
            r4.<init>(r10, r7, r2)
            r0.L$0 = r10
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r11 = r11.tryLock(r4, r0)
            if (r11 != r1) goto L_0x00c3
        L_0x00c2:
            return r1
        L_0x00c3:
            W2.s r11 = (W2.s) r11
        L_0x00c5:
            java.lang.Object r0 = r11.a()
            androidx.datastore.core.State r0 = (androidx.datastore.core.State) r0
            java.lang.Object r11 = r11.b()
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x00dc
            androidx.datastore.core.DataStoreInMemoryCache<T> r10 = r10.inMemoryCache
            r10.tryUpdate(r0)
        L_0x00dc:
            return r0
        L_0x00dd:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readDataAndUpdateCache(boolean, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object readDataFromFileOrDefault(C2308e eVar) {
        return StorageConnectionKt.readData(getStorageConnection$datastore_core_release(), eVar);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0085, code lost:
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a8, code lost:
        if (r11 == null) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r2 = r11.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00af, code lost:
        r11 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b1, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b2, code lost:
        r5 = r6.getCoordinator();
        r0.L$0 = r6;
        r0.L$1 = r11;
        r0.Z$0 = r10;
        r0.I$0 = r2;
        r0.label = 2;
        r5 = r5.getVersion(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c5, code lost:
        if (r5 != r1) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c9, code lost:
        r8 = r2;
        r2 = r10;
        r10 = r8;
        r8 = r5;
        r5 = r11;
        r11 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00da, code lost:
        return new androidx.datastore.core.Data(r5, r10, ((java.lang.Number) r11).intValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r11 = ((java.lang.Number) r11).intValue();
        r5 = r2.getCoordinator();
        r6 = new androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2(r2, r11, (b3.C2308e) null);
        r0.L$0 = r2;
        r0.Z$0 = r10;
        r0.label = 4;
        r11 = r5.tryLock(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010b, code lost:
        if (r11 != r1) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0110, code lost:
        return (androidx.datastore.core.Data) r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012c, code lost:
        r6 = r11;
        r11 = r5;
        r5 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012f, code lost:
        r5.f24690a = r11;
        r11 = new kotlin.jvm.internal.J();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r5 = new androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3(r2, r7, r11, (b3.C2308e) null);
        r0.L$0 = r6;
        r0.L$1 = r2;
        r0.L$2 = r11;
        r0.L$3 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x014a, code lost:
        if (r7.doWithWriteFileLock(r10, r5, r0) != r1) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x014d, code lost:
        r10 = r11;
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x014f, code lost:
        r0 = r1.f24690a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0153, code lost:
        if (r0 != null) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0155, code lost:
        r3 = r0.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x015e, code lost:
        return new androidx.datastore.core.Data(r0, r3, r10.f24688a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x015f, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0160, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0161, code lost:
        W2.C2216e.a(r0, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0164, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readDataOrHandleCorruption(boolean r10, b3.C2308e r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1 r0 = (androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1 r0 = new androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 0
            r4 = 0
            switch(r2) {
                case 0: goto L_0x0093;
                case 1: goto L_0x0088;
                case 2: goto L_0x0075;
                case 3: goto L_0x006a;
                case 4: goto L_0x005b;
                case 5: goto L_0x0041;
                case 6: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x002d:
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.J r10 = (kotlin.jvm.internal.J) r10
            java.lang.Object r1 = r0.L$1
            kotlin.jvm.internal.L r1 = (kotlin.jvm.internal.L) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.CorruptionException r0 = (androidx.datastore.core.CorruptionException) r0
            W2.u.b(r11)     // Catch:{ all -> 0x003e }
            goto L_0x014f
        L_0x003e:
            r10 = move-exception
            goto L_0x0161
        L_0x0041:
            boolean r10 = r0.Z$0
            java.lang.Object r2 = r0.L$3
            kotlin.jvm.internal.L r2 = (kotlin.jvm.internal.L) r2
            java.lang.Object r5 = r0.L$2
            kotlin.jvm.internal.L r5 = (kotlin.jvm.internal.L) r5
            java.lang.Object r6 = r0.L$1
            androidx.datastore.core.CorruptionException r6 = (androidx.datastore.core.CorruptionException) r6
            java.lang.Object r7 = r0.L$0
            androidx.datastore.core.DataStoreImpl r7 = (androidx.datastore.core.DataStoreImpl) r7
            W2.u.b(r11)
            r8 = r5
            r5 = r2
            r2 = r8
            goto L_0x012f
        L_0x005b:
            boolean r10 = r0.Z$0
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            W2.u.b(r11)     // Catch:{ CorruptionException -> 0x0066 }
            goto L_0x010e
        L_0x0066:
            r11 = move-exception
            r7 = r2
            goto L_0x0111
        L_0x006a:
            boolean r10 = r0.Z$0
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            W2.u.b(r11)     // Catch:{ CorruptionException -> 0x0066 }
            goto L_0x00f1
        L_0x0075:
            int r10 = r0.I$0
            boolean r2 = r0.Z$0
            java.lang.Object r5 = r0.L$1
            java.lang.Object r6 = r0.L$0
            androidx.datastore.core.DataStoreImpl r6 = (androidx.datastore.core.DataStoreImpl) r6
            W2.u.b(r11)     // Catch:{ CorruptionException -> 0x0083 }
            goto L_0x00cf
        L_0x0083:
            r11 = move-exception
            r10 = r2
        L_0x0085:
            r7 = r6
            goto L_0x0111
        L_0x0088:
            boolean r10 = r0.Z$0
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            W2.u.b(r11)     // Catch:{ CorruptionException -> 0x0066 }
            r6 = r2
            goto L_0x00a8
        L_0x0093:
            W2.u.b(r11)
            if (r10 == 0) goto L_0x00de
            r0.L$0 = r9     // Catch:{ CorruptionException -> 0x00db }
            r0.Z$0 = r10     // Catch:{ CorruptionException -> 0x00db }
            r11 = 1
            r0.label = r11     // Catch:{ CorruptionException -> 0x00db }
            java.lang.Object r11 = r9.readDataFromFileOrDefault(r0)     // Catch:{ CorruptionException -> 0x00db }
            if (r11 != r1) goto L_0x00a7
            goto L_0x014c
        L_0x00a7:
            r6 = r9
        L_0x00a8:
            if (r11 == 0) goto L_0x00b1
            int r2 = r11.hashCode()     // Catch:{ CorruptionException -> 0x00af }
            goto L_0x00b2
        L_0x00af:
            r11 = move-exception
            goto L_0x0085
        L_0x00b1:
            r2 = r3
        L_0x00b2:
            androidx.datastore.core.InterProcessCoordinator r5 = r6.getCoordinator()     // Catch:{ CorruptionException -> 0x00af }
            r0.L$0 = r6     // Catch:{ CorruptionException -> 0x00af }
            r0.L$1 = r11     // Catch:{ CorruptionException -> 0x00af }
            r0.Z$0 = r10     // Catch:{ CorruptionException -> 0x00af }
            r0.I$0 = r2     // Catch:{ CorruptionException -> 0x00af }
            r7 = 2
            r0.label = r7     // Catch:{ CorruptionException -> 0x00af }
            java.lang.Object r5 = r5.getVersion(r0)     // Catch:{ CorruptionException -> 0x00af }
            if (r5 != r1) goto L_0x00c9
            goto L_0x014c
        L_0x00c9:
            r8 = r2
            r2 = r10
            r10 = r8
            r8 = r5
            r5 = r11
            r11 = r8
        L_0x00cf:
            java.lang.Number r11 = (java.lang.Number) r11     // Catch:{ CorruptionException -> 0x0083 }
            int r11 = r11.intValue()     // Catch:{ CorruptionException -> 0x0083 }
            androidx.datastore.core.Data r7 = new androidx.datastore.core.Data     // Catch:{ CorruptionException -> 0x0083 }
            r7.<init>(r5, r10, r11)     // Catch:{ CorruptionException -> 0x0083 }
            return r7
        L_0x00db:
            r11 = move-exception
            r7 = r9
            goto L_0x0111
        L_0x00de:
            androidx.datastore.core.InterProcessCoordinator r11 = r9.getCoordinator()     // Catch:{ CorruptionException -> 0x00db }
            r0.L$0 = r9     // Catch:{ CorruptionException -> 0x00db }
            r0.Z$0 = r10     // Catch:{ CorruptionException -> 0x00db }
            r2 = 3
            r0.label = r2     // Catch:{ CorruptionException -> 0x00db }
            java.lang.Object r11 = r11.getVersion(r0)     // Catch:{ CorruptionException -> 0x00db }
            if (r11 != r1) goto L_0x00f0
            goto L_0x014c
        L_0x00f0:
            r2 = r9
        L_0x00f1:
            java.lang.Number r11 = (java.lang.Number) r11     // Catch:{ CorruptionException -> 0x0066 }
            int r11 = r11.intValue()     // Catch:{ CorruptionException -> 0x0066 }
            androidx.datastore.core.InterProcessCoordinator r5 = r2.getCoordinator()     // Catch:{ CorruptionException -> 0x0066 }
            androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2 r6 = new androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2     // Catch:{ CorruptionException -> 0x0066 }
            r6.<init>(r2, r11, r4)     // Catch:{ CorruptionException -> 0x0066 }
            r0.L$0 = r2     // Catch:{ CorruptionException -> 0x0066 }
            r0.Z$0 = r10     // Catch:{ CorruptionException -> 0x0066 }
            r11 = 4
            r0.label = r11     // Catch:{ CorruptionException -> 0x0066 }
            java.lang.Object r11 = r5.tryLock(r6, r0)     // Catch:{ CorruptionException -> 0x0066 }
            if (r11 != r1) goto L_0x010e
            goto L_0x014c
        L_0x010e:
            androidx.datastore.core.Data r11 = (androidx.datastore.core.Data) r11     // Catch:{ CorruptionException -> 0x0066 }
            return r11
        L_0x0111:
            kotlin.jvm.internal.L r2 = new kotlin.jvm.internal.L
            r2.<init>()
            androidx.datastore.core.CorruptionHandler<T> r5 = r7.corruptionHandler
            r0.L$0 = r7
            r0.L$1 = r11
            r0.L$2 = r2
            r0.L$3 = r2
            r0.Z$0 = r10
            r6 = 5
            r0.label = r6
            java.lang.Object r5 = r5.handleCorruption(r11, r0)
            if (r5 != r1) goto L_0x012c
            goto L_0x014c
        L_0x012c:
            r6 = r11
            r11 = r5
            r5 = r2
        L_0x012f:
            r5.f24690a = r11
            kotlin.jvm.internal.J r11 = new kotlin.jvm.internal.J
            r11.<init>()
            androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3 r5 = new androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3     // Catch:{ all -> 0x015f }
            r5.<init>(r2, r7, r11, r4)     // Catch:{ all -> 0x015f }
            r0.L$0 = r6     // Catch:{ all -> 0x015f }
            r0.L$1 = r2     // Catch:{ all -> 0x015f }
            r0.L$2 = r11     // Catch:{ all -> 0x015f }
            r0.L$3 = r4     // Catch:{ all -> 0x015f }
            r4 = 6
            r0.label = r4     // Catch:{ all -> 0x015f }
            java.lang.Object r10 = r7.doWithWriteFileLock(r10, r5, r0)     // Catch:{ all -> 0x015f }
            if (r10 != r1) goto L_0x014d
        L_0x014c:
            return r1
        L_0x014d:
            r10 = r11
            r1 = r2
        L_0x014f:
            androidx.datastore.core.Data r11 = new androidx.datastore.core.Data
            java.lang.Object r0 = r1.f24690a
            if (r0 == 0) goto L_0x0159
            int r3 = r0.hashCode()
        L_0x0159:
            int r10 = r10.f24688a
            r11.<init>(r0, r3, r10)
            return r11
        L_0x015f:
            r10 = move-exception
            r0 = r6
        L_0x0161:
            W2.C2216e.a(r0, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readDataOrHandleCorruption(boolean, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object readState(boolean z4, C2308e eVar) {
        return C2872g.g(this.scope.getCoroutineContext(), new DataStoreImpl$readState$2(this, z4, (C2308e) null), eVar);
    }

    /* access modifiers changed from: private */
    public final Object transformAndWrite(p pVar, C2312i iVar, C2308e eVar) {
        return getCoordinator().lock(new DataStoreImpl$transformAndWrite$2(this, iVar, pVar, (C2308e) null), eVar);
    }

    public C2972e getData() {
        return this.data;
    }

    public final StorageConnection<T> getStorageConnection$datastore_core_release() {
        return (StorageConnection) this.storageConnectionDelegate.getValue();
    }

    public Object updateData(p pVar, C2308e eVar) {
        UpdatingDataContextElement updatingDataContextElement = (UpdatingDataContextElement) eVar.getContext().get(UpdatingDataContextElement.Companion.Key.INSTANCE);
        if (updatingDataContextElement != null) {
            updatingDataContextElement.checkNotUpdating(this);
        }
        return C2872g.g(new UpdatingDataContextElement(updatingDataContextElement, this), new DataStoreImpl$updateData$2(this, pVar, (C2308e) null), eVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeData$datastore_core_release(T r11, boolean r12, b3.C2308e r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof androidx.datastore.core.DataStoreImpl$writeData$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            androidx.datastore.core.DataStoreImpl$writeData$1 r0 = (androidx.datastore.core.DataStoreImpl$writeData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.DataStoreImpl$writeData$1 r0 = new androidx.datastore.core.DataStoreImpl$writeData$1
            r0.<init>(r10, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r11 = r0.L$0
            kotlin.jvm.internal.J r11 = (kotlin.jvm.internal.J) r11
            W2.u.b(r13)
            goto L_0x0056
        L_0x002d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0035:
            W2.u.b(r13)
            kotlin.jvm.internal.J r5 = new kotlin.jvm.internal.J
            r5.<init>()
            androidx.datastore.core.StorageConnection r13 = r10.getStorageConnection$datastore_core_release()
            androidx.datastore.core.DataStoreImpl$writeData$2 r4 = new androidx.datastore.core.DataStoreImpl$writeData$2
            r9 = 0
            r6 = r10
            r7 = r11
            r8 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r11 = r13.writeScope(r4, r0)
            if (r11 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r11 = r5
        L_0x0056:
            int r11 = r11.f24688a
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.b.b(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.writeData$datastore_core_release(java.lang.Object, boolean, b3.e):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataStoreImpl(Storage storage2, List list, CorruptionHandler corruptionHandler2, M m5, int i5, C2633k kVar) {
        this(storage2, (i5 & 2) != 0 ? C2250q.g() : list, (i5 & 4) != 0 ? new NoOpCorruptionHandler() : corruptionHandler2, (i5 & 8) != 0 ? N.a(Actual_jvmKt.ioDispatcher().plus(T0.b((C2908y0) null, 1, (Object) null))) : m5);
    }
}
