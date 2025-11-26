package b1;

import K0.a;
import M0.d;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import c1.C1046c;
import e1.j;
import java.util.Map;
import kotlin.jvm.internal.t;
import o0.f;

public final class M {

    /* renamed from: a  reason: collision with root package name */
    public static final M f4547a = new M();

    /* renamed from: b  reason: collision with root package name */
    private static final a f4548b;

    static {
        a i5 = new d().j(C1018c.f4653a).k(true).i();
        t.d(i5, "build(...)");
        f4548b = i5;
    }

    private M() {
    }

    private final C1019d d(C1046c cVar) {
        if (cVar == null) {
            return C1019d.COLLECTION_SDK_NOT_INSTALLED;
        }
        if (cVar.a()) {
            return C1019d.COLLECTION_ENABLED;
        }
        return C1019d.COLLECTION_DISABLED;
    }

    public final L a(f fVar, K k5, j jVar, Map map, String str, String str2) {
        T t5;
        Map map2 = map;
        t.e(fVar, "firebaseApp");
        t.e(k5, "sessionDetails");
        t.e(jVar, "sessionsSettings");
        t.e(map2, "subscribers");
        String str3 = str;
        t.e(str3, "firebaseInstallationId");
        String str4 = str2;
        t.e(str4, "firebaseAuthenticationToken");
        C1026k kVar = C1026k.SESSION_START;
        new T(k5.b(), k5.a(), k5.c(), k5.d(), new C1021f(d((C1046c) map2.get(C1046c.a.PERFORMANCE)), d((C1046c) map2.get(C1046c.a.CRASHLYTICS)), jVar.a()), str3, str4);
        return new L(kVar, t5, b(fVar));
    }

    public final C1017b b(f fVar) {
        String valueOf;
        String str;
        t.e(fVar, "firebaseApp");
        Context k5 = fVar.k();
        t.d(k5, "getApplicationContext(...)");
        String packageName = k5.getPackageName();
        PackageInfo packageInfo = k5.getPackageManager().getPackageInfo(packageName, 0);
        if (Build.VERSION.SDK_INT >= 28) {
            valueOf = String.valueOf(packageInfo.getLongVersionCode());
        } else {
            valueOf = String.valueOf(packageInfo.versionCode);
        }
        String str2 = valueOf;
        String c5 = fVar.n().c();
        t.d(c5, "getApplicationId(...)");
        String str3 = Build.MODEL;
        t.d(str3, "MODEL");
        String str4 = c5;
        String str5 = Build.VERSION.RELEASE;
        t.d(str5, "RELEASE");
        String str6 = str3;
        C1038x xVar = C1038x.LOG_ENVIRONMENT_PROD;
        t.b(packageName);
        String str7 = packageInfo.versionName;
        if (str7 == null) {
            str = str2;
        } else {
            str = str7;
        }
        String str8 = Build.MANUFACTURER;
        t.d(str8, "MANUFACTURER");
        G g5 = G.f4531a;
        Context k6 = fVar.k();
        t.d(k6, "getApplicationContext(...)");
        F b5 = g5.b(k6);
        Context k7 = fVar.k();
        t.d(k7, "getApplicationContext(...)");
        return new C1017b(str4, str6, "3.0.3", str5, xVar, new C1016a(packageName, str, str2, str8, b5, g5.a(k7)));
    }

    public final a c() {
        return f4548b;
    }
}
