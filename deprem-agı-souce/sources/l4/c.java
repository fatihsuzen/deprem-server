package l4;

import java.util.Locale;
import k3.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;
import t3.C2777a;

public final class c extends u implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final c f25240a = new c();

    public c() {
        super(1);
    }

    public final Object invoke(Object obj) {
        String str;
        String str2 = (String) obj;
        t.e(str2, "s");
        String lowerCase = str2.toLowerCase(Locale.ROOT);
        t.d(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (lowerCase.length() <= 0) {
            return lowerCase;
        }
        StringBuilder sb = new StringBuilder();
        char charAt = lowerCase.charAt(0);
        if (Character.isLowerCase(charAt)) {
            Locale locale = Locale.getDefault();
            t.d(locale, "getDefault()");
            str = C2777a.d(charAt, locale);
        } else {
            str = String.valueOf(charAt);
        }
        sb.append(str);
        String substring = lowerCase.substring(1);
        t.d(substring, "this as java.lang.String).substring(startIndex)");
        sb.append(substring);
        return sb.toString();
    }
}
