package androidx.window.layout;

import W2.J;
import android.app.Activity;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import y3.C2934g;
import z3.C2973f;

@f(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", l = {54, 55}, m = "invokeSuspend")
final class WindowInfoTrackerImpl$windowLayoutInfo$1 extends l implements p {
    final /* synthetic */ Activity $activity;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ WindowInfoTrackerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WindowInfoTrackerImpl$windowLayoutInfo$1(WindowInfoTrackerImpl windowInfoTrackerImpl, Activity activity, C2308e eVar) {
        super(2, eVar);
        this.this$0 = windowInfoTrackerImpl;
        this.$activity = activity;
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m205invokeSuspend$lambda0(C2934g gVar, WindowLayoutInfo windowLayoutInfo) {
        t.d(windowLayoutInfo, "info");
        gVar.r(windowLayoutInfo);
    }

    public final C2308e create(Object obj, C2308e eVar) {
        WindowInfoTrackerImpl$windowLayoutInfo$1 windowInfoTrackerImpl$windowLayoutInfo$1 = new WindowInfoTrackerImpl$windowLayoutInfo$1(this.this$0, this.$activity, eVar);
        windowInfoTrackerImpl$windowLayoutInfo$1.L$0 = obj;
        return windowInfoTrackerImpl$windowLayoutInfo$1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0090, code lost:
        if (r5.emit((androidx.window.layout.WindowLayoutInfo) r1.next(), r9) == r0) goto L_0x0092;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0073 A[Catch:{ all -> 0x001f }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007e A[Catch:{ all -> 0x001f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003a
            if (r1 == r3) goto L_0x002a
            if (r1 != r2) goto L_0x0022
            java.lang.Object r1 = r9.L$2
            y3.i r1 = (y3.C2936i) r1
            java.lang.Object r4 = r9.L$1
            androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
            java.lang.Object r5 = r9.L$0
            z3.f r5 = (z3.C2973f) r5
            W2.u.b(r10)     // Catch:{ all -> 0x001f }
        L_0x001d:
            r10 = r5
            goto L_0x0064
        L_0x001f:
            r10 = move-exception
            goto L_0x009f
        L_0x0022:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x002a:
            java.lang.Object r1 = r9.L$2
            y3.i r1 = (y3.C2936i) r1
            java.lang.Object r4 = r9.L$1
            androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
            java.lang.Object r5 = r9.L$0
            z3.f r5 = (z3.C2973f) r5
            W2.u.b(r10)     // Catch:{ all -> 0x001f }
            goto L_0x0076
        L_0x003a:
            W2.u.b(r10)
            java.lang.Object r10 = r9.L$0
            z3.f r10 = (z3.C2973f) r10
            y3.a r1 = y3.C2928a.DROP_OLDEST
            r4 = 4
            r5 = 10
            r6 = 0
            y3.g r1 = y3.C2937j.b(r5, r1, r6, r4, r6)
            androidx.window.layout.k r4 = new androidx.window.layout.k
            r4.<init>(r1)
            androidx.window.layout.WindowInfoTrackerImpl r5 = r9.this$0
            androidx.window.layout.WindowBackend r5 = r5.windowBackend
            android.app.Activity r6 = r9.$activity
            androidx.privacysandbox.ads.adservices.adid.i r7 = new androidx.privacysandbox.ads.adservices.adid.i
            r7.<init>()
            r5.registerLayoutChangeCallback(r6, r7, r4)
            y3.i r1 = r1.iterator()     // Catch:{ all -> 0x001f }
        L_0x0064:
            r9.L$0 = r10     // Catch:{ all -> 0x001f }
            r9.L$1 = r4     // Catch:{ all -> 0x001f }
            r9.L$2 = r1     // Catch:{ all -> 0x001f }
            r9.label = r3     // Catch:{ all -> 0x001f }
            java.lang.Object r5 = r1.b(r9)     // Catch:{ all -> 0x001f }
            if (r5 != r0) goto L_0x0073
            goto L_0x0092
        L_0x0073:
            r8 = r5
            r5 = r10
            r10 = r8
        L_0x0076:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x001f }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x001f }
            if (r10 == 0) goto L_0x0093
            java.lang.Object r10 = r1.next()     // Catch:{ all -> 0x001f }
            androidx.window.layout.WindowLayoutInfo r10 = (androidx.window.layout.WindowLayoutInfo) r10     // Catch:{ all -> 0x001f }
            r9.L$0 = r5     // Catch:{ all -> 0x001f }
            r9.L$1 = r4     // Catch:{ all -> 0x001f }
            r9.L$2 = r1     // Catch:{ all -> 0x001f }
            r9.label = r2     // Catch:{ all -> 0x001f }
            java.lang.Object r10 = r5.emit(r10, r9)     // Catch:{ all -> 0x001f }
            if (r10 != r0) goto L_0x001d
        L_0x0092:
            return r0
        L_0x0093:
            androidx.window.layout.WindowInfoTrackerImpl r10 = r9.this$0
            androidx.window.layout.WindowBackend r10 = r10.windowBackend
            r10.unregisterLayoutChangeCallback(r4)
            W2.J r10 = W2.J.f19942a
            return r10
        L_0x009f:
            androidx.window.layout.WindowInfoTrackerImpl r0 = r9.this$0
            androidx.window.layout.WindowBackend r0 = r0.windowBackend
            r0.unregisterLayoutChangeCallback(r4)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(C2973f fVar, C2308e eVar) {
        return ((WindowInfoTrackerImpl$windowLayoutInfo$1) create(fVar, eVar)).invokeSuspend(J.f19942a);
    }
}
