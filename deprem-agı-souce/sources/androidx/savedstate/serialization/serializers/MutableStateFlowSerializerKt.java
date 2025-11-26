package androidx.savedstate.serialization.serializers;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.w;
import r3.C2743m;

public final class MutableStateFlowSerializerKt {
    public static final /* synthetic */ <T> MutableStateFlowSerializer<T> MutableStateFlowSerializer() {
        t.k(6, ExifInterface.GPS_DIRECTION_TRUE);
        w.a("kotlinx.serialization.serializer.simple");
        return new MutableStateFlowSerializer<>(H3.t.c((C2743m) null));
    }
}
