package F0;

import C0.a;
import C0.b;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.Command;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import u0.g;
import x0.C1927x;
import y0.i;

class c implements l {

    /* renamed from: a  reason: collision with root package name */
    private final String f2418a;

    /* renamed from: b  reason: collision with root package name */
    private final b f2419b;

    /* renamed from: c  reason: collision with root package name */
    private final g f2420c;

    public c(String str, b bVar) {
        this(str, bVar, g.f());
    }

    private a b(a aVar, k kVar) {
        c(aVar, "X-CRASHLYTICS-GOOGLE-APP-ID", kVar.f2451a);
        c(aVar, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        c(aVar, "X-CRASHLYTICS-API-CLIENT-VERSION", C1927x.k());
        c(aVar, "Accept", "application/json");
        c(aVar, "X-CRASHLYTICS-DEVICE-MODEL", kVar.f2452b);
        c(aVar, "X-CRASHLYTICS-OS-BUILD-VERSION", kVar.f2453c);
        c(aVar, "X-CRASHLYTICS-OS-DISPLAY-VERSION", kVar.f2454d);
        c(aVar, "X-CRASHLYTICS-INSTALLATION-ID", kVar.f2455e.a().c());
        return aVar;
    }

    private void c(a aVar, String str, String str2) {
        if (str2 != null) {
            aVar.d(str, str2);
        }
    }

    private JSONObject e(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e5) {
            g gVar = this.f2420c;
            gVar.l("Failed to parse settings JSON from " + this.f2418a, e5);
            g gVar2 = this.f2420c;
            gVar2.k("Settings response " + str);
            return null;
        }
    }

    private Map f(k kVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", kVar.f2458h);
        hashMap.put("display_version", kVar.f2457g);
        hashMap.put("source", Integer.toString(kVar.f2459i));
        String str = kVar.f2456f;
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    public JSONObject a(k kVar, boolean z4) {
        i.d();
        if (z4) {
            try {
                Map f5 = f(kVar);
                a b5 = b(d(f5), kVar);
                g gVar = this.f2420c;
                gVar.b("Requesting settings from " + this.f2418a);
                g gVar2 = this.f2420c;
                gVar2.i("Settings query params were: " + f5);
                return g(b5.c());
            } catch (IOException e5) {
                this.f2420c.e("Settings request failed.", e5);
                return null;
            }
        } else {
            throw new RuntimeException("An invalid data collection token was used.");
        }
    }

    /* access modifiers changed from: protected */
    public a d(Map map) {
        a a5 = this.f2419b.a(this.f2418a, map);
        return a5.d(Command.HTTP_HEADER_USER_AGENT, "Crashlytics Android SDK/" + C1927x.k()).d("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    /* access modifiers changed from: package-private */
    public JSONObject g(C0.c cVar) {
        int b5 = cVar.b();
        g gVar = this.f2420c;
        gVar.i("Settings response code was: " + b5);
        if (h(b5)) {
            return e(cVar.a());
        }
        g gVar2 = this.f2420c;
        gVar2.d("Settings request failed; (status: " + b5 + ") from " + this.f2418a);
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean h(int i5) {
        if (i5 == 200 || i5 == 201 || i5 == 202 || i5 == 203) {
            return true;
        }
        return false;
    }

    c(String str, b bVar, g gVar) {
        if (str != null) {
            this.f2420c = gVar;
            this.f2419b = bVar;
            this.f2418a = str;
            return;
        }
        throw new IllegalArgumentException("url must not be null.");
    }
}
