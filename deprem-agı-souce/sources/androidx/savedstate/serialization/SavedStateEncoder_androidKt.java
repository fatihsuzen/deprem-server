package androidx.savedstate.serialization;

import H3.l;
import J3.f;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.savedstate.serialization.serializers.CharSequenceArraySerializer;
import androidx.savedstate.serialization.serializers.CharSequenceListSerializer;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultJavaSerializableSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.IBinderSerializer;
import androidx.savedstate.serialization.serializers.ParcelableArraySerializer;
import androidx.savedstate.serialization.serializers.ParcelableListSerializer;
import androidx.savedstate.serialization.serializers.SparseParcelableArraySerializer;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.t;

public final class SavedStateEncoder_androidKt {
    public static final <T> boolean encodeFormatSpecificTypesOnPlatform(SavedStateEncoder savedStateEncoder, l lVar, T t5) {
        t.e(savedStateEncoder, "<this>");
        t.e(lVar, "strategy");
        f descriptor = lVar.getDescriptor();
        if (t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceDescriptor())) {
            CharSequenceSerializer charSequenceSerializer = CharSequenceSerializer.INSTANCE;
            t.c(t5, "null cannot be cast to non-null type kotlin.CharSequence");
            charSequenceSerializer.serialize((K3.f) savedStateEncoder, (CharSequence) t5);
            return true;
        } else if (t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableDescriptor())) {
            DefaultParcelableSerializer defaultParcelableSerializer = DefaultParcelableSerializer.INSTANCE;
            t.c(t5, "null cannot be cast to non-null type android.os.Parcelable");
            defaultParcelableSerializer.serialize((K3.f) savedStateEncoder, (Parcelable) t5);
            return true;
        } else if (t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicJavaSerializableDescriptor())) {
            DefaultJavaSerializableSerializer defaultJavaSerializableSerializer = DefaultJavaSerializableSerializer.INSTANCE;
            t.c(t5, "null cannot be cast to non-null type java.io.Serializable");
            defaultJavaSerializableSerializer.serialize((K3.f) savedStateEncoder, (Serializable) t5);
            return true;
        } else if (t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicIBinderDescriptor())) {
            IBinderSerializer iBinderSerializer = IBinderSerializer.INSTANCE;
            t.c(t5, "null cannot be cast to non-null type android.os.IBinder");
            iBinderSerializer.serialize((K3.f) savedStateEncoder, (IBinder) t5);
            return true;
        } else if (t.a(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceArrayDescriptor()) || t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceArrayDescriptor())) {
            CharSequenceArraySerializer charSequenceArraySerializer = CharSequenceArraySerializer.INSTANCE;
            t.c(t5, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
            charSequenceArraySerializer.serialize((K3.f) savedStateEncoder, (CharSequence[]) t5);
            return true;
        } else if (t.a(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceListDescriptor()) || t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceListDescriptor())) {
            CharSequenceListSerializer charSequenceListSerializer = CharSequenceListSerializer.INSTANCE;
            t.c(t5, "null cannot be cast to non-null type kotlin.collections.List<kotlin.CharSequence>");
            charSequenceListSerializer.serialize((K3.f) savedStateEncoder, (List<? extends CharSequence>) (List) t5);
            return true;
        } else if (t.a(descriptor, SavedStateCodecUtils_androidKt.getParcelableArrayDescriptor()) || t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableArrayDescriptor())) {
            ParcelableArraySerializer parcelableArraySerializer = ParcelableArraySerializer.INSTANCE;
            t.c(t5, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
            parcelableArraySerializer.serialize((K3.f) savedStateEncoder, (Parcelable[]) t5);
            return true;
        } else if (t.a(descriptor, SavedStateCodecUtils_androidKt.getParcelableListDescriptor()) || t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableListDescriptor())) {
            ParcelableListSerializer parcelableListSerializer = ParcelableListSerializer.INSTANCE;
            t.c(t5, "null cannot be cast to non-null type kotlin.collections.List<android.os.Parcelable>");
            parcelableListSerializer.serialize((K3.f) savedStateEncoder, (List<? extends Parcelable>) (List) t5);
            return true;
        } else if (!t.a(descriptor, SavedStateCodecUtils_androidKt.getSparseParcelableArrayDescriptor()) && !t.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicSparseParcelableArrayDescriptor()) && !t.a(descriptor, SavedStateCodecUtils_androidKt.getNullablePolymorphicSparseParcelableArrayDescriptor())) {
            return false;
        } else {
            SparseParcelableArraySerializer sparseParcelableArraySerializer = SparseParcelableArraySerializer.INSTANCE;
            t.c(t5, "null cannot be cast to non-null type android.util.SparseArray<android.os.Parcelable>");
            sparseParcelableArraySerializer.serialize((K3.f) savedStateEncoder, (SparseArray<Parcelable>) (SparseArray) t5);
            return true;
        }
    }
}
