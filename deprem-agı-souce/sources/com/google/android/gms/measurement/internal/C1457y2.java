package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: com.google.android.gms.measurement.internal.y2  reason: case insensitive filesystem */
final class C1457y2 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final q6 f6905a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f6906b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6907c;

    C1457y2(q6 q6Var) {
        C0722p.k(q6Var);
        this.f6905a = q6Var;
    }

    public final void a() {
        q6 q6Var = this.f6905a;
        q6Var.O0();
        q6Var.b().h();
        if (!this.f6906b) {
            q6Var.e().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f6907c = q6Var.E0().m();
            q6Var.a().w().b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f6907c));
            this.f6906b = true;
        }
    }

    public final void b() {
        q6 q6Var = this.f6905a;
        q6Var.O0();
        q6Var.b().h();
        q6Var.b().h();
        if (this.f6906b) {
            q6Var.a().w().a("Unregistering connectivity change receiver");
            this.f6906b = false;
            this.f6907c = false;
            try {
                q6Var.e().unregisterReceiver(this);
            } catch (IllegalArgumentException e5) {
                this.f6905a.a().o().b("Failed to unregister the network broadcast receiver", e5);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ q6 c() {
        return this.f6905a;
    }

    public final void onReceive(Context context, Intent intent) {
        q6 q6Var = this.f6905a;
        q6Var.O0();
        String action = intent.getAction();
        q6Var.a().w().b("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean m5 = q6Var.E0().m();
            if (this.f6907c != m5) {
                this.f6907c = m5;
                q6Var.b().t(new C1450x2(this, m5));
                return;
            }
            return;
        }
        q6Var.a().r().b("NetworkBroadcastReceiver received unknown action", action);
    }
}
