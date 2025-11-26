package androidx.savedstate.serialization;

import H3.g;
import I3.a;
import J3.f;
import android.os.IBinder;
import android.os.Parcelable;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import java.io.Serializable;
import kotlin.jvm.internal.M;

public final class SavedStateCodecUtils_androidKt {
    private static final f charSequenceArrayDescriptor;
    private static final f charSequenceListDescriptor;
    private static final f nullablePolymorphicSparseParcelableArrayDescriptor;
    private static final f parcelableArrayDescriptor;
    private static final f parcelableListDescriptor;
    private static final f polymorphicCharSequenceArrayDescriptor;
    private static final f polymorphicCharSequenceDescriptor;
    private static final f polymorphicCharSequenceListDescriptor;
    private static final f polymorphicIBinderDescriptor = new g(M.b(IBinder.class)).getDescriptor();
    private static final f polymorphicJavaSerializableDescriptor = new g(M.b(Serializable.class)).getDescriptor();
    private static final f polymorphicParcelableArrayDescriptor;
    private static final f polymorphicParcelableDescriptor;
    private static final f polymorphicParcelableListDescriptor;
    private static final f polymorphicSparseParcelableArrayDescriptor;
    private static final f sparseParcelableArrayDescriptor;

    static {
        Class<CharSequence> cls = CharSequence.class;
        polymorphicCharSequenceDescriptor = new g(M.b(cls)).getDescriptor();
        Class<Parcelable> cls2 = Parcelable.class;
        polymorphicParcelableDescriptor = new g(M.b(cls2)).getDescriptor();
        DefaultParcelableSerializer defaultParcelableSerializer = DefaultParcelableSerializer.INSTANCE;
        parcelableArrayDescriptor = a.a(M.b(cls2), defaultParcelableSerializer).getDescriptor();
        polymorphicParcelableArrayDescriptor = a.a(M.b(cls2), new g(M.b(cls2))).getDescriptor();
        parcelableListDescriptor = a.h(defaultParcelableSerializer).getDescriptor();
        polymorphicParcelableListDescriptor = a.h(new g(M.b(cls2))).getDescriptor();
        CharSequenceSerializer charSequenceSerializer = CharSequenceSerializer.INSTANCE;
        charSequenceArrayDescriptor = a.a(M.b(cls), charSequenceSerializer).getDescriptor();
        polymorphicCharSequenceArrayDescriptor = a.a(M.b(cls), new g(M.b(cls))).getDescriptor();
        charSequenceListDescriptor = a.h(charSequenceSerializer).getDescriptor();
        polymorphicCharSequenceListDescriptor = a.h(new g(M.b(cls))).getDescriptor();
        sparseParcelableArrayDescriptor = new SparseArraySerializer(defaultParcelableSerializer).getDescriptor();
        polymorphicSparseParcelableArrayDescriptor = new SparseArraySerializer(new g(M.b(cls2))).getDescriptor();
        nullablePolymorphicSparseParcelableArrayDescriptor = new SparseArraySerializer(a.t(new g(M.b(cls2)))).getDescriptor();
    }

    public static final f getCharSequenceArrayDescriptor() {
        return charSequenceArrayDescriptor;
    }

    public static /* synthetic */ void getCharSequenceArrayDescriptor$annotations() {
    }

    public static final f getCharSequenceListDescriptor() {
        return charSequenceListDescriptor;
    }

    public static final f getNullablePolymorphicSparseParcelableArrayDescriptor() {
        return nullablePolymorphicSparseParcelableArrayDescriptor;
    }

    public static final f getParcelableArrayDescriptor() {
        return parcelableArrayDescriptor;
    }

    public static /* synthetic */ void getParcelableArrayDescriptor$annotations() {
    }

    public static final f getParcelableListDescriptor() {
        return parcelableListDescriptor;
    }

    public static final f getPolymorphicCharSequenceArrayDescriptor() {
        return polymorphicCharSequenceArrayDescriptor;
    }

    public static /* synthetic */ void getPolymorphicCharSequenceArrayDescriptor$annotations() {
    }

    public static final f getPolymorphicCharSequenceDescriptor() {
        return polymorphicCharSequenceDescriptor;
    }

    public static final f getPolymorphicCharSequenceListDescriptor() {
        return polymorphicCharSequenceListDescriptor;
    }

    public static final f getPolymorphicIBinderDescriptor() {
        return polymorphicIBinderDescriptor;
    }

    public static final f getPolymorphicJavaSerializableDescriptor() {
        return polymorphicJavaSerializableDescriptor;
    }

    public static final f getPolymorphicParcelableArrayDescriptor() {
        return polymorphicParcelableArrayDescriptor;
    }

    public static /* synthetic */ void getPolymorphicParcelableArrayDescriptor$annotations() {
    }

    public static final f getPolymorphicParcelableDescriptor() {
        return polymorphicParcelableDescriptor;
    }

    public static final f getPolymorphicParcelableListDescriptor() {
        return polymorphicParcelableListDescriptor;
    }

    public static final f getPolymorphicSparseParcelableArrayDescriptor() {
        return polymorphicSparseParcelableArrayDescriptor;
    }

    public static final f getSparseParcelableArrayDescriptor() {
        return sparseParcelableArrayDescriptor;
    }
}
