package L3;

import H3.b;
import J3.e;
import J3.f;
import kotlin.jvm.internal.t;

/* renamed from: L3.l  reason: case insensitive filesystem */
public final class C2098l implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final C2098l f18553a = new C2098l();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18554b = new N0("kotlin.Byte", e.b.f18360a);

    private C2098l() {
    }

    /* renamed from: a */
    public Byte deserialize(K3.e eVar) {
        t.e(eVar, "decoder");
        return Byte.valueOf(eVar.decodeByte());
    }

    public void b(K3.f fVar, byte b5) {
        t.e(fVar, "encoder");
        fVar.encodeByte(b5);
    }

    public f getDescriptor() {
        return f18554b;
    }

    public /* bridge */ /* synthetic */ void serialize(K3.f fVar, Object obj) {
        b(fVar, ((Number) obj).byteValue());
    }
}
