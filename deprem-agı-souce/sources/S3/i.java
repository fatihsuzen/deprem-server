package S3;

import H2.d;
import R3.b;
import X2.C2250q;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ChoiceError;
import java.util.List;
import k1.C1703a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q1.C1770n;
import r1.C1805o;
import r4.a;
import s4.c;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public final C1703a f19038a = c.g();

    /* renamed from: b  reason: collision with root package name */
    public final T3.i f19039b = c.j();

    /* renamed from: c  reason: collision with root package name */
    public final a f19040c = c.l();

    /* renamed from: d  reason: collision with root package name */
    public final USRegulationData f19041d = new USRegulationData(0, (String) null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (List) null, (List) null, 0, 0, 0, 0, 0, 524287, (C2633k) null);

    public i() {
    }

    public final String a() {
        try {
            String e5 = this.f19038a.e();
            t.d(e5, "{\n            gppModel.encode()\n        }");
            return e5;
        } catch (Exception unused) {
            d.c((String) null, ChoiceError.ERROR_WHILE_SAVING_CONSENT.getMessage(), (Exception) null, Boolean.TRUE, 5);
            return "";
        }
    }

    public String b(b bVar) {
        t.e(bVar, "field");
        switch (bVar.ordinal()) {
            case 0:
                String str = C1770n.f16061b;
                t.d(str, "SHARING_NOTICE");
                return str;
            case 1:
                String str2 = C1770n.f16062c;
                t.d(str2, "SALE_OPT_OUT_NOTICE");
                return str2;
            case 2:
                String str3 = C1770n.f16063d;
                t.d(str3, "SHARING_OPT_OUT_NOTICE");
                return str3;
            case 3:
                String str4 = C1770n.f16064e;
                t.d(str4, "TARGETED_ADVERTISING_OPT_OUT_NOTICE");
                return str4;
            case 4:
                String str5 = C1770n.f16065f;
                t.d(str5, "SENSITIVE_DATA_PROCESSING_OPT_OUT_NOTICE");
                return str5;
            case 5:
                String str6 = C1770n.f16066g;
                t.d(str6, "SENSITIVE_DATA_LIMIT_USE_NOTICE");
                return str6;
            case 7:
                String str7 = C1770n.f16067h;
                t.d(str7, "SALE_OPT_OUT");
                return str7;
            case 8:
                String str8 = C1770n.f16068i;
                t.d(str8, "SHARING_OPT_OUT");
                return str8;
            case 9:
                String str9 = C1770n.f16069j;
                t.d(str9, "TARGETED_ADVERTISING_OPT_OUT");
                return str9;
            case 10:
                String str10 = C1770n.f16070k;
                t.d(str10, "SENSITIVE_DATA_PROCESSING");
                return str10;
            case 11:
                String str11 = C1770n.f16071l;
                t.d(str11, "KNOWN_CHILD_SENSITIVE_DATA_CONSENTS");
                return str11;
            case 12:
                String str12 = C1770n.f16072m;
                t.d(str12, "PERSONAL_DATA_CONSENTS");
                return str12;
            case 13:
                String str13 = C1770n.f16073n;
                t.d(str13, "MSPA_COVERED_TRANSACTION");
                return str13;
            case 14:
                String str14 = C1770n.f16074o;
                t.d(str14, "MSPA_OPT_OUT_OPTION_MODE");
                return str14;
            case 15:
                String str15 = C1770n.f16075p;
                t.d(str15, "MSPA_SERVICE_PROVIDER_MODE");
                return str15;
            default:
                return "";
        }
    }

    public final void c(b bVar, Object obj) {
        t.e(bVar, "field");
        t.e(obj, "value");
        try {
            this.f19038a.m(h(), b(bVar), obj);
        } catch (Exception unused) {
            d.c((String) null, ChoiceError.ERROR_WHILE_SAVING_CONSENT.getMessage(), (Exception) null, Boolean.TRUE, 5);
        }
    }

    public void d(b bVar, boolean z4) {
        List list;
        t.e(bVar, "field");
        if (z4) {
            list = C2250q.j(1, 1, 1);
        } else {
            list = C2250q.j(2, 2, 2);
        }
        c(bVar, list);
        this.f19041d.setKnownChildSensitiveDataConsents(list);
    }

    public void e(Boolean bool, b bVar) {
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
        uSRegulationData.setPersonalDataConsents(i6);
        c(bVar, Integer.valueOf(i5));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: R3.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: R3.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: R3.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: R3.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: java.util.ArrayList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(java.util.List r20, boolean r21, k3.l r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            java.lang.String r2 = "purposes"
            r3 = r20
            kotlin.jvm.internal.t.e(r3, r2)
            r4.a r2 = r0.f19040c
            r4.b r4 = r4.b.SAVED_MSPA_SECTION_ID
            r2.getClass()
            java.lang.String r5 = "preferenceKey"
            kotlin.jvm.internal.t.e(r4, r5)
            android.content.SharedPreferences r2 = r2.f25721a
            r4 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.String r6 = "SavedSectionId"
            int r2 = r2.getInt(r6, r4)
            java.lang.String r8 = java.lang.String.valueOf(r2)
            r10 = 4
            r11 = 0
            java.lang.String r6 = "IABGPP_[SectionID]_String"
            java.lang.String r7 = "[SectionID]"
            r9 = 0
            java.lang.String r6 = t3.s.L(r6, r7, r8, r9, r10, r11)
            r4.a r7 = r0.f19040c
            java.lang.String r8 = ""
            r7.c(r6, r8)
            r4.a r6 = r0.f19040c
            r4.b r7 = r4.b.HDR_SECTION_LIST
            java.lang.String r6 = r6.k(r7)
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0077 }
            r7.<init>(r6)     // Catch:{ JSONException -> 0x0077 }
            int r6 = r7.length()     // Catch:{ JSONException -> 0x0077 }
            q3.d r6 = q3.C2729e.l(r4, r6)     // Catch:{ JSONException -> 0x0077 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0077 }
            r10 = 10
            int r10 = X2.C2250q.p(r6, r10)     // Catch:{ JSONException -> 0x0077 }
            r9.<init>(r10)     // Catch:{ JSONException -> 0x0077 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ JSONException -> 0x0077 }
        L_0x005e:
            boolean r10 = r6.hasNext()     // Catch:{ JSONException -> 0x0077 }
            if (r10 == 0) goto L_0x007b
            r10 = r6
            X2.J r10 = (X2.J) r10     // Catch:{ JSONException -> 0x0077 }
            int r10 = r10.nextInt()     // Catch:{ JSONException -> 0x0077 }
            int r10 = r7.getInt(r10)     // Catch:{ JSONException -> 0x0077 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ JSONException -> 0x0077 }
            r9.add(r10)     // Catch:{ JSONException -> 0x0077 }
            goto L_0x005e
        L_0x0077:
            java.util.List r9 = X2.C2250q.g()
        L_0x007b:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Iterator r6 = r9.iterator()
        L_0x0084:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x009c
            java.lang.Object r7 = r6.next()
            r9 = r7
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            if (r9 != r2) goto L_0x0098
            goto L_0x0084
        L_0x0098:
            r10.add(r7)
            goto L_0x0084
        L_0x009c:
            r4.a r6 = r0.f19040c
            r4.b r7 = r4.b.HDR_SECTION_LIST
            java.lang.String r9 = r10.toString()
            r6.i(r7, r9)
            r4.a r6 = r0.f19040c
            r4.b r7 = r4.b.HDR_SECTION_ID
            r17 = 62
            r18 = 0
            java.lang.String r11 = "_"
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            java.lang.String r9 = X2.C2250q.V(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r6.i(r7, r9)
            k1.a r6 = r0.f19038a
            r6.c(r2)
            java.lang.String r2 = r0.a()
            r4.a r6 = r0.f19040c
            r4.b r7 = r4.b.HDR_GPP_STRING
            r6.i(r7, r2)
            java.util.Iterator r2 = r3.iterator()
        L_0x00d2:
            boolean r6 = r2.hasNext()
            r9 = 1
            if (r6 == 0) goto L_0x0257
            java.lang.Object r6 = r2.next()
            R3.f r6 = (R3.f) r6
            java.lang.Integer r10 = r6.f18985a
            if (r10 != 0) goto L_0x00e4
            goto L_0x00d2
        L_0x00e4:
            int r10 = r10.intValue()
            switch(r10) {
                case 1: goto L_0x00fd;
                case 2: goto L_0x00fa;
                case 3: goto L_0x00f7;
                case 4: goto L_0x00f4;
                case 5: goto L_0x00f1;
                case 6: goto L_0x00ee;
                default: goto L_0x00eb;
            }
        L_0x00eb:
            R3.b r10 = R3.b.NONE
            goto L_0x00ff
        L_0x00ee:
            R3.b r10 = R3.b.KnownChildSensitiveDataConsents
            goto L_0x00ff
        L_0x00f1:
            R3.b r10 = R3.b.SensitiveDataProcessing
            goto L_0x00ff
        L_0x00f4:
            R3.b r10 = R3.b.PersonalDataConsents
            goto L_0x00ff
        L_0x00f7:
            R3.b r10 = R3.b.TargetedAdvertisingOptOut
            goto L_0x00ff
        L_0x00fa:
            R3.b r10 = R3.b.SaleOptOut
            goto L_0x00ff
        L_0x00fd:
            R3.b r10 = R3.b.SharingOptOut
        L_0x00ff:
            int r11 = r10.ordinal()
            switch(r11) {
                case 7: goto L_0x0219;
                case 8: goto L_0x01d4;
                case 9: goto L_0x0198;
                case 10: goto L_0x012e;
                case 11: goto L_0x0122;
                case 12: goto L_0x0107;
                default: goto L_0x0106;
            }
        L_0x0106:
            goto L_0x00d2
        L_0x0107:
            boolean r7 = r6.f18991g
            if (r7 == 0) goto L_0x010f
            r0.l()
            goto L_0x00d2
        L_0x010f:
            java.lang.String r7 = r0.b(r10)
            int r7 = r7.length()
            if (r7 <= 0) goto L_0x00d2
            r0.l()
            java.lang.Boolean r6 = r6.f18987c
            r0.e(r6, r10)
            goto L_0x00d2
        L_0x0122:
            java.lang.Boolean r6 = r6.f18987c
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            boolean r6 = kotlin.jvm.internal.t.a(r6, r7)
            r0.d(r10, r6)
            goto L_0x00d2
        L_0x012e:
            java.util.List r11 = r6.f18990f
            if (r11 != 0) goto L_0x0134
            r6 = r5
            goto L_0x0193
        L_0x0134:
            r0.i(r1)
            r0.g(r1)
            r12 = 16
            int[] r13 = new int[r12]
            r14 = r4
        L_0x013f:
            if (r14 >= r12) goto L_0x0146
            r13[r14] = r4
            int r14 = r14 + 1
            goto L_0x013f
        L_0x0146:
            java.util.Iterator r11 = r11.iterator()
        L_0x014a:
            boolean r14 = r11.hasNext()
            if (r14 == 0) goto L_0x0186
            java.lang.Object r14 = r11.next()
            R3.g r14 = (R3.g) r14
            java.lang.Integer r15 = r14.f18993b
            if (r15 == 0) goto L_0x014a
            q3.d r15 = new q3.d
            r15.<init>(r9, r12)
            java.lang.Integer r7 = r14.f18993b
            int r7 = r7.intValue()
            boolean r7 = r15.k(r7)
            if (r7 == 0) goto L_0x014a
            java.lang.Integer r7 = r14.f18993b
            int r7 = r7.intValue()
            int r7 = r7 - r9
            java.lang.Boolean r14 = r14.f18995d
            if (r14 != 0) goto L_0x0178
            java.lang.Boolean r14 = r6.f18987c
        L_0x0178:
            java.lang.Boolean r15 = java.lang.Boolean.TRUE
            boolean r14 = kotlin.jvm.internal.t.a(r14, r15)
            if (r14 == 0) goto L_0x0182
            r14 = r9
            goto L_0x0183
        L_0x0182:
            r14 = 2
        L_0x0183:
            r13[r7] = r14
            goto L_0x014a
        L_0x0186:
            java.util.List r6 = X2.C2242i.p0(r13)
            com.inmobi.cmp.core.model.mspa.USRegulationData r7 = r0.f19041d
            java.util.List r9 = X2.C2242i.p0(r13)
            r7.setSensitiveDataProcessing(r9)
        L_0x0193:
            r0.c(r10, r6)
            goto L_0x00d2
        L_0x0198:
            java.lang.String r7 = r0.b(r10)
            int r7 = r7.length()
            if (r7 <= 0) goto L_0x00d2
            r0.n(r1)
            if (r1 == 0) goto L_0x01b5
            java.lang.Boolean r7 = r6.f18987c
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            boolean r7 = kotlin.jvm.internal.t.a(r7, r11)
            if (r7 == 0) goto L_0x01b3
            r7 = r9
            goto L_0x01b6
        L_0x01b3:
            r7 = 2
            goto L_0x01b6
        L_0x01b5:
            r7 = r4
        L_0x01b6:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            com.inmobi.cmp.core.model.mspa.USRegulationData r11 = r0.f19041d
            if (r1 == 0) goto L_0x01cb
            java.lang.Boolean r6 = r6.f18987c
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            boolean r6 = kotlin.jvm.internal.t.a(r6, r12)
            if (r6 == 0) goto L_0x01c9
            goto L_0x01cc
        L_0x01c9:
            r9 = 2
            goto L_0x01cc
        L_0x01cb:
            r9 = r4
        L_0x01cc:
            r11.setTargetedAdvertisingOptOut(r9)
            r0.c(r10, r7)
            goto L_0x00d2
        L_0x01d4:
            boolean r7 = r6.f18991g
            if (r7 == 0) goto L_0x01dd
            r0.k(r1)
            goto L_0x00d2
        L_0x01dd:
            r0.m(r1)
            java.lang.String r7 = r0.b(r10)
            int r7 = r7.length()
            if (r7 <= 0) goto L_0x00d2
            if (r1 == 0) goto L_0x01fa
            java.lang.Boolean r7 = r6.f18987c
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            boolean r7 = kotlin.jvm.internal.t.a(r7, r11)
            if (r7 == 0) goto L_0x01f8
            r7 = r9
            goto L_0x01fb
        L_0x01f8:
            r7 = 2
            goto L_0x01fb
        L_0x01fa:
            r7 = r4
        L_0x01fb:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            com.inmobi.cmp.core.model.mspa.USRegulationData r11 = r0.f19041d
            if (r1 == 0) goto L_0x0210
            java.lang.Boolean r6 = r6.f18987c
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            boolean r6 = kotlin.jvm.internal.t.a(r6, r12)
            if (r6 == 0) goto L_0x020e
            goto L_0x0211
        L_0x020e:
            r9 = 2
            goto L_0x0211
        L_0x0210:
            r9 = r4
        L_0x0211:
            r11.setSharingOptOut(r9)
            r0.c(r10, r7)
            goto L_0x00d2
        L_0x0219:
            if (r1 == 0) goto L_0x021d
            r7 = r9
            goto L_0x021e
        L_0x021d:
            r7 = 2
        L_0x021e:
            R3.b r11 = R3.b.SaleOptOutNotice
            java.lang.Integer r12 = java.lang.Integer.valueOf(r7)
            r0.c(r11, r12)
            com.inmobi.cmp.core.model.mspa.USRegulationData r11 = r0.f19041d
            r11.setSaleOptOutNotice(r7)
            if (r1 == 0) goto L_0x023c
            java.lang.Boolean r7 = r6.f18987c
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            boolean r7 = kotlin.jvm.internal.t.a(r7, r11)
            if (r7 == 0) goto L_0x023a
            r7 = r9
            goto L_0x023d
        L_0x023a:
            r7 = 2
            goto L_0x023d
        L_0x023c:
            r7 = r4
        L_0x023d:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            com.inmobi.cmp.core.model.mspa.USRegulationData r11 = r0.f19041d
            java.lang.Boolean r6 = r6.f18987c
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            boolean r6 = kotlin.jvm.internal.t.a(r6, r12)
            if (r6 == 0) goto L_0x024e
            goto L_0x024f
        L_0x024e:
            r9 = 2
        L_0x024f:
            r11.setSaleOptOut(r9)
            r0.c(r10, r7)
            goto L_0x00d2
        L_0x0257:
            T3.i r1 = r0.f19039b
            T3.c r1 = r1.f19281b
            boolean r1 = r1.f19220K
            if (r1 == 0) goto L_0x0261
            r1 = r9
            goto L_0x0262
        L_0x0261:
            r1 = 2
        L_0x0262:
            R3.b r2 = R3.b.MspaCoveredTransaction
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            r0.c(r2, r6)
            com.inmobi.cmp.core.model.mspa.USRegulationData r2 = r0.f19041d
            r2.setMspaCoveredTransaction(r1)
            T3.i r1 = r0.f19039b
            T3.c r1 = r1.f19281b
            java.lang.String r1 = r1.f19221L
            r2 = 0
            if (r1 != 0) goto L_0x027b
            r1 = r2
            goto L_0x02af
        L_0x027b:
            java.lang.String r6 = "OPT_OUT"
            boolean r6 = kotlin.jvm.internal.t.a(r1, r6)
            if (r6 == 0) goto L_0x0285
            r6 = r9
            goto L_0x0286
        L_0x0285:
            r6 = 2
        L_0x0286:
            java.lang.String r7 = "SERVICE-PROVIDER"
            boolean r1 = kotlin.jvm.internal.t.a(r1, r7)
            if (r1 == 0) goto L_0x0290
            r7 = r9
            goto L_0x0291
        L_0x0290:
            r7 = 2
        L_0x0291:
            R3.b r1 = R3.b.MspaOptOutOptionMode
            java.lang.Integer r10 = java.lang.Integer.valueOf(r6)
            r0.c(r1, r10)
            R3.b r1 = R3.b.MspaServiceProviderMode
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)
            r0.c(r1, r10)
            com.inmobi.cmp.core.model.mspa.USRegulationData r1 = r0.f19041d
            r1.setMspaOptOutOptionMode(r6)
            com.inmobi.cmp.core.model.mspa.USRegulationData r1 = r0.f19041d
            r1.setMspaServiceProviderMode(r7)
            W2.J r1 = W2.J.f19942a
        L_0x02af:
            if (r1 != 0) goto L_0x02c5
            R3.b r1 = R3.b.MspaOptOutOptionMode
            r0.c(r1, r5)
            R3.b r1 = R3.b.MspaServiceProviderMode
            r0.c(r1, r5)
            com.inmobi.cmp.core.model.mspa.USRegulationData r1 = r0.f19041d
            r1.setMspaOptOutOptionMode(r4)
            com.inmobi.cmp.core.model.mspa.USRegulationData r1 = r0.f19041d
            r1.setMspaServiceProviderMode(r4)
        L_0x02c5:
            com.inmobi.cmp.core.model.Vector r1 = new com.inmobi.cmp.core.model.Vector
            r1.<init>(r2, r9, r2)
            java.util.Iterator r4 = r3.iterator()
        L_0x02ce:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x02f5
            java.lang.Object r5 = r4.next()
            R3.f r5 = (R3.f) r5
            java.lang.Integer r6 = r5.f18985a
            if (r6 != 0) goto L_0x02df
            goto L_0x02ce
        L_0x02df:
            int r6 = r6.intValue()
            java.lang.Boolean r5 = r5.f18987c
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            boolean r5 = kotlin.jvm.internal.t.a(r5, r7)
            if (r5 == 0) goto L_0x02f1
            r1.set((int) r6)
            goto L_0x02ce
        L_0x02f1:
            r1.unset((int) r6)
            goto L_0x02ce
        L_0x02f5:
            r4.a r4 = r0.f19040c
            r4.b r5 = r4.b.MSPA_PURPOSE_CONSENT
            r4.h(r5, r1)
            com.inmobi.cmp.core.model.Vector r1 = new com.inmobi.cmp.core.model.Vector
            r1.<init>(r2, r9, r2)
            java.util.Iterator r3 = r3.iterator()
        L_0x0305:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0324
            java.lang.Object r4 = r3.next()
            r5 = r4
            R3.f r5 = (R3.f) r5
            java.lang.Integer r5 = r5.f18985a
            int[] r6 = R3.j.f19017b
            int r6 = X2.C2242i.Q(r6)
            if (r5 != 0) goto L_0x031d
            goto L_0x0305
        L_0x031d:
            int r5 = r5.intValue()
            if (r5 != r6) goto L_0x0305
            r2 = r4
        L_0x0324:
            R3.f r2 = (R3.f) r2
            if (r2 != 0) goto L_0x0329
            goto L_0x0359
        L_0x0329:
            java.util.List r2 = r2.f18990f
            if (r2 != 0) goto L_0x032e
            goto L_0x0359
        L_0x032e:
            java.util.Iterator r2 = r2.iterator()
        L_0x0332:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0359
            java.lang.Object r3 = r2.next()
            R3.g r3 = (R3.g) r3
            java.lang.Integer r4 = r3.f18993b
            if (r4 != 0) goto L_0x0343
            goto L_0x0332
        L_0x0343:
            int r4 = r4.intValue()
            java.lang.Boolean r3 = r3.f18995d
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            boolean r3 = kotlin.jvm.internal.t.a(r3, r5)
            if (r3 == 0) goto L_0x0355
            r1.set((int) r4)
            goto L_0x0332
        L_0x0355:
            r1.unset((int) r4)
            goto L_0x0332
        L_0x0359:
            r4.a r2 = r0.f19040c
            r4.b r3 = r4.b.MSPA_SENSITIVE_PURPOSE_CONSENT
            r2.h(r3, r1)
            android.app.Application r1 = s4.c.f25853a
            k1.a r1 = r0.f19038a
            java.lang.String r2 = "gppModel"
            kotlin.jvm.internal.t.e(r1, r2)
            s4.c.f25867o = r1
            com.inmobi.cmp.core.model.mspa.USRegulationData r1 = r0.f19041d
            java.lang.String r2 = r0.a()
            r1.setGppString(r2)
            com.inmobi.cmp.core.model.mspa.USRegulationData r1 = r0.f19041d
            r1.setVersion(r9)
            r4.a r1 = r0.f19040c
            r4.b r2 = r4.b.SAVED_MSPA_SECTION_ID
            int r3 = r0.j()
            r1.f(r2, r3)
            r4.a r1 = r0.f19040c
            r4.b r2 = r4.b.HDR_GPP_VERSION
            k1.a r3 = r0.f19038a
            r1.c r3 = r3.g()
            int r3 = r3.h()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r1.i(r2, r3)
            r4.a r1 = r0.f19040c
            r4.b r2 = r4.b.HDR_SECTION_LIST
            k1.a r3 = r0.f19038a
            java.util.List r3 = r3.j()
            java.lang.String r3 = r3.toString()
            r1.i(r2, r3)
            r4.a r1 = r0.f19040c
            r4.b r2 = r4.b.HDR_SECTION_ID
            k1.a r3 = r0.f19038a
            java.util.List r9 = r3.j()
            java.lang.String r3 = "gppModel.sectionIds"
            kotlin.jvm.internal.t.d(r9, r3)
            r16 = 62
            r17 = 0
            java.lang.String r10 = "_"
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            java.lang.String r3 = X2.C2250q.V(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r1.i(r2, r3)
            int r1 = r0.j()
            java.lang.String r4 = java.lang.String.valueOf(r1)
            r6 = 4
            r7 = 0
            java.lang.String r2 = "IABGPP_[SectionID]_String"
            java.lang.String r3 = "[SectionID]"
            r5 = 0
            java.lang.String r1 = t3.s.L(r2, r3, r4, r5, r6, r7)
            r4.a r2 = r0.f19040c
            k1.a r3 = r0.f19038a     // Catch:{ Exception -> 0x03f4 }
            java.lang.String r4 = r0.h()     // Catch:{ Exception -> 0x03f4 }
            r1.b r3 = r3.i(r4)     // Catch:{ Exception -> 0x03f4 }
            java.lang.String r3 = r3.b()     // Catch:{ Exception -> 0x03f4 }
            java.lang.String r4 = "{\n            gppModel.g…ction).encode()\n        }"
            kotlin.jvm.internal.t.d(r3, r4)     // Catch:{ Exception -> 0x03f4 }
            r8 = r3
        L_0x03f4:
            r2.c(r1, r8)
            r4.a r1 = r0.f19040c
            r4.b r2 = r4.b.HDR_GPP_STRING
            com.inmobi.cmp.core.model.mspa.USRegulationData r3 = r0.f19041d
            java.lang.String r3 = r3.getGppString()
            r1.i(r2, r3)
            r4.a r1 = r0.f19040c
            r4.b r2 = r4.b.SAVED_MSPA_JURISDICTION
            J2.i r3 = R3.e.f18984f
            java.lang.String r3 = r3.f18282a
            r1.i(r2, r3)
            r4.a r1 = r0.f19040c
            r4.b r2 = r4.b.SAVED_REGION
            java.lang.String r3 = s4.c.f25865m
            r1.i(r2, r3)
            com.inmobi.cmp.core.model.mspa.USRegulationData r1 = r0.f19041d
            r2 = r22
            r2.invoke(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: S3.i.f(java.util.List, boolean, k3.l):void");
    }

    public void g(boolean z4) {
        int i5;
        if (z4) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        c(b.SensitiveDataLimitUseNotice, Integer.valueOf(i5));
        this.f19041d.setSensitiveDataLimitUseNotice(i5);
    }

    public String h() {
        String str = C1805o.f16424g;
        t.d(str, "NAME");
        return str;
    }

    public void i(boolean z4) {
        int i5;
        if (z4) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        c(b.SensitiveDataProcessingOptOutNotice, Integer.valueOf(i5));
        this.f19041d.setSensitiveDataProcessingOptOutNotice(i5);
    }

    public int j() {
        return C1805o.f16422e;
    }

    public void k(boolean z4) {
        int i5;
        if (z4) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        c(b.SharingNotice, Integer.valueOf(i5));
        this.f19041d.setSharingNotice(i5);
    }

    public void m(boolean z4) {
        int i5;
        if (z4) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        c(b.SharingOptOutNotice, Integer.valueOf(i5));
        this.f19041d.setSharingOptOutNotice(i5);
    }

    public void n(boolean z4) {
        int i5;
        if (z4) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        c(b.TargetedAdvertisingOptOutNotice, Integer.valueOf(i5));
        this.f19041d.setTargetedAdvertisingOptOutNotice(i5);
    }

    public void l() {
    }
}
