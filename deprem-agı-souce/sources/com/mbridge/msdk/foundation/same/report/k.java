package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.af;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f9539a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9540b;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, String> f9541a = new HashMap();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final String f9542b;

        public a(String str) {
            this.f9542b = str;
        }

        public final k a() {
            return new k(this);
        }
    }

    private String b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception unused) {
            return str;
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(this.f9540b)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", this.f9540b);
                a(this.f9539a, jSONObject);
                d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b("SameCommonReporter", th.getMessage());
            }
        }
    }

    private k(a aVar) {
        this.f9540b = aVar.f9542b;
        this.f9539a = aVar.f9541a;
    }

    private void a(Map<String, String> map, JSONObject jSONObject) {
        if (map != null && !map.isEmpty() && jSONObject != null) {
            try {
                for (String next : map.keySet()) {
                    jSONObject.put(next, b(map.get(next)));
                }
            } catch (Exception e5) {
                af.b("SameCommonReporter", e5.getMessage());
            }
        }
    }
}
