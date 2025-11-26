package L3;

import H3.b;
import J3.e;
import J3.f;
import java.util.Map;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import r3.C2733c;
import t3.s;

public abstract class O0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f18475a = A0.i();

    public static final f a(String str, e eVar) {
        t.e(str, "serialName");
        t.e(eVar, "kind");
        c(str);
        return new N0(str, eVar);
    }

    public static final b b(C2733c cVar) {
        t.e(cVar, "<this>");
        return (b) f18475a.get(cVar);
    }

    private static final void c(String str) {
        for (b bVar : f18475a.values()) {
            if (t.a(str, bVar.getDescriptor().a())) {
                throw new IllegalArgumentException(s.n("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + str + " there already exists " + M.b(bVar.getClass()).c() + ".\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
            }
        }
    }
}
