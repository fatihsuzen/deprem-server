package a4;

import U3.A;
import U3.q;
import U3.s;
import U3.u;
import U3.v;
import U3.x;
import U3.z;
import X3.g;
import Y3.c;
import Y3.e;
import Y3.h;
import Y3.i;
import Y3.k;
import e4.C2356e;
import e4.C2359h;
import e4.C2364m;
import e4.L;
import e4.X;
import e4.Z;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class f implements c {

    /* renamed from: f  reason: collision with root package name */
    private static final C2359h f20339f;

    /* renamed from: g  reason: collision with root package name */
    private static final C2359h f20340g;

    /* renamed from: h  reason: collision with root package name */
    private static final C2359h f20341h;

    /* renamed from: i  reason: collision with root package name */
    private static final C2359h f20342i;

    /* renamed from: j  reason: collision with root package name */
    private static final C2359h f20343j;

    /* renamed from: k  reason: collision with root package name */
    private static final C2359h f20344k;

    /* renamed from: l  reason: collision with root package name */
    private static final C2359h f20345l;

    /* renamed from: m  reason: collision with root package name */
    private static final C2359h f20346m;

    /* renamed from: n  reason: collision with root package name */
    private static final List f20347n;

    /* renamed from: o  reason: collision with root package name */
    private static final List f20348o;

    /* renamed from: a  reason: collision with root package name */
    private final u f20349a;

    /* renamed from: b  reason: collision with root package name */
    private final s.a f20350b;

    /* renamed from: c  reason: collision with root package name */
    final g f20351c;

    /* renamed from: d  reason: collision with root package name */
    private final g f20352d;

    /* renamed from: e  reason: collision with root package name */
    private i f20353e;

    class a extends C2364m {

        /* renamed from: b  reason: collision with root package name */
        boolean f20354b = false;

        /* renamed from: c  reason: collision with root package name */
        long f20355c = 0;

        a(Z z4) {
            super(z4);
        }

        private void d(IOException iOException) {
            if (!this.f20354b) {
                this.f20354b = true;
                f fVar = f.this;
                fVar.f20351c.q(false, fVar, this.f20355c, iOException);
            }
        }

        public void close() {
            super.close();
            d((IOException) null);
        }

        public long e(C2356e eVar, long j5) {
            try {
                long e5 = a().e(eVar, j5);
                if (e5 <= 0) {
                    return e5;
                }
                this.f20355c += e5;
                return e5;
            } catch (IOException e6) {
                d(e6);
                throw e6;
            }
        }
    }

    static {
        C2359h f5 = C2359h.f("connection");
        f20339f = f5;
        C2359h f6 = C2359h.f("host");
        f20340g = f6;
        C2359h f7 = C2359h.f("keep-alive");
        f20341h = f7;
        C2359h f8 = C2359h.f("proxy-connection");
        f20342i = f8;
        C2359h f9 = C2359h.f("transfer-encoding");
        f20343j = f9;
        C2359h f10 = C2359h.f("te");
        f20344k = f10;
        C2359h f11 = C2359h.f("encoding");
        f20345l = f11;
        C2359h f12 = C2359h.f("upgrade");
        f20346m = f12;
        f20347n = V3.c.r(f5, f6, f7, f8, f10, f9, f11, f12, c.f20308f, c.f20309g, c.f20310h, c.f20311i);
        f20348o = V3.c.r(f5, f6, f7, f8, f10, f9, f11, f12);
    }

    public f(u uVar, s.a aVar, g gVar, g gVar2) {
        this.f20349a = uVar;
        this.f20350b = aVar;
        this.f20351c = gVar;
        this.f20352d = gVar2;
    }

    public static List d(x xVar) {
        q d5 = xVar.d();
        ArrayList arrayList = new ArrayList(d5.e() + 4);
        arrayList.add(new c(c.f20308f, xVar.g()));
        arrayList.add(new c(c.f20309g, i.c(xVar.i())));
        String c5 = xVar.c("Host");
        if (c5 != null) {
            arrayList.add(new c(c.f20311i, c5));
        }
        arrayList.add(new c(c.f20310h, xVar.i().A()));
        int e5 = d5.e();
        for (int i5 = 0; i5 < e5; i5++) {
            C2359h f5 = C2359h.f(d5.c(i5).toLowerCase(Locale.US));
            if (!f20347n.contains(f5)) {
                arrayList.add(new c(f5, d5.f(i5)));
            }
        }
        return arrayList;
    }

    public static z.a e(List list) {
        q.a aVar = new q.a();
        int size = list.size();
        k kVar = null;
        for (int i5 = 0; i5 < size; i5++) {
            c cVar = (c) list.get(i5);
            if (cVar != null) {
                C2359h hVar = cVar.f20312a;
                String L4 = cVar.f20313b.L();
                if (hVar.equals(c.f20307e)) {
                    kVar = k.a("HTTP/1.1 " + L4);
                } else if (!f20348o.contains(hVar)) {
                    V3.a.f19697a.b(aVar, hVar.L(), L4);
                }
            } else if (kVar != null && kVar.f20225b == 100) {
                aVar = new q.a();
                kVar = null;
            }
        }
        if (kVar != null) {
            return new z.a().m(v.HTTP_2).g(kVar.f20225b).j(kVar.f20226c).i(aVar.d());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public A a(z zVar) {
        g gVar = this.f20351c;
        gVar.f20108f.q(gVar.f20107e);
        return new h(zVar.o("Content-Type"), e.b(zVar), L.d(new a(this.f20353e.i())));
    }

    public void b(x xVar) {
        boolean z4;
        if (this.f20353e == null) {
            if (xVar.a() != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            i v5 = this.f20352d.v(d(xVar), z4);
            this.f20353e = v5;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            v5.l().g((long) this.f20350b.readTimeoutMillis(), timeUnit);
            this.f20353e.s().g((long) this.f20350b.writeTimeoutMillis(), timeUnit);
        }
    }

    public X c(x xVar, long j5) {
        return this.f20353e.h();
    }

    public void finishRequest() {
        this.f20353e.h().close();
    }

    public void flushRequest() {
        this.f20352d.flush();
    }

    public z.a readResponseHeaders(boolean z4) {
        z.a e5 = e(this.f20353e.q());
        if (!z4 || V3.a.f19697a.d(e5) != 100) {
            return e5;
        }
        return null;
    }
}
