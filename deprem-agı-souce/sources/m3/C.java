package M3;

import H3.b;
import J3.e;
import J3.f;
import J3.m;
import N3.z;
import k3.l;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;

public final class C implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final C f18658a = new C();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18659b = m.i("kotlinx.serialization.json.JsonPrimitive", e.i.f18367a, new f[0], (l) null, 8, (Object) null);

    private C() {
    }

    /* renamed from: a */
    public B deserialize(K3.e eVar) {
        t.e(eVar, "decoder");
        h b5 = q.d(eVar).b();
        if (b5 instanceof B) {
            return (B) b5;
        }
        throw z.e(-1, "Unexpected JSON element, expected JsonPrimitive, had " + M.b(b5.getClass()), b5.toString());
    }

    /* renamed from: b */
    public void serialize(K3.f fVar, B b5) {
        t.e(fVar, "encoder");
        t.e(b5, "value");
        q.h(fVar);
        if (b5 instanceof w) {
            fVar.encodeSerializableValue(x.f18701a, w.INSTANCE);
        } else {
            fVar.encodeSerializableValue(t.f18698a, (s) b5);
        }
    }

    public f getDescriptor() {
        return f18659b;
    }
}
