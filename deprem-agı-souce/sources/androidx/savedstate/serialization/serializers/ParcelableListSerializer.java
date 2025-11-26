package androidx.savedstate.serialization.serializers;

import H3.b;
import J3.f;
import J3.m;
import K3.e;
import android.os.Parcelable;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import java.util.List;
import k3.l;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;

public final class ParcelableListSerializer implements b {
    public static final ParcelableListSerializer INSTANCE = new ParcelableListSerializer();
    private static final f descriptor = m.f("kotlin.collections.List<android.os.Parcelable>", new f[0], (l) null, 4, (Object) null);

    private ParcelableListSerializer() {
    }

    public f getDescriptor() {
        return descriptor;
    }

    public List<Parcelable> deserialize(e eVar) {
        t.e(eVar, "decoder");
        if (eVar instanceof SavedStateDecoder) {
            SavedStateDecoder savedStateDecoder = (SavedStateDecoder) eVar;
            return SavedStateReader.m123getParcelableListimpl(SavedStateReader.m71constructorimpl(savedStateDecoder.getSavedState$savedstate_release()), savedStateDecoder.getKey$savedstate_release(), M.b(Parcelable.class));
        }
        throw new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(INSTANCE.getDescriptor().a(), eVar).toString());
    }

    public void serialize(K3.f fVar, List<? extends Parcelable> list) {
        t.e(fVar, "encoder");
        t.e(list, "value");
        if (fVar instanceof SavedStateEncoder) {
            SavedStateEncoder savedStateEncoder = (SavedStateEncoder) fVar;
            SavedStateWriter.m183putParcelableListimpl(SavedStateWriter.m157constructorimpl(savedStateEncoder.getSavedState$savedstate_release()), savedStateEncoder.getKey$savedstate_release(), list);
            return;
        }
        throw new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(INSTANCE.getDescriptor().a(), fVar).toString());
    }
}
