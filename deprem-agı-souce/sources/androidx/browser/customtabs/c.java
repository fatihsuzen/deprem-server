package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f217a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f218b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bundle f219c;

    public /* synthetic */ c(EngagementSignalsCallback engagementSignalsCallback, int i5, Bundle bundle) {
        this.f217a = engagementSignalsCallback;
        this.f218b = i5;
        this.f219c = bundle;
    }

    public final void run() {
        this.f217a.onGreatestScrollPercentageIncreased(this.f218b, this.f219c);
    }
}
