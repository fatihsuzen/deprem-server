package Y3;

import U3.k;
import U3.l;
import U3.s;
import U3.x;
import U3.y;
import U3.z;
import V3.c;
import V3.d;
import com.mbridge.msdk.foundation.download.Command;
import e4.C2366o;
import e4.L;
import java.util.List;

public final class a implements s {

    /* renamed from: a  reason: collision with root package name */
    private final l f20197a;

    public a(l lVar) {
        this.f20197a = lVar;
    }

    private String b(List list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (i5 > 0) {
                sb.append("; ");
            }
            k kVar = (k) list.get(i5);
            sb.append(kVar.c());
            sb.append('=');
            sb.append(kVar.k());
        }
        return sb.toString();
    }

    public z a(s.a aVar) {
        x request = aVar.request();
        x.a h5 = request.h();
        y a5 = request.a();
        if (a5 != null) {
            a5.b();
            long a6 = a5.a();
            if (a6 != -1) {
                h5.c("Content-Length", Long.toString(a6));
                h5.f("Transfer-Encoding");
            } else {
                h5.c("Transfer-Encoding", "chunked");
                h5.f("Content-Length");
            }
        }
        boolean z4 = false;
        if (request.c("Host") == null) {
            h5.c("Host", c.p(request.i(), false));
        }
        if (request.c("Connection") == null) {
            h5.c("Connection", "Keep-Alive");
        }
        if (request.c("Accept-Encoding") == null && request.c(Command.HTTP_HEADER_RANGE) == null) {
            h5.c("Accept-Encoding", "gzip");
            z4 = true;
        }
        List b5 = this.f20197a.b(request.i());
        if (!b5.isEmpty()) {
            h5.c("Cookie", b(b5));
        }
        if (request.c(Command.HTTP_HEADER_USER_AGENT) == null) {
            h5.c(Command.HTTP_HEADER_USER_AGENT, d.a());
        }
        z a7 = aVar.a(h5.a());
        e.g(this.f20197a, request.i(), a7.q());
        z.a o5 = a7.v().o(request);
        if (z4 && "gzip".equalsIgnoreCase(a7.o("Content-Encoding")) && e.c(a7)) {
            C2366o oVar = new C2366o(a7.a().m());
            o5.i(a7.q().d().g("Content-Encoding").g("Content-Length").d());
            o5.b(new h(a7.o("Content-Type"), -1, L.d(oVar)));
        }
        return o5.c();
    }
}
