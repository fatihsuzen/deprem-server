package com.mbridge.msdk.foundation.same.net.e;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.foundation.tools.aq;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9331a = "b";

    public static void a(e eVar, String str, String str2) {
        if (eVar != null) {
            try {
                if (ap.a(str)) {
                    return;
                }
                if (!ap.a(str2)) {
                    eVar.a(str, str2);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public static void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith("http")) {
                    str = aq.a(str);
                }
                TextUtils.isEmpty(str);
            }
        } catch (Throwable th) {
            af.b(f9331a, th.getMessage());
        }
    }
}
