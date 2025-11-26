package androidx.work;

import k3.l;

public final class Data$getFloatArray$$inlined$getTypedArray$1 implements l {
    final /* synthetic */ Object $value;

    public Data$getFloatArray$$inlined$getTypedArray$1(Object obj) {
        this.$value = obj;
    }

    public final Float invoke(int i5) {
        Object obj = ((Object[]) this.$value)[i5];
        if (obj != null) {
            return (Float) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
