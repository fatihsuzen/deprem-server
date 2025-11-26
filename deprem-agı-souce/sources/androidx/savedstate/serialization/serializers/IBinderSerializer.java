package androidx.savedstate.serialization.serializers;

import H3.b;
import J3.f;
import J3.m;
import K3.e;
import android.os.IBinder;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import k3.l;
import kotlin.jvm.internal.t;

public final class IBinderSerializer implements b {
    public static final IBinderSerializer INSTANCE = new IBinderSerializer();
    private static final f descriptor = m.f("android.os.IBinder", new f[0], (l) null, 4, (Object) null);

    private IBinderSerializer() {
    }

    public f getDescriptor() {
        return descriptor;
    }

    public IBinder deserialize(e eVar) {
        t.e(eVar, "decoder");
        if (eVar instanceof SavedStateDecoder) {
            SavedStateDecoder savedStateDecoder = (SavedStateDecoder) eVar;
            return SavedStateReader.m78getBinderimpl(SavedStateReader.m71constructorimpl(savedStateDecoder.getSavedState$savedstate_release()), savedStateDecoder.getKey$savedstate_release());
        }
        throw new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(INSTANCE.getDescriptor().a(), eVar).toString());
    }

    public void serialize(K3.f fVar, IBinder iBinder) {
        t.e(fVar, "encoder");
        t.e(iBinder, "value");
        if (fVar instanceof SavedStateEncoder) {
            SavedStateEncoder savedStateEncoder = (SavedStateEncoder) fVar;
            SavedStateWriter.m162putBinderimpl(SavedStateWriter.m157constructorimpl(savedStateEncoder.getSavedState$savedstate_release()), savedStateEncoder.getKey$savedstate_release(), iBinder);
            return;
        }
        throw new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(INSTANCE.getDescriptor().a(), fVar).toString());
    }
}
