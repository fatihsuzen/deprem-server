package androidx.activity;

import W2.J;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import k3.C2616a;
import kotlin.jvm.internal.t;

public final class FullyDrawnReporter {
    private final Executor executor;
    private final Object lock = new Object();
    @GuardedBy("lock")
    private final List<C2616a> onReportCallbacks = new ArrayList();
    private final C2616a reportFullyDrawn;
    @GuardedBy("lock")
    private boolean reportPosted;
    private final Runnable reportRunnable = new j(this);
    @GuardedBy("lock")
    private boolean reportedFullyDrawn;
    @GuardedBy("lock")
    private int reporterCount;

    public FullyDrawnReporter(Executor executor2, C2616a aVar) {
        t.e(executor2, "executor");
        t.e(aVar, "reportFullyDrawn");
        this.executor = executor2;
        this.reportFullyDrawn = aVar;
    }

    private final void postWhenReportersAreDone() {
        if (!this.reportPosted && this.reporterCount == 0) {
            this.reportPosted = true;
            this.executor.execute(this.reportRunnable);
        }
    }

    /* access modifiers changed from: private */
    public static final void reportRunnable$lambda$2(FullyDrawnReporter fullyDrawnReporter) {
        t.e(fullyDrawnReporter, "this$0");
        synchronized (fullyDrawnReporter.lock) {
            try {
                fullyDrawnReporter.reportPosted = false;
                if (fullyDrawnReporter.reporterCount == 0 && !fullyDrawnReporter.reportedFullyDrawn) {
                    fullyDrawnReporter.reportFullyDrawn.invoke();
                    fullyDrawnReporter.fullyDrawnReported();
                }
                J j5 = J.f19942a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void addOnReportDrawnListener(C2616a aVar) {
        boolean z4;
        t.e(aVar, "callback");
        synchronized (this.lock) {
            if (this.reportedFullyDrawn) {
                z4 = true;
            } else {
                this.onReportCallbacks.add(aVar);
                z4 = false;
            }
        }
        if (z4) {
            aVar.invoke();
        }
    }

    public final void addReporter() {
        synchronized (this.lock) {
            try {
                if (!this.reportedFullyDrawn) {
                    this.reporterCount++;
                }
                J j5 = J.f19942a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void fullyDrawnReported() {
        synchronized (this.lock) {
            try {
                this.reportedFullyDrawn = true;
                for (C2616a invoke : this.onReportCallbacks) {
                    invoke.invoke();
                }
                this.onReportCallbacks.clear();
                J j5 = J.f19942a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isFullyDrawnReported() {
        boolean z4;
        synchronized (this.lock) {
            z4 = this.reportedFullyDrawn;
        }
        return z4;
    }

    public final void removeOnReportDrawnListener(C2616a aVar) {
        t.e(aVar, "callback");
        synchronized (this.lock) {
            this.onReportCallbacks.remove(aVar);
            J j5 = J.f19942a;
        }
    }

    public final void removeReporter() {
        int i5;
        synchronized (this.lock) {
            try {
                if (!this.reportedFullyDrawn && (i5 = this.reporterCount) > 0) {
                    this.reporterCount = i5 - 1;
                    postWhenReportersAreDone();
                }
                J j5 = J.f19942a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
