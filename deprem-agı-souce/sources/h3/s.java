package H3;

import I3.a;
import L3.A0;
import L3.C2104o;
import L3.C2126z0;
import L3.S0;
import O3.f;
import java.util.List;
import kotlin.jvm.internal.t;
import r3.C2733c;
import r3.C2734d;
import r3.C2743m;

public abstract class s {

    /* renamed from: a  reason: collision with root package name */
    private static final S0 f18196a = C2104o.a(new m());

    /* renamed from: b  reason: collision with root package name */
    private static final S0 f18197b = C2104o.a(new n());

    /* renamed from: c  reason: collision with root package name */
    private static final C2126z0 f18198c = C2104o.b(new o());

    /* renamed from: d  reason: collision with root package name */
    private static final C2126z0 f18199d = C2104o.b(new p());

    /* access modifiers changed from: private */
    public static final b g(C2733c cVar, List list) {
        t.e(cVar, "clazz");
        t.e(list, "types");
        List f5 = t.f(f.a(), list, true);
        t.b(f5);
        return t.a(cVar, f5, new q(list));
    }

    /* access modifiers changed from: private */
    public static final C2734d h(List list) {
        return ((C2743m) list.get(0)).e();
    }

    /* access modifiers changed from: private */
    public static final b i(C2733c cVar, List list) {
        b t5;
        t.e(cVar, "clazz");
        t.e(list, "types");
        List f5 = t.f(f.a(), list, true);
        t.b(f5);
        b a5 = t.a(cVar, f5, new r(list));
        if (a5 == null || (t5 = a.t(a5)) == null) {
            return null;
        }
        return t5;
    }

    /* access modifiers changed from: private */
    public static final C2734d j(List list) {
        return ((C2743m) list.get(0)).e();
    }

    /* access modifiers changed from: private */
    public static final b k(C2733c cVar) {
        t.e(cVar, "it");
        b e5 = t.e(cVar);
        if (e5 != null) {
            return e5;
        }
        if (A0.l(cVar)) {
            return new g(cVar);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final b l(C2733c cVar) {
        b t5;
        t.e(cVar, "it");
        b e5 = t.e(cVar);
        if (e5 == null) {
            if (A0.l(cVar)) {
                e5 = new g(cVar);
            } else {
                e5 = null;
            }
        }
        if (e5 == null || (t5 = a.t(e5)) == null) {
            return null;
        }
        return t5;
    }

    public static final b m(C2733c cVar, boolean z4) {
        t.e(cVar, "clazz");
        if (z4) {
            return f18197b.a(cVar);
        }
        b a5 = f18196a.a(cVar);
        if (a5 != null) {
            return a5;
        }
        return null;
    }

    public static final Object n(C2733c cVar, List list, boolean z4) {
        t.e(cVar, "clazz");
        t.e(list, "types");
        if (!z4) {
            return f18198c.a(cVar, list);
        }
        return f18199d.a(cVar, list);
    }
}
