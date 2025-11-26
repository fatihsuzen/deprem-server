package com.mbridge.msdk.foundation.same.net.f;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.c.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f9394a = "h";

    /* renamed from: b  reason: collision with root package name */
    public static String f9395b = "i";

    /* renamed from: c  reason: collision with root package name */
    public static String f9396c = "coppa";

    /* renamed from: d  reason: collision with root package name */
    public static String f9397d = "d";

    /* renamed from: e  reason: collision with root package name */
    public static String f9398e = "e";

    /* renamed from: f  reason: collision with root package name */
    public static String f9399f = "a";

    /* renamed from: g  reason: collision with root package name */
    public static String f9400g = "f";

    /* renamed from: h  reason: collision with root package name */
    public static String f9401h = "g";

    /* renamed from: i  reason: collision with root package name */
    private static final String f9402i = "e";

    /* renamed from: j  reason: collision with root package name */
    private Map<String, a> f9403j = new LinkedHashMap();

    /* renamed from: k  reason: collision with root package name */
    private Map<String, String> f9404k = new LinkedHashMap();

    public e() {
    }

    public final void a(String str, String str2) {
        if (str2 == null) {
            af.b(f9402i, "add() value is null!");
        }
        if (!TextUtils.isEmpty(str) && str2 != null) {
            this.f9404k.put(str, str2);
        }
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : this.f9404k.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode((String) next.getKey(), C.UTF8_NAME));
                sb.append("=");
                sb.append(URLEncoder.encode((String) next.getValue(), C.UTF8_NAME));
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return sb.toString();
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : this.f9404k.entrySet()) {
                jSONObject.put(URLEncoder.encode((String) next.getKey(), C.UTF8_NAME), URLEncoder.encode((String) next.getValue(), C.UTF8_NAME));
            }
            for (Map.Entry next2 : this.f9403j.entrySet()) {
                jSONObject.put(URLEncoder.encode((String) next2.getKey(), C.UTF8_NAME), URLEncoder.encode("FILE_NAME_" + ((a) next2.getValue()).a().getName(), C.UTF8_NAME));
            }
        } catch (JSONException e5) {
            af.b(f9402i, e5.getMessage());
        } catch (UnsupportedEncodingException unused) {
        }
        return jSONObject;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(28);
        try {
            for (Map.Entry next : this.f9404k.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode((String) next.getKey(), C.UTF8_NAME));
                sb.append('=');
                sb.append(URLEncoder.encode((String) next.getValue(), C.UTF8_NAME));
            }
            for (Map.Entry next2 : this.f9403j.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode((String) next2.getKey(), C.UTF8_NAME));
                sb.append('=');
                sb.append(URLEncoder.encode("FILE_NAME_" + ((a) next2.getValue()).a().getName(), C.UTF8_NAME));
            }
        } catch (UnsupportedEncodingException e5) {
            af.b(f9402i, e5.getMessage());
        }
        return sb.toString();
    }

    public e(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                a((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    public final Map<String, String> a() {
        return this.f9404k;
    }

    public final void a(String str) {
        this.f9404k.remove(str);
        this.f9403j.remove(str);
    }
}
