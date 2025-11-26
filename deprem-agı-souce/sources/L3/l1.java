package L3;

import H3.b;
import I3.a;
import J3.f;
import K3.e;
import W2.D;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;

public final class l1 implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final l1 f18557a = new l1();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18558b = T.a("kotlin.ULong", a.F(v.f24720a));

    private l1() {
    }

    public long a(e eVar) {
        t.e(eVar, "decoder");
        return D.b(eVar.decodeInline(getDescriptor()).decodeLong());
    }

    public void b(K3.f fVar, long j5) {
        t.e(fVar, "encoder");
        fVar.encodeInline(getDescriptor()).encodeLong(j5);
    }

    public /* bridge */ /* synthetic */ Object deserialize(e eVar) {
        return D.a(a(eVar));
    }

    public f getDescriptor() {
        return f18558b;
    }

    public /* bridge */ /* synthetic */ void serialize(K3.f fVar, Object obj) {
        b(fVar, ((D) obj).f());
    }
}
