package O3;

import H3.b;
import L3.A0;
import O3.a;
import X2.M;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import k3.l;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class e implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Map f18856a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map f18857b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map f18858c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map f18859d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map f18860e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private boolean f18861f;

    public static /* synthetic */ void k(e eVar, C2733c cVar, C2733c cVar2, b bVar, boolean z4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            z4 = false;
        }
        eVar.j(cVar, cVar2, bVar, z4);
    }

    public static /* synthetic */ void m(e eVar, C2733c cVar, a aVar, boolean z4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        eVar.l(cVar, aVar, z4);
    }

    public void a(C2733c cVar, l lVar) {
        t.e(cVar, "baseClass");
        t.e(lVar, "defaultDeserializerProvider");
        h(cVar, lVar, false);
    }

    public void b(C2733c cVar, l lVar) {
        t.e(cVar, "baseClass");
        t.e(lVar, "defaultSerializerProvider");
        i(cVar, lVar, false);
    }

    public void c(C2733c cVar, l lVar) {
        t.e(cVar, "kClass");
        t.e(lVar, "provider");
        m(this, cVar, new a.b(lVar), false, 4, (Object) null);
    }

    public void d(C2733c cVar, C2733c cVar2, b bVar) {
        t.e(cVar, "baseClass");
        t.e(cVar2, "actualClass");
        t.e(bVar, "actualSerializer");
        k(this, cVar, cVar2, bVar, false, 8, (Object) null);
    }

    public void e(C2733c cVar, b bVar) {
        t.e(cVar, "kClass");
        t.e(bVar, "serializer");
        m(this, cVar, new a.C0179a(bVar), false, 4, (Object) null);
    }

    public final d f() {
        return new b(this.f18856a, this.f18857b, this.f18858c, this.f18859d, this.f18860e, this.f18861f);
    }

    public final void g(d dVar) {
        t.e(dVar, "module");
        dVar.a(this);
    }

    public final void h(C2733c cVar, l lVar, boolean z4) {
        t.e(cVar, "baseClass");
        t.e(lVar, "defaultDeserializerProvider");
        l lVar2 = (l) this.f18860e.get(cVar);
        if (lVar2 == null || t.a(lVar2, lVar) || z4) {
            this.f18860e.put(cVar, lVar);
            return;
        }
        throw new IllegalArgumentException("Default deserializers provider for " + cVar + " is already registered: " + lVar2);
    }

    public final void i(C2733c cVar, l lVar, boolean z4) {
        t.e(cVar, "baseClass");
        t.e(lVar, "defaultSerializerProvider");
        l lVar2 = (l) this.f18858c.get(cVar);
        if (lVar2 == null || t.a(lVar2, lVar) || z4) {
            this.f18858c.put(cVar, lVar);
            return;
        }
        throw new IllegalArgumentException("Default serializers provider for " + cVar + " is already registered: " + lVar2);
    }

    public final void j(C2733c cVar, C2733c cVar2, b bVar, boolean z4) {
        Object obj;
        t.e(cVar, "baseClass");
        t.e(cVar2, "concreteClass");
        t.e(bVar, "concreteSerializer");
        String a5 = bVar.getDescriptor().a();
        Map map = this.f18857b;
        Object obj2 = map.get(cVar);
        if (obj2 == null) {
            obj2 = new HashMap();
            map.put(cVar, obj2);
        }
        Map map2 = (Map) obj2;
        b bVar2 = (b) map2.get(cVar2);
        Map map3 = this.f18859d;
        Object obj3 = map3.get(cVar);
        if (obj3 == null) {
            obj3 = new HashMap();
            map3.put(cVar, obj3);
        }
        Map map4 = (Map) obj3;
        if (z4) {
            if (bVar2 != null) {
                map4.remove(bVar2.getDescriptor().a());
            }
            map2.put(cVar2, bVar);
            map4.put(a5, bVar);
            return;
        }
        if (bVar2 != null) {
            if (t.a(bVar2, bVar)) {
                b bVar3 = (b) map4.remove(bVar2.getDescriptor().a());
            } else {
                throw new c(cVar, cVar2);
            }
        }
        b bVar4 = (b) map4.get(a5);
        if (bVar4 != null) {
            Object obj4 = this.f18857b.get(cVar);
            t.b(obj4);
            Iterator it = M.w((Map) obj4).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((Map.Entry) obj).getValue() == bVar4) {
                    break;
                }
            }
            throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + cVar + "' have the same serial name '" + a5 + "': '" + cVar2 + "' and '" + ((Map.Entry) obj) + '\'');
        }
        map2.put(cVar2, bVar);
        map4.put(a5, bVar);
    }

    public final void l(C2733c cVar, a aVar, boolean z4) {
        a aVar2;
        t.e(cVar, "forClass");
        t.e(aVar, "provider");
        if (z4 || (aVar2 = (a) this.f18856a.get(cVar)) == null || t.a(aVar2, aVar)) {
            this.f18856a.put(cVar, aVar);
            if (A0.l(cVar)) {
                this.f18861f = true;
                return;
            }
            return;
        }
        throw new c("Contextual serializer or serializer provider for " + cVar + " already registered in this module");
    }
}
