package l4;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Locale;
import kotlin.jvm.internal.t;

public abstract class b {
    public static String a(String str, Integer num, String str2) {
        t.e(str, RewardPlus.NAME);
        t.e(str2, "noun");
        if (num == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" (");
        sb.append(num);
        sb.append(' ');
        String lowerCase = str2.toLowerCase(Locale.ROOT);
        t.d(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        sb.append(lowerCase);
        sb.append(')');
        return sb.toString();
    }
}
