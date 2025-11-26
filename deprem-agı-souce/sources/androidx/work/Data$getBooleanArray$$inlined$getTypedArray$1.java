package androidx.work;

import k3.l;

public final class Data$getBooleanArray$$inlined$getTypedArray$1 implements l {
    final /* synthetic */ Object $value;

    public Data$getBooleanArray$$inlined$getTypedArray$1(Object obj) {
        this.$value = obj;
    }

    public final Boolean invoke(int i5) {
        Object obj = ((Object[]) this.$value)[i5];
        if (obj != null) {
            return (Boolean) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
