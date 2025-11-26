package androidx.savedstate.serialization;

import H3.b;
import O3.d;
import O3.e;
import X2.C2250q;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.serialization.serializers.SizeFSerializer;
import androidx.savedstate.serialization.serializers.SizeSerializer;
import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import java.util.List;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;

public final class SavedStateConfig_androidKt {
    public static final d getDefaultSerializersModuleOnPlatform() {
        e eVar = new e();
        eVar.e(M.b(Size.class), SizeSerializer.INSTANCE);
        eVar.e(M.b(SizeF.class), SizeFSerializer.INSTANCE);
        eVar.c(M.b(SparseArray.class), new a());
        return eVar.f();
    }

    /* access modifiers changed from: private */
    public static final b getDefaultSerializersModuleOnPlatform$lambda$1$lambda$0(List list) {
        t.e(list, "argSerializers");
        return new SparseArraySerializer((b) C2250q.M(list));
    }
}
