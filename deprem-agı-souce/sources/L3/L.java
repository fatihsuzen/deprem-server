package L3;

import H3.b;
import J3.e;
import J3.f;
import kotlin.jvm.internal.t;

public final class L implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final L f18468a = new L();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18469b = new N0("kotlin.Float", e.C0178e.f18363a);

    private L() {
    }

    /* renamed from: a */
    public Float deserialize(K3.e eVar) {
        t.e(eVar, "decoder");
        return Float.valueOf(eVar.decodeFloat());
    }

    public void b(K3.f fVar, float f5) {
        t.e(fVar, "encoder");
        fVar.encodeFloat(f5);
    }

    public f getDescriptor() {
        return f18469b;
    }

    public /* bridge */ /* synthetic */ void serialize(K3.f fVar, Object obj) {
        b(fVar, ((Number) obj).floatValue());
    }
}
