package W3;

import U3.A;
import U3.q;
import U3.s;
import U3.v;
import U3.x;
import U3.z;
import V3.c;
import W3.c;
import Y3.e;
import Y3.f;
import Y3.h;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import e4.C2356e;
import e4.C2357f;
import e4.C2358g;
import e4.L;
import e4.X;
import e4.Z;
import e4.a0;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class a implements s {

    /* renamed from: a  reason: collision with root package name */
    final f f19982a;

    /* renamed from: W3.a$a  reason: collision with other inner class name */
    class C0191a implements Z {

        /* renamed from: a  reason: collision with root package name */
        boolean f19983a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2358g f19984b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f19985c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2357f f19986d;

        C0191a(C2358g gVar, b bVar, C2357f fVar) {
            this.f19984b = gVar;
            this.f19985c = bVar;
            this.f19986d = fVar;
        }

        public void close() {
            if (!this.f19983a && !c.m(this, 100, TimeUnit.MILLISECONDS)) {
                this.f19983a = true;
                this.f19985c.abort();
            }
            this.f19984b.close();
        }

        public long e(C2356e eVar, long j5) {
            try {
                long e5 = this.f19984b.e(eVar, j5);
                if (e5 == -1) {
                    if (!this.f19983a) {
                        this.f19983a = true;
                        this.f19986d.close();
                    }
                    return -1;
                }
                eVar.o(this.f19986d.buffer(), eVar.size() - e5, e5);
                this.f19986d.emitCompleteSegments();
                return e5;
            } catch (IOException e6) {
                IOException iOException = e6;
                if (!this.f19983a) {
                    this.f19983a = true;
                    this.f19985c.abort();
                }
                throw iOException;
            }
        }

        public a0 timeout() {
            return this.f19984b.timeout();
        }
    }

    public a(f fVar) {
        this.f19982a = fVar;
    }

    private z b(b bVar, z zVar) {
        X body;
        if (bVar == null || (body = bVar.body()) == null) {
            return zVar;
        }
        C0191a aVar = new C0191a(zVar.a().m(), bVar, L.c(body));
        return zVar.v().b(new h(zVar.o("Content-Type"), zVar.a().a(), L.d(aVar))).c();
    }

    private static q c(q qVar, q qVar2) {
        q.a aVar = new q.a();
        int e5 = qVar.e();
        for (int i5 = 0; i5 < e5; i5++) {
            String c5 = qVar.c(i5);
            String f5 = qVar.f(i5);
            if ((!"Warning".equalsIgnoreCase(c5) || !f5.startsWith("1")) && (d(c5) || !e(c5) || qVar2.a(c5) == null)) {
                V3.a.f19697a.b(aVar, c5, f5);
            }
        }
        int e6 = qVar2.e();
        for (int i6 = 0; i6 < e6; i6++) {
            String c6 = qVar2.c(i6);
            if (!d(c6) && e(c6)) {
                V3.a.f19697a.b(aVar, c6, qVar2.f(i6));
            }
        }
        return aVar.d();
    }

    static boolean d(String str) {
        if ("Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    static boolean e(String str) {
        if ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    private static z f(z zVar) {
        if (zVar == null || zVar.a() == null) {
            return zVar;
        }
        return zVar.v().b((A) null).c();
    }

    public z a(s.a aVar) {
        z zVar;
        f fVar = this.f19982a;
        if (fVar != null) {
            zVar = fVar.b(aVar.request());
        } else {
            zVar = null;
        }
        c c5 = new c.a(System.currentTimeMillis(), aVar.request(), zVar).c();
        x xVar = c5.f19988a;
        z zVar2 = c5.f19989b;
        f fVar2 = this.f19982a;
        if (fVar2 != null) {
            fVar2.a(c5);
        }
        if (zVar != null && zVar2 == null) {
            V3.c.d(zVar.a());
        }
        if (xVar == null && zVar2 == null) {
            return new z.a().o(aVar.request()).m(v.HTTP_1_1).g(TypedValues.PositionType.TYPE_PERCENT_HEIGHT).j("Unsatisfiable Request (only-if-cached)").b(V3.c.f19701c).p(-1).n(System.currentTimeMillis()).c();
        }
        if (xVar == null) {
            return zVar2.v().d(f(zVar2)).c();
        }
        try {
            z a5 = aVar.a(xVar);
            if (a5 == null && zVar != null) {
            }
            if (zVar2 != null) {
                if (a5.m() == 304) {
                    z c6 = zVar2.v().i(c(zVar2.q(), a5.q())).p(a5.B()).n(a5.z()).d(f(zVar2)).k(f(a5)).c();
                    a5.a().close();
                    this.f19982a.trackConditionalCacheHit();
                    this.f19982a.c(zVar2, c6);
                    return c6;
                }
                V3.c.d(zVar2.a());
            }
            z c7 = a5.v().d(f(zVar2)).k(f(a5)).c();
            if (this.f19982a != null) {
                if (e.c(c7) && c.a(c7, xVar)) {
                    return b(this.f19982a.d(c7), c7);
                }
                if (f.a(xVar.g())) {
                    try {
                        this.f19982a.e(xVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return c7;
        } finally {
            if (zVar != null) {
                V3.c.d(zVar.a());
            }
        }
    }
}
