package com.google.android.gms.internal.measurement;

final class C4 extends G4 {

    /* renamed from: d  reason: collision with root package name */
    private final int f4930d;

    C4(byte[] bArr, int i5, int i6) {
        super(bArr);
        H4.n(0, i6, bArr.length);
        this.f4930d = i6;
    }

    public final byte c(int i5) {
        int i6 = this.f4930d;
        if (((i6 - (i5 + 1)) | i5) >= 0) {
            return this.f4952c[i5];
        }
        if (i5 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 11);
            sb.append("Index < 0: ");
            sb.append(i5);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(i5).length() + 18 + String.valueOf(i6).length());
        sb2.append("Index > length: ");
        sb2.append(i5);
        sb2.append(", ");
        sb2.append(i6);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: package-private */
    public final byte d(int i5) {
        return this.f4952c[i5];
    }

    public final int f() {
        return this.f4930d;
    }

    /* access modifiers changed from: protected */
    public final int o() {
        return 0;
    }
}
