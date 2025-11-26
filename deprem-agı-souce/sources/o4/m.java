package o4;

import J2.d;
import J2.e;
import J2.j;
import J2.k;
import J2.n;
import J2.u;
import L2.h;
import X2.C2250q;
import android.app.Application;
import android.os.Build;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.cmpapi.status.CmpStatus;
import com.inmobi.cmp.core.model.ACData;
import com.inmobi.cmp.core.model.GDPRData;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import com.inmobi.cmp.model.ChoiceError;
import com.inmobi.cmp.model.NonIABData;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import k1.C1703a;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import n1.o;
import q1.C1762f;
import r1.C1797g;
import r4.a;
import r4.b;
import s4.c;
import t3.C2777a;
import t3.s;

public final class m implements j {

    /* renamed from: a  reason: collision with root package name */
    public final a f25600a;

    /* renamed from: b  reason: collision with root package name */
    public final u f25601b;

    /* renamed from: c  reason: collision with root package name */
    public final ChoiceCmpCallback f25602c;

    /* renamed from: d  reason: collision with root package name */
    public final h f25603d = new h(Boolean.TRUE, 2, C2250q.l(n.CORE));

    public m(a aVar, u uVar, ChoiceCmpCallback choiceCmpCallback) {
        t.e(aVar, "sharedStorage");
        t.e(uVar, "tcModel");
        this.f25600a = aVar;
        this.f25601b = uVar;
        this.f25602c = choiceCmpCallback;
    }

