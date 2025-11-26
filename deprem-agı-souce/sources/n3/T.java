package N3;

import H3.a;
import M3.C2128b;
import M3.z;
import kotlin.jvm.internal.t;

public abstract class T {
    public static final Object a(C2128b bVar, String str, z zVar, a aVar) {
        t.e(bVar, "<this>");
        t.e(str, "discriminator");
        t.e(zVar, "element");
        t.e(aVar, "deserializer");
        return new G(bVar, zVar, str, aVar.getDescriptor()).decodeSerializableValue(aVar);
    }
}
