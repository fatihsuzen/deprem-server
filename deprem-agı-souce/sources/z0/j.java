package z0;

import A0.F;
import K0.a;
import M0.d;
import org.json.JSONObject;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17222a = new d().j(C1972a.f17173a).i();

    static j a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return b(jSONObject.getString("rolloutId"), jSONObject.getString("parameterKey"), jSONObject.getString("parameterValue"), jSONObject.getString("variantId"), jSONObject.getLong("templateVersion"));
    }

    public static j b(String str, String str2, String str3, String str4, long j5) {
        return new C1973b(str, str2, i(str3), str4, j5);
    }

    private static String i(String str) {
        if (str.length() > 256) {
            return str.substring(0, 256);
        }
        return str;
    }

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract long f();

    public abstract String g();

    public F.e.d.C0037e h() {
        return F.e.d.C0037e.a().d(F.e.d.C0037e.b.a().c(g()).b(e()).a()).b(c()).c(d()).e(f()).a();
    }
}
