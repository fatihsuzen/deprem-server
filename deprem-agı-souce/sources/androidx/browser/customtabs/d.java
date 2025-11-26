package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f220a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f221b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bundle f222c;

    public /* synthetic */ d(EngagementSignalsCallback engagementSignalsCallback, boolean z4, Bundle bundle) {
        this.f220a = engagementSignalsCallback;
        this.f221b = z4;
        this.f222c = bundle;
    }

    public final void run() {
        this.f220a.onVerticalScrollEvent(this.f221b, this.f222c);
    }
}
