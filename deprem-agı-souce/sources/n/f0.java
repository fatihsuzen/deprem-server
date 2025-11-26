package N;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

public final class f0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final int f3086a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0709c f3087b;

    public f0(C0709c cVar, int i5) {
        this.f3087b = cVar;
        this.f3086a = i5;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C0718l lVar;
        C0709c cVar = this.f3087b;
        if (iBinder == null) {
            C0709c.d0(cVar, 16);
            return;
        }
        synchronized (cVar.f3029n) {
            try {
                C0709c cVar2 = this.f3087b;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof C0718l)) {
                    lVar = new U(iBinder);
                } else {
                    lVar = (C0718l) queryLocalInterface;
                }
                cVar2.f3030o = lVar;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.f3087b.e0(0, (Bundle) null, this.f3086a);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f3087b.f3029n) {
            this.f3087b.f3030o = null;
        }
        C0709c cVar = this.f3087b;
        int i5 = this.f3086a;
        Handler handler = cVar.f3027l;
        handler.sendMessage(handler.obtainMessage(6, i5, 1));
    }
}
