package S3;

import R3.b;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import kotlin.jvm.internal.t;
import q1.C1772p;
import r1.C1807q;

public final class k extends i {
    public final String b(b bVar) {
        t.e(bVar, "field");
        int ordinal = bVar.ordinal();
        if (ordinal == 1) {
            String str = C1772p.f16100c;
            t.d(str, "SALE_OPT_OUT_NOTICE");
            return str;
        } else if (ordinal == 3) {
            String str2 = C1772p.f16101d;
            t.d(str2, "TARGETED_ADVERTISING_OPT_OUT_NOTICE");
            return str2;
        } else if (ordinal == 6) {
            String str3 = C1772p.f16099b;
            t.d(str3, "PROCESSING_NOTICE");
            return str3;
        } else if (ordinal != 7) {
            switch (ordinal) {
                case 9:
                    String str4 = C1772p.f16103f;
                    t.d(str4, "TARGETED_ADVERTISING_OPT_OUT");
                    return str4;
                case 10:
                    String str5 = C1772p.f16104g;
                    t.d(str5, "SENSITIVE_DATA_PROCESSING");
                    return str5;
                case 11:
                    String str6 = C1772p.f16105h;
                    t.d(str6, "KNOWN_CHILD_SENSITIVE_DATA_CONSENTS");
                    return str6;
                case 12:
                    String str7 = C1772p.f16106i;
                    t.d(str7, "ADDITIONAL_DATA_PROCESSING_CONSENT");
                    return str7;
                case 13:
                    String str8 = C1772p.f16107j;
                    t.d(str8, "MSPA_COVERED_TRANSACTION");
                    return str8;
                case 14:
                    String str9 = C1772p.f16108k;
                    t.d(str9, "MSPA_OPT_OUT_OPTION_MODE");
                    return str9;
                case 15:
                    String str10 = C1772p.f16109l;
                    t.d(str10, "MSPA_SERVICE_PROVIDER_MODE");
                    return str10;
                default:
                    return "";
            }
        } else {
            String str11 = C1772p.f16102e;
            t.d(str11, "SALE_OPT_OUT");
            return str11;
        }
    }

    public final void e(Boolean bool, b bVar) {
        int i5;
        t.e(bVar, "field");
        Boolean bool2 = Boolean.TRUE;
        int i6 = 2;
        if (t.a(bool, bool2)) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        USRegulationData uSRegulationData = this.f19041d;
        if (t.a(bool, bool2)) {
            i6 = 1;
        }
        uSRegulationData.setAdditionalProcessingDataConsent(i6);
        c(bVar, Integer.valueOf(i5));
    }

    public final String h() {
        String str = C1807q.f16430g;
        t.d(str, "NAME");
        return str;
    }

    public final int j() {
        return C1807q.f16428e;
    }

    public final void g(boolean z4) {
    }

    public final void i(boolean z4) {
    }

    public final void m(boolean z4) {
    }
}
