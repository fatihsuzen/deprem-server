package androidx.graphics.shapes;

import W2.s;
import k3.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

final class FeatureMappingKt$featureMapper$1$1 extends u implements l {
    public static final FeatureMappingKt$featureMapper$1$1 INSTANCE = new FeatureMappingKt$featureMapper$1$1();

    FeatureMappingKt$featureMapper$1$1() {
        super(1);
    }

    public final CharSequence invoke(s sVar) {
        t.e(sVar, "it");
        return ((Number) sVar.c()).floatValue() + " -> " + ((Number) sVar.d()).floatValue();
    }
}
