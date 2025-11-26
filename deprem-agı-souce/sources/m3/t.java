package M3;

import H3.b;
import I3.a;
import J3.e;
import J3.f;
import J3.m;
import N3.z;
import W2.D;
import kotlin.jvm.internal.M;
import t3.O;
import t3.s;

final class t implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final t f18698a = new t();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18699b = m.c("kotlinx.serialization.json.JsonLiteral", e.i.f18367a);

    private t() {
    }

    /* renamed from: a */
    public s deserialize(K3.e eVar) {
        kotlin.jvm.internal.t.e(eVar, "decoder");
        h b5 = q.d(eVar).b();
        if (b5 instanceof s) {
            return (s) b5;
        }
        throw z.e(-1, "Unexpected JSON element, expected JsonLiteral, had " + M.b(b5.getClass()), b5.toString());
    }

    /* renamed from: b */
    public void serialize(K3.f fVar, s sVar) {
        kotlin.jvm.internal.t.e(fVar, "encoder");
        kotlin.jvm.internal.t.e(sVar, "value");
        q.h(fVar);
        if (sVar.g()) {
            fVar.encodeString(sVar.c());
        } else if (sVar.f() != null) {
            fVar.encodeInline(sVar.f()).encodeString(sVar.c());
        } else {
            Long v5 = s.v(sVar.c());
            if (v5 != null) {
                fVar.encodeLong(v5.longValue());
                return;
            }
            D h5 = O.h(sVar.c());
            if (h5 != null) {
                fVar.encodeInline(a.w(D.f19931b).getDescriptor()).encodeLong(h5.f());
                return;
            }
            Double r5 = s.r(sVar.c());
            if (r5 != null) {
                fVar.encodeDouble(r5.doubleValue());
                return;
            }
            Boolean V02 = s.V0(sVar.c());
            if (V02 != null) {
                fVar.encodeBoolean(V02.booleanValue());
            } else {
                fVar.encodeString(sVar.c());
            }
        }
    }

    public f getDescriptor() {
        return f18699b;
    }
}
