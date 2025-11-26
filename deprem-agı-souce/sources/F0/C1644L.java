package f0;

import N.C0722p;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

/* renamed from: f0.L  reason: case insensitive filesystem */
public abstract class C1644L {
    public static String a(Context context, String str, String str2) {
        C0722p.k(context);
        Resources resources = context.getResources();
        if (TextUtils.isEmpty(str2)) {
            str2 = C1661p.a(context);
        }
        return C1661p.b("google_app_id", resources, str2);
    }

    public static String b(String str, String[] strArr, String[] strArr2) {
        C0722p.k(strArr);
        C0722p.k(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i5 = 0; i5 < min; i5++) {
            String str2 = strArr[i5];
            if ((str == null && str2 == null) || (str != null && str.equals(str2))) {
                return strArr2[i5];
            }
        }
        return null;
    }
}
