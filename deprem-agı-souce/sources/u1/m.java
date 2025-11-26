package u1;

import A1.c;
import A1.g;
import java.net.URL;
import org.json.JSONObject;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final String f16722a;

    /* renamed from: b  reason: collision with root package name */
    private final URL f16723b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16724c;

    private m(String str, URL url, String str2) {
        this.f16722a = str;
        this.f16723b = url;
        this.f16724c = str2;
    }

    public static m a(String str, URL url, String str2) {
        g.d(str, "VendorKey is null or empty");
        g.b(url, "ResourceURL is null");
        g.d(str2, "VerificationParameters is null or empty");
        return new m(str, url, str2);
    }

    public static m b(URL url) {
        g.b(url, "ResourceURL is null");
        return new m((String) null, url, (String) null);
    }

    public URL c() {
        return this.f16723b;
    }

    public String d() {
        return this.f16722a;
    }

    public String e() {
        return this.f16724c;
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        c.h(jSONObject, "vendorKey", this.f16722a);
        c.h(jSONObject, "resourceUrl", this.f16723b.toString());
        c.h(jSONObject, "verificationParameters", this.f16724c);
        return jSONObject;
    }
}
