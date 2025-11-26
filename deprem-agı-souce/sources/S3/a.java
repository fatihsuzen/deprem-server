package S3;

import R3.b;
import kotlin.jvm.internal.t;
import q1.C1763g;
import r1.C1798h;

public final class a extends i {
    public final String b(b bVar) {
        t.e(bVar, "field");
        int ordinal = bVar.ordinal();
        if (ordinal == 1) {
            String str = C1763g.f15948b;
            t.d(str, "SALE_OPT_OUT_NOTICE");
            return str;
        } else if (ordinal == 2) {
            String str2 = C1763g.f15949c;
            t.d(str2, "SHARING_OPT_OUT_NOTICE");
            return str2;
        } else if (ordinal == 5) {
            String str3 = C1763g.f15950d;
            t.d(str3, "SENSITIVE_DATA_LIMIT_USE_NOTICE");
            return str3;
        } else if (ordinal == 7) {
            String str4 = C1763g.f15951e;
            t.d(str4, "SALE_OPT_OUT");
            return str4;
        } else if (ordinal != 8) {
            switch (ordinal) {
                case 10:
                    String str5 = C1763g.f15953g;
                    t.d(str5, "SENSITIVE_DATA_PROCESSING");
                    return str5;
                case 11:
                    String str6 = C1763g.f15954h;
                    t.d(str6, "KNOWN_CHILD_SENSITIVE_DATA_CONSENTS");
                    return str6;
                case 12:
                    String str7 = C1763g.f15955i;
                    t.d(str7, "PERSONAL_DATA_CONSENTS");
                    return str7;
                case 13:
                    String str8 = C1763g.f15956j;
                    t.d(str8, "MSPA_COVERED_TRANSACTION");
                    return str8;
                case 14:
                    String str9 = C1763g.f15957k;
                    t.d(str9, "MSPA_OPT_OUT_OPTION_MODE");
                    return str9;
                case 15:
                    String str10 = C1763g.f15958l;
                    t.d(str10, "MSPA_SERVICE_PROVIDER_MODE");
                    return str10;
                default:
                    return "";
            }
        } else {
            String str11 = C1763g.f15952f;
            t.d(str11, "SHARING_OPT_OUT");
            return str11;
        }
    }

    public final String h() {
        String str = C1798h.f16403g;
        t.d(str, "NAME");
        return str;
    }

    public final int j() {
        return C1798h.f16401e;
    }

    public final void l() {
    }

    public final void i(boolean z4) {
    }

    public final void k(boolean z4) {
    }

    public final void n(boolean z4) {
    }
}
