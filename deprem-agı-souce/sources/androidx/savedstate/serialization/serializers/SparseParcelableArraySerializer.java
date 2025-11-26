package androidx.savedstate.serialization.serializers;

import H3.b;
import J3.f;
import J3.m;
import K3.e;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import k3.l;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;

public final class SparseParcelableArraySerializer implements b {
    public static final SparseParcelableArraySerializer INSTANCE = new SparseParcelableArraySerializer();
    private static final f descriptor = m.f("android.util.SparseArray<android.os.Parcelable>", new f[0], (l) null, 4, (Object) null);

    private SparseParcelableArraySerializer() {
    }

    public f getDescriptor() {
        return descriptor;
    }

    public SparseArray<Parcelable> deserialize(e eVar) {
        t.e(eVar, "decoder");
        if (eVar instanceof SavedStateDecoder) {
            SavedStateDecoder savedStateDecoder = (SavedStateDecoder) eVar;
            return SavedStateReader.m139getSparseParcelableArrayimpl(SavedStateReader.m71constructorimpl(savedStateDecoder.getSavedState$savedstate_release()), savedStateDecoder.getKey$savedstate_release(), M.b(Parcelable.class));
        }
        throw new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(INSTANCE.getDescriptor().a(), eVar).toString());
    }

    public void serialize(K3.f fVar, SparseArray<Parcelable> sparseArray) {
        t.e(fVar, "encoder");
        t.e(sparseArray, "value");
        if (fVar instanceof SavedStateEncoder) {
            SavedStateEncoder savedStateEncoder = (SavedStateEncoder) fVar;
            SavedStateWriter.m189putSparseParcelableArrayimpl(SavedStateWriter.m157constructorimpl(savedStateEncoder.getSavedState$savedstate_release()), savedStateEncoder.getKey$savedstate_release(), sparseArray);
            return;
        }
        throw new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(INSTANCE.getDescriptor().a(), fVar).toString());
    }
}
