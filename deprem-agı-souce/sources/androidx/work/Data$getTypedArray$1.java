package androidx.work;

import androidx.exifinterface.media.ExifInterface;
import k3.l;
import kotlin.jvm.internal.t;

public final class Data$getTypedArray$1 implements l {
    final /* synthetic */ Object $value;

    public Data$getTypedArray$1(Object obj) {
        this.$value = obj;
    }

    public final T invoke(int i5) {
        T t5 = ((Object[]) this.$value)[i5];
        t.k(1, ExifInterface.GPS_DIRECTION_TRUE);
        return t5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
