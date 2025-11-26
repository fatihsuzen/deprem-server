package androidx.savedstate.serialization;

import H3.b;
import O3.d;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.SavedStateRegistryOwner;
import k3.C2616a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.w;
import n3.C2701b;
import r3.C2743m;

public final class SavedStateRegistryOwnerDelegateKt {
    public static final /* synthetic */ <T> C2701b saved(SavedStateRegistryOwner savedStateRegistryOwner, String str, SavedStateConfiguration savedStateConfiguration, C2616a aVar) {
        t.e(savedStateRegistryOwner, "<this>");
        t.e(savedStateConfiguration, "configuration");
        t.e(aVar, "init");
        d serializersModule = savedStateConfiguration.getSerializersModule();
        t.k(6, ExifInterface.GPS_DIRECTION_TRUE);
        w.a("kotlinx.serialization.serializer.withModule");
        return saved(savedStateRegistryOwner, H3.t.b(serializersModule, (C2743m) null), str, savedStateConfiguration, aVar);
    }

    public static /* synthetic */ C2701b saved$default(SavedStateRegistryOwner savedStateRegistryOwner, String str, SavedStateConfiguration savedStateConfiguration, C2616a aVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = null;
        }
        if ((i5 & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        t.e(savedStateRegistryOwner, "<this>");
        t.e(savedStateConfiguration, "configuration");
        t.e(aVar, "init");
        d serializersModule = savedStateConfiguration.getSerializersModule();
        t.k(6, ExifInterface.GPS_DIRECTION_TRUE);
        w.a("kotlinx.serialization.serializer.withModule");
        return saved(savedStateRegistryOwner, H3.t.b(serializersModule, (C2743m) null), str, savedStateConfiguration, aVar);
    }

    public static final <T> C2701b saved(SavedStateRegistryOwner savedStateRegistryOwner, b bVar, String str, SavedStateConfiguration savedStateConfiguration, C2616a aVar) {
        t.e(savedStateRegistryOwner, "<this>");
        t.e(bVar, "serializer");
        t.e(savedStateConfiguration, "configuration");
        t.e(aVar, "init");
        return new SavedStateRegistryOwnerDelegate(savedStateRegistryOwner.getSavedStateRegistry(), bVar, str, savedStateConfiguration, aVar);
    }

    public static /* synthetic */ C2701b saved$default(SavedStateRegistryOwner savedStateRegistryOwner, b bVar, String str, SavedStateConfiguration savedStateConfiguration, C2616a aVar, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = null;
        }
        if ((i5 & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return saved(savedStateRegistryOwner, bVar, str, savedStateConfiguration, aVar);
    }
}
