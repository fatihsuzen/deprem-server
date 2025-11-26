package com.google.android.gms.internal.measurement;

final class I4 extends J4 {

    /* renamed from: b  reason: collision with root package name */
    private int f4964b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f4965c;

    /* renamed from: d  reason: collision with root package name */
    private int f4966d = Integer.MAX_VALUE;

    /* synthetic */ I4(byte[] bArr, int i5, int i6, boolean z4, byte[] bArr2) {
        super((byte[]) null);
    }

    public final int c(int i5) {
        int i6 = this.f4966d;
        this.f4966d = 0;
        int i7 = this.f4964b + this.f4965c;
        this.f4964b = i7;
        if (i7 > 0) {
            this.f4965c = i7;
            this.f4964b = 0;
            return i6;
        }
        this.f4965c = 0;
        return i6;
    }
}
