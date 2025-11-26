package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.C1209s0;

public final class N5 extends C1320f2 {

    /* renamed from: c  reason: collision with root package name */
    private Handler f5996c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5997d = true;

    /* renamed from: e  reason: collision with root package name */
    protected final M5 f5998e = new M5(this);

    /* renamed from: f  reason: collision with root package name */
    protected final L5 f5999f = new L5(this);

    /* renamed from: g  reason: collision with root package name */
    protected final I5 f6000g = new I5(this);

    N5(X2 x22) {
        super(x22);
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public final void q() {
        h();
        if (this.f5996c == null) {
            this.f5996c = new C1209s0(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: protected */
    public final boolean m() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void o(boolean z4) {
        h();
        this.f5997d = z4;
    }

    /* access modifiers changed from: package-private */
    public final boolean p() {
        h();
        return this.f5997d;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void r(long j5) {
        h();
        q();
        X2 x22 = this.f5730a;
        x22.a().w().b("Activity resumed, time", Long.valueOf(j5));
        if (x22.w().H((String) null, C1304d2.f6303V0)) {
            if (x22.w().N() || this.f5997d) {
                this.f5999f.a(j5);
            }
        } else if (x22.w().N() || x22.x().f5850t.a()) {
            this.f5999f.a(j5);
        }
        this.f6000g.a();
        M5 m5 = this.f5998e;
        N5 n5 = m5.f5984a;
        n5.h();
        if (n5.f5730a.g()) {
            m5.b(n5.f5730a.f().currentTimeMillis(), false);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void s(long j5) {
        h();
        q();
        X2 x22 = this.f5730a;
        x22.a().w().b("Activity paused, time", Long.valueOf(j5));
        this.f6000g.b(j5);
        if (x22.w().N()) {
            this.f5999f.b(j5);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Handler t() {
        return this.f5996c;
    }
}
