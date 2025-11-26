package androidx.room.util;

import X2.C2250q;
import kotlin.jvm.internal.t;
import t3.s;

public final class FtsTableInfoKt {
    public static final boolean equalsCommon(FtsTableInfo ftsTableInfo, Object obj) {
        t.e(ftsTableInfo, "<this>");
        if (ftsTableInfo == obj) {
            return true;
        }
        if (!(obj instanceof FtsTableInfo)) {
            return false;
        }
        FtsTableInfo ftsTableInfo2 = (FtsTableInfo) obj;
        if (t.a(ftsTableInfo.name, ftsTableInfo2.name) && t.a(ftsTableInfo.columns, ftsTableInfo2.columns)) {
            return t.a(ftsTableInfo.options, ftsTableInfo2.options);
        }
        return false;
    }

    public static final int hashCodeCommon(FtsTableInfo ftsTableInfo) {
        t.e(ftsTableInfo, "<this>");
        return (((ftsTableInfo.name.hashCode() * 31) + ftsTableInfo.columns.hashCode()) * 31) + ftsTableInfo.options.hashCode();
    }

    public static final String toStringCommon(FtsTableInfo ftsTableInfo) {
        t.e(ftsTableInfo, "<this>");
        return s.p("\n            |FtsTableInfo {\n            |   name = '" + ftsTableInfo.name + "',\n            |   columns = {" + TableInfoKt.formatString(C2250q.g0(ftsTableInfo.columns)) + "\n            |   options = {" + TableInfoKt.formatString(C2250q.g0(ftsTableInfo.options)) + "\n            |}\n        ", (String) null, 1, (Object) null);
    }
}
