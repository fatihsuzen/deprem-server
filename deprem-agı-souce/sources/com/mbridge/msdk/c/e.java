package com.mbridge.msdk.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public int f8006a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, f> f8007b;

    static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final e f8008a = new e();
    }

    public static e a() {
        return a.f8008a;
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (this.f8007b == null) {
                    this.f8007b = new HashMap<>();
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject.getString(next);
                    f fVar = new f();
                    fVar.a(next);
                    fVar.b(string);
                    this.f8007b.put(next, fVar);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    private e() {
        this.f8006a = 6;
        this.f8007b = new HashMap<>();
    }

    public final int a(String str) {
        HashMap<String, f> hashMap;
        f fVar;
        if (TextUtils.isEmpty(str) || (hashMap = this.f8007b) == null || !hashMap.containsKey(str) || (fVar = this.f8007b.get(str)) == null) {
            return 0;
        }
        int i5 = fVar.b() ? 1 : fVar.a() >= this.f8006a ? 2 : 0;
        fVar.a(false);
        return i5;
    }
}
