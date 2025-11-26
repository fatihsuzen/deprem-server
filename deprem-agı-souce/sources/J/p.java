package J;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0646b f2643a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f2644b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f2645c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f2646d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BroadcastReceiver.PendingResult f2647e;

    public /* synthetic */ p(C0646b bVar, Intent intent, Context context, boolean z4, BroadcastReceiver.PendingResult pendingResult) {
        this.f2643a = bVar;
        this.f2644b = intent;
        this.f2645c = context;
        this.f2646d = z4;
        this.f2647e = pendingResult;
    }

    public final void run() {
        this.f2643a.d(this.f2644b, this.f2645c, this.f2646d, this.f2647e);
    }
}
