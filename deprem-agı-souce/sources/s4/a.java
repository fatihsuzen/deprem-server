package s4;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import b.l;
import b.m;
import b.x;
import b3.C2308e;
import b3.C2312i;
import com.inmobi.cmp.ChoiceCmp;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.t;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;
import w3.T0;

public final class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference f25848a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f25849b;

    public a(m mVar) {
        this.f25849b = mVar;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        t.e(activity, "activity");
    }

    public final void onActivityDestroyed(Activity activity) {
        t.e(activity, "activity");
    }

    public final void onActivityPaused(Activity activity) {
        t.e(activity, "activity");
    }

    public final void onActivityResumed(Activity activity) {
        t.e(activity, "activity");
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        t.e(activity, "activity");
        t.e(bundle, "outState");
    }

    public final void onActivityStarted(Activity activity) {
        t.e(activity, "activity");
        WeakReference weakReference = this.f25848a;
        if (weakReference == null || !t.a((Activity) weakReference.get(), activity)) {
            if (!b.f25850a) {
                this.f25849b.getClass();
                x access$getViewModel$p = ChoiceCmp.f7838g;
                if (access$getViewModel$p == null) {
                    t.w("viewModel");
                    access$getViewModel$p = null;
                }
                if (!access$getViewModel$p.f851m) {
                    ChoiceCmp.access$startLoadCmpInfo(ChoiceCmp.INSTANCE);
                } else if (!ChoiceCmp.f7841j) {
                    M access$getActiveScope$p = ChoiceCmp.f7839h;
                    if (access$getActiveScope$p == null) {
                        access$getActiveScope$p = N.a(T0.b((C2908y0) null, 1, (Object) null));
                    }
                    ChoiceCmp.f7839h = access$getActiveScope$p;
                    M access$getActiveScope$p2 = ChoiceCmp.f7839h;
                    if (access$getActiveScope$p2 != null) {
                        C2908y0 unused = C2876i.d(access$getActiveScope$p2, (C2312i) null, (O) null, new l((C2308e) null), 3, (Object) null);
                    }
                }
                b.f25850a = true;
            }
            this.f25848a = new WeakReference(activity);
        }
    }

    public final void onActivityStopped(Activity activity) {
        Activity activity2;
        t.e(activity, "activity");
        WeakReference weakReference = this.f25848a;
        if (weakReference == null) {
            activity2 = null;
        } else {
            activity2 = (Activity) weakReference.get();
        }
        if (t.a(activity2, activity)) {
            if (b.f25850a) {
                this.f25849b.getClass();
                M access$getActiveScope$p = ChoiceCmp.f7839h;
                if (access$getActiveScope$p != null) {
                    N.c(access$getActiveScope$p, (CancellationException) null, 1, (Object) null);
                }
                ChoiceCmp.f7839h = null;
                b.f25850a = false;
            }
            this.f25848a = null;
        }
    }
}
