package androidx.work;

import W2.s;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.Data;
import kotlin.jvm.internal.t;

public final class DataKt {
    public static final /* synthetic */ <T> boolean hasKeyWithValueOfType(Data data, String str) {
        t.e(data, "<this>");
        t.e(str, "key");
        t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
        return data.hasKeyWithValueOfType(str, Object.class);
    }

    public static final Data workDataOf(s... sVarArr) {
        t.e(sVarArr, "pairs");
        Data.Builder builder = new Data.Builder();
        for (s sVar : sVarArr) {
            builder.put((String) sVar.c(), sVar.d());
        }
        return builder.build();
    }
}
