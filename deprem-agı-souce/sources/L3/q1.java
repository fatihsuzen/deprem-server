package L3;

import H3.b;
import J3.e;
import J3.f;
import kotlin.jvm.internal.t;
import v3.C2803a;

public final class q1 implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final q1 f18577a = new q1();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18578b = new N0("kotlin.uuid.Uuid", e.i.f18367a);

    private q1() {
    }

    /* renamed from: a */
    public C2803a deserialize(K3.e eVar) {
        t.e(eVar, "decoder");
        return C2803a.f26045c.c(eVar.decodeString());
    }

    /* renamed from: b */
    public void serialize(K3.f fVar, C2803a aVar) {
        t.e(fVar, "encoder");
        t.e(aVar, "value");
        fVar.encodeString(aVar.toString());
    }

    public f getDescriptor() {
        return f18578b;
    }
}
