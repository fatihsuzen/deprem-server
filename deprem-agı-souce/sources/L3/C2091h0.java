package L3;

import H3.b;
import J3.e;
import J3.f;
import kotlin.jvm.internal.t;

/* renamed from: L3.h0  reason: case insensitive filesystem */
public final class C2091h0 implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final C2091h0 f18531a = new C2091h0();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18532b = new N0("kotlin.Long", e.g.f18365a);

    private C2091h0() {
    }

    /* renamed from: a */
    public Long deserialize(K3.e eVar) {
        t.e(eVar, "decoder");
        return Long.valueOf(eVar.decodeLong());
    }

    public void b(K3.f fVar, long j5) {
        t.e(fVar, "encoder");
        fVar.encodeLong(j5);
    }

    public f getDescriptor() {
        return f18532b;
    }

    public /* bridge */ /* synthetic */ void serialize(K3.f fVar, Object obj) {
        b(fVar, ((Number) obj).longValue());
    }
}
