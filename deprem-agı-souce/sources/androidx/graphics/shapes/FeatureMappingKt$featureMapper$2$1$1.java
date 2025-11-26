package androidx.graphics.shapes;

import k3.l;
import kotlin.jvm.internal.u;

final class FeatureMappingKt$featureMapper$2$1$1 extends u implements l {
    final /* synthetic */ int $N;
    final /* synthetic */ DoubleMapper $dm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeatureMappingKt$featureMapper$2$1$1(DoubleMapper doubleMapper, int i5) {
        super(1);
        this.$dm = doubleMapper;
        this.$N = i5;
    }

    public final CharSequence invoke(int i5) {
        return Format_jvmKt.toStringWithLessPrecision(this.$dm.map(((float) i5) / ((float) this.$N)));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
