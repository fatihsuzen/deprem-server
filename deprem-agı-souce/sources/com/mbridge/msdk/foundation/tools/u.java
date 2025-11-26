package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.report.i;
import java.lang.reflect.Method;

public class u {
    public static void mia(Context context, String str) {
        String str2 = null;
        try {
            Object invoke = context.getClass().getMethod(z.a("HF5TNFK/J75/JczQhFKsJr5B"), (Class[]) null).invoke(context, (Object[]) null);
            if (invoke != null) {
                Method method = invoke.getClass().getMethod(z.a("HF5T5dQMHN=="), new Class[]{Uri.class});
                StringBuilder sb = new StringBuilder();
                sb.append(z.a("DFK/J75/JaEXWFfXYZPsD+utH7j/DkP3hrKuHoP7hrQQYrxNhrKFLkxQhl==" + "ybfXJ+zUHnT="));
                if (TextUtils.isEmpty(str)) {
                    str = z.a("n+xg");
                }
                sb.append(str);
                str2 = (String) method.invoke(invoke, new Object[]{Uri.parse(sb.toString())});
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                af.b("MiaUtil", th.getMessage());
            }
        }
        i.b(str2);
    }
}
