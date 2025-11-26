package S3;

import X2.C2250q;
import kotlin.jvm.internal.t;
import q1.C1764h;
import r1.C1799i;

public final class b extends i {
    public final String b(R3.b bVar) {
        t.e(bVar, "field");
        int ordinal = bVar.ordinal();
        if (ordinal == 0) {
            String str = C1764h.f15965b;
            t.d(str, "SHARING_NOTICE");
            return str;
        } else if (ordinal == 1) {
            String str2 = C1764h.f15966c;
            t.d(str2, "SALE_OPT_OUT_NOTICE");
            return str2;
        } else if (ordinal == 3) {
            String str3 = C1764h.f15967d;
            t.d(str3, "TARGETED_ADVERTISING_OPT_OUT_NOTICE");
            return str3;
        } else if (ordinal != 7) {
            switch (ordinal) {
                case 9:
                    String str4 = C1764h.f15969f;
                    t.d(str4, "TARGETED_ADVERTISING_OPT_OUT");
                    return str4;
                case 10:
                    String str5 = C1764h.f15970g;
                    t.d(str5, "SENSITIVE_DATA_PROCESSING");
                    return str5;
                case 11:
                    String str6 = C1764h.f15971h;
                    t.d(str6, "KNOWN_CHILD_SENSITIVE_DATA_CONSENTS");
                    return str6;
                default:
                    switch (ordinal) {
                        case 13:
                            String str7 = C1764h.f15972i;
                            t.d(str7, "MSPA_COVERED_TRANSACTION");
                            return str7;
                        case 14:
                            String str8 = C1764h.f15973j;
                            t.d(str8, "MSPA_OPT_OUT_OPTION_MODE");
                            return str8;
                        case 15:
                            String str9 = C1764h.f15974k;
                            t.d(str9, "MSPA_SERVICE_PROVIDER_MODE");
                            return str9;
                        default:
                            return "";
                    }
            }
        } else {
            String str10 = C1764h.f15968e;
            t.d(str10, "SALE_OPT_OUT");
            return str10;
        }
    }

    public final void d(R3.b bVar, boolean z4) {
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
        String str = C1799i.f16406g;
        t.d(str, "NAME");
        return str;
    }

    public final int j() {
        return C1799i.f16404e;
    }

    public final void l() {
    }

    public final void g(boolean z4) {
    }

    public final void i(boolean z4) {
    }

    public final void m(boolean z4) {
    }
}
