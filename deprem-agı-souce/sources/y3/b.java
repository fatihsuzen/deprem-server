package Y3;

import U3.s;
import U3.x;
import U3.z;
import X3.c;
import X3.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import e4.C2356e;
import e4.C2357f;
import e4.C2363l;
import e4.L;
import e4.X;
import java.net.ProtocolException;

public final class b implements s {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f20198a;

    static final class a extends C2363l {

        /* renamed from: b  reason: collision with root package name */
        long f20199b;

        a(X x4) {
            super(x4);
        }

        public void f(C2356e eVar, long j5) {
            super.f(eVar, j5);
            this.f20199b += j5;
        }
    }

    public b(boolean z4) {
        this.f20198a = z4;
    }

    public z a(s.a aVar) {
        z zVar;
        g gVar = (g) aVar;
        c e5 = gVar.e();
        g g5 = gVar.g();
        c cVar = (c) gVar.c();
        x request = gVar.request();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.d().o(gVar.b());
        e5.b(request);
        gVar.d().n(gVar.b(), request);
        z.a aVar2 = null;
        if (f.b(request.g()) && request.a() != null) {
            if ("100-continue".equalsIgnoreCase(request.c("Expect"))) {
                e5.flushRequest();
                gVar.d().s(gVar.b());
                aVar2 = e5.readResponseHeaders(true);
            }
            if (aVar2 == null) {
                gVar.d().m(gVar.b());
                a aVar3 = new a(e5.c(request, request.a().a()));
                C2357f c5 = L.c(aVar3);
                request.a().e(c5);
                c5.close();
                gVar.d().l(gVar.b(), aVar3.f20199b);
            } else if (!cVar.m()) {
                g5.i();
            }
        }
        e5.finishRequest();
        if (aVar2 == null) {
            gVar.d().s(gVar.b());
            aVar2 = e5.readResponseHeaders(false);
        }
        z c6 = aVar2.o(request).h(g5.c().j()).p(currentTimeMillis).n(System.currentTimeMillis()).c();
        int m5 = c6.m();
        if (m5 == 100) {
            c6 = e5.readResponseHeaders(false).o(request).h(g5.c().j()).p(currentTimeMillis).n(System.currentTimeMillis()).c();
            m5 = c6.m();
        }
        gVar.d().r(gVar.b(), c6);
        if (!this.f20198a || m5 != 101) {
            zVar = c6.v().b(e5.a(c6)).c();
        } else {
            zVar = c6.v().b(V3.c.f19701c).c();
        }
        if (CampaignEx.JSON_NATIVE_VIDEO_CLOSE.equalsIgnoreCase(zVar.A().c("Connection")) || CampaignEx.JSON_NATIVE_VIDEO_CLOSE.equalsIgnoreCase(zVar.o("Connection"))) {
            g5.i();
        }
        if ((m5 != 204 && m5 != 205) || zVar.a().a() <= 0) {
            return zVar;
        }
        throw new ProtocolException("HTTP " + m5 + " had non-zero Content-Length: " + zVar.a().a());
    }
}
