package com.google.firebase.messaging;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.adid.i;
import com.google.firebase.messaging.k0;
import java.util.concurrent.ExecutorService;
import k0.C1698l;
import k0.C1699m;
import k0.C1701o;

/* renamed from: com.google.firebase.messaging.i  reason: case insensitive filesystem */
public abstract class C1560i extends Service {

    /* renamed from: a  reason: collision with root package name */
    final ExecutorService f7438a = C1566o.d();

    /* renamed from: b  reason: collision with root package name */
    private Binder f7439b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f7440c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private int f7441d;

    /* renamed from: e  reason: collision with root package name */
    private int f7442e = 0;

    /* renamed from: com.google.firebase.messaging.i$a */
    class a implements k0.a {
        a() {
        }

        public C1698l a(Intent intent) {
            return C1560i.this.h(intent);
        }
    }

    public static /* synthetic */ void a(C1560i iVar, Intent intent, C1699m mVar) {
        iVar.getClass();
        try {
            iVar.f(intent);
        } finally {
            mVar.c((Object) null);
        }
    }

    /* access modifiers changed from: private */
    public void d(Intent intent) {
        if (intent != null) {
            i0.c(intent);
        }
        synchronized (this.f7440c) {
            try {
                int i5 = this.f7442e - 1;
                this.f7442e = i5;
                if (i5 == 0) {
                    i(this.f7441d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public C1698l h(Intent intent) {
        if (g(intent)) {
            return C1701o.e((Object) null);
        }
        C1699m mVar = new C1699m();
        this.f7438a.execute(new C1559h(this, intent, mVar));
        return mVar.a();
    }

    /* access modifiers changed from: protected */
    public abstract Intent e(Intent intent);

    public abstract void f(Intent intent);

    public boolean g(Intent intent) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean i(int i5) {
        return stopSelfResult(i5);
    }

    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "Service received bind request");
            }
            if (this.f7439b == null) {
                this.f7439b = new k0(new a());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f7439b;
    }

    public void onDestroy() {
        this.f7438a.shutdown();
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i5, int i6) {
        synchronized (this.f7440c) {
            this.f7441d = i6;
            this.f7442e++;
        }
        Intent e5 = e(intent);
        if (e5 == null) {
            d(intent);
            return 2;
        }
        C1698l h5 = h(e5);
        if (h5.m()) {
            d(intent);
            return 2;
        }
        h5.b(new i(), new C1558g(this, intent));
        return 3;
    }
}
