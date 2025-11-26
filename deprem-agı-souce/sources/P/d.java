package P;

import L.C0668a;
import L.e;
import M.C0696p;
import N.C0725t;
import N.C0727v;
import N.C0728w;
import android.content.Context;
import k0.C1698l;

public final class d extends e implements C0727v {

    /* renamed from: k  reason: collision with root package name */
    private static final C0668a.g f3865k;

    /* renamed from: l  reason: collision with root package name */
    private static final C0668a.C0048a f3866l;

    /* renamed from: m  reason: collision with root package name */
    private static final C0668a f3867m;

    /* renamed from: n  reason: collision with root package name */
    public static final /* synthetic */ int f3868n = 0;

    static {
        C0668a.g gVar = new C0668a.g();
        f3865k = gVar;
        c cVar = new c();
        f3866l = cVar;
        f3867m = new C0668a("ClientTelemetry.API", cVar, gVar);
    }

    public d(Context context, C0728w wVar) {
        super(context, f3867m, wVar, e.a.f2779c);
    }

    public final C1698l a(C0725t tVar) {
        C0696p.a a5 = C0696p.a();
        a5.d(Z.d.f4494a);
        a5.c(false);
        a5.b(new b(tVar));
        return d(a5.a());
    }
}
