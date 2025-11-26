package androidx.work;

import k3.l;

public final class Data$getIntArray$$inlined$getTypedArray$1 implements l {
    final /* synthetic */ Object $value;

    public Data$getIntArray$$inlined$getTypedArray$1(Object obj) {
        this.$value = obj;
    }

    public final Integer invoke(int i5) {
        Object obj = ((Object[]) this.$value)[i5];
        if (obj != null) {
            return (Integer) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
