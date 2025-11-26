package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f226a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f227b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bundle f228c;

    public /* synthetic */ f(EngagementSignalsCallback engagementSignalsCallback, int i5, Bundle bundle) {
        this.f226a = engagementSignalsCallback;
        this.f227b = i5;
        this.f228c = bundle;
    }

    public final void run() {
        this.f226a.onGreatestScrollPercentageIncreased(this.f227b, this.f228c);
    }
}
