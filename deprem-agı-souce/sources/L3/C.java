package L3;

import H3.b;
import J3.e;
import J3.f;
import kotlin.jvm.internal.t;

public final class C implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final C f18428a = new C();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18429b = new N0("kotlin.Double", e.d.f18362a);

    private C() {
    }

    /* renamed from: a */
    public Double deserialize(K3.e eVar) {
        t.e(eVar, "decoder");
        return Double.valueOf(eVar.decodeDouble());
    }

    public void b(K3.f fVar, double d5) {
        t.e(fVar, "encoder");
        fVar.encodeDouble(d5);
    }

    public f getDescriptor() {
        return f18429b;
    }

    public /* bridge */ /* synthetic */ void serialize(K3.f fVar, Object obj) {
        b(fVar, ((Number) obj).doubleValue());
    }
}
