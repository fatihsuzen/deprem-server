package androidx.datastore.core;

import F3.a;
import F3.g;
import W2.C2223l;
import W2.m;
import b3.C2308e;
import b3.C2312i;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.File;
import java.io.IOException;
import k3.p;
import kotlin.coroutines.jvm.internal.b;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import w3.C2872g;
import z3.C2972e;

public final class MultiProcessCoordinator implements InterProcessCoordinator {
    public static final Companion Companion = new Companion((C2633k) null);
    /* access modifiers changed from: private */
    public static final String DEADLOCK_ERROR_MESSAGE = "Resource deadlock would occur";
    /* access modifiers changed from: private */
    public static final long INITIAL_WAIT_MILLIS = 10;
    /* access modifiers changed from: private */
    public static final long MAX_WAIT_MILLIS = ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
    private final String LOCK_ERROR_MESSAGE = "fcntl failed: EAGAIN";
    /* access modifiers changed from: private */
    public final String LOCK_SUFFIX = ".lock";
    /* access modifiers changed from: private */
    public final String VERSION_SUFFIX = ".version";
    private final C2312i context;
    private final File file;
    private final a inMemoryMutex = g.b(false, 1, (Object) null);
    private final C2223l lazySharedCounter = m.b(new MultiProcessCoordinator$lazySharedCounter$1(this));
    private final C2223l lockFile$delegate = m.b(new MultiProcessCoordinator$lockFile$2(this));
    private final C2972e updateNotifications;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x004b A[SYNTHETIC, Splitter:B:15:0x004b] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0083  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object getExclusiveFileLockWithRetryIfDeadlock(java.io.FileOutputStream r14, b3.C2308e r15) {
            /*
                r13 = this;
                boolean r0 = r15 instanceof androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1
                if (r0 == 0) goto L_0x0013
                r0 = r15
                androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 r0 = (androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 r0 = new androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1
                r0.<init>(r13, r15)
            L_0x0018:
                java.lang.Object r15 = r0.result
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x0039
                if (r2 != r4) goto L_0x0031
                long r5 = r0.J$0
                java.lang.Object r14 = r0.L$0
                java.io.FileOutputStream r14 = (java.io.FileOutputStream) r14
                W2.u.b(r15)
                r15 = r0
                goto L_0x007f
            L_0x0031:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r15)
                throw r14
            L_0x0039:
                W2.u.b(r15)
                long r5 = androidx.datastore.core.MultiProcessCoordinator.INITIAL_WAIT_MILLIS
                r15 = r0
            L_0x0041:
                long r7 = androidx.datastore.core.MultiProcessCoordinator.MAX_WAIT_MILLIS
                int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                java.lang.String r2 = "lockFileStream.getChanne…LUE, /* shared= */ false)"
                if (r0 > 0) goto L_0x0083
                java.nio.channels.FileChannel r7 = r14.getChannel()     // Catch:{ IOException -> 0x005f }
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r12 = 0
                r8 = 0
                java.nio.channels.FileLock r0 = r7.lock(r8, r10, r12)     // Catch:{ IOException -> 0x005f }
                kotlin.jvm.internal.t.d(r0, r2)     // Catch:{ IOException -> 0x005f }
                return r0
            L_0x005f:
                r0 = move-exception
                java.lang.String r2 = r0.getMessage()
                if (r2 == 0) goto L_0x0082
                java.lang.String r7 = androidx.datastore.core.MultiProcessCoordinator.DEADLOCK_ERROR_MESSAGE
                r8 = 0
                r9 = 0
                boolean r2 = t3.s.V(r2, r7, r8, r3, r9)
                if (r2 != r4) goto L_0x0082
                r15.L$0 = r14
                r15.J$0 = r5
                r15.label = r4
                java.lang.Object r0 = w3.X.b(r5, r15)
                if (r0 != r1) goto L_0x007f
                return r1
            L_0x007f:
                long r7 = (long) r3
                long r5 = r5 * r7
                goto L_0x0041
            L_0x0082:
                throw r0
            L_0x0083:
                java.nio.channels.FileChannel r7 = r14.getChannel()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r12 = 0
                r8 = 0
                java.nio.channels.FileLock r14 = r7.lock(r8, r10, r12)
                kotlin.jvm.internal.t.d(r14, r2)
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.Companion.getExclusiveFileLockWithRetryIfDeadlock(java.io.FileOutputStream, b3.e):java.lang.Object");
        }

        private Companion() {
        }
    }

    public MultiProcessCoordinator(C2312i iVar, File file2) {
        t.e(iVar, "context");
        t.e(file2, "file");
        this.context = iVar;
        this.file = file2;
        this.updateNotifications = MulticastFileObserver.Companion.observe(file2);
    }

    /* access modifiers changed from: private */
    public final void createIfNotExists(File file2) {
        createParentDirectories(file2);
        if (!file2.exists()) {
            file2.createNewFile();
        }
    }

    private final void createParentDirectories(File file2) {
        File parentFile = file2.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                throw new IOException("Unable to create parent directories of " + file2);
            }
        }
    }

    /* access modifiers changed from: private */
    public final File fileWithSuffix(String str) {
        return new File(this.file.getAbsolutePath() + str);
    }

    private final File getLockFile() {
        return (File) this.lockFile$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SharedCounter getSharedCounter() {
        return (SharedCounter) this.lazySharedCounter.getValue();
    }

    private static Object getSharedCounter$delegate(MultiProcessCoordinator multiProcessCoordinator) {
        return multiProcessCoordinator.lazySharedCounter;
    }

    private final <T> Object withLazyCounter(p pVar, C2308e eVar) {
        if (this.lazySharedCounter.isInitialized()) {
            return pVar.invoke(getSharedCounter(), eVar);
        }
        C2312i iVar = this.context;
        MultiProcessCoordinator$withLazyCounter$2 multiProcessCoordinator$withLazyCounter$2 = new MultiProcessCoordinator$withLazyCounter$2(pVar, this, (C2308e) null);
        r.c(0);
        Object g5 = C2872g.g(iVar, multiProcessCoordinator$withLazyCounter$2, eVar);
        r.c(1);
        return g5;
    }

    /* access modifiers changed from: protected */
    public final File getFile() {
        return this.file;
    }

    public C2972e getUpdateNotifications() {
        return this.updateNotifications;
    }

    public Object getVersion(C2308e eVar) {
        if (this.lazySharedCounter.isInitialized()) {
            return b.b(getSharedCounter().getValue());
        }
        return C2872g.g(this.context, new MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(this, (C2308e) null), eVar);
    }

    public Object incrementAndGetVersion(C2308e eVar) {
        if (this.lazySharedCounter.isInitialized()) {
            return b.b(getSharedCounter().incrementAndGetValue());
        }
        return C2872g.g(this.context, new MultiProcessCoordinator$incrementAndGetVersion$$inlined$withLazyCounter$1(this, (C2308e) null), eVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bb A[SYNTHETIC, Splitter:B:41:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d9 A[SYNTHETIC, Splitter:B:56:0x00d9] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.lang.Object lock(k3.l r9, b3.C2308e r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.MultiProcessCoordinator$lock$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.datastore.core.MultiProcessCoordinator$lock$1 r0 = (androidx.datastore.core.MultiProcessCoordinator$lock$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.MultiProcessCoordinator$lock$1 r0 = new androidx.datastore.core.MultiProcessCoordinator$lock$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0070
            if (r2 == r5) goto L_0x005e
            if (r2 == r4) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r9 = r0.L$2
            java.nio.channels.FileLock r9 = (java.nio.channels.FileLock) r9
            java.lang.Object r1 = r0.L$1
            java.io.Closeable r1 = (java.io.Closeable) r1
            java.lang.Object r0 = r0.L$0
            F3.a r0 = (F3.a) r0
            W2.u.b(r10)     // Catch:{ all -> 0x003d }
            goto L_0x00b9
        L_0x003d:
            r10 = move-exception
            goto L_0x00d7
        L_0x0040:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0048:
            java.lang.Object r9 = r0.L$2
            java.io.Closeable r9 = (java.io.Closeable) r9
            java.lang.Object r2 = r0.L$1
            F3.a r2 = (F3.a) r2
            java.lang.Object r4 = r0.L$0
            k3.l r4 = (k3.l) r4
            W2.u.b(r10)     // Catch:{ all -> 0x0058 }
            goto L_0x00a4
        L_0x0058:
            r10 = move-exception
            r1 = r9
            r0 = r2
        L_0x005b:
            r9 = r6
            goto L_0x00d7
        L_0x005e:
            java.lang.Object r9 = r0.L$2
            F3.a r9 = (F3.a) r9
            java.lang.Object r2 = r0.L$1
            k3.l r2 = (k3.l) r2
            java.lang.Object r5 = r0.L$0
            androidx.datastore.core.MultiProcessCoordinator r5 = (androidx.datastore.core.MultiProcessCoordinator) r5
            W2.u.b(r10)
            r10 = r9
            r9 = r2
            goto L_0x0085
        L_0x0070:
            W2.u.b(r10)
            F3.a r10 = r8.inMemoryMutex
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r5
            java.lang.Object r2 = r10.lock(r6, r0)
            if (r2 != r1) goto L_0x0084
            goto L_0x00b4
        L_0x0084:
            r5 = r8
        L_0x0085:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x00e3 }
            java.io.File r5 = r5.getLockFile()     // Catch:{ all -> 0x00e3 }
            r2.<init>(r5)     // Catch:{ all -> 0x00e3 }
            androidx.datastore.core.MultiProcessCoordinator$Companion r5 = Companion     // Catch:{ all -> 0x00d2 }
            r0.L$0 = r9     // Catch:{ all -> 0x00d2 }
            r0.L$1 = r10     // Catch:{ all -> 0x00d2 }
            r0.L$2 = r2     // Catch:{ all -> 0x00d2 }
            r0.label = r4     // Catch:{ all -> 0x00d2 }
            java.lang.Object r4 = r5.getExclusiveFileLockWithRetryIfDeadlock(r2, r0)     // Catch:{ all -> 0x00d2 }
            if (r4 != r1) goto L_0x009f
            goto L_0x00b4
        L_0x009f:
            r7 = r4
            r4 = r9
            r9 = r2
            r2 = r10
            r10 = r7
        L_0x00a4:
            java.nio.channels.FileLock r10 = (java.nio.channels.FileLock) r10     // Catch:{ all -> 0x0058 }
            r0.L$0 = r2     // Catch:{ all -> 0x00cc }
            r0.L$1 = r9     // Catch:{ all -> 0x00cc }
            r0.L$2 = r10     // Catch:{ all -> 0x00cc }
            r0.label = r3     // Catch:{ all -> 0x00cc }
            java.lang.Object r0 = r4.invoke(r0)     // Catch:{ all -> 0x00cc }
            if (r0 != r1) goto L_0x00b5
        L_0x00b4:
            return r1
        L_0x00b5:
            r1 = r9
            r9 = r10
            r10 = r0
            r0 = r2
        L_0x00b9:
            if (r9 == 0) goto L_0x00c2
            r9.release()     // Catch:{ all -> 0x00bf }
            goto L_0x00c2
        L_0x00bf:
            r9 = move-exception
            r10 = r0
            goto L_0x00dd
        L_0x00c2:
            h3.C2453b.a(r1, r6)     // Catch:{ all -> 0x00c9 }
            r0.unlock(r6)
            return r10
        L_0x00c9:
            r9 = move-exception
            r10 = r0
            goto L_0x00e4
        L_0x00cc:
            r0 = move-exception
            r1 = r9
            r9 = r10
            r10 = r0
            r0 = r2
            goto L_0x00d7
        L_0x00d2:
            r9 = move-exception
            r0 = r10
            r1 = r2
            r10 = r9
            goto L_0x005b
        L_0x00d7:
            if (r9 == 0) goto L_0x00dc
            r9.release()     // Catch:{ all -> 0x00bf }
        L_0x00dc:
            throw r10     // Catch:{ all -> 0x00bf }
        L_0x00dd:
            throw r9     // Catch:{ all -> 0x00de }
        L_0x00de:
            r0 = move-exception
            h3.C2453b.a(r1, r9)     // Catch:{ all -> 0x00e3 }
            throw r0     // Catch:{ all -> 0x00e3 }
        L_0x00e3:
            r9 = move-exception
        L_0x00e4:
            r10.unlock(r6)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.lock(k3.l, b3.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e6 A[SYNTHETIC, Splitter:B:58:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.lang.Object tryLock(k3.p r19, b3.C2308e r20) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r0 = r20
            boolean r3 = r0 instanceof androidx.datastore.core.MultiProcessCoordinator$tryLock$1
            if (r3 == 0) goto L_0x0019
            r3 = r0
            androidx.datastore.core.MultiProcessCoordinator$tryLock$1 r3 = (androidx.datastore.core.MultiProcessCoordinator$tryLock$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001e
        L_0x0019:
            androidx.datastore.core.MultiProcessCoordinator$tryLock$1 r3 = new androidx.datastore.core.MultiProcessCoordinator$tryLock$1
            r3.<init>(r1, r0)
        L_0x001e:
            java.lang.Object r0 = r3.result
            java.lang.Object r4 = c3.C2316b.f()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x005a
            if (r5 == r7) goto L_0x004d
            if (r5 != r6) goto L_0x0045
            boolean r2 = r3.Z$0
            java.lang.Object r4 = r3.L$2
            java.nio.channels.FileLock r4 = (java.nio.channels.FileLock) r4
            java.lang.Object r5 = r3.L$1
            java.io.Closeable r5 = (java.io.Closeable) r5
            java.lang.Object r3 = r3.L$0
            F3.a r3 = (F3.a) r3
            W2.u.b(r0)     // Catch:{ all -> 0x0042 }
            goto L_0x00e4
        L_0x0042:
            r0 = move-exception
            goto L_0x00ff
        L_0x0045:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004d:
            boolean r2 = r3.Z$0
            java.lang.Object r3 = r3.L$0
            F3.a r3 = (F3.a) r3
            W2.u.b(r0)     // Catch:{ all -> 0x0057 }
            goto L_0x007a
        L_0x0057:
            r0 = move-exception
            goto L_0x010e
        L_0x005a:
            W2.u.b(r0)
            F3.a r5 = r1.inMemoryMutex
            boolean r9 = r5.tryLock(r8)
            r10 = 0
            if (r9 != 0) goto L_0x0085
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.b.a(r10)     // Catch:{ all -> 0x0080 }
            r3.L$0 = r5     // Catch:{ all -> 0x0080 }
            r3.Z$0 = r9     // Catch:{ all -> 0x0080 }
            r3.label = r7     // Catch:{ all -> 0x0080 }
            java.lang.Object r0 = r2.invoke(r0, r3)     // Catch:{ all -> 0x0080 }
            if (r0 != r4) goto L_0x0078
            goto L_0x00df
        L_0x0078:
            r3 = r5
            r2 = r9
        L_0x007a:
            if (r2 == 0) goto L_0x007f
            r3.unlock(r8)
        L_0x007f:
            return r0
        L_0x0080:
            r0 = move-exception
            r3 = r5
            r2 = r9
            goto L_0x010e
        L_0x0085:
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ all -> 0x0080 }
            java.io.File r0 = r1.getLockFile()     // Catch:{ all -> 0x0080 }
            r11.<init>(r0)     // Catch:{ all -> 0x0080 }
            java.nio.channels.FileChannel r12 = r11.getChannel()     // Catch:{ IOException -> 0x00a8 }
            r15 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r17 = 1
            r13 = 0
            java.nio.channels.FileLock r0 = r12.tryLock(r13, r15, r17)     // Catch:{ IOException -> 0x00a8 }
            r12 = r0
            goto L_0x00c7
        L_0x00a1:
            r0 = move-exception
            r3 = r5
            r4 = r8
            r2 = r9
            r5 = r11
            goto L_0x00ff
        L_0x00a8:
            r0 = move-exception
            java.lang.String r12 = r0.getMessage()     // Catch:{ all -> 0x00a1 }
            if (r12 == 0) goto L_0x00b8
            java.lang.String r13 = r1.LOCK_ERROR_MESSAGE     // Catch:{ all -> 0x00a1 }
            boolean r12 = t3.s.P(r12, r13, r10, r6, r8)     // Catch:{ all -> 0x00a1 }
            if (r12 != r7) goto L_0x00b8
            goto L_0x00c6
        L_0x00b8:
            java.lang.String r12 = r0.getMessage()     // Catch:{ all -> 0x00a1 }
            if (r12 == 0) goto L_0x00fe
            java.lang.String r13 = DEADLOCK_ERROR_MESSAGE     // Catch:{ all -> 0x00a1 }
            boolean r12 = t3.s.P(r12, r13, r10, r6, r8)     // Catch:{ all -> 0x00a1 }
            if (r12 != r7) goto L_0x00fe
        L_0x00c6:
            r12 = r8
        L_0x00c7:
            if (r12 == 0) goto L_0x00ca
            goto L_0x00cb
        L_0x00ca:
            r7 = r10
        L_0x00cb:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.b.a(r7)     // Catch:{ all -> 0x00f8 }
            r3.L$0 = r5     // Catch:{ all -> 0x00f8 }
            r3.L$1 = r11     // Catch:{ all -> 0x00f8 }
            r3.L$2 = r12     // Catch:{ all -> 0x00f8 }
            r3.Z$0 = r9     // Catch:{ all -> 0x00f8 }
            r3.label = r6     // Catch:{ all -> 0x00f8 }
            java.lang.Object r0 = r2.invoke(r0, r3)     // Catch:{ all -> 0x00f8 }
            if (r0 != r4) goto L_0x00e0
        L_0x00df:
            return r4
        L_0x00e0:
            r3 = r5
            r2 = r9
            r5 = r11
            r4 = r12
        L_0x00e4:
            if (r4 == 0) goto L_0x00ef
            r4.release()     // Catch:{ all -> 0x00ea }
            goto L_0x00ef
        L_0x00ea:
            r0 = move-exception
            r4 = r3
            r3 = r2
            r2 = r0
            goto L_0x0105
        L_0x00ef:
            h3.C2453b.a(r5, r8)     // Catch:{ all -> 0x0057 }
            if (r2 == 0) goto L_0x00f7
            r3.unlock(r8)
        L_0x00f7:
            return r0
        L_0x00f8:
            r0 = move-exception
            r3 = r5
            r2 = r9
            r5 = r11
            r4 = r12
            goto L_0x00ff
        L_0x00fe:
            throw r0     // Catch:{ all -> 0x00a1 }
        L_0x00ff:
            if (r4 == 0) goto L_0x0104
            r4.release()     // Catch:{ all -> 0x00ea }
        L_0x0104:
            throw r0     // Catch:{ all -> 0x00ea }
        L_0x0105:
            throw r2     // Catch:{ all -> 0x0106 }
        L_0x0106:
            r0 = move-exception
            h3.C2453b.a(r5, r2)     // Catch:{ all -> 0x010b }
            throw r0     // Catch:{ all -> 0x010b }
        L_0x010b:
            r0 = move-exception
            r2 = r3
            r3 = r4
        L_0x010e:
            if (r2 == 0) goto L_0x0113
            r3.unlock(r8)
        L_0x0113:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.tryLock(k3.p, b3.e):java.lang.Object");
    }
}
