package L3;

import H3.b;
import J3.e;
import J3.f;
import kotlin.jvm.internal.t;

public final class V0 implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final V0 f18490a = new V0();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18491b = new N0("kotlin.Short", e.h.f18366a);

    private V0() {
    }

    /* renamed from: a */
    public Short deserialize(K3.e eVar) {
        t.e(eVar, "decoder");
        return Short.valueOf(eVar.decodeShort());
    }

    public void b(K3.f fVar, short s5) {
        t.e(fVar, "encoder");
        fVar.encodeShort(s5);
    }

    public f getDescriptor() {
        return f18491b;
    }

    public /* bridge */ /* synthetic */ void serialize(K3.f fVar, Object obj) {
        b(fVar, ((Number) obj).shortValue());
    }
}
