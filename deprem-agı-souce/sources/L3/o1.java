package L3;

import H3.b;
import I3.a;
import J3.f;
import K3.e;
import W2.G;
import kotlin.jvm.internal.O;
import kotlin.jvm.internal.t;

public final class o1 implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final o1 f18565a = new o1();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18566b = T.a("kotlin.UShort", a.G(O.f24693a));

    private o1() {
    }

    public short a(e eVar) {
        t.e(eVar, "decoder");
        return G.b(eVar.decodeInline(getDescriptor()).decodeShort());
    }

    public void b(K3.f fVar, short s5) {
        t.e(fVar, "encoder");
        fVar.encodeInline(getDescriptor()).encodeShort(s5);
    }

    public /* bridge */ /* synthetic */ Object deserialize(e eVar) {
        return G.a(a(eVar));
    }

    public f getDescriptor() {
        return f18566b;
    }

    public /* bridge */ /* synthetic */ void serialize(K3.f fVar, Object obj) {
        b(fVar, ((G) obj).f());
    }
}
