package K1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import k3.C2616a;
import kotlin.jvm.internal.t;

final class a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final C2616a f2743a;

    /* renamed from: b  reason: collision with root package name */
    private final C2616a f2744b;

    public a(C2616a aVar, C2616a aVar2) {
        t.e(aVar, "onNetworkAvailable");
        t.e(aVar2, "onNetworkUnavailable");
        this.f2743a = aVar;
        this.f2744b = aVar2;
    }

    public void onReceive(Context context, Intent intent) {
        t.e(context, "context");
        t.e(intent, "intent");
        if (g.b(context)) {
            this.f2743a.invoke();
        } else {
            this.f2744b.invoke();
        }
    }
}
