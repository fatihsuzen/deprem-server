package androidx.savedstate.serialization.serializers;

import H3.b;
import J3.f;
import J3.m;
import K3.e;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import java.io.Serializable;
import k3.l;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;

public abstract class JavaSerializableSerializer<T extends Serializable> implements b {
    private final f descriptor = m.f("java.io.Serializable", new f[0], (l) null, 4, (Object) null);

    public final f getDescriptor() {
        return this.descriptor;
    }

    public final T deserialize(e eVar) {
        t.e(eVar, "decoder");
        if (eVar instanceof SavedStateDecoder) {
            SavedStateDecoder savedStateDecoder = (SavedStateDecoder) eVar;
            T r32 = SavedStateReader.m109getJavaSerializableimpl(SavedStateReader.m71constructorimpl(savedStateDecoder.getSavedState$savedstate_release()), savedStateDecoder.getKey$savedstate_release(), M.b(Serializable.class));
            t.c(r32, "null cannot be cast to non-null type T of androidx.savedstate.serialization.serializers.JavaSerializableSerializer");
            return r32;
        }
        throw new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(this.descriptor.a(), eVar).toString());
    }

    public final void serialize(K3.f fVar, T t5) {
        t.e(fVar, "encoder");
        t.e(t5, "value");
        if (fVar instanceof SavedStateEncoder) {
            SavedStateEncoder savedStateEncoder = (SavedStateEncoder) fVar;
            SavedStateWriter.m177putJavaSerializableimpl(SavedStateWriter.m157constructorimpl(savedStateEncoder.getSavedState$savedstate_release()), savedStateEncoder.getKey$savedstate_release(), t5);
            return;
        }
        throw new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(this.descriptor.a(), fVar).toString());
    }
}
