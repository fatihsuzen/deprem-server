package androidx.savedstate.serialization;

import H3.a;
import J3.f;
import K3.e;
import android.os.Parcelable;
import androidx.savedstate.serialization.serializers.CharSequenceArraySerializer;
import androidx.savedstate.serialization.serializers.CharSequenceListSerializer;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultJavaSerializableSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.IBinderSerializer;
import androidx.savedstate.serialization.serializers.ParcelableArraySerializer;
import androidx.savedstate.serialization.serializers.ParcelableListSerializer;
import androidx.savedstate.serialization.serializers.SparseParcelableArraySerializer;
import j3.C2582a;
import java.util.Arrays;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class SavedStateDecoder_androidKt {
    public static final <T> T decodeFormatSpecificTypesOnPlatform(SavedStateDecoder savedStateDecoder, a aVar) {
        t.e(savedStateDecoder, "<this>");
        t.e(aVar, "strategy");
        f descriptor = aVar.getDescriptor();
        if (t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceDescriptor())) {
            return CharSequenceSerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableDescriptor())) {
            return DefaultParcelableSerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicJavaSerializableDescriptor())) {
            return DefaultJavaSerializableSerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicIBinderDescriptor())) {
            return IBinderSerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (t.a(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceArrayDescriptor()) || t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceArrayDescriptor())) {
            return CharSequenceArraySerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (t.a(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceListDescriptor()) || t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceListDescriptor())) {
            return CharSequenceListSerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (t.a(descriptor, SavedStateCodecUtils_androidKt.getParcelableArrayDescriptor())) {
            Parcelable[] deserialize = ParcelableArraySerializer.INSTANCE.deserialize((e) savedStateDecoder);
            return Arrays.copyOf(deserialize, deserialize.length, C2582a.a(getArrayKClass(aVar)));
        } else if (t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableArrayDescriptor())) {
            return ParcelableArraySerializer.INSTANCE.deserialize((e) savedStateDecoder);
        } else {
            if (t.a(descriptor, SavedStateCodecUtils_androidKt.getParcelableListDescriptor()) || t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableListDescriptor())) {
                return ParcelableListSerializer.INSTANCE.deserialize((e) savedStateDecoder);
            }
            if (t.a(descriptor, SavedStateCodecUtils_androidKt.getSparseParcelableArrayDescriptor()) || t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicSparseParcelableArrayDescriptor()) || t.a(descriptor, SavedStateCodecUtils_androidKt.getNullablePolymorphicSparseParcelableArrayDescriptor())) {
                return SparseParcelableArraySerializer.INSTANCE.deserialize((e) savedStateDecoder);
            }
            return null;
        }
    }

    private static final C2733c getArrayKClass(a aVar) {
        Object deserialize = aVar.deserialize(EmptyArrayDecoder.INSTANCE);
        t.b(deserialize);
        return M.b(deserialize.getClass());
    }
}