    public final void a() {
        d dVar;
        Object obj;
        Integer num;
        int i5;
        String str = "";
        u uVar = this.f25601b;
        t.e(uVar, "tcModel");
        try {
            C1703a g5 = c.g();
            a l5 = c.l();
            g5.m(C1797g.f16400g, C1762f.f15921a, Integer.valueOf(uVar.f18322i));
            g5.m(C1797g.f16400g, C1762f.f15924d, Integer.valueOf(uVar.f18326m));
            g5.m(C1797g.f16400g, C1762f.f15925e, Integer.valueOf(uVar.f18327n));
            g5.m(C1797g.f16400g, C1762f.f15926f, Integer.valueOf(uVar.f18323j));
            g5.m(C1797g.f16400g, C1762f.f15927g, uVar.f18325l);
            String str2 = C1797g.f16400g;
            String str3 = C1762f.f15928h;
            P3.d dVar2 = uVar.f18314a;
            if (dVar2 == null) {
                num = null;
            } else {
                num = dVar2.f18870b;
            }
            if (num == null) {
                i5 = uVar.f18328o;
            } else {
                i5 = num.intValue();
            }
            g5.m(str2, str3, Integer.valueOf(i5));
            g5.m(C1797g.f16400g, C1762f.f15929i, Integer.valueOf(uVar.f()));
            g5.m(C1797g.f16400g, C1762f.f15930j, Boolean.valueOf(uVar.f18318e));
            g5.m(C1797g.f16400g, C1762f.f15931k, Boolean.valueOf(uVar.f18319f));
            g5.m(C1797g.f16400g, C1762f.f15932l, e.a(12, uVar.f18330q));
            g5.m(C1797g.f16400g, C1762f.f15933m, e.a(24, uVar.f18331r));
            g5.m(C1797g.f16400g, C1762f.f15934n, e.a(24, uVar.f18332s));
            g5.m(C1797g.f16400g, C1762f.f15935o, Boolean.valueOf(uVar.f18320g));
            g5.m(C1797g.f16400g, C1762f.f15936p, uVar.f18321h);
            g5.m(C1797g.f16400g, C1762f.f15937q, C2250q.n0(uVar.f18339z.getAcceptedItems()));
            g5.m(C1797g.f16400g, C1762f.f15938r, C2250q.n0(uVar.f18309C.getAcceptedItems()));
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : uVar.f18313G.f18287c.entrySet()) {
                k a5 = j.a((String) entry.getKey());
                arrayList.add(new o(a5.f18283a, a5.f18284b.f18293a, C2250q.n0((Set) entry.getValue())));
            }
            g5.m(C1797g.f16400g, C1762f.f15939s, arrayList);
            g5.m(C1797g.f16400g, C1762f.f15941u, e.a(24, uVar.f18335v));
            g5.m(C1797g.f16400g, C1762f.f15942v, e.a(24, uVar.f18336w));
            int i6 = uVar.f18329p;
            g5.m(C1797g.f16400g, C1762f.f15943w, Integer.valueOf(i6));
            g5.m(C1797g.f16400g, C1762f.f15944x, e.a(i6, uVar.f18337x));
            g5.m(C1797g.f16400g, C1762f.f15945y, e.a(i6, uVar.f18338y));
            g5.m(C1797g.f16400g, C1762f.f15914A, C2250q.n0(uVar.f18312F.getAcceptedItems()));
            g5.m(C1797g.f16400g, C1762f.f15916C, C2250q.n0(uVar.f18311E.getAcceptedItems()));
            l5.i(b.HDR_GPP_VERSION, String.valueOf(g5.g().h()));
            l5.i(b.HDR_SECTION_LIST, g5.j().toString());
            b bVar = b.HDR_SECTION_ID;
            List j5 = g5.j();
            t.d(j5, "gppModel.sectionIds");
            l5.i(bVar, C2250q.V(j5, "_", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null));
            String L4 = s.L("IABGPP_[SectionID]_String", "[SectionID]", String.valueOf(C1797g.f16398e), false, 4, (Object) null);
            String b5 = g5.i(C1797g.f16400g).b();
            t.d(b5, "tcfEuV2SectionString");
            l5.c(L4, b5);
            ZonedDateTime zonedDateTime = uVar.f18317d;
            if (zonedDateTime != null) {
                g5.m(C1797g.f16400g, C1762f.f15922b, zonedDateTime);
                g5.m(C1797g.f16400g, C1762f.f15923c, uVar.f18317d);
            }
            Application application = c.f25853a;
            t.e(g5, "gppModel");
            c.f25867o = g5;
            dVar = new d(g5.e(), b5);
        } catch (Exception e5) {
            H2.d.c("GPPString", t.n("Error while encoding GPP String: ", e5.getMessage()), e5, (Boolean) null, 8);
            ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
            if (callback != null) {
                callback.onCmpError(ChoiceError.ERROR_WHILE_SAVING_CONSENT);
            }
            dVar = new d(str, str);
        }
        a aVar = this.f25600a;
        String str4 = dVar.f18271a;
        if (str4 == null) {
            str4 = str;
        }
        String str5 = dVar.f18272b;
        if (str5 != null) {
            str = str5;
        }
        String b6 = L2.d.b(uVar.f18307A);
        String b7 = l4.e.b(uVar.f18307A.toString());
        String b8 = L2.d.b(uVar.f18310D);
        Set<Integer> acceptedItems = uVar.f18308B.getAcceptedItems();
        t.e(acceptedItems, "vendorsID");
        String str6 = "1~";
        int i7 = 0;
        for (T next : acceptedItems) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                C2250q.o();
            }
            int intValue = ((Number) next).intValue();
            if (i7 != 0) {
                obj = t.n(".", Integer.valueOf(intValue));
            } else {
                obj = Integer.valueOf(intValue);
            }
            str6 = t.n(str6, obj);
            i7 = i8;
        }
        String b9 = L2.d.b(uVar.f18339z);
        String b10 = L2.d.b(uVar.f18309C);
        String b11 = L2.d.b(uVar.f18331r);
        String b12 = L2.d.b(uVar.f18332s);
        String b13 = L2.d.b(uVar.f18330q);
        String obj2 = uVar.f18313G.f18287c.toString();
        String b14 = L2.d.b(uVar.f18335v);
        String b15 = L2.d.b(uVar.f18336w);
        a aVar2 = aVar;
        String b16 = L2.d.b(uVar.f18337x);
        String b17 = L2.d.b(uVar.f18338y);
        aVar2.getClass();
        String str7 = b17;
        t.e(str4, "gppString");
        t.e(str, "tcString");
        t.e(b6, "nonIabVendorConsents");
        t.e(b7, "nonIabVendorConsentsEncoded");
        t.e(b8, "nonIabVendorLegitimateInterests");
        t.e(str6, "googleVendorConsents");
        t.e(b9, "iabVendorConsents");
        t.e(b10, "vendorLegitimateInterests");
        t.e(b11, "purposeConsents");
        t.e(b12, "purposeLegitimateInterests");
        t.e(b13, "specialFeatureOptions");
        t.e(obj2, "publisherRestrictions");
        t.e(b14, "publisherConsents");
        t.e(b15, "publisherLegitimateInterests");
        t.e(b16, "publisherCustomConsents");
        String str8 = b7;
        t.e(str7, "publisherCustomLegitimateInterests");
        a aVar3 = aVar2;
        aVar3.i(b.HDR_GPP_STRING, str4);
        aVar3.i(b.GPP_TC_STRING, str);
        aVar3.i(b.NON_IAB_VENDOR_CONSENTS, b6);
        b bVar2 = b.NON_IAB_VENDOR_CONSENT_HASH;
        aVar3.i(bVar2, l4.e.b(str8));
        aVar3.i(b.NON_IAB_VENDOR_LEG_INTERESTS, b8);
        aVar3.i(b.OPTION_HASH, t.n(aVar3.k(bVar2), aVar3.k(b.PORTAL_CONFIG_HASH)));
        aVar3.i(b.ADDTL_CONSENT, str6);
        aVar3.i(b.GPP_VENDOR_CONSENTS, b9);
        aVar3.i(b.GPP_VENDOR_LEGITIMATE_INTERESTS, b10);
        aVar3.i(b.GPP_PURPOSE_CONSENTS, b11);
        aVar3.i(b.GPP_PURPOSE_LEGITIMATE_INTERESTS, b12);
        aVar3.i(b.GPP_SPECIAL_FEATURES_OPT_INS, b13);
        aVar3.i(b.GPP_PUBLISHER_RESTRICTIONS, obj2);
        aVar3.i(b.GPP_PUBLISHER_CONSENT, b14);
        aVar3.i(b.GPP_PUBLISHER_LEGITIMATE_INTERESTS, b15);
        aVar3.i(b.GPP_PUBLISHER_CUSTOM_PURPOSES_CONSENTS, b16);
        aVar3.i(b.GPP_PUBLISHER_CUSTOM_PURPOSES_LEGITIMATE_INTERESTS, str7);
    }

    public final void b(PrivacyEncodingMode privacyEncodingMode, boolean z4, boolean z5) {
        ChoiceCmpCallback choiceCmpCallback;
        Object obj;
        boolean z6;
        boolean z7;
        PrivacyEncodingMode privacyEncodingMode2 = privacyEncodingMode;
        t.e(privacyEncodingMode2, "encodingMode");
        u uVar = this.f25601b;
        int i5 = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
            ZonedDateTime of = ZonedDateTime.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth(), 0, 0, 0, 0, ZoneOffset.UTC);
            uVar.f18317d = of;
            long epochMilli = of.toInstant().toEpochMilli();
            uVar.f18315b = epochMilli;
            uVar.f18316c = epochMilli;
        } else {
            Calendar instance = Calendar.getInstance();
            instance.setTime(new Date());
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            long timeInMillis = instance.getTimeInMillis();
            uVar.f18315b = timeInMillis;
            uVar.f18316c = timeInMillis;
        }
        int i6 = l.f25599a[privacyEncodingMode2.ordinal()];
        if (i6 == 1) {
            a();
        } else if (i6 != 2) {
            a();
            c();
        } else {
            c();
        }
        a aVar = this.f25600a;
        b bVar = b.NON_IAB_CONSENT_ENCODED;
        u uVar2 = this.f25601b;
        long j5 = uVar2.f18315b;
        long j6 = uVar2.f18316c;
        int i7 = uVar2.f18326m;
        int i8 = uVar2.f18327n;
        int maxId = uVar2.f18307A.getMaxId();
        Set<Integer> acceptedItems = uVar2.f18307A.getAcceptedItems();
        t.e(acceptedItems, "vendorConsents");
        StringBuilder sb = new StringBuilder();
        String l5 = Long.toString(j5, C2777a.a(2));
        t.d(l5, "toString(this, checkRadix(radix))");
        sb.append(l5);
        String l6 = Long.toString(j6, C2777a.a(2));
        t.d(l6, "toString(this, checkRadix(radix))");
        sb.append(l6);
        String num = Integer.toString(i7, C2777a.a(2));
        t.d(num, "toString(this, checkRadix(radix))");
        sb.append(num);
        String num2 = Integer.toString(i8, C2777a.a(2));
        t.d(num2, "toString(this, checkRadix(radix))");
        sb.append(num2);
        String num3 = Integer.toString(maxId, C2777a.a(2));
        t.d(num3, "toString(this, checkRadix(radix))");
        sb.append(num3);
        String str = "";
        if (!acceptedItems.isEmpty()) {
            for (Number intValue : acceptedItems) {
                String num4 = Integer.toString(intValue.intValue(), C2777a.a(2));
                t.d(num4, "toString(this, checkRadix(radix))");
                while (true) {
                    int length = num4.length();
                    String num5 = Integer.toString(maxId, C2777a.a(2));
                    t.d(num5, "toString(this, checkRadix(radix))");
                    if (length >= num5.length()) {
                        break;
                    }
                    num4 = t.n("0", num4);
                }
                str = t.n(str, num4);
            }
        }
        sb.append(str);
        String sb2 = sb.toString();
        Map map = L2.b.f18402a;
        aVar.i(bVar, L2.a.b(sb2));
        if (z5) {
            String str2 = c.j().f19281b.f19230U;
            if (str2 != null) {
                this.f25600a.i(b.CONFIG_THEME_UUID, str2);
            }
            this.f25600a.i(b.CONFIG_LANGUAGE, this.f25600a.k(b.PORTAL_CHOICE_LANG));
            a aVar2 = this.f25600a;
            b bVar2 = b.CONFIG_COP_APPLICABLE;
            Boolean bool = c.j().f19281b.f19231V.f19264c;
            Boolean bool2 = Boolean.TRUE;
            if (t.a(bool, bool2)) {
                List list = c.j().f19281b.f19233X.f19208a;
                String upperCase = c.f25866n.toUpperCase(Locale.ROOT);
                t.d(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                if (list.contains(upperCase)) {
                    z7 = true;
                    aVar2.j(bVar2, z7);
                    this.f25600a.j(b.CONFIG_ADV_APPLICABLE, t.a(c.j().f19281b.f19231V.f19263b, bool2));
                    this.f25600a.j(b.CONFIG_GBC_APPLICABLE, m.l.f960a);
                }
            }
            z7 = false;
            aVar2.j(bVar2, z7);
            this.f25600a.j(b.CONFIG_ADV_APPLICABLE, t.a(c.j().f19281b.f19231V.f19263b, bool2));
            this.f25600a.j(b.CONFIG_GBC_APPLICABLE, m.l.f960a);
        }
        long j7 = c.j().f19287h;
        if (z4) {
            this.f25600a.g(b.GDPR_CONSENT_LAST_STORED_TIME_STAMP, j7);
            ChoiceCmpCallback choiceCmpCallback2 = this.f25602c;
            if (choiceCmpCallback2 != null) {
                GDPRData gDPRData = new GDPRData((Set) null, 1, (C2633k) null);
                gDPRData.setCmpStatus(CmpStatus.LOADED);
                choiceCmpCallback2.onIABVendorConsentGiven(gDPRData);
            }
            ChoiceCmpCallback choiceCmpCallback3 = this.f25602c;
            if (choiceCmpCallback3 != null) {
                a aVar3 = this.f25600a;
                b bVar3 = b.TCF_GDPR_APPLIES;
                aVar3.getClass();
                t.e(bVar3, "preferenceKey");
                if (aVar3.f25721a.getInt("IABTCF_gdprApplies", 0) == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                choiceCmpCallback3.onNonIABVendorConsentGiven(new NonIABData(z6, false, false, this.f25600a.k(b.NON_IAB_CONSENT_ENCODED), this.f25601b.f18307A.getMap()));
            }
            a aVar4 = this.f25600a;
            b bVar4 = b.GOOGLE_ENABLED;
            aVar4.getClass();
            t.e(bVar4, "preferenceKey");
            if (aVar4.f25721a.getBoolean("google_enabled", false) && (choiceCmpCallback = this.f25602c) != null) {
                Set<Integer> acceptedItems2 = this.f25601b.f18308B.getAcceptedItems();
                t.e(acceptedItems2, "vendorsID");
                String str3 = "1~";
                for (T next : acceptedItems2) {
                    int i9 = i5 + 1;
                    if (i5 < 0) {
                        C2250q.o();
                    }
                    int intValue2 = ((Number) next).intValue();
                    if (i5 != 0) {
                        obj = t.n(".", Integer.valueOf(intValue2));
                    } else {
                        obj = Integer.valueOf(intValue2);
                    }
                    str3 = t.n(str3, obj);
                    i5 = i9;
                }
                choiceCmpCallback.onGoogleVendorConsentGiven(new ACData(str3));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v38, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v4, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0339, code lost:
        r30 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x034a, code lost:
        r2 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x034c, code lost:
        r5 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0373, code lost:
        r31 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x039a, code lost:
        r31 = r3;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0511, code lost:
        r1 = kotlin.jvm.internal.t.n(r1, r2);
        r11 = r5;
        r5 = r30;
        r3 = r31;
        r2 = r36;
        r4 = r37;
        r10 = r39;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0506 A[LOOP:4: B:216:0x04df->B:226:0x0506, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x0503 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r41 = this;
            r0 = r41
            J2.u r1 = r0.f25601b
            r4.a r2 = r0.f25600a
            L2.h r3 = r0.f25603d
            java.lang.String r4 = "tcModel"
            kotlin.jvm.internal.t.e(r1, r4)
            java.lang.String r5 = "options"
            kotlin.jvm.internal.t.e(r3, r5)
            J2.u r5 = L2.k.a(r1, r3)
            java.util.List r6 = r3.f18421c
            r7 = 2
            r8 = 0
            r9 = 1
            if (r6 == 0) goto L_0x0027
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x0024
            goto L_0x0027
        L_0x0024:
            java.util.List r3 = r3.f18421c
            goto L_0x0073
        L_0x0027:
            kotlin.jvm.internal.t.e(r5, r4)
            J2.n r6 = J2.n.CORE
            J2.n[] r10 = new J2.n[r9]
            r10[r8] = r6
            java.util.List r10 = X2.C2250q.l(r10)
            J2.n[] r11 = new J2.n[r9]
            r11[r8] = r6
            java.util.List r6 = X2.C2250q.l(r11)
            int r11 = r5.f18322i
            if (r11 != r7) goto L_0x0072
            boolean r10 = r5.f18318e
            if (r10 == 0) goto L_0x004a
            J2.n r3 = J2.n.PUBLISHER_TC
            r6.add(r3)
            goto L_0x0070
        L_0x004a:
            java.lang.Boolean r3 = r3.f18419a
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            kotlin.jvm.internal.t.a(r3, r10)
            J2.n r10 = J2.n.VENDORS_DISCLOSED
            r6.add(r10)
            if (r3 == 0) goto L_0x0070
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0070
            com.inmobi.cmp.core.model.Vector r3 = r5.f18312F
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x006b
            J2.n r3 = J2.n.VENDORS_ALLOWED
            r6.add(r3)
        L_0x006b:
            J2.n r3 = J2.n.PUBLISHER_TC
            r6.add(r3)
        L_0x0070:
            r3 = r6
            goto L_0x0073
        L_0x0072:
            r3 = r10
        L_0x0073:
            java.util.Iterator r6 = r3.iterator()
            java.lang.String r10 = ""
            r11 = r10
        L_0x007a:
            boolean r12 = r6.hasNext()
            java.lang.String r13 = "publisherCustomLegitimateInterests"
            java.lang.String r14 = "publisherCustomConsents"
            java.lang.String r15 = "publisherLegitimateInterests"
            java.lang.String r8 = "publisherConsents"
            java.lang.String r7 = "publisherRestrictions"
            r18 = r9
            java.lang.String r9 = "vendorLegitimateInterests"
            java.lang.String r0 = "purposeLegitimateInterests"
            r19 = r6
            java.lang.String r6 = "purposeConsents"
            r20 = r12
            java.lang.String r12 = "specialFeatureOptions"
            r21 = r2
            java.lang.String r2 = "."
            if (r20 == 0) goto L_0x05a7
            java.lang.Object r20 = r19.next()
            r22 = r2
            r2 = r20
            J2.n r2 = (J2.n) r2
            int r20 = r3.size()
            r23 = r1
            int r1 = r20 + -1
            java.lang.Object r1 = r3.get(r1)
            if (r2 == r1) goto L_0x00b9
            r1 = r22
        L_0x00b6:
            r20 = r3
            goto L_0x00bb
        L_0x00b9:
            r1 = r10
            goto L_0x00b6
        L_0x00bb:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r11)
            kotlin.jvm.internal.t.e(r5, r4)
            java.lang.String r11 = "segment"
            kotlin.jvm.internal.t.e(r2, r11)
            int r11 = r5.f18322i
            r24 = r4
            java.lang.String r4 = "g.i"
            r22 = r1
            r1 = r18
            if (r11 == r1) goto L_0x0109
            r1 = 2
            if (r11 != r1) goto L_0x00e5
            java.util.Map r11 = P2.a.f18865b
            java.lang.String r1 = r2.f18299a
            java.lang.Object r1 = r11.get(r1)
            java.lang.String[] r1 = (java.lang.String[]) r1
            goto L_0x0113
        L_0x00e5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r1 = ": Unable to encode version: "
            r0.append(r1)
            int r1 = r5.f18322i
            r0.append(r1)
            java.lang.String r1 = ", segment: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            L2.g r1 = new L2.g
            r1.<init>(r0)
            throw r1
        L_0x0109:
            java.util.Map r1 = P2.a.f18864a
            java.lang.String r11 = r2.f18299a
            java.lang.Object r1 = r1.get(r11)
            java.lang.String[] r1 = (java.lang.String[]) r1
        L_0x0113:
            J2.n r11 = J2.n.CORE
            r25 = 0
            r26 = r3
            java.lang.String r3 = "key"
            if (r2 == r11) goto L_0x0158
            java.util.Map r11 = J2.o.f18301b
            java.lang.Object r11 = r11.get(r2)
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 != 0) goto L_0x012c
            r28 = r2
            r2 = r25
            goto L_0x0153
        L_0x012c:
            int r11 = r11.intValue()
            java.util.Map r27 = L2.e.f18404a
            r27 = r11
            L2.f r11 = L2.f.SEGMENT_TYPE
            kotlin.jvm.internal.t.e(r11, r3)
            r28 = r2
            java.util.Map r2 = L2.e.f18405b
            java.lang.Object r2 = r2.get(r11)
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Integer r11 = java.lang.Integer.valueOf(r27)
            if (r2 != 0) goto L_0x014b
            r2 = 0
            goto L_0x014f
        L_0x014b:
            int r2 = r2.intValue()
        L_0x014f:
            java.lang.String r2 = N2.d.b(r11, r2)
        L_0x0153:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            goto L_0x015b
        L_0x0158:
            r28 = r2
            r2 = r10
        L_0x015b:
            java.lang.String r11 = "0"
            if (r1 != 0) goto L_0x0166
        L_0x015f:
            r30 = r5
            r39 = r10
            r5 = r11
            goto L_0x056c
        L_0x0166:
            r27 = r2
            int r2 = r1.length
            r29 = r1
            r1 = r27
            r27 = r4
            r4 = 0
        L_0x0170:
            if (r4 >= r2) goto L_0x0569
            r36 = r2
            r2 = r29[r4]
            int r4 = r4 + 1
            r37 = r4
            java.lang.String r4 = "version"
            boolean r4 = kotlin.jvm.internal.t.a(r2, r4)
            if (r4 == 0) goto L_0x0191
            int r4 = r5.f18322i
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r38 = r10
            r10 = r4
            r4 = r38
            r38 = r11
            goto L_0x02e4
        L_0x0191:
            java.lang.String r4 = "created"
            boolean r4 = kotlin.jvm.internal.t.a(r2, r4)
            if (r4 == 0) goto L_0x01a4
            r4 = r10
            r38 = r11
            long r10 = r5.f18315b
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            goto L_0x02e4
        L_0x01a4:
            r4 = r10
            r38 = r11
            java.lang.String r10 = "lastUpdated"
            boolean r10 = kotlin.jvm.internal.t.a(r2, r10)
            if (r10 == 0) goto L_0x01b7
            long r10 = r5.f18316c
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            goto L_0x02e4
        L_0x01b7:
            java.lang.String r10 = "cmpId"
            boolean r10 = kotlin.jvm.internal.t.a(r2, r10)
            if (r10 == 0) goto L_0x01c7
            int r10 = r5.f18326m
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x02e4
        L_0x01c7:
            java.lang.String r10 = "cmpVersion"
            boolean r10 = kotlin.jvm.internal.t.a(r2, r10)
            if (r10 == 0) goto L_0x01d7
            int r10 = r5.f18327n
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x02e4
        L_0x01d7:
            java.lang.String r10 = "consentScreen"
            boolean r10 = kotlin.jvm.internal.t.a(r2, r10)
            if (r10 == 0) goto L_0x01e7
            int r10 = r5.f18323j
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x02e4
        L_0x01e7:
            java.lang.String r10 = "consentLanguage"
            boolean r10 = kotlin.jvm.internal.t.a(r2, r10)
            if (r10 == 0) goto L_0x01f3
            java.lang.String r10 = r5.f18325l
            goto L_0x02e4
        L_0x01f3:
            java.lang.String r10 = "vendorListVersion"
            boolean r10 = kotlin.jvm.internal.t.a(r2, r10)
            if (r10 == 0) goto L_0x0213
            P3.d r10 = r5.f18314a
            if (r10 != 0) goto L_0x0202
            r10 = r25
            goto L_0x0204
        L_0x0202:
            java.lang.Integer r10 = r10.f18870b
        L_0x0204:
            if (r10 != 0) goto L_0x0209
            int r10 = r5.f18328o
            goto L_0x020d
        L_0x0209:
            int r10 = r10.intValue()
        L_0x020d:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x02e4
        L_0x0213:
            java.lang.String r10 = "policyVersion"
            boolean r10 = kotlin.jvm.internal.t.a(r2, r10)
            if (r10 == 0) goto L_0x0225
            int r10 = r5.f()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x02e4
        L_0x0225:
            java.lang.String r10 = "isServiceSpecific"
            boolean r10 = kotlin.jvm.internal.t.a(r2, r10)
            if (r10 == 0) goto L_0x0235
            boolean r10 = r5.f18318e
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            goto L_0x02e4
        L_0x0235:
            java.lang.String r10 = "useNonStandardStacks"
            boolean r10 = kotlin.jvm.internal.t.a(r2, r10)
            if (r10 == 0) goto L_0x0245
            boolean r10 = r5.f18319f
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            goto L_0x02e4
        L_0x0245:
            boolean r10 = kotlin.jvm.internal.t.a(r2, r12)
            if (r10 == 0) goto L_0x024f
            com.inmobi.cmp.core.model.Vector r10 = r5.f18330q
            goto L_0x02e4
        L_0x024f:
            boolean r10 = kotlin.jvm.internal.t.a(r2, r6)
            if (r10 == 0) goto L_0x0259
            com.inmobi.cmp.core.model.Vector r10 = r5.f18331r
            goto L_0x02e4
        L_0x0259:
            boolean r10 = kotlin.jvm.internal.t.a(r2, r0)
            if (r10 == 0) goto L_0x0263
            com.inmobi.cmp.core.model.Vector r10 = r5.f18332s
            goto L_0x02e4
        L_0x0263:
            java.lang.String r10 = "purposeOneTreatment"
            boolean r10 = kotlin.jvm.internal.t.a(r2, r10)
            if (r10 == 0) goto L_0x0273
            boolean r10 = r5.f18320g
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            goto L_0x02e4
        L_0x0273:
            java.lang.String r10 = "publisherCountryCode"
            boolean r10 = kotlin.jvm.internal.t.a(r2, r10)
            if (r10 == 0) goto L_0x027f
            java.lang.String r10 = r5.f18321h
            goto L_0x02e4
        L_0x027f:
            java.lang.String r10 = "vendorConsents"
            boolean r10 = kotlin.jvm.internal.t.a(r2, r10)
            if (r10 == 0) goto L_0x028a
            com.inmobi.cmp.core.model.Vector r10 = r5.f18339z
            goto L_0x02e4
        L_0x028a:
            boolean r10 = kotlin.jvm.internal.t.a(r2, r9)
            if (r10 == 0) goto L_0x0293
            com.inmobi.cmp.core.model.Vector r10 = r5.f18309C
            goto L_0x02e4
        L_0x0293:
            boolean r10 = kotlin.jvm.internal.t.a(r2, r7)
            if (r10 == 0) goto L_0x029c
            J2.l r10 = r5.f18313G
            goto L_0x02e4
        L_0x029c:
            boolean r10 = kotlin.jvm.internal.t.a(r2, r8)
            if (r10 == 0) goto L_0x02a5
            com.inmobi.cmp.core.model.Vector r10 = r5.f18335v
            goto L_0x02e4
        L_0x02a5:
            boolean r10 = kotlin.jvm.internal.t.a(r2, r15)
            if (r10 == 0) goto L_0x02ae
            com.inmobi.cmp.core.model.Vector r10 = r5.f18336w
            goto L_0x02e4
        L_0x02ae:
            java.lang.String r10 = "numCustomPurposes"
            boolean r10 = kotlin.jvm.internal.t.a(r2, r10)
            if (r10 == 0) goto L_0x02bd
            int r10 = r5.f18329p
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x02e4
        L_0x02bd:
            boolean r10 = kotlin.jvm.internal.t.a(r2, r14)
            if (r10 == 0) goto L_0x02c6
            com.inmobi.cmp.core.model.Vector r10 = r5.f18337x
            goto L_0x02e4
        L_0x02c6:
            boolean r10 = kotlin.jvm.internal.t.a(r2, r13)
            if (r10 == 0) goto L_0x02cf
            com.inmobi.cmp.core.model.Vector r10 = r5.f18338y
            goto L_0x02e4
        L_0x02cf:
            java.lang.String r10 = "vendorsAllowed"
            boolean r10 = kotlin.jvm.internal.t.a(r2, r10)
            if (r10 == 0) goto L_0x02da
            com.inmobi.cmp.core.model.Vector r10 = r5.f18312F
            goto L_0x02e4
        L_0x02da:
            java.lang.String r10 = "vendorsDisclosed"
            boolean r10 = kotlin.jvm.internal.t.a(r2, r10)
            if (r10 == 0) goto L_0x0548
            com.inmobi.cmp.core.model.Vector r10 = r5.f18311E
        L_0x02e4:
            java.util.Map r11 = N2.b.f18704a
            kotlin.jvm.internal.t.e(r2, r3)
            java.util.Map r11 = N2.b.f18704a
            java.lang.Object r11 = r11.get(r2)
            java.lang.String r11 = (java.lang.String) r11
            java.util.Map r30 = L2.e.f18404a
            kotlin.jvm.internal.t.e(r2, r3)
            r39 = r4
            java.util.Map r4 = L2.e.f18406c
            java.lang.Object r4 = r4.get(r2)
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 != 0) goto L_0x031e
            r34 = 6
            r35 = 0
            java.lang.String r31 = "publisherCustom"
            r32 = 0
            r33 = 0
            r30 = r2
            int r2 = t3.s.f0(r30, r31, r32, r33, r34, r35)
            r31 = r2
            r2 = r30
            if (r31 != 0) goto L_0x031e
            int r4 = r5.f18329p
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x031e:
            if (r11 == 0) goto L_0x0522
            int r30 = r11.hashCode()
            r31 = r4
            java.lang.String r4 = "value"
            java.lang.String r32 = "1"
            switch(r30) {
                case -203882031: goto L_0x048a;
                case 26410996: goto L_0x046f;
                case 683778315: goto L_0x03ea;
                case 1045601125: goto L_0x038e;
                case 1210305326: goto L_0x0376;
                case 1255568750: goto L_0x0350;
                case 1942709837: goto L_0x032f;
                default: goto L_0x032d;
            }
        L_0x032d:
            goto L_0x0522
        L_0x032f:
            java.lang.String r4 = "IntEncoder"
            boolean r4 = r11.equals(r4)
            if (r4 == 0) goto L_0x0522
            if (r31 != 0) goto L_0x033c
        L_0x0339:
            r30 = r5
            goto L_0x039a
        L_0x033c:
            int r2 = r31.intValue()
            java.lang.Integer r10 = (java.lang.Integer) r10
            java.lang.String r32 = N2.d.b(r10, r2)
            r31 = r3
            r30 = r5
        L_0x034a:
            r2 = r32
        L_0x034c:
            r5 = r38
            goto L_0x0511
        L_0x0350:
            java.lang.String r4 = "DateEncoder"
            boolean r4 = r11.equals(r4)
            if (r4 == 0) goto L_0x0522
            if (r31 != 0) goto L_0x035b
            goto L_0x0339
        L_0x035b:
            int r2 = r31.intValue()
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            r4 = 100
            r30 = r5
            long r4 = (long) r4
            long r10 = r10 / r4
            java.lang.Long r4 = java.lang.Long.valueOf(r10)
            java.lang.String r32 = N2.d.b(r4, r2)
        L_0x0373:
            r31 = r3
            goto L_0x034a
        L_0x0376:
            r30 = r5
            java.lang.String r4 = "LangEncoder"
            boolean r4 = r11.equals(r4)
            if (r4 == 0) goto L_0x0522
            if (r31 != 0) goto L_0x0383
            goto L_0x039a
        L_0x0383:
            int r2 = r31.intValue()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r32 = N2.e.b(r2, r10)
            goto L_0x0373
        L_0x038e:
            r30 = r5
            java.lang.String r5 = "FixedVectorEncoder"
            boolean r5 = r11.equals(r5)
            if (r5 == 0) goto L_0x0522
            if (r31 != 0) goto L_0x039f
        L_0x039a:
            r31 = r3
            r2 = r25
            goto L_0x034c
        L_0x039f:
            int r2 = r31.intValue()
            com.inmobi.cmp.core.model.Vector r10 = (com.inmobi.cmp.core.model.Vector) r10
            kotlin.jvm.internal.t.e(r10, r4)
            int r4 = r10.size()
            if (r4 > r2) goto L_0x03dc
            r4 = 1
            if (r4 > r2) goto L_0x03d9
            r5 = r39
            r4 = 1
        L_0x03b4:
            int r11 = r4 + 1
            java.lang.Boolean r31 = r10.get(r4)
            if (r31 != 0) goto L_0x03bd
            goto L_0x03c8
        L_0x03bd:
            boolean r31 = r31.booleanValue()
            if (r31 == 0) goto L_0x03c8
            r31 = r10
            r10 = r32
            goto L_0x03cc
        L_0x03c8:
            r31 = r10
            r10 = r38
        L_0x03cc:
            java.lang.String r5 = kotlin.jvm.internal.t.n(r5, r10)
            if (r4 != r2) goto L_0x03d5
            r32 = r5
            goto L_0x0373
        L_0x03d5:
            r4 = r11
            r10 = r31
            goto L_0x03b4
        L_0x03d9:
            r32 = r39
            goto L_0x0373
        L_0x03dc:
            java.lang.String r0 = "h.e"
            java.lang.String r1 = ": bitfield encoding length mismatch"
            java.lang.String r0 = kotlin.jvm.internal.t.n(r0, r1)
            L2.g r1 = new L2.g
            r1.<init>(r0)
            throw r1
        L_0x03ea:
            r30 = r5
            java.lang.String r4 = "PurposeRestrictionVectorEncoder"
            boolean r4 = r11.equals(r4)
            if (r4 == 0) goto L_0x0522
            J2.l r10 = (J2.l) r10
            java.lang.String r2 = "prVector"
            kotlin.jvm.internal.t.e(r10, r2)
            kotlin.jvm.internal.L r2 = new kotlin.jvm.internal.L
            r2.<init>()
            java.util.Map r4 = r10.f18287c
            int r4 = r4.size()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            L2.f r5 = L2.f.NUM_RESTRICTIONS
            kotlin.jvm.internal.t.e(r5, r3)
            java.util.Map r11 = L2.e.f18405b
            java.lang.Object r5 = r11.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 != 0) goto L_0x041b
            r5 = 0
            goto L_0x041f
        L_0x041b:
            int r5 = r5.intValue()
        L_0x041f:
            java.lang.String r4 = N2.d.b(r4, r5)
            r2.f24690a = r4
            java.util.Map r4 = r10.f18287c
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0459
            N2.f r4 = new N2.f
            r4.<init>(r2)
            java.lang.String r5 = "action"
            kotlin.jvm.internal.t.e(r4, r5)
            java.util.Map r5 = r10.f18287c
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0441:
            boolean r10 = r5.hasNext()
            if (r10 == 0) goto L_0x0467
            java.lang.Object r10 = r5.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r11 = r10.getKey()
            java.lang.Object r10 = r10.getValue()
            r4.invoke(r11, r10)
            goto L_0x0441
        L_0x0459:
            java.lang.Object r4 = r2.f24690a
            java.lang.String r4 = (java.lang.String) r4
            r5 = 36
            r10 = 48
            java.lang.String r4 = t3.s.q0(r4, r5, r10)
            r2.f24690a = r4
        L_0x0467:
            java.lang.Object r2 = r2.f24690a
            r32 = r2
            java.lang.String r32 = (java.lang.String) r32
            goto L_0x0373
        L_0x046f:
            r30 = r5
            java.lang.String r4 = "BooleanEncoder"
            boolean r4 = r11.equals(r4)
            if (r4 == 0) goto L_0x0522
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r2 = r10.booleanValue()
            if (r2 == 0) goto L_0x0483
            goto L_0x0373
        L_0x0483:
            r31 = r3
            r2 = r38
            r5 = r2
            goto L_0x0511
        L_0x048a:
            r30 = r5
            java.lang.String r5 = "VendorVectorEncoder"
            boolean r5 = r11.equals(r5)
            if (r5 == 0) goto L_0x0522
            com.inmobi.cmp.core.model.Vector r10 = (com.inmobi.cmp.core.model.Vector) r10
            kotlin.jvm.internal.t.e(r10, r4)
            int r2 = r10.getMaxId()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            L2.f r4 = L2.f.MAX_ID
            kotlin.jvm.internal.t.e(r4, r3)
            java.util.Map r5 = L2.e.f18405b
            java.lang.Object r4 = r5.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 != 0) goto L_0x04b2
            r4 = 0
            goto L_0x04b6
        L_0x04b2:
            int r4 = r4.intValue()
        L_0x04b6:
            java.lang.String r2 = N2.d.b(r2, r4)
            r4 = r39
            java.lang.String r2 = kotlin.jvm.internal.t.n(r4, r2)
            r5 = r38
            java.lang.String r2 = kotlin.jvm.internal.t.n(r2, r5)
            int r11 = r10.getMaxId()
            if (r11 != 0) goto L_0x04d1
            r31 = r3
        L_0x04ce:
            r39 = r4
            goto L_0x050d
        L_0x04d1:
            int r11 = r10.getMaxId()
            r31 = r3
            r3 = 1
            if (r3 > r11) goto L_0x04ce
            r40 = r3
            r3 = r2
            r2 = r40
        L_0x04df:
            int r33 = r2 + 1
            boolean r34 = r10.contains(r2)
            r39 = r4
            if (r34 == 0) goto L_0x04fa
            java.lang.Boolean r4 = r10.get(r2)
            r34 = r10
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            boolean r4 = kotlin.jvm.internal.t.a(r4, r10)
            if (r4 == 0) goto L_0x04fc
            r4 = r32
            goto L_0x04fd
        L_0x04fa:
            r34 = r10
        L_0x04fc:
            r4 = r5
        L_0x04fd:
            java.lang.String r3 = kotlin.jvm.internal.t.n(r3, r4)
            if (r2 != r11) goto L_0x0506
            r32 = r3
            goto L_0x050f
        L_0x0506:
            r2 = r33
            r10 = r34
            r4 = r39
            goto L_0x04df
        L_0x050d:
            r32 = r2
        L_0x050f:
            r2 = r32
        L_0x0511:
            java.lang.String r1 = kotlin.jvm.internal.t.n(r1, r2)
            r11 = r5
            r5 = r30
            r3 = r31
            r2 = r36
            r4 = r37
            r10 = r39
            goto L_0x0170
        L_0x0522:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = r27
            r0.append(r1)
            java.lang.String r1 = ": Error encoding "
            r0.append(r1)
            r1 = r28
            r0.append(r1)
            java.lang.String r1 = "->"
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            L2.g r1 = new L2.g
            r1.<init>(r0)
            throw r1
        L_0x0548:
            r1 = r27
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = ": Unable to find: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r1 = " field on TCModel"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            L2.g r1 = new L2.g
            r1.<init>(r0)
            throw r1
        L_0x0569:
            r2 = r1
            goto L_0x015f
        L_0x056c:
            java.util.Map r0 = L2.b.f18402a
            int r0 = r2.length()
            int r0 = r0 % 8
            if (r0 == 0) goto L_0x0580
            int r0 = 8 - r0
            java.lang.String r0 = t3.s.H(r5, r0)
            java.lang.String r2 = kotlin.jvm.internal.t.n(r2, r0)
        L_0x0580:
            java.lang.String r0 = L2.a.b(r2)
            r1 = r26
            r1.append(r0)
            r10 = r22
            r1.append(r10)
            java.lang.String r11 = r1.toString()
            r0 = r41
            r6 = r19
            r3 = r20
            r2 = r21
            r1 = r23
            r4 = r24
            r5 = r30
            r10 = r39
            r7 = 2
            r8 = 0
            r9 = 1
            goto L_0x007a
        L_0x05a7:
            r22 = r2
            com.inmobi.cmp.core.model.Vector r2 = r1.f18307A
            java.lang.String r2 = L2.d.b(r2)
            com.inmobi.cmp.core.model.Vector r3 = r1.f18307A
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = l4.e.b(r3)
            com.inmobi.cmp.core.model.Vector r4 = r1.f18310D
            java.lang.String r4 = L2.d.b(r4)
            com.inmobi.cmp.core.model.Vector r5 = r1.f18308B
            java.util.Set r5 = r5.getAcceptedItems()
            java.lang.String r10 = "vendorsID"
            kotlin.jvm.internal.t.e(r5, r10)
            java.util.Iterator r5 = r5.iterator()
            java.lang.String r10 = "1~"
            r16 = 0
        L_0x05d2:
            boolean r17 = r5.hasNext()
            if (r17 == 0) goto L_0x0611
            java.lang.Object r17 = r5.next()
            int r18 = r16 + 1
            if (r16 >= 0) goto L_0x05e3
            X2.C2250q.o()
        L_0x05e3:
            java.lang.Number r17 = (java.lang.Number) r17
            int r17 = r17.intValue()
            if (r16 == 0) goto L_0x05fa
            r16 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)
            r19 = r13
            r13 = r22
            java.lang.String r5 = kotlin.jvm.internal.t.n(r13, r5)
            goto L_0x0604
        L_0x05fa:
            r16 = r5
            r19 = r13
            r13 = r22
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)
        L_0x0604:
            java.lang.String r10 = kotlin.jvm.internal.t.n(r10, r5)
            r22 = r13
            r5 = r16
            r16 = r18
            r13 = r19
            goto L_0x05d2
        L_0x0611:
            r19 = r13
            com.inmobi.cmp.core.model.Vector r5 = r1.f18339z
            java.lang.String r5 = L2.d.b(r5)
            com.inmobi.cmp.core.model.Vector r13 = r1.f18309C
            java.lang.String r13 = L2.d.b(r13)
            r16 = r14
            com.inmobi.cmp.core.model.Vector r14 = r1.f18331r
            java.lang.String r14 = L2.d.b(r14)
            r17 = r15
            com.inmobi.cmp.core.model.Vector r15 = r1.f18332s
            java.lang.String r15 = L2.d.b(r15)
            r18 = r8
            com.inmobi.cmp.core.model.Vector r8 = r1.f18330q
            java.lang.String r8 = L2.d.b(r8)
            r20 = r7
            J2.l r7 = r1.f18313G
            java.util.Map r7 = r7.f18287c
            java.lang.String r7 = r7.toString()
            r22 = r7
            com.inmobi.cmp.core.model.Vector r7 = r1.f18335v
            java.lang.String r7 = L2.d.b(r7)
            r23 = r7
            com.inmobi.cmp.core.model.Vector r7 = r1.f18336w
            java.lang.String r7 = L2.d.b(r7)
            r24 = r7
            com.inmobi.cmp.core.model.Vector r7 = r1.f18337x
            java.lang.String r7 = L2.d.b(r7)
            com.inmobi.cmp.core.model.Vector r1 = r1.f18338y
            java.lang.String r1 = L2.d.b(r1)
            r21.getClass()
            r25 = r1
            java.lang.String r1 = "tcString"
            kotlin.jvm.internal.t.e(r11, r1)
            java.lang.String r1 = "nonIabVendorConsents"
            kotlin.jvm.internal.t.e(r2, r1)
            java.lang.String r1 = "nonIabVendorConsentsEncoded"
            kotlin.jvm.internal.t.e(r3, r1)
            java.lang.String r1 = "nonIabVendorLegitimateInterests"
            kotlin.jvm.internal.t.e(r4, r1)
            java.lang.String r1 = "googleVendorConsents"
            kotlin.jvm.internal.t.e(r10, r1)
            java.lang.String r1 = "iabVendorConsents"
            kotlin.jvm.internal.t.e(r5, r1)
            kotlin.jvm.internal.t.e(r13, r9)
            kotlin.jvm.internal.t.e(r14, r6)
            kotlin.jvm.internal.t.e(r15, r0)
            kotlin.jvm.internal.t.e(r8, r12)
            r1 = r20
            r0 = r22
            kotlin.jvm.internal.t.e(r0, r1)
            r6 = r18
            r1 = r23
            kotlin.jvm.internal.t.e(r1, r6)
            r9 = r17
            r6 = r24
            kotlin.jvm.internal.t.e(r6, r9)
            r9 = r16
            kotlin.jvm.internal.t.e(r7, r9)
            r12 = r19
            r9 = r25
            kotlin.jvm.internal.t.e(r9, r12)
            r4.b r12 = r4.b.TC_STRING
            r16 = r3
            r3 = r21
            r3.i(r12, r11)
            r4.b r12 = r4.b.GPP_TC_STRING
            r3.i(r12, r11)
            r4.b r11 = r4.b.NON_IAB_VENDOR_CONSENTS
            r3.i(r11, r2)
            r4.b r2 = r4.b.NON_IAB_VENDOR_CONSENT_HASH
            java.lang.String r11 = l4.e.b(r16)
            r3.i(r2, r11)
            r4.b r11 = r4.b.NON_IAB_VENDOR_LEG_INTERESTS
            r3.i(r11, r4)
            r4.b r4 = r4.b.OPTION_HASH
            java.lang.String r2 = r3.k(r2)
            r4.b r11 = r4.b.PORTAL_CONFIG_HASH
            java.lang.String r11 = r3.k(r11)
            java.lang.String r2 = kotlin.jvm.internal.t.n(r2, r11)
            r3.i(r4, r2)
            r4.b r2 = r4.b.ADDTL_CONSENT
            r3.i(r2, r10)
            r4.b r2 = r4.b.TCF_VENDOR_CONSENTS
            r3.i(r2, r5)
            r4.b r2 = r4.b.TCF_VENDOR_LEGITIMATE_INTERESTS
            r3.i(r2, r13)
            r4.b r2 = r4.b.TCF_PURPOSE_CONSENTS
            r3.i(r2, r14)
            r4.b r2 = r4.b.TCF_PURPOSE_LEGITIMATE_INTERESTS
            r3.i(r2, r15)
            r4.b r2 = r4.b.TCF_SPECIAL_FEATURES_OPT_INS
            r3.i(r2, r8)
            r4.b r2 = r4.b.TCF_PUBLISHER_RESTRICTIONS
            r3.i(r2, r0)
            r4.b r0 = r4.b.TCF_PUBLISHER_CONSENT
            r3.i(r0, r1)
            r4.b r0 = r4.b.TCF_PUBLISHER_LEGITIMATE_INTERESTS
            r3.i(r0, r6)
            r4.b r0 = r4.b.TCF_PUBLISHER_CUSTOM_PURPOSES_CONSENTS
            r3.i(r0, r7)
            r4.b r0 = r4.b.TCF_PUBLISHER_CUSTOM_PURPOSES_LEGITIMATE_INTERESTS
            r3.i(r0, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.m.c():void");
    }
}
