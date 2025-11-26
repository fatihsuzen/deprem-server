package S3;

import R3.b;
import X2.C2250q;
import kotlin.jvm.internal.t;
import q1.C1777u;
import r1.C1812v;

public final class p extends i {
    public final String b(b bVar) {
        t.e(bVar, "field");
        switch (bVar.ordinal()) {
            case 0:
                String str = C1777u.f16184b;
                t.d(str, "SHARING_NOTICE");
                return str;
            case 1:
                String str2 = C1777u.f16185c;
                t.d(str2, "SALE_OPT_OUT_NOTICE");
                return str2;
            case 3:
                String str3 = C1777u.f16186d;
                t.d(str3, "TARGETED_ADVERTISING_OPT_OUT_NOTICE");
                return str3;
            case 4:
                String str4 = C1777u.f16187e;
                t.d(str4, "SENSITIVE_DATA_PROCESSING_OPT_OUT_NOTICE");
                return str4;
            case 7:
                String str5 = C1777u.f16188f;
                t.d(str5, "SALE_OPT_OUT");
                return str5;
            case 9:
                String str6 = C1777u.f16189g;
                t.d(str6, "TARGETED_ADVERTISING_OPT_OUT");
                return str6;
            case 10:
                String str7 = C1777u.f16190h;
                t.d(str7, "SENSITIVE_DATA_PROCESSING");
                return str7;
            case 11:
                String str8 = C1777u.f16191i;
                t.d(str8, "KNOWN_CHILD_SENSITIVE_DATA_CONSENTS");
                return str8;
            case 13:
                String str9 = C1777u.f16192j;
                t.d(str9, "MSPA_COVERED_TRANSACTION");
                return str9;
            case 14:
                String str10 = C1777u.f16193k;
                t.d(str10, "MSPA_OPT_OUT_OPTION_MODE");
                return str10;
            case 15:
                String str11 = C1777u.f16194l;
                t.d(str11, "MSPA_SERVICE_PROVIDER_MODE");
                return str11;
            default:
                return "";
        }
    }

    public final void d(b bVar, boolean z4) {
        int i5;
        t.e(bVar, "field");
        if (z4) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        c(bVar, Integer.valueOf(i5));
        this.f19041d.setKnownChildSensitiveDataConsents(C2250q.d(Integer.valueOf(i5)));
    }

    public final String h() {
        String str = C1812v.f16445g;
        t.d(str, "NAME");
        return str;
    }

    public final int j() {
        return C1812v.f16443e;
    }

    public final void l() {
    }

    public final void g(boolean z4) {
    }

    public final void m(boolean z4) {
    }
}
