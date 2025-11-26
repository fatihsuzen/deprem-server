package androidx.core.app;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.PendingIntentCompat;

public final /* synthetic */ class p implements PendingIntent.OnFinished {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PendingIntentCompat.GatedCallback f244a;

    public /* synthetic */ p(PendingIntentCompat.GatedCallback gatedCallback) {
        this.f244a = gatedCallback;
    }

    public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i5, String str, Bundle bundle) {
        this.f244a.onSendFinished(pendingIntent, intent, i5, str, bundle);
    }
}
