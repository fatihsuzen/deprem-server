package p2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import java.util.Locale;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;
import q2.C2716c;
import q2.C2718e;
import q2.C2724k;

/* renamed from: p2.a  reason: case insensitive filesystem */
public final class C2712a {

    /* renamed from: i  reason: collision with root package name */
    public static final C0257a f25661i = new C0257a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f25662a;

    /* renamed from: b  reason: collision with root package name */
    public final long f25663b = -1;

    /* renamed from: c  reason: collision with root package name */
    public final long f25664c = -1;

    /* renamed from: d  reason: collision with root package name */
    public final String f25665d;

    /* renamed from: e  reason: collision with root package name */
    public final String f25666e;

    /* renamed from: f  reason: collision with root package name */
    public final int f25667f;

    /* renamed from: g  reason: collision with root package name */
    public final int f25668g;

    /* renamed from: h  reason: collision with root package name */
    public final String f25669h;

    /* renamed from: p2.a$a  reason: collision with other inner class name */
    public static final class C0257a {
        public C0257a(C2633k kVar) {
        }
    }

    /* renamed from: p2.a$b */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f25670a = Build.MODEL;

        /* renamed from: b  reason: collision with root package name */
        public final String f25671b = Build.MANUFACTURER;

        /* renamed from: c  reason: collision with root package name */
        public final String f25672c = Build.BRAND;

        public final JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            String str = this.f25670a;
            if (!(str == null || str.length() == 0)) {
                jSONObject.put("model", this.f25670a);
            }
            String str2 = this.f25671b;
            if (!(str2 == null || str2.length() == 0)) {
                jSONObject.put("manufacturer", this.f25671b);
            }
            String str3 = this.f25672c;
            if (!(str3 == null || str3.length() == 0)) {
                jSONObject.put("brand", this.f25672c);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        }
    }

    public C2712a(Context context, String str) {
        t.e(context, "context");
        t.e(str, "token");
        this.f25662a = str;
        this.f25663b = new C2718e(context).a();
        String country = Locale.getDefault().getCountry();
        this.f25665d = country;
        if (country == null || country.length() == 0) {
            Object systemService = context.getSystemService("phone");
            t.c(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            this.f25665d = ((TelephonyManager) systemService).getNetworkCountryIso();
        }
        C2724k kVar = C2724k.f25689a;
        String packageName = context.getPackageName();
        t.d(packageName, "context.packageName");
        this.f25666e = kVar.a(context, packageName);
        try {
            PackageManager packageManager = context.getPackageManager();
            t.d(packageManager, "context.packageManager");
            String packageName2 = context.getPackageName();
            t.d(packageName2, "context.packageName");
            PackageInfo a5 = C2716c.a(packageManager, packageName2, 0);
            this.f25664c = kVar.e(a5);
            if (kVar.g(a5)) {
                this.f25668g = 1;
            } else {
                this.f25668g = 0;
            }
        } catch (PackageManager.NameNotFoundException e5) {
            e5.printStackTrace();
        }
        long j5 = this.f25664c;
        long j6 = this.f25663b;
        if (j5 <= j6) {
            this.f25667f = 0;
        } else if (j6 == -1) {
            this.f25667f = 0;
        } else {
            this.f25667f = 1;
        }
        this.f25669h = Locale.getDefault().getLanguage();
    }

    public final JSONObject a(Context context) {
        boolean z4;
        t.e(context, "context");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token", this.f25662a);
        jSONObject.put("sdkVersion", Build.VERSION.SDK_INT);
        String str = this.f25665d;
        if (!(str == null || str.length() == 0)) {
            String str2 = this.f25665d;
            t.b(str2);
            String upperCase = str2.toUpperCase(Locale.ROOT);
            t.d(upperCase, "toUpperCase(...)");
            jSONObject.put("countryCode", upperCase);
        }
        String str3 = this.f25666e;
        if (!(str3 == null || str3.length() == 0)) {
            jSONObject.put("installer", this.f25666e);
        }
        jSONObject.put("update", this.f25667f);
        jSONObject.put("isSystemApp", this.f25668g);
        JSONObject a5 = new b().a();
        if (a5 != null) {
            jSONObject.put("device", a5);
        }
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr != null) {
            if (strArr.length == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                JSONArray jSONArray = new JSONArray();
                for (String put : strArr) {
                    jSONArray.put(put);
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("abis", jSONArray);
                }
            }
        }
        String str4 = this.f25669h;
        if (!(str4 == null || str4.length() == 0)) {
            jSONObject.put("deviceLanguageCode", this.f25669h);
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (string != null) {
            jSONObject.put("identifier", string);
        }
        return jSONObject;
    }
}
