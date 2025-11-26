package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.U;
import com.google.android.gms.internal.measurement.V;
import j$.util.Objects;

public final class G2 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final String f5889a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ H2 f5890b;

    G2(H2 h22, String str) {
        Objects.requireNonNull(h22);
        this.f5890b = h22;
        this.f5889a = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String a() {
        return this.f5889a;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            try {
                V j5 = U.j(iBinder);
                if (j5 == null) {
                    this.f5890b.f5907a.a().r().a("Install Referrer Service implementation was not found");
                    return;
                }
                X2 x22 = this.f5890b.f5907a;
                x22.a().w().a("Install Referrer Service connected");
                x22.b().t(new F2(this, j5, this));
            } catch (RuntimeException e5) {
                this.f5890b.f5907a.a().r().b("Exception occurred while calling Install Referrer API", e5);
            }
        } else {
            this.f5890b.f5907a.a().r().a("Install Referrer connection returned with null binder");
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f5890b.f5907a.a().w().a("Install Referrer Service disconnected");
    }
}
