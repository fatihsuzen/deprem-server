package androidx.work.impl.constraints;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import b3.C2308e;
import b3.C2312i;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2908y0;
import w3.I;
import w3.N;
import w3.O;

public final class WorkConstraintsTrackerKt {
    private static final long DefaultNetworkRequestTimeoutMs = 1000;
    /* access modifiers changed from: private */
    public static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkConstraintsTracker");
        t.d(tagWithPrefix, "tagWithPrefix(...)");
        TAG = tagWithPrefix;
    }

    @RequiresApi(28)
    public static final NetworkRequestConstraintController NetworkRequestConstraintController(Context context) {
        t.e(context, "context");
        Object systemService = context.getSystemService("connectivity");
        t.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return new NetworkRequestConstraintController((ConnectivityManager) systemService, 0, 2, (C2633k) null);
    }

    public static final C2908y0 listen(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, I i5, OnConstraintsStateChangedListener onConstraintsStateChangedListener) {
        t.e(workConstraintsTracker, "<this>");
        t.e(workSpec, "spec");
        t.e(i5, "dispatcher");
        t.e(onConstraintsStateChangedListener, "listener");
        return C2876i.d(N.a(i5), (C2312i) null, (O) null, new WorkConstraintsTrackerKt$listen$1(workConstraintsTracker, workSpec, onConstraintsStateChangedListener, (C2308e) null), 3, (Object) null);
    }
}
