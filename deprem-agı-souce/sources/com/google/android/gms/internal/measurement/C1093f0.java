package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.measurement.f0  reason: case insensitive filesystem */
public final class C1093f0 {

    /* renamed from: a  reason: collision with root package name */
    final C1219t1 f5342a;

    /* renamed from: b  reason: collision with root package name */
    U1 f5343b;

    /* renamed from: c  reason: collision with root package name */
    final C1065c f5344c = new C1065c();

    /* renamed from: d  reason: collision with root package name */
    private final W7 f5345d = new W7();

    public C1093f0() {
        C1219t1 t1Var = new C1219t1();
        this.f5342a = t1Var;
        this.f5343b = t1Var.f5581b.c();
        t1Var.f5583d.a("internal.registerCallback", new D(this));
        t1Var.f5583d.a("internal.eventLogger", new C1047a(this));
    }

    public final void a(String str, Callable callable) {
        this.f5342a.f5583d.a(str, callable);
    }

    public final boolean b(C1056b bVar) {
        try {
            C1065c cVar = this.f5344c;
            cVar.b(bVar);
            this.f5342a.f5582c.e("runtime.counter", new C1128j(Double.valueOf(0.0d)));
            this.f5345d.b(this.f5343b.c(), cVar);
            if (c() || d()) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw new F0(th);
        }
    }

    public final boolean c() {
        C1065c cVar = this.f5344c;
        if (!cVar.c().equals(cVar.a())) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        if (!this.f5344c.f().isEmpty()) {
            return true;
        }
        return false;
    }

    public final C1065c e() {
        return this.f5344c;
    }

    public final void f(C1265y3 y3Var) {
        C1137k kVar;
        try {
            C1219t1 t1Var = this.f5342a;
            this.f5343b = t1Var.f5581b.c();
            if (!(t1Var.a(this.f5343b, (C3[]) y3Var.F().toArray(new C3[0])) instanceof C1110h)) {
                for (C1239v3 v3Var : y3Var.G().F()) {
                    List G4 = v3Var.G();
                    String F4 = v3Var.F();
                    Iterator it = G4.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            r a5 = t1Var.a(this.f5343b, (C3) it.next());
                            if (a5 instanceof C1173o) {
                                U1 u12 = this.f5343b;
                                if (!u12.d(F4)) {
                                    kVar = null;
                                } else {
                                    r h5 = u12.h(F4);
                                    if (h5 instanceof C1137k) {
                                        kVar = (C1137k) h5;
                                    } else {
                                        throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(F4)));
                                    }
                                }
                                if (kVar != null) {
                                    kVar.a(this.f5343b, Collections.singletonList(a5));
                                } else {
                                    throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(F4)));
                                }
                            } else {
                                throw new IllegalArgumentException("Invalid rule definition");
                            }
                        }
                    }
                }
                return;
            }
            throw new IllegalStateException("Program loading failed");
        } catch (Throwable th) {
            throw new F0(th);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ C1137k g() {
        return new S7(this.f5345d);
    }
}
