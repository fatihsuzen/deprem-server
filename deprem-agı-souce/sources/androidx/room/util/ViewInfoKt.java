package androidx.room.util;

import kotlin.jvm.internal.t;
import t3.s;

public final class ViewInfoKt {
    public static final boolean equalsCommon(ViewInfo viewInfo, Object obj) {
        boolean z4;
        t.e(viewInfo, "<this>");
        if (viewInfo == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo2 = (ViewInfo) obj;
        if (t.a(viewInfo.name, viewInfo2.name)) {
            String str = viewInfo.sql;
            if (str != null) {
                z4 = t.a(str, viewInfo2.sql);
            } else if (viewInfo2.sql == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                return true;
            }
        }
        return false;
    }

    public static final int hashCodeCommon(ViewInfo viewInfo) {
        int i5;
        t.e(viewInfo, "<this>");
        int hashCode = viewInfo.name.hashCode() * 31;
        String str = viewInfo.sql;
        if (str != null) {
            i5 = str.hashCode();
        } else {
            i5 = 0;
        }
        return hashCode + i5;
    }

    public static final String toStringCommon(ViewInfo viewInfo) {
        t.e(viewInfo, "<this>");
        return s.p("\n            |ViewInfo {\n            |   name = '" + viewInfo.name + "',\n            |   sql = '" + viewInfo.sql + "'\n            |}\n        ", (String) null, 1, (Object) null);
    }
}
