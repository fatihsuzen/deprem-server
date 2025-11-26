package q4;

import J2.a;
import android.app.Application;
import android.content.Context;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.LinkedHashMap;
import java.util.Locale;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements i {

    /* renamed from: a  reason: collision with root package name */
    public final Context f25700a;

    /* renamed from: b  reason: collision with root package name */
    public final Locale f25701b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f25702c;

    public b(Application application, Locale locale) {
        t.e(application, "context");
        t.e(locale, "appLocale");
        this.f25700a = application;
        this.f25701b = locale;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        h3.C2453b.a(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "jsonString"
            kotlin.jvm.internal.t.e(r6, r0)
            int r0 = r6.length()     // Catch:{ JSONException -> 0x0074 }
            r1 = 0
            if (r0 != 0) goto L_0x0031
            android.content.Context r6 = r5.f25700a     // Catch:{ JSONException -> 0x0074 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ JSONException -> 0x0074 }
            int r0 = E1.d.cmp_list     // Catch:{ JSONException -> 0x0074 }
            java.io.InputStream r6 = r6.openRawResource(r0)     // Catch:{ JSONException -> 0x0074 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ JSONException -> 0x0074 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ JSONException -> 0x0074 }
            r2.<init>(r6)     // Catch:{ JSONException -> 0x0074 }
            r0.<init>(r2)     // Catch:{ JSONException -> 0x0074 }
            java.lang.String r6 = r0.readLine()     // Catch:{ all -> 0x002a }
            h3.C2453b.a(r0, r1)     // Catch:{ JSONException -> 0x0074 }
            goto L_0x0031
        L_0x002a:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x002c }
        L_0x002c:
            r1 = move-exception
            h3.C2453b.a(r0, r6)     // Catch:{ JSONException -> 0x0074 }
            throw r1     // Catch:{ JSONException -> 0x0074 }
        L_0x0031:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0074 }
            r0.<init>(r6)     // Catch:{ JSONException -> 0x0074 }
            r5.f25702c = r0     // Catch:{ JSONException -> 0x0074 }
            J2.h r6 = new J2.h     // Catch:{ JSONException -> 0x0074 }
            java.lang.String r2 = "lastUpdated"
            java.lang.String r0 = r0.getString(r2)     // Catch:{ JSONException -> 0x0074 }
            java.lang.String r2 = "cmpListJson.getString(\"lastUpdated\")"
            kotlin.jvm.internal.t.d(r0, r2)     // Catch:{ JSONException -> 0x0074 }
            java.util.Locale r2 = r5.f25701b     // Catch:{ JSONException -> 0x0074 }
            java.lang.String r3 = "yyyy-MM-dd'T'HH:mm:ss"
            java.lang.String r4 = "dateString"
            kotlin.jvm.internal.t.e(r0, r4)     // Catch:{ JSONException -> 0x0074 }
            java.lang.String r4 = "format"
            kotlin.jvm.internal.t.e(r3, r4)     // Catch:{ JSONException -> 0x0074 }
            java.lang.String r4 = "locale"
            kotlin.jvm.internal.t.e(r2, r4)     // Catch:{ JSONException -> 0x0074 }
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ JSONException -> 0x0074 }
            r4.<init>(r3, r2)     // Catch:{ JSONException -> 0x0074 }
            java.util.Date r0 = r4.parse(r0)     // Catch:{ JSONException -> 0x0074 }
            if (r0 != 0) goto L_0x0064
            goto L_0x006c
        L_0x0064:
            long r0 = r0.getTime()     // Catch:{ JSONException -> 0x0074 }
            java.lang.Long r1 = java.lang.Long.valueOf(r0)     // Catch:{ JSONException -> 0x0074 }
        L_0x006c:
            java.util.LinkedHashMap r0 = r5.b()     // Catch:{ JSONException -> 0x0074 }
            r6.<init>(r1, r0)     // Catch:{ JSONException -> 0x0074 }
            return r6
        L_0x0074:
            com.inmobi.cmp.ChoiceCmp r6 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r6 = r6.getCallback()
            if (r6 != 0) goto L_0x007d
            goto L_0x0082
        L_0x007d:
            com.inmobi.cmp.model.ChoiceError r0 = com.inmobi.cmp.model.ChoiceError.INVALID_JSON_FORMAT
            r6.onCmpError(r0)
        L_0x0082:
            J2.h r6 = new J2.h
            r6.<init>()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.b.a(java.lang.String):java.lang.Object");
    }

    public final LinkedHashMap b() {
        int i5;
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = this.f25702c;
        if (jSONObject == null) {
            t.w("cmpListJson");
            jSONObject = null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("cmps");
        JSONArray names = jSONObject2.names();
        int i6 = 0;
        if (names == null) {
            i5 = 0;
        } else {
            i5 = names.length();
        }
        while (i6 < i5) {
            int i7 = i6 + 1;
            if (names == null || (str = names.getString(i6)) == null) {
                str = "0";
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject(str);
            jSONObject3.getInt("id");
            String string = jSONObject3.getString(RewardPlus.NAME);
            t.d(string, "cmp.getString(\"name\")");
            jSONObject3.getBoolean("isCommercial");
            linkedHashMap.put(str, new a(string));
            i6 = i7;
        }
        return linkedHashMap;
    }
}
