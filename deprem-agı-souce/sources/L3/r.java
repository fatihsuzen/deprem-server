package L3;

import H3.b;
import J3.e;
import J3.f;
import kotlin.jvm.internal.t;

public final class r implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final r f18579a = new r();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18580b = new N0("kotlin.Char", e.c.f18361a);

    private r() {
    }

    /* renamed from: a */
    public Character deserialize(K3.e eVar) {
        t.e(eVar, "decoder");
        return Character.valueOf(eVar.decodeChar());
    }

    public void b(K3.f fVar, char c5) {
        t.e(fVar, "encoder");
        fVar.encodeChar(c5);
    }

    public f getDescriptor() {
        return f18580b;
    }

    public /* bridge */ /* synthetic */ void serialize(K3.f fVar, Object obj) {
        b(fVar, ((Character) obj).charValue());
    }
}
