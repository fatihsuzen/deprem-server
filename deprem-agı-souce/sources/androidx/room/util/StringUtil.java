package androidx.room.util;

import X2.C2250q;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.List;
import k3.l;
import kotlin.jvm.internal.t;
import t3.s;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static final void appendPlaceholders(StringBuilder sb, int i5) {
        t.e(sb, "builder");
        for (int i6 = 0; i6 < i5; i6++) {
            sb.append("?");
            if (i6 < i5 - 1) {
                sb.append(",");
            }
        }
    }

    public static /* synthetic */ void getEMPTY_STRING_ARRAY$annotations() {
    }

    public static final String joinIntoString(List<Integer> list) {
        if (list != null) {
            return C2250q.V(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null);
        }
        return null;
    }

    public static final StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    public static final List<Integer> splitToIntList(String str) {
        List<String> F02;
        Integer num;
        if (str == null || (F02 = s.F0(str, new char[]{','}, false, 0, 6, (Object) null)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String parseInt : F02) {
            try {
                num = Integer.valueOf(Integer.parseInt(parseInt));
            } catch (NumberFormatException unused) {
                num = null;
            }
            if (num != null) {
                arrayList.add(num);
            }
        }
        return arrayList;
    }
}
