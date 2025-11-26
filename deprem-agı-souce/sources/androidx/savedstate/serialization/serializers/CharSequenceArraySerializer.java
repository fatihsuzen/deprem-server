package androidx.savedstate.serialization.serializers;

import H3.b;
import J3.f;
import J3.m;
import K3.e;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import k3.l;
import kotlin.jvm.internal.t;

public final class CharSequenceArraySerializer implements b {
    public static final CharSequenceArraySerializer INSTANCE = new CharSequenceArraySerializer();
    private static final f descriptor = m.f("kotlin.Array<kotlin.CharSequence>", new f[0], (l) null, 4, (Object) null);

    private CharSequenceArraySerializer() {
    }

    public f getDescriptor() {
        return descriptor;
    }

    public CharSequence[] deserialize(e eVar) {
        t.e(eVar, "decoder");
        if (eVar instanceof SavedStateDecoder) {
            SavedStateDecoder savedStateDecoder = (SavedStateDecoder) eVar;
            return SavedStateReader.m89getCharSequenceArrayimpl(SavedStateReader.m71constructorimpl(savedStateDecoder.getSavedState$savedstate_release()), savedStateDecoder.getKey$savedstate_release());
        }
        throw new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(INSTANCE.getDescriptor().a(), eVar).toString());
    }

    public void serialize(K3.f fVar, CharSequence[] charSequenceArr) {
        t.e(fVar, "encoder");
        t.e(charSequenceArr, "value");
        if (fVar instanceof SavedStateEncoder) {
            SavedStateEncoder savedStateEncoder = (SavedStateEncoder) fVar;
            SavedStateWriter.m168putCharSequenceArrayimpl(SavedStateWriter.m157constructorimpl(savedStateEncoder.getSavedState$savedstate_release()), savedStateEncoder.getKey$savedstate_release(), charSequenceArr);
            return;
        }
        throw new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(INSTANCE.getDescriptor().a(), fVar).toString());
    }
}
