package androidx.savedstate.serialization.serializers;

import H3.b;
import J3.f;
import J3.m;
import K3.e;
import android.util.Size;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import k3.l;
import kotlin.jvm.internal.t;

public final class SizeSerializer implements b {
    public static final SizeSerializer INSTANCE = new SizeSerializer();
    private static final f descriptor = m.f("android.util.Size", new f[0], (l) null, 4, (Object) null);

    private SizeSerializer() {
    }

    public f getDescriptor() {
        return descriptor;
    }

    public Size deserialize(e eVar) {
        t.e(eVar, "decoder");
        if (eVar instanceof SavedStateDecoder) {
            SavedStateDecoder savedStateDecoder = (SavedStateDecoder) eVar;
            return SavedStateReader.m134getSizeimpl(SavedStateReader.m71constructorimpl(savedStateDecoder.getSavedState$savedstate_release()), savedStateDecoder.getKey$savedstate_release());
        }
        throw new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(INSTANCE.getDescriptor().a(), eVar).toString());
    }

    public void serialize(K3.f fVar, Size size) {
        t.e(fVar, "encoder");
        t.e(size, "value");
        if (fVar instanceof SavedStateEncoder) {
            SavedStateEncoder savedStateEncoder = (SavedStateEncoder) fVar;
            SavedStateWriter.m187putSizeimpl(SavedStateWriter.m157constructorimpl(savedStateEncoder.getSavedState$savedstate_release()), savedStateEncoder.getKey$savedstate_release(), size);
            return;
        }
        throw new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(INSTANCE.getDescriptor().a(), fVar).toString());
    }
}
