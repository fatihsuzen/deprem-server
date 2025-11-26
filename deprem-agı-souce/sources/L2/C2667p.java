package l2;

import U1.C2201a;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.FeatureInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import b2.C2286f;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;
import t3.p;
import t3.s;

/* renamed from: l2.p  reason: case insensitive filesystem */
public final class C2667p {

    /* renamed from: w  reason: collision with root package name */
    public static final a f25132w = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private String f25133a;

    /* renamed from: b  reason: collision with root package name */
    private String f25134b;

    /* renamed from: c  reason: collision with root package name */
    private String f25135c;

    /* renamed from: d  reason: collision with root package name */
    private String f25136d;

    /* renamed from: e  reason: collision with root package name */
    private String f25137e;

    /* renamed from: f  reason: collision with root package name */
    private String f25138f;

    /* renamed from: g  reason: collision with root package name */
    private String f25139g;

    /* renamed from: h  reason: collision with root package name */
    private int f25140h;

    /* renamed from: i  reason: collision with root package name */
    private int f25141i;

    /* renamed from: j  reason: collision with root package name */
    private int f25142j;

    /* renamed from: k  reason: collision with root package name */
    private float f25143k;

    /* renamed from: l  reason: collision with root package name */
    private String f25144l;

    /* renamed from: m  reason: collision with root package name */
    private long f25145m;

    /* renamed from: n  reason: collision with root package name */
    private String[] f25146n;

    /* renamed from: o  reason: collision with root package name */
    private String[] f25147o;

    /* renamed from: p  reason: collision with root package name */
    private String[] f25148p;

    /* renamed from: q  reason: collision with root package name */
    private String f25149q;

    /* renamed from: r  reason: collision with root package name */
    private int f25150r;

    /* renamed from: s  reason: collision with root package name */
    private String f25151s;

    /* renamed from: t  reason: collision with root package name */
    private int f25152t;

    /* renamed from: u  reason: collision with root package name */
    private String f25153u;

    /* renamed from: v  reason: collision with root package name */
    private int f25154v;

