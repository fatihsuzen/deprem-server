package S3;

import R3.b;
import X2.C2250q;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import java.util.List;
import kotlin.jvm.internal.t;
import q1.C1766j;
import r1.C1801k;

public final class d extends i {
    public final String b(b bVar) {
        t.e(bVar, "field");
        int ordinal = bVar.ordinal();
        if (ordinal == 1) {
            String str = C1766j.f15998c;
            t.d(str, "SALE_OPT_OUT_NOTICE");
            return str;
        } else if (ordinal == 3) {
            String str2 = C1766j.f15999d;
            t.d(str2, "TARGETED_ADVERTISING_OPT_OUT_NOTICE");
            return str2;
        } else if (ordinal == 6) {
            String str3 = C1766j.f15997b;
            t.d(str3, "PROCESSING_NOTICE");
            return str3;
        } else if (ordinal != 7) {
            switch (ordinal) {
                case 9:
                    String str4 = C1766j.f16001f;
                    t.d(str4, "TARGETED_ADVERTISING_OPT_OUT");
                    return str4;
                case 10:
                    String str5 = C1766j.f16002g;
                    t.d(str5, "SENSITIVE_DATA_PROCESSING");
                    return str5;
                case 11:
                    String str6 = C1766j.f16003h;
                    t.d(str6, "KNOWN_CHILD_SENSITIVE_DATA_CONSENTS");
                    return str6;
                case 12:
                    String str7 = C1766j.f16004i;
                    t.d(str7, "ADDITIONAL_DATA_PROCESSING_CONSENT");
                    return str7;
                case 13:
                    String str8 = C1766j.f16005j;
                    t.d(str8, "MSPA_COVERED_TRANSACTION");
                    return str8;
                case 14:
                    String str9 = C1766j.f16006k;
                    t.d(str9, "MSPA_OPT_OUT_OPTION_MODE");
                    return str9;
                case 15:
                    String str10 = C1766j.f16007l;
                    t.d(str10, "MSPA_SERVICE_PROVIDER_MODE");
                    return str10;
                default:
                    return "";
            }
        } else {
            String str11 = C1766j.f16000e;
            t.d(str11, "SALE_OPT_OUT");
            return str11;
        }
    }

    public final void d(b bVar, boolean z4) {
        List list;
        t.e(bVar, "field");
        if (z4) {
            list = C2250q.j(1, 1, 1, 1, 1);
        } else {
            list = C2250q.j(2, 2, 2, 2, 2);
        }
        c(bVar, list);
        this.f19041d.setKnownChildSensitiveDataConsents(list);
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
        String str = C1801k.f16412g;
        t.d(str, "NAME");
        return str;
    }

    public final int j() {
        return C1801k.f16410e;
    }

    public final void g(boolean z4) {
    }

    public final void i(boolean z4) {
    }

    public final void m(boolean z4) {
    }
}
