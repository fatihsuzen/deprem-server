package L3;

import H3.b;
import J3.e;
import J3.f;
import kotlin.jvm.internal.t;

public final class W implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final W f18492a = new W();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18493b = new N0("kotlin.Int", e.f.f18364a);

    private W() {
    }

    /* renamed from: a */
    public Integer deserialize(K3.e eVar) {
        t.e(eVar, "decoder");
        return Integer.valueOf(eVar.decodeInt());
    }

    public void b(K3.f fVar, int i5) {
        t.e(fVar, "encoder");
        fVar.encodeInt(i5);
    }

    public f getDescriptor() {
        return f18493b;
    }

    public /* bridge */ /* synthetic */ void serialize(K3.f fVar, Object obj) {
        b(fVar, ((Number) obj).intValue());
    }
}
