package M;

import K.C0655b;
import K.C0660g;
import N.C0722p;
import android.app.Activity;
import androidx.collection.ArraySet;

/* renamed from: M.t  reason: case insensitive filesystem */
public final class C0699t extends c0 {

    /* renamed from: f  reason: collision with root package name */
    private final ArraySet f2938f = new ArraySet();

    /* renamed from: g  reason: collision with root package name */
    private final C0685e f2939g;

    C0699t(C0688h hVar, C0685e eVar, C0660g gVar) {
        super(hVar, gVar);
        this.f2939g = eVar;
        this.f2922a.a("ConnectionlessLifecycleHelper", this);
    }

    public static void u(Activity activity, C0685e eVar, C0682b bVar) {
        C0688h d5 = C0687g.d(activity);
        C0699t tVar = (C0699t) d5.b("ConnectionlessLifecycleHelper", C0699t.class);
        if (tVar == null) {
            tVar = new C0699t(d5, eVar, C0660g.n());
        }
        C0722p.l(bVar, "ApiKey cannot be null");
        tVar.f2938f.add(bVar);
        eVar.b(tVar);
    }

    private final void v() {
        if (!this.f2938f.isEmpty()) {
            this.f2939g.b(this);
        }
    }

    public final void h() {
        super.h();
        v();
    }

    public final void j() {
        super.j();
        v();
    }

    public final void k() {
        super.k();
        this.f2939g.c(this);
    }

    /* access modifiers changed from: protected */
    public final void m(C0655b bVar, int i5) {
        this.f2939g.D(bVar, i5);
    }

    /* access modifiers changed from: protected */
    public final void n() {
        this.f2939g.E();
    }

    /* access modifiers changed from: package-private */
    public final ArraySet t() {
        return this.f2938f;
    }
}
