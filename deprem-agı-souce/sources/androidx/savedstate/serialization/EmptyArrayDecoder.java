package androidx.savedstate.serialization;

import K3.a;
import O3.d;
import O3.f;
import kotlin.jvm.internal.t;

final class EmptyArrayDecoder extends a {
    public static final EmptyArrayDecoder INSTANCE = new EmptyArrayDecoder();
    private static final d serializersModule = f.a();

    private EmptyArrayDecoder() {
    }

    public int decodeElementIndex(J3.f fVar) {
        t.e(fVar, "descriptor");
        return -1;
    }

    public d getSerializersModule() {
        return serializersModule;
    }
}
