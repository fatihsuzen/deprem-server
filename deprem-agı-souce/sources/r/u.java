package r;

import B.C0628a;
import android.content.Context;
import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.Set;
import p.C1745c;
import p.j;
import p.k;
import r.i;
import x.e;
import y.r;
import y.v;

public class u implements t {

    /* renamed from: e  reason: collision with root package name */
    private static volatile v f16300e;

    /* renamed from: a  reason: collision with root package name */
    private final C0628a f16301a;

    /* renamed from: b  reason: collision with root package name */
    private final C0628a f16302b;

    /* renamed from: c  reason: collision with root package name */
    private final e f16303c;

    /* renamed from: d  reason: collision with root package name */
    private final r f16304d;

    u(C0628a aVar, C0628a aVar2, e eVar, r rVar, v vVar) {
        this.f16301a = aVar;
        this.f16302b = aVar2;
        this.f16303c = eVar;
        this.f16304d = rVar;
        vVar.c();
    }

    private i b(o oVar) {
        i.a g5 = i.a().i(this.f16301a.a()).o(this.f16302b.a()).n(oVar.g()).h(new h(oVar.b(), oVar.d())).g(oVar.c().a());
        if (!(oVar.c().e() == null || oVar.c().e().a() == null)) {
            g5.l(oVar.c().e().a());
        }
        oVar.c().b();
        return g5.d();
    }

    public static u c() {
        v vVar = f16300e;
        if (vVar != null) {
            return vVar.d();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set d(f fVar) {
        if (fVar instanceof g) {
            return DesugarCollections.unmodifiableSet(((g) fVar).a());
        }
        return Collections.singleton(C1745c.b("proto"));
    }

    public static void f(Context context) {
        if (f16300e == null) {
            synchronized (u.class) {
                try {
                    if (f16300e == null) {
                        f16300e = e.a().a(context).build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void a(o oVar, k kVar) {
        this.f16303c.a(oVar.f().f(oVar.c().d()), b(oVar), kVar);
    }

    public r e() {
        return this.f16304d;
    }

    public j g(f fVar) {
        return new q(d(fVar), p.a().b(fVar.getName()).c(fVar.getExtras()).a(), this);
    }
}
