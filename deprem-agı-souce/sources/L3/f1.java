package L3;

import H3.b;
import I3.a;
import J3.f;
import K3.e;
import W2.z;
import kotlin.jvm.internal.C2627e;
import kotlin.jvm.internal.t;

public final class f1 implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final f1 f18523a = new f1();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18524b = T.a("kotlin.UByte", a.A(C2627e.f24706a));

    private f1() {
    }

    public byte a(e eVar) {
        t.e(eVar, "decoder");
        return z.b(eVar.decodeInline(getDescriptor()).decodeByte());
    }

    public void b(K3.f fVar, byte b5) {
        t.e(fVar, "encoder");
        fVar.encodeInline(getDescriptor()).encodeByte(b5);
    }

    public /* bridge */ /* synthetic */ Object deserialize(e eVar) {
        return z.a(a(eVar));
    }

    public f getDescriptor() {
        return f18524b;
    }

    public /* bridge */ /* synthetic */ void serialize(K3.f fVar, Object obj) {
        b(fVar, ((z) obj).f());
    }
}
