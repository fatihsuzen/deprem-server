package U3;

import V3.b;
import Y3.c;
import Y3.g;
import Y3.j;
import c4.f;
import java.io.IOException;
import java.util.ArrayList;

final class w implements e {

    /* renamed from: a  reason: collision with root package name */
    final u f19643a;

    /* renamed from: b  reason: collision with root package name */
    final j f19644b;

    /* renamed from: c  reason: collision with root package name */
    private o f19645c;

    /* renamed from: d  reason: collision with root package name */
    final x f19646d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f19647e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f19648f;

    final class a extends b {
    }

    private w(u uVar, x xVar, boolean z4) {
        this.f19643a = uVar;
        this.f19646d = xVar;
        this.f19647e = z4;
        this.f19644b = new j(uVar, z4);
    }

    private void a() {
        this.f19644b.h(f.i().m("response.body().close()"));
    }

    static w d(u uVar, x xVar, boolean z4) {
        w wVar = new w(uVar, xVar, z4);
        wVar.f19645c = uVar.k().a(wVar);
        return wVar;
    }

    /* renamed from: b */
    public w clone() {
        return d(this.f19643a, this.f19646d, this.f19647e);
    }

    /* access modifiers changed from: package-private */
    public z c() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f19643a.p());
        arrayList.add(this.f19644b);
        arrayList.add(new Y3.a(this.f19643a.h()));
        arrayList.add(new W3.a(this.f19643a.q()));
        arrayList.add(new X3.a(this.f19643a));
        if (!this.f19647e) {
            arrayList.addAll(this.f19643a.r());
        }
        arrayList.add(new Y3.b(this.f19647e));
        return new g(arrayList, (X3.g) null, (c) null, (X3.c) null, 0, this.f19646d, this, this.f19645c, this.f19643a.e(), this.f19643a.z(), this.f19643a.F()).a(this.f19646d);
    }

    public z execute() {
        synchronized (this) {
            if (!this.f19648f) {
                this.f19648f = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        a();
        this.f19645c.c(this);
        try {
            this.f19643a.i().a(this);
            z c5 = c();
            if (c5 != null) {
                this.f19643a.i().c(this);
                return c5;
            }
            throw new IOException("Canceled");
        } catch (IOException e5) {
            this.f19645c.b(this, e5);
            throw e5;
        } catch (Throwable th) {
            this.f19643a.i().c(this);
            throw th;
        }
    }
}
