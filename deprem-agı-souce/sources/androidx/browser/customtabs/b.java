package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f214a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f215b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bundle f216c;

    public /* synthetic */ b(EngagementSignalsCallback engagementSignalsCallback, boolean z4, Bundle bundle) {
        this.f214a = engagementSignalsCallback;
        this.f215b = z4;
        this.f216c = bundle;
    }

    public final void run() {
        this.f214a.onSessionEnded(this.f215b, this.f216c);
    }
}
