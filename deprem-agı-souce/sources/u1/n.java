package u1;

import A1.g;
import D1.a;
import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
import x1.c;
import x1.f;
import x1.i;
import z1.b;

public class n extends b {

    /* renamed from: a  reason: collision with root package name */
    private final d f16725a;

    /* renamed from: b  reason: collision with root package name */
    private final c f16726b;

    /* renamed from: c  reason: collision with root package name */
    private final f f16727c;

    /* renamed from: d  reason: collision with root package name */
    private a f16728d;

    /* renamed from: e  reason: collision with root package name */
    private z1.a f16729e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16730f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f16731g;

    /* renamed from: h  reason: collision with root package name */
    private final String f16732h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f16733i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f16734j;

    n(c cVar, d dVar) {
        this(cVar, dVar, UUID.randomUUID().toString());
    }

    private void h() {
        if (this.f16733i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void i(View view) {
        Collection<n> c5 = c.e().c();
        if (c5 != null && !c5.isEmpty()) {
            for (n nVar : c5) {
                if (nVar != this && nVar.n() == view) {
                    nVar.f16728d.clear();
                }
            }
        }
    }

    private void l() {
        if (this.f16734j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    private void m(View view) {
        this.f16728d = new a(view);
    }

    public void a(View view, h hVar, String str) {
        if (!this.f16731g) {
            this.f16727c.c(view, hVar, str);
        }
    }

    public void c() {
        if (!this.f16731g) {
            this.f16728d.clear();
            e();
            this.f16731g = true;
            t().u();
            c.e().d(this);
            t().o();
            this.f16729e = null;
        }
    }

    public void d(View view) {
        if (!this.f16731g) {
            g.b(view, "AdView is null");
            if (n() != view) {
                m(view);
                t().a();
                i(view);
            }
        }
    }

    public void e() {
        if (!this.f16731g) {
            this.f16727c.f();
        }
    }

    public void f(View view) {
        if (!this.f16731g) {
            this.f16727c.g(view);
        }
    }

    public void g() {
        if (!this.f16730f) {
            this.f16730f = true;
            c.e().f(this);
            this.f16729e.b(i.d().c());
            this.f16729e.g(x1.a.a().c());
            this.f16729e.k(this, this.f16725a);
        }
    }

    public void j(List list) {
        if (p()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view = (View) ((a) it.next()).get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    public void k(JSONObject jSONObject) {
        l();
        t().h(jSONObject);
        this.f16734j = true;
    }

    public View n() {
        return (View) this.f16728d.get();
    }

    public List o() {
        return this.f16727c.a();
    }

    public boolean p() {
        return false;
    }

    public boolean q() {
        if (!this.f16730f || this.f16731g) {
            return false;
        }
        return true;
    }

    public boolean r() {
        return this.f16731g;
    }

    public String s() {
        return this.f16732h;
    }

    public z1.a t() {
        return this.f16729e;
    }

    public boolean u() {
        return this.f16726b.b();
    }

    public boolean v() {
        return this.f16726b.c();
    }

    public boolean w() {
        return this.f16730f;
    }

    /* access modifiers changed from: package-private */
    public void x() {
        h();
        t().v();
        this.f16733i = true;
    }

    /* access modifiers changed from: package-private */
    public void y() {
        l();
        t().x();
        this.f16734j = true;
    }

    n(c cVar, d dVar, String str) {
        this.f16727c = new f();
        this.f16730f = false;
        this.f16731g = false;
        this.f16726b = cVar;
        this.f16725a = dVar;
        this.f16732h = str;
        m((View) null);
        this.f16729e = (dVar.c() == e.HTML || dVar.c() == e.JAVASCRIPT) ? new b(str, dVar.j()) : new z1.c(str, dVar.f(), dVar.g());
        this.f16729e.y();
        c.e().b(this);
        this.f16729e.j(cVar);
    }
}
