package N3;

import J3.f;
import java.util.Map;
import k3.C2616a;
import kotlin.jvm.internal.t;

/* renamed from: N3.s  reason: case insensitive filesystem */
public final class C2148s {

    /* renamed from: a  reason: collision with root package name */
    private final Map f18796a = r.a(16);

    /* renamed from: N3.s$a */
    public static final class a {
    }

    public final Object a(f fVar, a aVar) {
        Object obj;
        t.e(fVar, "descriptor");
        t.e(aVar, "key");
        Map map = (Map) this.f18796a.get(fVar);
        if (map != null) {
            obj = map.get(aVar);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        return obj;
    }

    public final Object b(f fVar, a aVar, C2616a aVar2) {
        t.e(fVar, "descriptor");
        t.e(aVar, "key");
        t.e(aVar2, "defaultValue");
        Object a5 = a(fVar, aVar);
        if (a5 != null) {
            return a5;
        }
        Object invoke = aVar2.invoke();
        c(fVar, aVar, invoke);
        return invoke;
    }

    public final void c(f fVar, a aVar, Object obj) {
        t.e(fVar, "descriptor");
        t.e(aVar, "key");
        t.e(obj, "value");
        Map map = this.f18796a;
        Object obj2 = map.get(fVar);
        if (obj2 == null) {
            obj2 = r.a(2);
            map.put(fVar, obj2);
        }
        ((Map) obj2).put(aVar, obj);
    }
}
