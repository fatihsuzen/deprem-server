package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f229a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f230b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bundle f231c;

    public /* synthetic */ g(EngagementSignalsCallback engagementSignalsCallback, boolean z4, Bundle bundle) {
        this.f229a = engagementSignalsCallback;
        this.f230b = z4;
        this.f231c = bundle;
    }

    public final void run() {
        this.f229a.onSessionEnded(this.f230b, this.f231c);
    }
}
