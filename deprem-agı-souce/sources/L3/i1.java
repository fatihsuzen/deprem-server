package L3;

import H3.b;
import I3.a;
import J3.f;
import K3.e;
import W2.B;
import kotlin.jvm.internal.C2640s;
import kotlin.jvm.internal.t;

public final class i1 implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final i1 f18538a = new i1();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18539b = T.a("kotlin.UInt", a.E(C2640s.f24719a));

    private i1() {
    }

    public int a(e eVar) {
        t.e(eVar, "decoder");
        return B.b(eVar.decodeInline(getDescriptor()).decodeInt());
    }

    public void b(K3.f fVar, int i5) {
        t.e(fVar, "encoder");
        fVar.encodeInline(getDescriptor()).encodeInt(i5);
    }

    public /* bridge */ /* synthetic */ Object deserialize(e eVar) {
        return B.a(a(eVar));
    }

    public f getDescriptor() {
        return f18539b;
    }

    public /* bridge */ /* synthetic */ void serialize(K3.f fVar, Object obj) {
        b(fVar, ((B) obj).f());
    }
}
