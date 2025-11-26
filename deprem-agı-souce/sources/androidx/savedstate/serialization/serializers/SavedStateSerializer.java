package androidx.savedstate.serialization.serializers;

import H3.b;
import J3.f;
import J3.m;
import K3.e;
import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import k3.l;
import kotlin.jvm.internal.t;

public final class SavedStateSerializer implements b {
    public static final SavedStateSerializer INSTANCE = new SavedStateSerializer();
    private static final f descriptor = m.f("androidx.savedstate.SavedState", new f[0], (l) null, 4, (Object) null);

    private SavedStateSerializer() {
    }

    public f getDescriptor() {
        return descriptor;
    }

    public Bundle deserialize(e eVar) {
        t.e(eVar, "decoder");
        if (eVar instanceof SavedStateDecoder) {
            SavedStateDecoder savedStateDecoder = (SavedStateDecoder) eVar;
            if (t.a(savedStateDecoder.getKey$savedstate_release(), "")) {
                return savedStateDecoder.getSavedState$savedstate_release();
            }
            return SavedStateReader.m128getSavedStateimpl(SavedStateReader.m71constructorimpl(savedStateDecoder.getSavedState$savedstate_release()), savedStateDecoder.getKey$savedstate_release());
        }
        throw new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(INSTANCE.getDescriptor().a(), eVar).toString());
    }

    public void serialize(K3.f fVar, Bundle bundle) {
        t.e(fVar, "encoder");
        t.e(bundle, "value");
        if (fVar instanceof SavedStateEncoder) {
            SavedStateEncoder savedStateEncoder = (SavedStateEncoder) fVar;
            if (t.a(savedStateEncoder.getKey$savedstate_release(), "")) {
                SavedStateWriter.m161putAllimpl(SavedStateWriter.m157constructorimpl(savedStateEncoder.getSavedState$savedstate_release()), bundle);
            } else {
                SavedStateWriter.m184putSavedStateimpl(SavedStateWriter.m157constructorimpl(savedStateEncoder.getSavedState$savedstate_release()), savedStateEncoder.getKey$savedstate_release(), bundle);
            }
        } else {
            throw new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(INSTANCE.getDescriptor().a(), fVar).toString());
        }
    }
}
