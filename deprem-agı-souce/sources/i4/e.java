package i4;

import android.content.BroadcastReceiver;
import android.content.Context;
import org.matomo.sdk.extra.InstallReferrerReceiver;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f24516a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f24517b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BroadcastReceiver.PendingResult f24518c;

    public /* synthetic */ e(Context context, String str, BroadcastReceiver.PendingResult pendingResult) {
        this.f24516a = context;
        this.f24517b = str;
        this.f24518c = pendingResult;
    }

    public final void run() {
        InstallReferrerReceiver.a(this.f24516a, this.f24517b, this.f24518c);
    }
}
