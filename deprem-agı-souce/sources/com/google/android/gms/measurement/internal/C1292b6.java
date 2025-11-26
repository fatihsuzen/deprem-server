package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.b6  reason: case insensitive filesystem */
abstract class C1292b6 extends W5 {

    /* renamed from: c  reason: collision with root package name */
    private boolean f6229c;

    C1292b6(q6 q6Var) {
        super(q6Var);
        this.f6129b.e0();
    }

    /* access modifiers changed from: package-private */
    public final boolean i() {
        return this.f6229c;
    }

    /* access modifiers changed from: protected */
    public final void j() {
        if (!i()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void k() {
        if (!this.f6229c) {
            l();
            this.f6129b.f0();
            this.f6229c = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: protected */
    public abstract boolean l();
}
