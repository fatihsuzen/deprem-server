package androidx.room.support;

import W2.J;
import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import b3.C2308e;
import b3.C2312i;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import k3.C2616a;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2908y0;
import w3.M;
import w3.O;

public final class AutoCloser {
    public static final String BUG_LINK = "https://issuetracker.google.com/issues/new?component=413107&template=1096568";
    public static final Companion Companion = new Companion((C2633k) null);
    private C2908y0 autoCloseJob;
    /* access modifiers changed from: private */
    public final long autoCloseTimeoutInMs;
    private M coroutineScope;
    @GuardedBy("lock")
    private SupportSQLiteDatabase delegateDatabase;
    private SupportSQLiteOpenHelper delegateOpenHelper;
    private AtomicLong lastDecrementRefCountTimeStamp;
    private final Object lock;
    private boolean manuallyClosed;
    private C2616a onAutoCloseCallback;
    private final AtomicInteger referenceCount;
    private final Watch watch;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    public interface Watch {
        long getMillis();
    }

    public AutoCloser(long j5, TimeUnit timeUnit, Watch watch2) {
        t.e(timeUnit, "timeUnit");
        t.e(watch2, "watch");
        this.watch = watch2;
        this.lock = new Object();
        this.autoCloseTimeoutInMs = timeUnit.toMillis(j5);
        this.referenceCount = new AtomicInteger(0);
        this.lastDecrementRefCountTimeStamp = new AtomicLong(watch2.getMillis());
    }

    /* access modifiers changed from: private */
    public static final long _init_$lambda$0() {
        return SystemClock.uptimeMillis();
    }

    /* access modifiers changed from: private */
    public final void autoCloseDatabase() {
        synchronized (this.lock) {
            try {
                if (this.watch.getMillis() - this.lastDecrementRefCountTimeStamp.get() >= this.autoCloseTimeoutInMs) {
                    if (this.referenceCount.get() == 0) {
                        C2616a aVar = this.onAutoCloseCallback;
                        if (aVar != null) {
                            aVar.invoke();
                            SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
                            if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                                supportSQLiteDatabase.close();
                            }
                            this.delegateDatabase = null;
                            J j5 = J.f19942a;
                            return;
                        }
                        throw new IllegalStateException("onAutoCloseCallback is null but it should  have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void closeDatabaseIfOpen() {
        synchronized (this.lock) {
            try {
                this.manuallyClosed = true;
                C2908y0 y0Var = this.autoCloseJob;
                if (y0Var != null) {
                    C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
                }
                this.autoCloseJob = null;
                SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
                if (supportSQLiteDatabase != null) {
                    supportSQLiteDatabase.close();
                }
                this.delegateDatabase = null;
                J j5 = J.f19942a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void decrementCountAndScheduleClose() {
        M m5;
        int decrementAndGet = this.referenceCount.decrementAndGet();
        if (decrementAndGet >= 0) {
            this.lastDecrementRefCountTimeStamp.set(this.watch.getMillis());
            if (decrementAndGet == 0) {
                M m6 = this.coroutineScope;
                if (m6 == null) {
                    t.w("coroutineScope");
                    m5 = null;
                } else {
                    m5 = m6;
                }
                this.autoCloseJob = C2876i.d(m5, (C2312i) null, (O) null, new AutoCloser$decrementCountAndScheduleClose$2(this, (C2308e) null), 3, (Object) null);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced reference count.");
    }

    public final <V> V executeRefCountingFunction(l lVar) {
        t.e(lVar, "block");
        try {
            return lVar.invoke(incrementCountAndEnsureDbIsOpen());
        } finally {
            decrementCountAndScheduleClose();
        }
    }

    public final C2616a getAutoCloseCallbackForTest$room_runtime_release() {
        return this.onAutoCloseCallback;
    }

    public final SupportSQLiteDatabase getDelegateDatabase$room_runtime_release() {
        return this.delegateDatabase;
    }

    public final int getRefCountForTest$room_runtime_release() {
        return this.referenceCount.get();
    }

    public final SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        C2908y0 y0Var = this.autoCloseJob;
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = null;
        if (y0Var != null) {
            C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
        }
        this.autoCloseJob = null;
        this.referenceCount.incrementAndGet();
        if (!this.manuallyClosed) {
            synchronized (this.lock) {
                SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
                if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                    return supportSQLiteDatabase;
                }
                SupportSQLiteOpenHelper supportSQLiteOpenHelper2 = this.delegateOpenHelper;
                if (supportSQLiteOpenHelper2 == null) {
                    t.w("delegateOpenHelper");
                } else {
                    supportSQLiteOpenHelper = supportSQLiteOpenHelper2;
                }
                SupportSQLiteDatabase writableDatabase = supportSQLiteOpenHelper.getWritableDatabase();
                this.delegateDatabase = writableDatabase;
                return writableDatabase;
            }
        }
        throw new IllegalStateException("Attempting to open already closed database.");
    }

    public final void initCoroutineScope(M m5) {
        t.e(m5, "coroutineScope");
        this.coroutineScope = m5;
    }

    public final void initOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        t.e(supportSQLiteOpenHelper, "delegateOpenHelper");
        if (!(supportSQLiteOpenHelper instanceof AutoClosingRoomOpenHelper)) {
            this.delegateOpenHelper = supportSQLiteOpenHelper;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public final boolean isActive() {
        return !this.manuallyClosed;
    }

    public final void setAutoCloseCallback(C2616a aVar) {
        t.e(aVar, "onAutoClose");
        this.onAutoCloseCallback = aVar;
    }

    public final void setDelegateDatabase$room_runtime_release(SupportSQLiteDatabase supportSQLiteDatabase) {
        this.delegateDatabase = supportSQLiteDatabase;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AutoCloser(long r1, java.util.concurrent.TimeUnit r3, androidx.room.support.AutoCloser.Watch r4, int r5, kotlin.jvm.internal.C2633k r6) {
        /*
            r0 = this;
            r5 = r5 & 4
            if (r5 == 0) goto L_0x0009
            androidx.room.support.a r4 = new androidx.room.support.a
            r4.<init>()
        L_0x0009:
            r0.<init>(r1, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.support.AutoCloser.<init>(long, java.util.concurrent.TimeUnit, androidx.room.support.AutoCloser$Watch, int, kotlin.jvm.internal.k):void");
    }
}
