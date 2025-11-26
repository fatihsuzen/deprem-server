package com.mbridge.msdk.foundation.db.a;

import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.k;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public com.mbridge.msdk.foundation.same.a.a f8940a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public k f8941b;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static b f8945a = new b();
    }

    private b() {
        this.f8940a = new com.mbridge.msdk.foundation.same.a.a(1000);
        try {
            k a5 = k.a((f) g.a(c.m().c()));
            this.f8941b = a5;
            a(a5.a(), false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(JSONObject jSONObject, final boolean z4) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            final com.mbridge.msdk.foundation.same.a.a aVar = new com.mbridge.msdk.foundation.same.a.a(100);
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                this.f8940a.a(next, optJSONObject);
                aVar.a(next, optJSONObject);
            }
            com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() {
                public final void run() {
                    if (z4 && b.this.f8941b != null) {
                        for (String next : aVar.a()) {
                            b.this.f8941b.a(next, b.this.f8940a.a(next));
                        }
                    }
                }
            });
        }
    }

    public final JSONArray b() {
        return new JSONArray(this.f8940a.a());
    }

    public static b a() {
        return a.f8945a;
    }

    public final JSONObject a(String str) {
        k kVar;
        JSONObject a5 = this.f8940a.a(str);
        if (a5 != null || (kVar = this.f8941b) == null) {
            return a5;
        }
        JSONObject a6 = kVar.a(str);
        if (a6 != null) {
            this.f8940a.a(str, a6);
        }
        return a6;
    }
}
