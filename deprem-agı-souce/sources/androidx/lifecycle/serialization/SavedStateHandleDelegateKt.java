package androidx.lifecycle.serialization;

import H3.b;
import O3.d;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.serialization.SavedStateConfiguration;
import k3.C2616a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.w;
import n3.C2701b;
import r3.C2743m;

public final class SavedStateHandleDelegateKt {
    public static final /* synthetic */ <T> C2701b saved(SavedStateHandle savedStateHandle, String str, SavedStateConfiguration savedStateConfiguration, C2616a aVar) {
        t.e(savedStateHandle, "<this>");
        t.e(savedStateConfiguration, "configuration");
        t.e(aVar, "init");
        d serializersModule = savedStateConfiguration.getSerializersModule();
        t.k(6, ExifInterface.GPS_DIRECTION_TRUE);
        w.a("kotlinx.serialization.serializer.withModule");
        return saved(savedStateHandle, H3.t.b(serializersModule, (C2743m) null), str, savedStateConfiguration, aVar);
    }

    public static /* synthetic */ C2701b saved$default(SavedStateHandle savedStateHandle, String str, SavedStateConfiguration savedStateConfiguration, C2616a aVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = null;
        }
        if ((i5 & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        t.e(savedStateHandle, "<this>");
        t.e(savedStateConfiguration, "configuration");
        t.e(aVar, "init");
        d serializersModule = savedStateConfiguration.getSerializersModule();
        t.k(6, ExifInterface.GPS_DIRECTION_TRUE);
        w.a("kotlinx.serialization.serializer.withModule");
        return saved(savedStateHandle, H3.t.b(serializersModule, (C2743m) null), str, savedStateConfiguration, aVar);
    }

    public static final <T> C2701b saved(SavedStateHandle savedStateHandle, b bVar, String str, SavedStateConfiguration savedStateConfiguration, C2616a aVar) {
        t.e(savedStateHandle, "<this>");
        t.e(bVar, "serializer");
        t.e(savedStateConfiguration, "configuration");
        t.e(aVar, "init");
        return new SavedStateHandleDelegate(savedStateHandle, bVar, str, savedStateConfiguration, aVar);
    }

    public static /* synthetic */ C2701b saved$default(SavedStateHandle savedStateHandle, b bVar, String str, SavedStateConfiguration savedStateConfiguration, C2616a aVar, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = null;
        }
        if ((i5 & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return saved(savedStateHandle, bVar, str, savedStateConfiguration, aVar);
    }
}
