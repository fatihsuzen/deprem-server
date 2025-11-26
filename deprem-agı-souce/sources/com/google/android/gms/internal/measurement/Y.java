package com.google.android.gms.internal.measurement;

final class Y extends C1084e0 {

    /* renamed from: a  reason: collision with root package name */
    private String f5272a;

    /* renamed from: b  reason: collision with root package name */
    private byte f5273b;

    /* renamed from: c  reason: collision with root package name */
    private int f5274c;

    /* renamed from: d  reason: collision with root package name */
    private int f5275d;

    Y() {
    }

    public final C1084e0 a(boolean z4) {
        this.f5273b = 1;
        return this;
    }

    public final C1102g0 b() {
        if (this.f5273b == 1 && this.f5272a != null && this.f5274c != 0 && this.f5275d != 0) {
            return new Z(this.f5272a, false, this.f5274c, (W) null, (X) null, this.f5275d, (byte[]) null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f5272a == null) {
            sb.append(" fileOwner");
        }
        if (this.f5273b == 0) {
            sb.append(" hasDifferentDmaOwner");
        }
        if (this.f5274c == 0) {
            sb.append(" fileChecks");
        }
        if (this.f5275d == 0) {
            sb.append(" filePurpose");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    /* access modifiers changed from: package-private */
    public final C1084e0 c(int i5) {
        this.f5274c = i5;
        return this;
    }

    public final C1084e0 d(int i5) {
        this.f5275d = 1;
        return this;
    }

    public final C1084e0 e(String str) {
        this.f5272a = "";
        return this;
    }
}
