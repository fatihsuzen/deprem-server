package N3;

import H3.l;
import M3.C2128b;
import M3.r;
import kotlin.jvm.internal.t;

public abstract class E {
    public static final void a(C2128b bVar, C2149t tVar, l lVar, Object obj) {
        t.e(bVar, "json");
        t.e(tVar, "writer");
        t.e(lVar, "serializer");
        new M(tVar, bVar, U.OBJ, new r[U.b().size()]).encodeSerializableValue(lVar, obj);
    }
}
