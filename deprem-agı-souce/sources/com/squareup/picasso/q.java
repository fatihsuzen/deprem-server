package com.squareup.picasso;

import M1.c;
import U3.A;
import U3.d;
import U3.x;
import U3.z;
import android.net.NetworkInfo;
import com.squareup.picasso.s;
import com.squareup.picasso.x;
import e4.Z;
import java.io.IOException;

class q extends x {

    /* renamed from: a  reason: collision with root package name */
    private final c f13349a;

    /* renamed from: b  reason: collision with root package name */
    private final z f13350b;

    static class a extends IOException {
        a(String str) {
            super(str);
        }
    }

    static final class b extends IOException {

        /* renamed from: a  reason: collision with root package name */
        final int f13351a;

        /* renamed from: b  reason: collision with root package name */
        final int f13352b;

        b(int i5, int i6) {
            super("HTTP " + i5);
            this.f13351a = i5;
            this.f13352b = i6;
        }
    }

    q(c cVar, z zVar) {
        this.f13349a = cVar;
        this.f13350b = zVar;
    }

    private static x j(v vVar, int i5) {
        d dVar;
        if (i5 == 0) {
            dVar = null;
        } else if (p.a(i5)) {
            dVar = d.f19365o;
        } else {
            d.a aVar = new d.a();
            if (!p.b(i5)) {
                aVar.c();
            }
            if (!p.c(i5)) {
                aVar.d();
            }
            dVar = aVar.a();
        }
        x.a h5 = new x.a().h(vVar.f13408d.toString());
        if (dVar != null) {
            h5.b(dVar);
        }
        return h5.a();
    }

    public boolean c(v vVar) {
        String scheme = vVar.f13408d.getScheme();
        if ("http".equals(scheme) || "https".equals(scheme)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return 2;
    }

    public x.a f(v vVar, int i5) {
        s.e eVar;
        z a5 = this.f13349a.a(j(vVar, i5));
        A a6 = a5.a();
        if (a5.s()) {
            if (a5.l() == null) {
                eVar = s.e.NETWORK;
            } else {
                eVar = s.e.DISK;
            }
            if (eVar == s.e.DISK && a6.a() == 0) {
                a6.close();
                throw new a("Received response with 0 content-length header.");
            }
            if (eVar == s.e.NETWORK && a6.a() > 0) {
                this.f13350b.f(a6.a());
            }
            return new x.a((Z) a6.m(), eVar);
        }
        a6.close();
        throw new b(a5.m(), vVar.f13407c);
    }

    /* access modifiers changed from: package-private */
    public boolean h(boolean z4, NetworkInfo networkInfo) {
        if (networkInfo == null || networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return true;
    }
}