    /* renamed from: l2.p$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public final String a() {
        String str = this.f25133a + this.f25140h;
        if (this.f25134b != null) {
            str = str + this.f25134b;
        }
        if (this.f25136d != null) {
            str = str + this.f25136d;
        }
        return C2286f.f20690a.c(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        if (r0.equals("0") != false) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "json"
            kotlin.jvm.internal.t.e(r5, r0)
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r5)
            java.lang.String r5 = "success"
            boolean r1 = r0.isNull(r5)
            r2 = 0
            if (r1 != 0) goto L_0x0071
            int r5 = r0.optInt(r5)
            r1 = 1
            if (r5 != r1) goto L_0x0071
            java.lang.String r5 = "data"
            org.json.JSONObject r5 = r0.optJSONObject(r5)
            if (r5 == 0) goto L_0x0071
            java.lang.String r0 = "sdk"
            boolean r3 = r5.isNull(r0)
            if (r3 != 0) goto L_0x0033
            int r3 = r4.f25140h
            int r0 = r5.optInt(r0)
            if (r3 != r0) goto L_0x0033
            r2 = r1
        L_0x0033:
            if (r2 == 0) goto L_0x0071
            java.lang.String r0 = "userID"
            boolean r1 = r5.isNull(r0)
            r2 = 0
            if (r1 != 0) goto L_0x004a
            java.lang.String r0 = r5.optString(r0)
            java.lang.String r1 = "0"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x004b
        L_0x004a:
            r0 = r2
        L_0x004b:
            z2.v r1 = new z2.v
            r1.<init>()
            java.lang.String r3 = r4.f25134b
            boolean r0 = r1.v(r0, r3)
            if (r0 == 0) goto L_0x0070
            java.lang.String r0 = "language"
            boolean r1 = r5.isNull(r0)
            if (r1 != 0) goto L_0x0064
            java.lang.String r2 = r5.optString(r0)
        L_0x0064:
            z2.v r5 = new z2.v
            r5.<init>()
            java.lang.String r0 = r4.f25136d
            boolean r5 = r5.v(r2, r0)
            return r5
        L_0x0070:
            return r0
        L_0x0071:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.C2667p.b(java.lang.String):boolean");
    }

    public final String c() {
        return this.f25135c;
    }

    public final String d() {
        return this.f25133a;
    }

    public final ArrayList e(ArrayList arrayList, Context context) {
        t.e(arrayList, "appRequiredFeatures");
        t.e(context, "context");
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() > 0) {
            FeatureInfo[] systemAvailableFeatures = context.getPackageManager().getSystemAvailableFeatures();
            t.d(systemAvailableFeatures, "getSystemAvailableFeatures(...)");
            String[] systemSharedLibraryNames = context.getPackageManager().getSystemSharedLibraryNames();
            Iterator it = arrayList.iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                String str = (String) next;
                boolean z4 = false;
                boolean z5 = false;
                for (FeatureInfo featureInfo : systemAvailableFeatures) {
                    z5 = context.getPackageManager().hasSystemFeature(str);
                    if (!z5 && s.E(str, "android.hardware.ram.low", true)) {
                        z5 = context.getPackageManager().hasSystemFeature("android.hardware.ram.normal");
                    }
                    if (z5) {
                        break;
                    }
                }
                if (!z5 && systemSharedLibraryNames != null) {
                    Iterator a5 = C2625c.a(systemSharedLibraryNames);
                    while (true) {
                        if (a5.hasNext()) {
                            if (s.E(str, (String) a5.next(), true)) {
                                z4 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (!z5 && !z4) {
                    arrayList2.add(str);
                }
            }
        }
        return arrayList2;
    }

    public final boolean f(ArrayList arrayList, Context context) {
        t.e(arrayList, "appRequiredFeatures");
        t.e(context, "context");
        return e(arrayList, context).isEmpty();
    }

    public final boolean g(C2668q qVar) {
        t.e(qVar, "download");
        if (qVar.A() == null || this.f25146n == null) {
            return true;
        }
        String A4 = qVar.A();
        t.b(A4);
        String[] strArr = (String[]) new p(",").j(A4, 0).toArray(new String[0]);
        String[] strArr2 = this.f25146n;
        t.b(strArr2);
        int length = strArr2.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            } else if (!s.E(strArr2[i5], "arm64-v8a", true)) {
                i5++;
            } else if (Build.VERSION.SDK_INT > 34) {
                boolean z4 = false;
                for (String E4 : strArr) {
                    if (s.E(E4, "arm64-v8a", true)) {
                        z4 = true;
                    }
                }
                return z4;
            }
        }
        String[] strArr3 = this.f25146n;
        t.b(strArr3);
        boolean z5 = false;
        for (String str : strArr3) {
            if (z5) {
                break;
            }
            int length2 = strArr.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length2) {
                    break;
                }
                String str2 = strArr[i6];
                if (!s.E(str2, "universal", true) && !s.E(str, str2, true)) {
                    i6++;
                }
            }
            z5 = true;
        }
        return z5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h(l2.C2668q r5) {
        /*
            r4 = this;
            java.lang.String r0 = "download"
            kotlin.jvm.internal.t.e(r5, r0)
            java.util.ArrayList r0 = r5.B()
            r1 = 1
            if (r0 == 0) goto L_0x0057
            java.util.ArrayList r0 = r5.B()
            kotlin.jvm.internal.t.b(r0)
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0057
            java.util.ArrayList r5 = r5.B()
            kotlin.jvm.internal.t.b(r5)
            java.util.Iterator r5 = r5.iterator()
            java.lang.String r0 = "iterator(...)"
            kotlin.jvm.internal.t.d(r5, r0)
        L_0x0029:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0055
            java.lang.Object r0 = r5.next()
            java.lang.String r2 = "next(...)"
            kotlin.jvm.internal.t.d(r0, r2)
            java.lang.String r0 = (java.lang.String) r0
            int r2 = java.lang.Integer.parseInt(r0)
            int r3 = r4.f25152t
            if (r2 == r3) goto L_0x0054
            int r2 = java.lang.Integer.parseInt(r0)
            r3 = 65534(0xfffe, float:9.1833E-41)
            if (r2 == r3) goto L_0x0054
            int r0 = java.lang.Integer.parseInt(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            if (r0 != r2) goto L_0x0029
        L_0x0054:
            return r1
        L_0x0055:
            r5 = 0
            return r5
        L_0x0057:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.C2667p.h(l2.q):boolean");
    }

    public final boolean i(C2668q qVar) {
        t.e(qVar, "download");
        if (qVar.u() <= this.f25140h) {
            return true;
        }
        return false;
    }

    public final void j(Context context) {
        String str;
        t.e(context, "context");
        this.f25133a = Settings.Secure.getString(context.getContentResolver(), "android_id");
        V h5 = V.f24870q.h(context);
        if (h5 != null) {
            str = h5.j();
        } else {
            str = null;
        }
        if (str != null) {
            this.f25134b = h5.j();
        } else {
            this.f25134b = null;
        }
        this.f25140h = Build.VERSION.SDK_INT;
        if (new C2201a(context).m()) {
            this.f25150r = 1;
        }
    }

    public final void k(Context context) {
        t.e(context, "context");
        j(context);
        this.f25141i = context.getResources().getDisplayMetrics().widthPixels;
        this.f25142j = context.getResources().getDisplayMetrics().heightPixels;
        this.f25143k = context.getResources().getDisplayMetrics().density;
        this.f25152t = context.getResources().getDisplayMetrics().densityDpi;
        this.f25153u = context.getString(R.string.dpi_device);
        this.f25135c = Locale.getDefault().getCountry();
        this.f25136d = Locale.getDefault().getLanguage();
        this.f25137e = Build.BRAND;
        this.f25139g = Build.MANUFACTURER;
        this.f25138f = Build.MODEL;
        Object systemService = context.getSystemService("phone");
        t.c(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        this.f25144l = telephonyManager.getNetworkOperatorName();
        String str = this.f25135c;
        if (str == null || str.length() == 0) {
            this.f25135c = telephonyManager.getNetworkCountryIso();
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            Object systemService2 = context.getSystemService("activity");
            t.c(systemService2, "null cannot be cast to non-null type android.app.ActivityManager");
            ((ActivityManager) systemService2).getMemoryInfo(memoryInfo);
            this.f25145m = memoryInfo.totalMem;
        } catch (Exception e5) {
            e5.getMessage();
        } catch (Error e6) {
            e6.getMessage();
        }
        this.f25146n = Build.SUPPORTED_ABIS;
        this.f25147o = Build.SUPPORTED_32_BIT_ABIS;
        this.f25148p = Build.SUPPORTED_64_BIT_ABIS;
        this.f25149q = context.getString(R.string.version, new Object[]{context.getString(R.string.app_name), "6.94", "694"});
        this.f25151s = Build.HARDWARE;
        if (UptodownApp.f13477F.R(context)) {
            this.f25154v = 1;
        } else {
            this.f25154v = 0;
        }
    }

    public final JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("identifier", this.f25133a);
        jSONObject.put("userID", this.f25134b);
        jSONObject.put("country", this.f25135c);
        jSONObject.put("language", this.f25136d);
        jSONObject.put("brand", this.f25137e);
        jSONObject.put("model", this.f25138f);
        jSONObject.put("manufacturer", this.f25139g);
        int i5 = this.f25140h;
        if (i5 > 0) {
            jSONObject.put("sdk", i5);
        }
        int i6 = this.f25141i;
        if (i6 > 0) {
            jSONObject.put("displayWidth", i6);
        }
        int i7 = this.f25142j;
        if (i7 > 0) {
            jSONObject.put("displayHeight", i7);
        }
        float f5 = this.f25143k;
        if (f5 > 0.0f) {
            jSONObject.put("displayDensity", (double) f5);
        }
        String str = this.f25153u;
        if (str != null) {
            t.b(str);
            if (str.length() > 0) {
                jSONObject.put("density", this.f25153u);
            }
        }
        long j5 = this.f25145m;
        if (j5 > 0) {
            jSONObject.put("ram", j5);
        }
        jSONObject.put("operador", this.f25144l);
        String[] strArr = this.f25146n;
        if (!(strArr == null || strArr.length == 0)) {
            JSONArray jSONArray = new JSONArray();
            Iterator a5 = C2625c.a(strArr);
            while (a5.hasNext()) {
                jSONArray.put((String) a5.next());
            }
            jSONObject.put("supportedABIs", jSONArray);
        }
        String[] strArr2 = this.f25147o;
        if (!(strArr2 == null || strArr2.length == 0)) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator a6 = C2625c.a(strArr2);
            while (a6.hasNext()) {
                jSONArray2.put((String) a6.next());
            }
            jSONObject.put("supported32BitsABIs", jSONArray2);
        }
        String[] strArr3 = this.f25148p;
        if (!(strArr3 == null || strArr3.length == 0)) {
            JSONArray jSONArray3 = new JSONArray();
            Iterator a7 = C2625c.a(strArr3);
            while (a7.hasNext()) {
                jSONArray3.put((String) a7.next());
            }
            jSONObject.put("supported64BitsABIs", jSONArray3);
        }
        jSONObject.put("appVersion", this.f25149q);
        jSONObject.put("rooted", this.f25150r);
        jSONObject.put("isTV", this.f25154v);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceInfo(identifier=");
        sb.append(this.f25133a);
        sb.append(", userId=");
        sb.append(this.f25134b);
        sb.append(", country=");
        sb.append(this.f25135c);
        sb.append(", language=");
        sb.append(this.f25136d);
        sb.append(", brand=");
        sb.append(this.f25137e);
        sb.append(", model=");
        sb.append(this.f25138f);
        sb.append(", manufacturer=");
        sb.append(this.f25139g);
        sb.append(", sdk=");
        sb.append(this.f25140h);
        sb.append(", displayWidth=");
        sb.append(this.f25141i);
        sb.append(", displayHeight=");
        sb.append(this.f25142j);
        sb.append(", displayDensity=");
        sb.append(this.f25143k);
        sb.append(", densityDpi=");
        sb.append(this.f25152t);
        sb.append(", density=");
        sb.append(this.f25153u);
        sb.append(", operador=");
        sb.append(this.f25144l);
        sb.append(", ram=");
        sb.append(this.f25145m);
        sb.append(", supportedAbis=");
        String arrays = Arrays.toString(this.f25146n);
        t.d(arrays, "toString(...)");
        sb.append(arrays);
        sb.append(", supported32BitsAbis=");
        String arrays2 = Arrays.toString(this.f25147o);
        t.d(arrays2, "toString(...)");
        sb.append(arrays2);
        sb.append(", supported64BitsAbis=");
        String arrays3 = Arrays.toString(this.f25148p);
        t.d(arrays3, "toString(...)");
        sb.append(arrays3);
        sb.append(", appVersion=");
        sb.append(this.f25149q);
        sb.append(", rooted=");
        sb.append(this.f25150r);
        sb.append(", hardware=");
        sb.append(this.f25151s);
        sb.append(", isTv=");
        sb.append(this.f25154v);
        sb.append(')');
        return sb.toString();
    }
}
