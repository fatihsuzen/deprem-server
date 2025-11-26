package com.google.android.gms.internal.measurement;

class G4 extends F4 {

    /* renamed from: c  reason: collision with root package name */
    protected final byte[] f4952c;

    G4(byte[] bArr) {
        super((byte[]) null);
        bArr.getClass();
        this.f4952c = bArr;
    }

    public byte c(int i5) {
        return this.f4952c[i5];
    }

    /* access modifiers changed from: package-private */
    public byte d(int i5) {
        return this.f4952c[i5];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof H4) || f() != ((H4) obj).f()) {
            return false;
        }
        if (f() == 0) {
            return true;
        }
        if (!(obj instanceof G4)) {
            return obj.equals(this);
        }
        G4 g42 = (G4) obj;
        int l5 = l();
        int l6 = g42.l();
        if (l5 != 0 && l6 != 0 && l5 != l6) {
            return false;
        }
        int f5 = f();
        if (f5 > g42.f()) {
            int f6 = f();
            StringBuilder sb = new StringBuilder(String.valueOf(f5).length() + 18 + String.valueOf(f6).length());
            sb.append("Length too large: ");
            sb.append(f5);
            sb.append(f6);
            throw new IllegalArgumentException(sb.toString());
        } else if (f5 <= g42.f()) {
            byte[] bArr = this.f4952c;
            byte[] bArr2 = g42.f4952c;
            g42.o();
            int i5 = 0;
            int i6 = 0;
            while (i5 < f5) {
                if (bArr[i5] != bArr2[i6]) {
                    return false;
                }
                i5++;
                i6++;
            }
            return true;
        } else {
            int f7 = g42.f();
            StringBuilder sb2 = new StringBuilder(String.valueOf(f5).length() + 27 + String.valueOf(f7).length());
            sb2.append("Ran off end of other: 0, ");
            sb2.append(f5);
            sb2.append(", ");
            sb2.append(f7);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public int f() {
        return this.f4952c.length;
    }

    public final H4 g(int i5, int i6) {
        int n5 = H4.n(0, i6, f());
        if (n5 == 0) {
            return H4.f4958b;
        }
        return new C4(this.f4952c, 0, n5);
    }

    /* access modifiers changed from: package-private */
    public final void i(C1266y4 y4Var) {
        ((K4) y4Var).F(this.f4952c, 0, f());
    }

    /* access modifiers changed from: protected */
    public final int j(int i5, int i6, int i7) {
        return C1152l5.c(i5, this.f4952c, 0, i7);
    }

    /* access modifiers changed from: protected */
    public int o() {
        return 0;
    }
}
