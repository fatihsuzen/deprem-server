package androidx.window.layout;

import android.app.Activity;
import b3.C2308e;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import z3.C2972e;
import z3.C2974g;

public final class WindowInfoTrackerImpl implements WindowInfoTracker {
    private static final int BUFFER_CAPACITY = 10;
    public static final Companion Companion = new Companion((C2633k) null);
    /* access modifiers changed from: private */
    public final WindowBackend windowBackend;
    private final WindowMetricsCalculator windowMetricsCalculator;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    public WindowInfoTrackerImpl(WindowMetricsCalculator windowMetricsCalculator2, WindowBackend windowBackend2) {
        t.e(windowMetricsCalculator2, "windowMetricsCalculator");
        t.e(windowBackend2, "windowBackend");
        this.windowMetricsCalculator = windowMetricsCalculator2;
        this.windowBackend = windowBackend2;
    }

    public C2972e windowLayoutInfo(Activity activity) {
        t.e(activity, "activity");
        return C2974g.q(new WindowInfoTrackerImpl$windowLayoutInfo$1(this, activity, (C2308e) null));
    }
}
