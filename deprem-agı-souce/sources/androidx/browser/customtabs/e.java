package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f223a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f224b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bundle f225c;

    public /* synthetic */ e(EngagementSignalsCallback engagementSignalsCallback, boolean z4, Bundle bundle) {
        this.f223a = engagementSignalsCallback;
        this.f224b = z4;
        this.f225c = bundle;
    }

    public final void run() {
        this.f223a.onVerticalScrollEvent(this.f224b, this.f225c);
    }
}
