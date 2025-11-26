package com.google.android.gms.internal.measurement;

import androidx.work.WorkInfo;
import java.util.Locale;

final class K4 extends M4 {

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f5007e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5008f;

    /* renamed from: g  reason: collision with root package name */
    private int f5009g;

    K4(byte[] bArr, int i5, int i6) {
        super((byte[]) null);
        int length = bArr.length;
        if (((length - i6) | i6) >= 0) {
            this.f5007e = bArr;
            this.f5009g = 0;
            this.f5008f = i6;
            return;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i6)}));
    }

    public final void A(long j5) {
        int i5 = this.f5009g;
        try {
            byte[] bArr = this.f5007e;
            bArr[i5] = (byte) ((int) j5);
            bArr[i5 + 1] = (byte) ((int) (j5 >> 8));
            bArr[i5 + 2] = (byte) ((int) (j5 >> 16));
            bArr[i5 + 3] = (byte) ((int) (j5 >> 24));
            bArr[i5 + 4] = (byte) ((int) (j5 >> 32));
            bArr[i5 + 5] = (byte) ((int) (j5 >> 40));
            bArr[i5 + 6] = (byte) ((int) (j5 >> 48));
            bArr[i5 + 7] = (byte) ((int) (j5 >> 56));
            this.f5009g = i5 + 8;
        } catch (IndexOutOfBoundsException e5) {
            throw new L4((long) i5, (long) this.f5008f, 8, e5);
        }
    }

    public final void B(byte[] bArr, int i5, int i6) {
        F(bArr, 0, i6);
    }

    public final void C(String str) {
        int i5 = this.f5009g;
        try {
            int E4 = M4.E(str.length() * 3);
            int E5 = M4.E(str.length());
            if (E5 == E4) {
                int i6 = i5 + E5;
                this.f5009g = i6;
                int c5 = C1153l6.c(str, this.f5007e, i6, this.f5008f - i6);
                this.f5009g = i5;
                x((c5 - i5) - E5);
                this.f5009g = c5;
                return;
            }
            x(C1153l6.b(str));
            byte[] bArr = this.f5007e;
            int i7 = this.f5009g;
            this.f5009g = C1153l6.c(str, bArr, i7, this.f5008f - i7);
        } catch (C1144k6 e5) {
            this.f5009g = i5;
            f(str, e5);
        } catch (IndexOutOfBoundsException e6) {
            throw new L4(e6);
        }
    }

    public final int D() {
        return this.f5008f - this.f5009g;
    }

    public final void F(byte[] bArr, int i5, int i6) {
        try {
            System.arraycopy(bArr, 0, this.f5007e, this.f5009g, i6);
            this.f5009g += i6;
        } catch (IndexOutOfBoundsException e5) {
            throw new L4((long) this.f5009g, (long) this.f5008f, i6, e5);
        }
    }

    public final void i(int i5, int i6) {
        x((i5 << 3) | i6);
    }

    public final void j(int i5, int i6) {
        x(i5 << 3);
        w(i6);
    }

    public final void k(int i5, int i6) {
        x(i5 << 3);
        x(i6);
    }

    public final void l(int i5, int i6) {
        x((i5 << 3) | 5);
        y(i6);
    }

    public final void m(int i5, long j5) {
        x(i5 << 3);
        z(j5);
    }

    public final void n(int i5, long j5) {
        x((i5 << 3) | 1);
        A(j5);
    }

    public final void o(int i5, boolean z4) {
        x(i5 << 3);
        v(z4 ? (byte) 1 : 0);
    }

    public final void p(int i5, String str) {
        x((i5 << 3) | 2);
        C(str);
    }

    public final void q(int i5, H4 h42) {
        x((i5 << 3) | 2);
        r(h42);
    }

    public final void r(H4 h42) {
        x(h42.f());
        h42.i(this);
    }

    public final void s(byte[] bArr, int i5, int i6) {
        x(i6);
        F(bArr, 0, i6);
    }

    /* access modifiers changed from: package-private */
    public final void t(int i5, F5 f5, Q5 q5) {
        x((i5 << 3) | 2);
        x(((C1213s4) f5).f(q5));
        q5.g(f5, this.f5025a);
    }

    public final void u(F5 f5) {
        x(f5.a());
        f5.c(this);
    }

    public final void v(byte b5) {
        int i5 = this.f5009g;
        try {
            int i6 = i5 + 1;
            try {
                this.f5007e[i5] = b5;
                this.f5009g = i6;
            } catch (IndexOutOfBoundsException e5) {
                e = e5;
                i5 = i6;
                throw new L4((long) i5, (long) this.f5008f, 1, e);
            }
        } catch (IndexOutOfBoundsException e6) {
            e = e6;
            throw new L4((long) i5, (long) this.f5008f, 1, e);
        }
    }

    public final void w(int i5) {
        if (i5 >= 0) {
            x(i5);
        } else {
            z((long) i5);
        }
    }

    public final void x(int i5) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i6;
        int i7 = this.f5009g;
        while ((i5 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) != 0) {
            i6 = i7 + 1;
            this.f5007e[i7] = (byte) (i5 | 128);
            i5 >>>= 7;
            i7 = i6;
        }
        try {
            i6 = i7 + 1;
        } catch (IndexOutOfBoundsException e5) {
            indexOutOfBoundsException = e5;
            throw new L4((long) i7, (long) this.f5008f, 1, indexOutOfBoundsException);
        }
        try {
            this.f5007e[i7] = (byte) i5;
            this.f5009g = i6;
        } catch (IndexOutOfBoundsException e6) {
            indexOutOfBoundsException = e6;
            i7 = i6;
            throw new L4((long) i7, (long) this.f5008f, 1, indexOutOfBoundsException);
        }
    }

    public final void y(int i5) {
        int i6 = this.f5009g;
        try {
            byte[] bArr = this.f5007e;
            bArr[i6] = (byte) i5;
            bArr[i6 + 1] = (byte) (i5 >> 8);
            bArr[i6 + 2] = (byte) (i5 >> 16);
            bArr[i6 + 3] = (byte) (i5 >> 24);
            this.f5009g = i6 + 4;
        } catch (IndexOutOfBoundsException e5) {
            throw new L4((long) i6, (long) this.f5008f, 4, e5);
        }
    }

    public final void z(long j5) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i5;
        boolean h5 = M4.f5023c;
        int i6 = this.f5009g;
        if (!h5 || this.f5008f - i6 < 10) {
            while ((j5 & -128) != 0) {
                int i7 = i6 + 1;
                try {
                    this.f5007e[i6] = (byte) (((int) j5) | 128);
                    j5 >>>= 7;
                    i6 = i7;
                } catch (IndexOutOfBoundsException e5) {
                    indexOutOfBoundsException = e5;
                    i6 = i7;
                    throw new L4((long) i6, (long) this.f5008f, 1, indexOutOfBoundsException);
                }
            }
            try {
                i5 = i6 + 1;
            } catch (IndexOutOfBoundsException e6) {
                indexOutOfBoundsException = e6;
                throw new L4((long) i6, (long) this.f5008f, 1, indexOutOfBoundsException);
            }
            try {
                this.f5007e[i6] = (byte) ((int) j5);
            } catch (IndexOutOfBoundsException e7) {
                indexOutOfBoundsException = e7;
                i6 = i5;
                throw new L4((long) i6, (long) this.f5008f, 1, indexOutOfBoundsException);
            }
        } else {
            while ((j5 & -128) != 0) {
                C1126i6.u(this.f5007e, (long) i6, (byte) (((int) j5) | 128));
                j5 >>>= 7;
                i6++;
            }
            i5 = i6 + 1;
            C1126i6.u(this.f5007e, (long) i6, (byte) ((int) j5));
        }
        this.f5009g = i5;
    }
}
