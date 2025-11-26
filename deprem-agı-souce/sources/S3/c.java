package S3;

import R3.b;
import kotlin.jvm.internal.t;
import q1.C1765i;
import r1.C1800j;

public final class c extends i {
    public final String b(b bVar) {
        t.e(bVar, "field");
        int ordinal = bVar.ordinal();
        if (ordinal == 0) {
            String str = C1765i.f15981b;
            t.d(str, "SHARING_NOTICE");
            return str;
        } else if (ordinal == 1) {
            String str2 = C1765i.f15982c;
            t.d(str2, "SALE_OPT_OUT_NOTICE");
            return str2;
        } else if (ordinal == 3) {
            String str3 = C1765i.f15983d;
            t.d(str3, "TARGETED_ADVERTISING_OPT_OUT_NOTICE");
            return str3;
        } else if (ordinal != 7) {
            switch (ordinal) {
                case 9:
                    String str4 = C1765i.f15985f;
                    t.d(str4, "TARGETED_ADVERTISING_OPT_OUT");
                    return str4;
                case 10:
                    String str5 = C1765i.f15986g;
                    t.d(str5, "SENSITIVE_DATA_PROCESSING");
                    return str5;
                case 11:
                    String str6 = C1765i.f15987h;
                    t.d(str6, "KNOWN_CHILD_SENSITIVE_DATA_CONSENTS");
                    return str6;
                default:
                    switch (ordinal) {
                        case 13:
                            String str7 = C1765i.f15988i;
                            t.d(str7, "MSPA_COVERED_TRANSACTION");
                            return str7;
                        case 14:
                            String str8 = C1765i.f15989j;
                            t.d(str8, "MSPA_OPT_OUT_OPTION_MODE");
                            return str8;
                        case 15:
                            String str9 = C1765i.f15990k;
                            t.d(str9, "MSPA_SERVICE_PROVIDER_MODE");
                            return str9;
                        default:
                            return "";
                    }
            }
        } else {
            String str10 = C1765i.f15984e;
            t.d(str10, "SALE_OPT_OUT");
            return str10;
        }
    }

    public final String h() {
        String str = C1800j.f16409g;
        t.d(str, "NAME");
        return str;
    }

    public final int j() {
        return C1800j.f16407e;
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
