package androidx.savedstate.serialization.serializers;

import K3.e;
import K3.f;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;

public final class BuiltInSerializerKt {
    public static final String decoderErrorMessage(String str, e eVar) {
        t.e(str, "serialName");
        t.e(eVar, "decoder");
        return "Cannot deserialize " + str + " with '" + M.b(eVar.getClass()).c() + "'. This serializer can only be used with SavedStateDecoder. Use 'decodeFromSavedState' instead.";
    }

    public static final String encoderErrorMessage(String str, f fVar) {
        t.e(str, "serialName");
        t.e(fVar, "encoder");
        return "Cannot serialize " + str + " with '" + M.b(fVar.getClass()).c() + "'. This serializer can only be used with SavedStateEncoder. Use 'encodeToSavedState' instead.";
    }
}
