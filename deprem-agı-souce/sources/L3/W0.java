package L3;

import H3.b;
import J3.e;
import J3.f;
import kotlin.jvm.internal.t;

public final class W0 implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final W0 f18494a = new W0();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18495b = new N0("kotlin.String", e.i.f18367a);

    private W0() {
    }

    /* renamed from: a */
    public String deserialize(K3.e eVar) {
        t.e(eVar, "decoder");
        return eVar.decodeString();
    }

    /* renamed from: b */
    public void serialize(K3.f fVar, String str) {
        t.e(fVar, "encoder");
        t.e(str, "value");
        fVar.encodeString(str);
    }

    public f getDescriptor() {
        return f18495b;
    }
}
