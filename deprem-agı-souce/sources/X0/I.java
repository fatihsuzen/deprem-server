package x0;

import S0.e;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.work.WorkRequest;
import j$.util.Objects;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import k0.C1701o;
import u0.g;
import x0.J;
import y0.i;

public class I implements J {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f16818g = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: h  reason: collision with root package name */
    private static final String f16819h = Pattern.quote("/");

    /* renamed from: a  reason: collision with root package name */
    private final K f16820a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f16821b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16822c;

    /* renamed from: d  reason: collision with root package name */
    private final e f16823d;

    /* renamed from: e  reason: collision with root package name */
    private final D f16824e;

    /* renamed from: f  reason: collision with root package name */
    private J.a f16825f;

    public I(Context context, String str, e eVar, D d5) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str != null) {
            this.f16821b = context;
            this.f16822c = str;
            this.f16823d = eVar;
            this.f16824e = d5;
            this.f16820a = new K();
        } else {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
    }

    private synchronized String b(String str, SharedPreferences sharedPreferences) {
        String e5;
        e5 = e(UUID.randomUUID().toString());
        g f5 = g.f();
        f5.i("Created new Crashlytics installation ID: " + e5 + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", e5).putString("firebase.installation.id", str).apply();
        return e5;
    }

    static String c() {
        return "SYN_" + UUID.randomUUID().toString();
    }

    private static String e(String str) {
        return f16818g.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    static boolean k(String str) {
        if (str == null || !str.startsWith("SYN_")) {
            return false;
        }
        return true;
    }

    private String l(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", (String) null);
    }

    private String m(String str) {
        return str.replaceAll(f16819h, "");
    }

    private boolean n() {
        J.a aVar = this.f16825f;
        if (aVar == null) {
            return true;
        }
        if (aVar.e() != null || !this.f16824e.d()) {
            return false;
        }
        return true;
    }

    public synchronized J.a a() {
        String str;
        if (!n()) {
            return this.f16825f;
        }
        g.f().i("Determining Crashlytics installation ID...");
        SharedPreferences q5 = C1914j.q(this.f16821b);
        String string = q5.getString("firebase.installation.id", (String) null);
        g f5 = g.f();
        f5.i("Cached Firebase Installation ID: " + string);
        if (this.f16824e.d()) {
            H d5 = d(false);
            g f6 = g.f();
            f6.i("Fetched Firebase Installation ID: " + d5.b());
            if (d5.b() == null) {
                if (string == null) {
                    str = c();
                } else {
                    str = string;
                }
                d5 = new H(str, (String) null);
            }
            if (Objects.equals(d5.b(), string)) {
                this.f16825f = J.a.a(l(q5), d5);
            } else {
                this.f16825f = J.a.a(b(d5.b(), q5), d5);
            }
        } else if (k(string)) {
            this.f16825f = J.a.b(l(q5));
        } else {
            this.f16825f = J.a.b(b(c(), q5));
        }
        g f7 = g.f();
        f7.i("Install IDs: " + this.f16825f);
        return this.f16825f;
    }

    public H d(boolean z4) {
        String str;
        i.e();
        String str2 = null;
        if (z4) {
            try {
                str = ((com.google.firebase.installations.g) C1701o.b(this.f16823d.a(false), WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS)).b();
            } catch (Exception e5) {
                g.f().l("Error getting Firebase authentication token.", e5);
            }
            str2 = (String) C1701o.b(this.f16823d.getId(), WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
            return new H(str2, str);
        }
        str = null;
        try {
            str2 = (String) C1701o.b(this.f16823d.getId(), WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
        } catch (Exception e6) {
            g.f().l("Error getting Firebase installation id.", e6);
        }
        return new H(str2, str);
    }

    public String f() {
        return this.f16822c;
    }

    public String g() {
        return this.f16820a.a(this.f16821b);
    }

    public String h() {
        return String.format(Locale.US, "%s/%s", new Object[]{m(Build.MANUFACTURER), m(Build.MODEL)});
    }

    public String i() {
        return m(Build.VERSION.INCREMENTAL);
    }

    public String j() {
        return m(Build.VERSION.RELEASE);
    }
}
