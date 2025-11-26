package com.google.android.gms.measurement.internal;

abstract class B3 extends A3 {

    /* renamed from: b  reason: collision with root package name */
    private boolean f5757b;

    B3(X2 x22) {
        super(x22);
        this.f5730a.k();
    }

    /* access modifiers changed from: protected */
    public abstract boolean i();

    /* access modifiers changed from: protected */
    public void j() {
    }

    /* access modifiers changed from: package-private */
    public final boolean k() {
        return this.f5757b;
    }

    /* access modifiers changed from: protected */
    public final void l() {
        if (!k()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void m() {
        if (this.f5757b) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!i()) {
            this.f5730a.l();
            this.f5757b = true;
        }
    }

    public final void n() {
        if (!this.f5757b) {
            j();
            this.f5730a.l();
            this.f5757b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
