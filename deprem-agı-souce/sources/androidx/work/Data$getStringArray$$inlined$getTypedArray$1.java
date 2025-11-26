package androidx.work;

import k3.l;

public final class Data$getStringArray$$inlined$getTypedArray$1 implements l {
    final /* synthetic */ Object $value;

    public Data$getStringArray$$inlined$getTypedArray$1(Object obj) {
        this.$value = obj;
    }

    public final String invoke(int i5) {
        Object obj = ((Object[]) this.$value)[i5];
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
