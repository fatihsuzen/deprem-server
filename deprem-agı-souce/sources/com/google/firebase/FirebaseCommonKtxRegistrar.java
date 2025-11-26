package com.google.firebase;

import X2.C2250q;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.t;
import q0.C1756a;
import r0.C1786c;
import r0.C1788e;
import r0.F;
import r0.h;
import r0.r;
import w3.C2894r0;
import w3.I;

@Keep
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {

    public static final class a implements h {

        /* renamed from: a  reason: collision with root package name */
        public static final a f7146a = new a();

        /* renamed from: b */
        public final I a(C1788e eVar) {
            Object e5 = eVar.e(F.a(C1756a.class, Executor.class));
            t.d(e5, "get(...)");
            return C2894r0.b((Executor) e5);
        }
    }

    public static final class b implements h {

        /* renamed from: a  reason: collision with root package name */
        public static final b f7147a = new b();

        /* renamed from: b */
        public final I a(C1788e eVar) {
            Object e5 = eVar.e(F.a(q0.c.class, Executor.class));
            t.d(e5, "get(...)");
            return C2894r0.b((Executor) e5);
        }
    }

    public static final class c implements h {

        /* renamed from: a  reason: collision with root package name */
        public static final c f7148a = new c();

        /* renamed from: b */
        public final I a(C1788e eVar) {
            Object e5 = eVar.e(F.a(q0.b.class, Executor.class));
            t.d(e5, "get(...)");
            return C2894r0.b((Executor) e5);
        }
    }

    public static final class d implements h {

        /* renamed from: a  reason: collision with root package name */
        public static final d f7149a = new d();

        /* renamed from: b */
        public final I a(C1788e eVar) {
            Object e5 = eVar.e(F.a(q0.d.class, Executor.class));
            t.d(e5, "get(...)");
            return C2894r0.b((Executor) e5);
        }
    }

    public List<C1786c> getComponents() {
        Class<C1756a> cls = C1756a.class;
        Class<I> cls2 = I.class;
        Class<Executor> cls3 = Executor.class;
        C1786c d5 = C1786c.e(F.a(cls, cls2)).b(r.l(F.a(cls, cls3))).f(a.f7146a).d();
        t.d(d5, "build(...)");
        Class<q0.c> cls4 = q0.c.class;
        C1786c d6 = C1786c.e(F.a(cls4, cls2)).b(r.l(F.a(cls4, cls3))).f(b.f7147a).d();
        t.d(d6, "build(...)");
        Class<q0.b> cls5 = q0.b.class;
        C1786c d7 = C1786c.e(F.a(cls5, cls2)).b(r.l(F.a(cls5, cls3))).f(c.f7148a).d();
        t.d(d7, "build(...)");
        Class<q0.d> cls6 = q0.d.class;
        C1786c d8 = C1786c.e(F.a(cls6, cls2)).b(r.l(F.a(cls6, cls3))).f(d.f7149a).d();
        t.d(d8, "build(...)");
        return C2250q.j(d5, d6, d7, d8);
    }
}
