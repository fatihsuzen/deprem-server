package l2;

import android.content.Context;
import com.uptodown.activities.preferences.a;
import java.util.Arrays;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;

public final class M {

    /* renamed from: a  reason: collision with root package name */
    private String f24805a;

    /* renamed from: b  reason: collision with root package name */
    private int f24806b;

    /* renamed from: c  reason: collision with root package name */
    private String f24807c;

    /* renamed from: d  reason: collision with root package name */
    private JSONObject f24808d;

    public final void a(Context context) {
        t.e(context, "context");
        if (this.f24806b == 526) {
            a.C0147a aVar = a.f15150a;
            aVar.m1(context, true);
            aVar.t1(context, 694);
            String str = this.f24805a;
            if (str != null && str.length() != 0) {
                String str2 = this.f24805a;
                t.b(str2);
                JSONObject jSONObject = new JSONObject(str2);
                if (!jSONObject.isNull("url_update")) {
                    aVar.r1(context, jSONObject.optString("url_update"));
                }
            }
        }
    }

    public final boolean b() {
        int i5 = this.f24806b;
        if (i5 < 200 || i5 >= 300) {
            return true;
        }
        return false;
    }

    public final String c() {
        return this.f24807c;
    }

    public final String d() {
        return this.f24805a;
    }

    public final JSONObject e() {
        return this.f24808d;
    }

    public final int f() {
        return this.f24806b;
    }

    public final String g(JSONObject jSONObject) {
        t.e(jSONObject, "jsonObject");
        String str = null;
        try {
            if (!jSONObject.isNull("errorMsg")) {
                Object obj = jSONObject.get("errorMsg");
                if (obj instanceof JSONArray) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("errorMsg");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i5 = 0; i5 < length; i5++) {
                            if (str == null || t.a(str, "")) {
                                str = optJSONArray.getString(i5);
                            } else {
                                Q q5 = Q.f24695a;
                                String format = String.format("%s\n%s", Arrays.copyOf(new Object[]{str, optJSONArray.optString(i5)}, 2));
                                t.d(format, "format(...)");
                                str = format;
                            }
                        }
                        return str;
                    }
                } else if (obj instanceof String) {
                    return (String) obj;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final void h(String str) {
        this.f24807c = str;
    }

    public final void i(String str) {
        this.f24805a = str;
    }

    public final void j(JSONObject jSONObject) {
        this.f24808d = jSONObject;
    }

    public final void k(int i5) {
        this.f24806b = i5;
    }
}
