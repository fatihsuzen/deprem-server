package e4;

import X2.C2242i;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import f4.b;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

/* renamed from: e4.h  reason: case insensitive filesystem */
public class C2359h implements Serializable, Comparable {

    /* renamed from: d  reason: collision with root package name */
    public static final a f21566d = new a((C2633k) null);

    /* renamed from: e  reason: collision with root package name */
    public static final C2359h f21567e = new C2359h(new byte[0]);

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f21568a;

    /* renamed from: b  reason: collision with root package name */
    private transient int f21569b;

    /* renamed from: c  reason: collision with root package name */
    private transient String f21570c;

    /* renamed from: e4.h$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final C2359h a(String str) {
            t.e(str, "<this>");
            byte[] a5 = C2352a.a(str);
            if (a5 != null) {
                return new C2359h(a5);
            }
            return null;
        }

        public final C2359h b(String str) {
            t.e(str, "<this>");
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i5 = 0; i5 < length; i5++) {
                    int i6 = i5 * 2;
                    bArr[i5] = (byte) ((b.e(str.charAt(i6)) << 4) + b.e(str.charAt(i6 + 1)));
                }
                return new C2359h(bArr);
            }
            throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
        }

        public final C2359h c(String str) {
            t.e(str, "<this>");
            C2359h hVar = new C2359h(c0.a(str));
            hVar.D(str);
            return hVar;
        }

        public final C2359h d(byte... bArr) {
            t.e(bArr, DataSchemeDataSource.SCHEME_DATA);
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            t.d(copyOf, "copyOf(this, size)");
            return new C2359h(copyOf);
        }

        private a() {
        }
    }

    public C2359h(byte[] bArr) {
        t.e(bArr, DataSchemeDataSource.SCHEME_DATA);
        this.f21568a = bArr;
    }

    public static /* synthetic */ C2359h I(C2359h hVar, int i5, int i6, int i7, Object obj) {
        if (obj == null) {
            if ((i7 & 1) != 0) {
                i5 = 0;
            }
            if ((i7 & 2) != 0) {
                i6 = C2353b.c();
            }
            return hVar.H(i5, i6);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    public static final C2359h c(String str) {
        return f21566d.a(str);
    }

    public static final C2359h d(String str) {
        return f21566d.b(str);
    }

    public static final C2359h f(String str) {
        return f21566d.c(str);
    }

    public static /* synthetic */ int p(C2359h hVar, C2359h hVar2, int i5, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 2) != 0) {
                i5 = 0;
            }
            return hVar.n(hVar2, i5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int u(C2359h hVar, C2359h hVar2, int i5, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 2) != 0) {
                i5 = C2353b.c();
            }
            return hVar.s(hVar2, i5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static final C2359h w(byte... bArr) {
        return f21566d.d(bArr);
    }

    public final void D(String str) {
        this.f21570c = str;
    }

    public final C2359h E() {
        return e("SHA-256");
    }

    public final int F() {
        return k();
    }

    public final boolean G(C2359h hVar) {
        t.e(hVar, "prefix");
        return x(0, hVar, 0, hVar.F());
    }

    public C2359h H(int i5, int i6) {
        int d5 = C2353b.d(this, i6);
        if (i5 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (d5 > i().length) {
            throw new IllegalArgumentException(("endIndex > length(" + i().length + ')').toString());
        } else if (d5 - i5 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        } else if (i5 == 0 && d5 == i().length) {
            return this;
        } else {
            return new C2359h(C2242i.r(i(), i5, d5));
        }
    }

    public C2359h J() {
        int i5 = 0;
        while (i5 < i().length) {
            byte b5 = i()[i5];
            if (b5 < 65 || b5 > 90) {
                i5++;
            } else {
                byte[] i6 = i();
                byte[] copyOf = Arrays.copyOf(i6, i6.length);
                t.d(copyOf, "copyOf(this, size)");
                copyOf[i5] = (byte) (b5 + 32);
                for (int i7 = i5 + 1; i7 < copyOf.length; i7++) {
                    byte b6 = copyOf[i7];
                    if (b6 >= 65 && b6 <= 90) {
                        copyOf[i7] = (byte) (b6 + 32);
                    }
                }
                return new C2359h(copyOf);
            }
        }
        return this;
    }

    public byte[] K() {
        byte[] i5 = i();
        byte[] copyOf = Arrays.copyOf(i5, i5.length);
        t.d(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public String L() {
        String l5 = l();
        if (l5 != null) {
            return l5;
        }
        String c5 = c0.c(q());
        D(c5);
        return c5;
    }

    public void M(C2356e eVar, int i5, int i6) {
        t.e(eVar, "buffer");
        b.d(this, eVar, i5, i6);
    }

    public String a() {
        return C2352a.c(i(), (byte[]) null, 1, (Object) null);
    }

    /* renamed from: b */
    public int compareTo(C2359h hVar) {
        t.e(hVar, "other");
        int F4 = F();
        int F5 = hVar.F();
        int min = Math.min(F4, F5);
        int i5 = 0;
        while (i5 < min) {
            byte h5 = h(i5) & 255;
            byte h6 = hVar.h(i5) & 255;
            if (h5 == h6) {
                i5++;
            } else if (h5 < h6) {
                return -1;
            } else {
                return 1;
            }
        }
        if (F4 == F5) {
            return 0;
        }
        if (F4 < F5) {
            return -1;
        }
        return 1;
    }

    public C2359h e(String str) {
        t.e(str, "algorithm");
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(this.f21568a, 0, F());
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
            if (hVar.F() != i().length || !hVar.y(0, i(), 0, i().length)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean g(C2359h hVar) {
        t.e(hVar, "suffix");
        return x(F() - hVar.F(), hVar, 0, hVar.F());
    }

    public final byte h(int i5) {
        return r(i5);
    }

    public int hashCode() {
        int j5 = j();
        if (j5 != 0) {
            return j5;
        }
        int hashCode = Arrays.hashCode(i());
        z(hashCode);
        return hashCode;
    }

    public final byte[] i() {
        return this.f21568a;
    }

    public final int j() {
        return this.f21569b;
    }

    public int k() {
        return i().length;
    }

    public final String l() {
        return this.f21570c;
    }

    public String m() {
        char[] cArr = new char[(i().length * 2)];
        int i5 = 0;
        for (byte b5 : i()) {
            int i6 = i5 + 1;
            cArr[i5] = b.f()[(b5 >> 4) & 15];
            i5 += 2;
            cArr[i6] = b.f()[b5 & 15];
        }
        return s.y(cArr);
    }

    public final int n(C2359h hVar, int i5) {
        t.e(hVar, "other");
        return o(hVar.q(), i5);
    }

    public int o(byte[] bArr, int i5) {
        t.e(bArr, "other");
        int length = i().length - bArr.length;
        int max = Math.max(i5, 0);
        if (max > length) {
            return -1;
        }
        while (!C2353b.a(i(), max, bArr, 0, bArr.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    public byte[] q() {
        return i();
    }

    public byte r(int i5) {
        return i()[i5];
    }

    public final int s(C2359h hVar, int i5) {
        t.e(hVar, "other");
        return t(hVar.q(), i5);
    }

    public int t(byte[] bArr, int i5) {
        t.e(bArr, "other");
        for (int min = Math.min(C2353b.d(this, i5), i().length - bArr.length); -1 < min; min--) {
            if (C2353b.a(i(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public String toString() {
        C2359h hVar;
        if (i().length == 0) {
            return "[size=0]";
        }
        int a5 = b.c(i(), 64);
        if (a5 != -1) {
            String L4 = L();
            String substring = L4.substring(0, a5);
            t.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String L5 = s.L(s.L(s.L(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
            if (a5 < L4.length()) {
                return "[size=" + i().length + " text=" + L5 + "…]";
            }
            return "[text=" + L5 + ']';
        } else if (i().length <= 64) {
            return "[hex=" + m() + ']';
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(i().length);
            sb.append(" hex=");
            int d5 = C2353b.d(this, 64);
            if (d5 > i().length) {
                throw new IllegalArgumentException(("endIndex > length(" + i().length + ')').toString());
            } else if (d5 >= 0) {
                if (d5 == i().length) {
                    hVar = this;
                } else {
                    hVar = new C2359h(C2242i.r(i(), 0, d5));
                }
                sb.append(hVar.m());
                sb.append("…]");
                return sb.toString();
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
        }
    }

    public final C2359h v() {
        return e(SameMD5.TAG);
    }

    public boolean x(int i5, C2359h hVar, int i6, int i7) {
        t.e(hVar, "other");
        return hVar.y(i6, i(), i5, i7);
    }

    public boolean y(int i5, byte[] bArr, int i6, int i7) {
        t.e(bArr, "other");
        if (i5 < 0 || i5 > i().length - i7 || i6 < 0 || i6 > bArr.length - i7 || !C2353b.a(i(), i5, bArr, i6, i7)) {
            return false;
        }
        return true;
    }

    public final void z(int i5) {
        this.f21569b = i5;
    }
}
