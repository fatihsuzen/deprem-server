package androidx.savedstate.serialization;

import O3.d;
import O3.e;
import O3.h;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.SavedStateConfiguration;
import androidx.savedstate.serialization.serializers.SavedStateSerializer;
import k3.l;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;

public final class SavedStateConfigurationKt {
    /* access modifiers changed from: private */
    public static final d DEFAULT_SERIALIZERS_MODULE;

    static {
        e eVar = new e();
        eVar.e(M.b(Bundle.class), SavedStateSerializer.INSTANCE);
        DEFAULT_SERIALIZERS_MODULE = h.c(eVar.f(), SavedStateConfig_androidKt.getDefaultSerializersModuleOnPlatform());
    }

    public static final SavedStateConfiguration SavedStateConfiguration(l lVar) {
        t.e(lVar, "builderAction");
        return SavedStateConfiguration$default((SavedStateConfiguration) null, lVar, 1, (Object) null);
    }

    public static /* synthetic */ SavedStateConfiguration SavedStateConfiguration$default(SavedStateConfiguration savedStateConfiguration, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return SavedStateConfiguration(savedStateConfiguration, lVar);
    }

    public static final SavedStateConfiguration SavedStateConfiguration(SavedStateConfiguration savedStateConfiguration, l lVar) {
        t.e(savedStateConfiguration, TypedValues.TransitionType.S_FROM);
        t.e(lVar, "builderAction");
        SavedStateConfiguration.Builder builder = new SavedStateConfiguration.Builder(savedStateConfiguration);
        lVar.invoke(builder);
        return builder.build$savedstate_release();
    }
}
