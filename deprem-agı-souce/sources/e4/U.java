package e4;

import X2.C2242i;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class U {

    /* renamed from: h  reason: collision with root package name */
    public static final a f21512h = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f21513a;

    /* renamed from: b  reason: collision with root package name */
    public int f21514b;

    /* renamed from: c  reason: collision with root package name */
    public int f21515c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f21516d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f21517e;

    /* renamed from: f  reason: collision with root package name */
    public U f21518f;

    /* renamed from: g  reason: collision with root package name */
    public U f21519g;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public U() {
        this.f21513a = new byte[8192];
        this.f21517e = true;
        this.f21516d = false;
    }

    public final void a() {
        int i5;
        U u5 = this.f21519g;
        if (u5 != this) {
            t.b(u5);
            if (u5.f21517e) {
                int i6 = this.f21515c - this.f21514b;
                U u6 = this.f21519g;
                t.b(u6);
                int i7 = 8192 - u6.f21515c;
                U u7 = this.f21519g;
                t.b(u7);
                if (u7.f21516d) {
                    i5 = 0;
                } else {
                    U u8 = this.f21519g;
                    t.b(u8);
                    i5 = u8.f21514b;
                }
                if (i6 <= i7 + i5) {
                    U u9 = this.f21519g;
                    t.b(u9);
                    f(u9, i6);
                    b();
                    V.b(this);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("cannot compact");
    }

    public final U b() {
        U u5 = this.f21518f;
        if (u5 == this) {
            u5 = null;
        }
        U u6 = this.f21519g;
        t.b(u6);
        u6.f21518f = this.f21518f;
        U u7 = this.f21518f;
        t.b(u7);
        u7.f21519g = this.f21519g;
        this.f21518f = null;
        this.f21519g = null;
        return u5;
    }

    public final U c(U u5) {
        t.e(u5, "segment");
        u5.f21519g = this;
        u5.f21518f = this.f21518f;
        U u6 = this.f21518f;
        t.b(u6);
        u6.f21519g = u5;
        this.f21518f = u5;
        return u5;
    }

    public final U d() {
        this.f21516d = true;
        return new U(this.f21513a, this.f21514b, this.f21515c, true, false);
    }

    public final U e(int i5) {
        U u5;
        if (i5 <= 0 || i5 > this.f21515c - this.f21514b) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i5 >= 1024) {
            u5 = d();
        } else {
            u5 = V.c();
            byte[] bArr = this.f21513a;
            byte[] bArr2 = u5.f21513a;
            int i6 = this.f21514b;
            C2242i.m(bArr, bArr2, 0, i6, i6 + i5, 2, (Object) null);
        }
        u5.f21515c = u5.f21514b + i5;
        this.f21514b += i5;
        U u6 = this.f21519g;
        t.b(u6);
        u6.c(u5);
        return u5;
    }

    public final void f(U u5, int i5) {
        t.e(u5, "sink");
        if (u5.f21517e) {
            int i6 = u5.f21515c;
            if (i6 + i5 > 8192) {
                if (!u5.f21516d) {
                    int i7 = u5.f21514b;
                    if ((i6 + i5) - i7 <= 8192) {
                        byte[] bArr = u5.f21513a;
                        C2242i.m(bArr, bArr, 0, i7, i6, 2, (Object) null);
                        u5.f21515c -= u5.f21514b;
                        u5.f21514b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.f21513a;
            byte[] bArr3 = u5.f21513a;
            int i8 = u5.f21515c;
            int i9 = this.f21514b;
            C2242i.h(bArr2, bArr3, i8, i9, i9 + i5);
            u5.f21515c += i5;
            this.f21514b += i5;
            return;
        }
        throw new IllegalStateException("only owner can write");
    }

    public U(byte[] bArr, int i5, int i6, boolean z4, boolean z5) {
        t.e(bArr, DataSchemeDataSource.SCHEME_DATA);
        this.f21513a = bArr;
        this.f21514b = i5;
        this.f21515c = i6;
        this.f21516d = z4;
        this.f21517e = z5;
    }
}
