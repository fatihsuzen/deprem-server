package androidx.slidingpanelayout.widget;

import android.app.Activity;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import b3.C2308e;
import b3.C2312i;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.t;
import w3.C2894r0;
import w3.C2908y0;
import w3.N;
import w3.O;

public final class FoldingFeatureObserver {
    private final Executor executor;
    private C2908y0 job;
    /* access modifiers changed from: private */
    public OnFoldingFeatureChangeListener onFoldingFeatureChangeListener;
    /* access modifiers changed from: private */
    public final WindowInfoTracker windowInfoTracker;

    public interface OnFoldingFeatureChangeListener {
        void onFoldingFeatureChange(FoldingFeature foldingFeature);
    }

    public FoldingFeatureObserver(WindowInfoTracker windowInfoTracker2, Executor executor2) {
        t.e(windowInfoTracker2, "windowInfoTracker");
        t.e(executor2, "executor");
        this.windowInfoTracker = windowInfoTracker2;
        this.executor = executor2;
    }

    /* access modifiers changed from: private */
    public final FoldingFeature getFoldingFeature(WindowLayoutInfo windowLayoutInfo) {
        Object obj;
        Iterator it = windowLayoutInfo.getDisplayFeatures().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((DisplayFeature) obj) instanceof FoldingFeature) {
                break;
            }
        }
        if (obj instanceof FoldingFeature) {
            return (FoldingFeature) obj;
        }
        return null;
    }

    public final void registerLayoutStateChangeCallback(Activity activity) {
        t.e(activity, "activity");
        C2908y0 y0Var = this.job;
        if (y0Var != null) {
            C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
        }
        this.job = C2876i.d(N.a(C2894r0.b(this.executor)), (C2312i) null, (O) null, new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(this, activity, (C2308e) null), 3, (Object) null);
    }

    public final void setOnFoldingFeatureChangeListener(OnFoldingFeatureChangeListener onFoldingFeatureChangeListener2) {
        t.e(onFoldingFeatureChangeListener2, "onFoldingFeatureChangeListener");
        this.onFoldingFeatureChangeListener = onFoldingFeatureChangeListener2;
    }

    public final void unregisterLayoutStateChangeCallback() {
        C2908y0 y0Var = this.job;
        if (y0Var != null) {
            C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
        }
    }
}
