package androidx.savedstate.serialization;

import H3.l;
import O3.d;
import W2.s;
import W2.y;
import X2.M;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.w;
import r3.C2743m;

public final class SavedStateEncoderKt {
    public static final <T> Bundle encodeToSavedState(l lVar, T t5) {
        t.e(lVar, "serializer");
        t.e(t5, "value");
        return encodeToSavedState$default(lVar, t5, (SavedStateConfiguration) null, 4, (Object) null);
    }

    public static /* synthetic */ Bundle encodeToSavedState$default(Object obj, SavedStateConfiguration savedStateConfiguration, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        t.e(obj, "value");
        t.e(savedStateConfiguration, "configuration");
        d serializersModule = savedStateConfiguration.getSerializersModule();
        t.k(6, ExifInterface.GPS_DIRECTION_TRUE);
        w.a("kotlinx.serialization.serializer.withModule");
        return encodeToSavedState(H3.t.b(serializersModule, (C2743m) null), obj, savedStateConfiguration);
    }

    public static final /* synthetic */ <T> Bundle encodeToSavedState(T t5, SavedStateConfiguration savedStateConfiguration) {
        t.e(t5, "value");
        t.e(savedStateConfiguration, "configuration");
        d serializersModule = savedStateConfiguration.getSerializersModule();
        t.k(6, ExifInterface.GPS_DIRECTION_TRUE);
        w.a("kotlinx.serialization.serializer.withModule");
        return encodeToSavedState(H3.t.b(serializersModule, (C2743m) null), t5, savedStateConfiguration);
    }

    public static final <T> Bundle encodeToSavedState(l lVar, T t5, SavedStateConfiguration savedStateConfiguration) {
        s[] sVarArr;
        t.e(lVar, "serializer");
        t.e(t5, "value");
        t.e(savedStateConfiguration, "configuration");
        Map h5 = M.h();
        if (h5.isEmpty()) {
            sVarArr = new s[0];
        } else {
            ArrayList arrayList = new ArrayList(h5.size());
            for (Map.Entry entry : h5.entrySet()) {
                arrayList.add(y.a((String) entry.getKey(), entry.getValue()));
            }
            sVarArr = (s[]) arrayList.toArray(new s[0]);
        }
        Bundle bundleOf = BundleKt.bundleOf((s[]) Arrays.copyOf(sVarArr, sVarArr.length));
        SavedStateWriter.m157constructorimpl(bundleOf);
        new SavedStateEncoder(bundleOf, savedStateConfiguration).encodeSerializableValue(lVar, t5);
        return bundleOf;
    }

    public static /* synthetic */ Bundle encodeToSavedState$default(l lVar, Object obj, SavedStateConfiguration savedStateConfiguration, int i5, Object obj2) {
        if ((i5 & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return encodeToSavedState(lVar, obj, savedStateConfiguration);
    }
}
