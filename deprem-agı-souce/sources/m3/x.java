package M3;

import H3.b;
import J3.f;
import J3.m;
import J3.n;
import K3.e;
import N3.C2151v;
import k3.l;
import kotlin.jvm.internal.t;

public final class x implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final x f18701a = new x();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18702b = m.i("kotlinx.serialization.json.JsonNull", n.b.f18389a, new f[0], (l) null, 8, (Object) null);

    private x() {
    }

    /* renamed from: a */
    public w deserialize(e eVar) {
        t.e(eVar, "decoder");
        q.g(eVar);
        if (!eVar.decodeNotNullMark()) {
            eVar.decodeNull();
            return w.INSTANCE;
        }
        throw new C2151v("Expected 'null' literal");
    }

    /* renamed from: b */
    public void serialize(K3.f fVar, w wVar) {
        t.e(fVar, "encoder");
        t.e(wVar, "value");
        q.h(fVar);
        fVar.encodeNull();
    }

    public f getDescriptor() {
        return f18702b;
    }
}
