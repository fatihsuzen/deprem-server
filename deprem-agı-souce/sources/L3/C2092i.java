package L3;

import H3.b;
import J3.e;
import J3.f;
import kotlin.jvm.internal.t;

/* renamed from: L3.i  reason: case insensitive filesystem */
public final class C2092i implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final C2092i f18534a = new C2092i();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18535b = new N0("kotlin.Boolean", e.a.f18359a);

    private C2092i() {
    }

    /* renamed from: a */
    public Boolean deserialize(K3.e eVar) {
        t.e(eVar, "decoder");
        return Boolean.valueOf(eVar.decodeBoolean());
    }

    public void b(K3.f fVar, boolean z4) {
        t.e(fVar, "encoder");
        fVar.encodeBoolean(z4);
    }

    public f getDescriptor() {
        return f18535b;
    }

    public /* bridge */ /* synthetic */ void serialize(K3.f fVar, Object obj) {
        b(fVar, ((Boolean) obj).booleanValue());
    }
}
