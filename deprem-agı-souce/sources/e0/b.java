package E0;

import A0.F;
import B0.j;
import android.content.Context;
import com.google.android.datatransport.cct.a;
import k0.C1698l;
import p.C1745c;
import p.h;
import r.u;
import x0.C1903A;
import x0.N;

public class b {

    /* renamed from: c  reason: collision with root package name */
    private static final j f2390c = new j();

    /* renamed from: d  reason: collision with root package name */
    private static final String f2391d = d("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* renamed from: e  reason: collision with root package name */
    private static final String f2392e = d("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* renamed from: f  reason: collision with root package name */
    private static final h f2393f = new a();

    /* renamed from: a  reason: collision with root package name */
    private final e f2394a;

    /* renamed from: b  reason: collision with root package name */
    private final h f2395b;

    b(e eVar, h hVar) {
        this.f2394a = eVar;
        this.f2395b = hVar;
    }

    public static b b(Context context, F0.j jVar, N n5) {
        u.f(context);
        p.j g5 = u.c().g(new a(f2391d, f2392e));
        C1745c b5 = C1745c.b("json");
        h hVar = f2393f;
        return new b(new e(g5.a("FIREBASE_CRASHLYTICS_REPORT", F.class, b5, hVar), jVar.b(), n5), hVar);
    }

    private static String d(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length());
        for (int i5 = 0; i5 < str.length(); i5++) {
            sb.append(str.charAt(i5));
            if (str2.length() > i5) {
                sb.append(str2.charAt(i5));
            }
        }
        return sb.toString();
    }

    public C1698l c(C1903A a5, boolean z4) {
        return this.f2394a.i(a5, z4).a();
    }
}
