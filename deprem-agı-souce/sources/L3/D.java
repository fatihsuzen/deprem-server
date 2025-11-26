package L3;

import H3.b;
import J3.e;
import J3.f;
import kotlin.jvm.internal.t;
import u3.C2795a;

public final class D implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final D f18430a = new D();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18431b = new N0("kotlin.time.Duration", e.i.f18367a);

    private D() {
    }

    public long a(K3.e eVar) {
        t.e(eVar, "decoder");
        return C2795a.f25994b.c(eVar.decodeString());
    }

    public void b(K3.f fVar, long j5) {
        t.e(fVar, "encoder");
        fVar.encodeString(C2795a.G(j5));
    }

    public /* bridge */ /* synthetic */ Object deserialize(K3.e eVar) {
        return C2795a.e(a(eVar));
    }

    public f getDescriptor() {
        return f18431b;
    }

    public /* bridge */ /* synthetic */ void serialize(K3.f fVar, Object obj) {
        b(fVar, ((C2795a) obj).K());
    }
}
