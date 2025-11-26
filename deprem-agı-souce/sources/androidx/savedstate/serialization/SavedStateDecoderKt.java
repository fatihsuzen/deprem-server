package androidx.savedstate.serialization;

import H3.a;
import O3.d;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.w;
import r3.C2743m;

public final class SavedStateDecoderKt {
    public static final <T> T decodeFromSavedState(a aVar, Bundle bundle) {
        t.e(aVar, "deserializer");
        t.e(bundle, "savedState");
        return decodeFromSavedState$default(aVar, bundle, (SavedStateConfiguration) null, 4, (Object) null);
    }

    public static /* synthetic */ Object decodeFromSavedState$default(Bundle bundle, SavedStateConfiguration savedStateConfiguration, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        t.e(bundle, "savedState");
        t.e(savedStateConfiguration, "configuration");
        d serializersModule = savedStateConfiguration.getSerializersModule();
        t.k(6, ExifInterface.GPS_DIRECTION_TRUE);
        w.a("kotlinx.serialization.serializer.withModule");
        return decodeFromSavedState(H3.t.b(serializersModule, (C2743m) null), bundle, savedStateConfiguration);
    }

    public static final /* synthetic */ <T> T decodeFromSavedState(Bundle bundle, SavedStateConfiguration savedStateConfiguration) {
        t.e(bundle, "savedState");
        t.e(savedStateConfiguration, "configuration");
        d serializersModule = savedStateConfiguration.getSerializersModule();
        t.k(6, ExifInterface.GPS_DIRECTION_TRUE);
        w.a("kotlinx.serialization.serializer.withModule");
        return decodeFromSavedState(H3.t.b(serializersModule, (C2743m) null), bundle, savedStateConfiguration);
    }

    public static final <T> T decodeFromSavedState(a aVar, Bundle bundle, SavedStateConfiguration savedStateConfiguration) {
        t.e(aVar, "deserializer");
        t.e(bundle, "savedState");
        t.e(savedStateConfiguration, "configuration");
        return new SavedStateDecoder(bundle, savedStateConfiguration).decodeSerializableValue(aVar);
    }

    public static /* synthetic */ Object decodeFromSavedState$default(a aVar, Bundle bundle, SavedStateConfiguration savedStateConfiguration, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return decodeFromSavedState(aVar, bundle, savedStateConfiguration);
    }
}
