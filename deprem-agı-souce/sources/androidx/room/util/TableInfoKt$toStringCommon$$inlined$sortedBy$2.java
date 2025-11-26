package androidx.room.util;

import a3.C2265a;
import androidx.room.util.TableInfo;
import java.util.Comparator;

public final class TableInfoKt$toStringCommon$$inlined$sortedBy$2<T> implements Comparator {
    public final int compare(T t5, T t6) {
        return C2265a.a(((TableInfo.Index) t5).name, ((TableInfo.Index) t6).name);
    }
}
