package e4;

import X2.C2242i;
import f4.e;
import java.security.MessageDigest;
import kotlin.jvm.internal.t;

public final class W extends C2359h {

    /* renamed from: f  reason: collision with root package name */
    private final transient byte[][] f21525f;

    /* renamed from: g  reason: collision with root package name */
    private final transient int[] f21526g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public W(byte[][] bArr, int[] iArr) {
        super(C2359h.f21567e.i());
        t.e(bArr, "segments");
        t.e(iArr, "directory");
        this.f21525f = bArr;
        this.f21526g = iArr;
    }

    private final C2359h P() {
        return new C2359h(K());
    }

    public C2359h H(int i5, int i6) {
        int d5 = C2353b.d(this, i6);
        if (i5 < 0) {
            throw new IllegalArgumentException(("beginIndex=" + i5 + " < 0").toString());
        } else if (d5 <= F()) {
            int i7 = d5 - i5;
            if (i7 < 0) {
                throw new IllegalArgumentException(("endIndex=" + d5 + " < beginIndex=" + i5).toString());
            } else if (i5 == 0 && d5 == F()) {
                return this;
            } else {
                if (i5 == d5) {
                    return C2359h.f21567e;
                }
                int b5 = e.b(this, i5);
                int b6 = e.b(this, d5 - 1);
                byte[][] bArr = (byte[][]) C2242i.s(O(), b5, b6 + 1);
                int[] iArr = new int[(bArr.length * 2)];
                int i8 = 0;
                if (b5 <= b6) {
                    int i9 = b5;
                    int i10 = 0;
                    while (true) {
                        iArr[i10] = Math.min(N()[i9] - i5, i7);
                        int i11 = i10 + 1;
                        iArr[i10 + bArr.length] = N()[O().length + i9];
                        if (i9 == b6) {
                            break;
                        }
                        i9++;
                        i10 = i11;
                    }
                }
                if (b5 != 0) {
                    i8 = N()[b5 - 1];
                }
                int length = bArr.length;
                iArr[length] = iArr[length] + (i5 - i8);
                return new W(bArr, iArr);
            }
        } else {
            throw new IllegalArgumentException(("endIndex=" + d5 + " > length(" + F() + ')').toString());
        }
    }

    public C2359h J() {
        return P().J();
    }

    public byte[] K() {
        byte[] bArr = new byte[F()];
        int length = O().length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < length) {
            int i8 = N()[length + i5];
            int i9 = N()[i5];
            int i10 = i9 - i6;
            C2242i.h(O()[i5], bArr, i7, i8, i8 + i10);
            i7 += i10;
            i5++;
            i6 = i9;
        }
        return bArr;
    }

    public void M(C2356e eVar, int i5, int i6) {
        int i7;
        t.e(eVar, "buffer");
        int i8 = i5 + i6;
        int b5 = e.b(this, i5);
        while (i5 < i8) {
            if (b5 == 0) {
                i7 = 0;
            } else {
                i7 = N()[b5 - 1];
            }
            int i9 = N()[O().length + b5];
            int min = Math.min(i8, (N()[b5] - i7) + i7) - i5;
            int i10 = i9 + (i5 - i7);
            U u5 = new U(O()[b5], i10, i10 + min, true, false);
            U u6 = eVar.f21556a;
            if (u6 == null) {
                u5.f21519g = u5;
                u5.f21518f = u5;
                eVar.f21556a = u5;
            } else {
                t.b(u6);
                U u7 = u6.f21519g;
                t.b(u7);
                u7.c(u5);
            }
            i5 += min;
            b5++;
        }
        eVar.z(eVar.size() + ((long) i6));
    }

    public final int[] N() {
        return this.f21526g;
    }

    public final byte[][] O() {
        return this.f21525f;
    }

    public String a() {
        return P().a();
    }

    public C2359h e(String str) {
        t.e(str, "algorithm");
        MessageDigest instance = MessageDigest.getInstance(str);
        int length = O().length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7 = N()[length + i5];
            int i8 = N()[i5];
            instance.update(O()[i5], i7, i8 - i6);
            i5++;
            i6 = i8;
        }
        byte[] digest = instance.digest();
        t.d(digest, "digestBytes");
        return new C2359h(digest);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2359h) {
            C2359h hVar = (C2359h) obj;
            if (hVar.F() != F() || !x(0, hVar, 0, F())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int j5 = j();
        if (j5 != 0) {
            return j5;
        }
        int length = O().length;
        int i5 = 0;
        int i6 = 1;
        int i7 = 0;
        while (i5 < length) {
            int i8 = N()[length + i5];
            int i9 = N()[i5];
            byte[] bArr = O()[i5];
            int i10 = (i9 - i7) + i8;
            while (i8 < i10) {
                i6 = (i6 * 31) + bArr[i8];
                i8++;
            }
            i5++;
            i7 = i9;
        }
        z(i6);
        return i6;
    }

    public int k() {
        return N()[O().length - 1];
    }

    public String m() {
        return P().m();
    }

    public int o(byte[] bArr, int i5) {
        t.e(bArr, "other");
        return P().o(bArr, i5);
    }

    public byte[] q() {
        return K();
    }

    public byte r(int i5) {
        int i6;
        C2353b.b((long) N()[O().length - 1], (long) i5, 1);
        int b5 = e.b(this, i5);
        if (b5 == 0) {
            i6 = 0;
        } else {
            i6 = N()[b5 - 1];
        }
        return O()[b5][(i5 - i6) + N()[O().length + b5]];
    }

    public int t(byte[] bArr, int i5) {
        t.e(bArr, "other");
        return P().t(bArr, i5);
    }

    public String toString() {
        return P().toString();
    }

    public boolean x(int i5, C2359h hVar, int i6, int i7) {
        int i8;
        t.e(hVar, "other");
        if (i5 < 0 || i5 > F() - i7) {
            return false;
        }
        int i9 = i7 + i5;
        int b5 = e.b(this, i5);
        while (i5 < i9) {
            if (b5 == 0) {
                i8 = 0;
            } else {
                i8 = N()[b5 - 1];
            }
            int i10 = N()[O().length + b5];
            int min = Math.min(i9, (N()[b5] - i8) + i8) - i5;
            if (!hVar.y(i6, O()[b5], i10 + (i5 - i8), min)) {
                return false;
            }
            i6 += min;
            i5 += min;
            b5++;
        }
        return true;
    }

    public boolean y(int i5, byte[] bArr, int i6, int i7) {
        int i8;
        t.e(bArr, "other");
        if (i5 < 0 || i5 > F() - i7 || i6 < 0 || i6 > bArr.length - i7) {
            return false;
        }
        int i9 = i7 + i5;
        int b5 = e.b(this, i5);
        while (i5 < i9) {
            if (b5 == 0) {
                i8 = 0;
            } else {
                i8 = N()[b5 - 1];
            }
            int i10 = N()[O().length + b5];
            int min = Math.min(i9, (N()[b5] - i8) + i8) - i5;
            if (!C2353b.a(O()[b5], i10 + (i5 - i8), bArr, i6, min)) {
                return false;
            }
            i6 += min;
            i5 += min;
            b5++;
        }
        return true;
    }
}
