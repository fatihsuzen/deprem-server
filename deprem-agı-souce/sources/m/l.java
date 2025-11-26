package m;

import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.core.model.gbc.GoogleBasicConsents;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.t;
import r4.a;
import r4.b;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f960a;

    /* renamed from: b  reason: collision with root package name */
    public static final Vector f961b = new Vector((Map) null, 1, (C2633k) null);

    public static GoogleBasicConsents a() {
        return new GoogleBasicConsents(b("adStorage"), b("adUserData"), b("adPersonalization"), b("analyticsStorage"));
    }

    public static GBCConsentValue b(String str) {
        Vector vector = f961b;
        int d5 = d(str);
        if (!vector.contains(d5) || !t.a(vector.get(d5), Boolean.TRUE)) {
            return GBCConsentValue.DENIED;
        }
        return GBCConsentValue.GRANTED;
    }

    public static String c(a aVar) {
        t.e(aVar, "storage");
        if (!f960a) {
            return null;
        }
        String k5 = aVar.k(b.GBC_STATUS);
        if (k5.length() != 0) {
            return k5;
        }
        t.e(aVar, "storage");
        t.e(b.GBC_SHOWN, "preferenceKey");
        if (aVar.f25721a.getBoolean("GBCShown", false)) {
            return "Bounce";
        }
        return "NA";
    }

    public static int d(String str) {
        t.e(str, "value");
        if (t.a(str, "adStorage")) {
            return 1;
        }
        if (t.a(str, "adUserData")) {
            return 2;
        }
        if (t.a(str, "adPersonalization")) {
            return 3;
        }
        if (t.a(str, "analyticsStorage")) {
            return 4;
        }
        return 0;
    }

    public static String e() {
        if (!f960a) {
            return null;
        }
        I i5 = new I();
        i5.f24687a = true;
        Vector vector = f961b;
        vector.forEach(new j(i5));
        if (i5.f24687a) {
            return "All";
        }
        I i6 = new I();
        i6.f24687a = true;
        vector.forEach(new k(i6));
        if (i6.f24687a) {
            return "Reject";
        }
        return "Partial";
    }
}
