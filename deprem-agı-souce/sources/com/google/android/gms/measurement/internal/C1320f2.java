package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.f2  reason: case insensitive filesystem */
abstract class C1320f2 extends E1 {

    /* renamed from: b  reason: collision with root package name */
    private boolean f6405b;

    C1320f2(X2 x22) {
        super(x22);
        this.f5730a.k();
    }

    /* access modifiers changed from: package-private */
    public final boolean i() {
        return this.f6405b;
    }

    /* access modifiers changed from: protected */
    public final void j() {
        if (!i()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void k() {
        if (this.f6405b) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!m()) {
            this.f5730a.l();
            this.f6405b = true;
        }
    }

    public final void l() {
        if (!this.f6405b) {
            n();
            this.f5730a.l();
            this.f6405b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: protected */
    public abstract boolean m();

    /* access modifiers changed from: protected */
    public void n() {
    }
}
