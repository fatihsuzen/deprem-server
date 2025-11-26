package b;

import J2.f;
import J2.h;
import J2.u;
import P3.d;
import T3.i;
import U2.c;
import W2.J;
import X2.C2250q;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import kotlin.jvm.internal.C2633k;
import l4.e;
import m.l;
import o4.B;
import o4.C2711f;
import o4.E;
import o4.j;
import o4.k;
import o4.m;
import o4.p;
import o4.r;
import o4.t;
import o4.v;
import o4.w;
import r4.a;
import r4.b;
import t3.s;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public final a f839a;

    /* renamed from: b  reason: collision with root package name */
    public final u f840b;

    /* renamed from: c  reason: collision with root package name */
    public final i f841c;

    /* renamed from: d  reason: collision with root package name */
    public final w f842d;

    /* renamed from: e  reason: collision with root package name */
    public final C2711f f843e;

    /* renamed from: f  reason: collision with root package name */
    public final E f844f;

    /* renamed from: g  reason: collision with root package name */
    public final k f845g;

    /* renamed from: h  reason: collision with root package name */
    public final t f846h;

    /* renamed from: i  reason: collision with root package name */
    public final v f847i;

    /* renamed from: j  reason: collision with root package name */
    public final r f848j;

    /* renamed from: k  reason: collision with root package name */
    public final j f849k;

    /* renamed from: l  reason: collision with root package name */
    public final p f850l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f851m;

    /* renamed from: n  reason: collision with root package name */
    public f f852n;

    /* renamed from: o  reason: collision with root package name */
    public c f853o;

    /* renamed from: p  reason: collision with root package name */
    public int f854p;

    /* renamed from: q  reason: collision with root package name */
    public h f855q;

    public x(a aVar, u uVar, i iVar, B b5, C2711f fVar, E e5, k kVar, t tVar, v vVar, r rVar, m mVar, p pVar) {
        kotlin.jvm.internal.t.e(aVar, "storage");
        kotlin.jvm.internal.t.e(uVar, "tcModel");
        kotlin.jvm.internal.t.e(iVar, "portalConfig");
        kotlin.jvm.internal.t.e(b5, "gvlRepository");
        kotlin.jvm.internal.t.e(fVar, "cmpRepository");
        kotlin.jvm.internal.t.e(e5, "portalConfigRepository");
        kotlin.jvm.internal.t.e(kVar, "translationsTextRepository");
        kotlin.jvm.internal.t.e(tVar, "geoIPRepository");
        kotlin.jvm.internal.t.e(vVar, "googleVendorsRepository");
        kotlin.jvm.internal.t.e(rVar, "gbcRepository");
        kotlin.jvm.internal.t.e(mVar, "consentRepository");
        kotlin.jvm.internal.t.e(pVar, "gbcConsentRepository");
        this.f839a = aVar;
        this.f840b = uVar;
        this.f841c = iVar;
        this.f842d = b5;
        this.f843e = fVar;
        this.f844f = e5;
        this.f845g = kVar;
        this.f846h = tVar;
        this.f847i = vVar;
        this.f848j = rVar;
        this.f849k = mVar;
        this.f850l = pVar;
        this.f852n = new f();
        this.f854p = -1;
        this.f855q = new h();
        this.f854p = i();
    }

    public static Vector a(Object obj) {
        ArrayList arrayList;
        Boolean bool;
        if (obj instanceof ArrayList) {
            arrayList = (ArrayList) obj;
        } else {
            arrayList = null;
        }
        Vector vector = new Vector((Map) null, 1, (C2633k) null);
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            int i6 = 0;
            while (i6 < size) {
                Object obj2 = arrayList.get(i6);
                i6++;
                int i7 = i5 + 1;
                if (i5 < 0) {
                    C2250q.o();
                }
                if (obj2 instanceof Boolean) {
                    bool = (Boolean) obj2;
                } else {
                    bool = null;
                }
                if (kotlin.jvm.internal.t.a(bool, Boolean.TRUE)) {
                    vector.set(i7);
                }
                i5 = i7;
            }
        }
        return vector;
    }

    public static Vector e(Object obj) {
        ArrayList arrayList;
        Integer num;
        if (obj instanceof ArrayList) {
            arrayList = (ArrayList) obj;
        } else {
            arrayList = null;
        }
        Vector vector = new Vector((Map) null, 1, (C2633k) null);
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj2 = arrayList.get(i5);
                i5++;
                if (obj2 instanceof Integer) {
                    num = (Integer) obj2;
                } else {
                    num = null;
                }
                if (num != null) {
                    vector.set(num.intValue());
                }
            }
        }
        return vector;
    }

    public final void b() {
        this.f839a.e(b.GPP_CMP_SDK_ID);
        this.f839a.e(b.GPP_CMP_SDK_VERSION);
        this.f839a.e(b.GPP_POLICY_VERSION);
        this.f839a.e(b.GPP_GDPR_APPLIES);
        this.f839a.e(b.GPP_PUBLISHER_CC);
        this.f839a.e(b.GPP_PURPOSE_ONE_TREATMENT);
        this.f839a.e(b.GPP_USE_NON_STANDARD_STACKS);
        this.f839a.e(b.GPP_VENDOR_CONSENTS);
        this.f839a.e(b.GPP_VENDOR_LEGITIMATE_INTERESTS);
        this.f839a.e(b.GPP_PURPOSE_CONSENTS);
        this.f839a.e(b.GPP_PURPOSE_LEGITIMATE_INTERESTS);
        this.f839a.e(b.GPP_SPECIAL_FEATURES_OPT_INS);
        this.f839a.e(b.GPP_PUBLISHER_RESTRICTIONS);
        this.f839a.e(b.GPP_PUBLISHER_CONSENT);
        this.f839a.e(b.GPP_PUBLISHER_LEGITIMATE_INTERESTS);
        this.f839a.e(b.GPP_PUBLISHER_CUSTOM_PURPOSES_CONSENTS);
        this.f839a.e(b.GPP_PUBLISHER_CUSTOM_PURPOSES_LEGITIMATE_INTERESTS);
    }

    public final void c(boolean z4) {
        if (z4) {
            this.f839a.i(b.GDPR_STATUS, "Reject");
        } else {
            this.f839a.i(b.GDPR_STATUS, "");
            this.f839a.e(b.GDPR_SHOWN);
        }
        if (!l.f960a) {
            return;
        }
        if (z4) {
            this.f839a.i(b.GBC_STATUS, "Reject");
            return;
        }
        this.f839a.i(b.GBC_STATUS, "");
        this.f839a.e(b.GBC_SHOWN);
    }

    public final boolean d(Set set) {
        List list = this.f841c.f19281b.f19243h;
        if (w.a(set) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (list.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                return true;
            }
        }
        return false;
    }

    public final void f() {
        this.f839a.e(b.TCF_CMP_SDK_ID);
        this.f839a.e(b.TCF_CMP_SDK_VERSION);
        this.f839a.e(b.TCF_POLICY_VERSION);
        this.f839a.e(b.TCF_GDPR_APPLIES);
        this.f839a.e(b.TCF_PUBLISHER_CC);
        this.f839a.e(b.TCF_PURPOSE_ONE_TREATMENT);
        this.f839a.e(b.TCF_USE_NON_STANDARD_STACKS);
        this.f839a.e(b.TC_STRING);
        this.f839a.e(b.GPP_TC_STRING);
        this.f839a.e(b.TCF_VENDOR_CONSENTS);
        this.f839a.e(b.TCF_VENDOR_LEGITIMATE_INTERESTS);
        this.f839a.e(b.TCF_PURPOSE_CONSENTS);
        this.f839a.e(b.TCF_PURPOSE_LEGITIMATE_INTERESTS);
        this.f839a.e(b.TCF_SPECIAL_FEATURES_OPT_INS);
        this.f839a.e(b.TCF_PUBLISHER_RESTRICTIONS);
        this.f839a.e(b.TCF_PUBLISHER_CONSENT);
        this.f839a.e(b.TCF_PUBLISHER_LEGITIMATE_INTERESTS);
        this.f839a.e(b.TCF_PUBLISHER_CUSTOM_PURPOSES_CONSENTS);
        this.f839a.e(b.TCF_PUBLISHER_CUSTOM_PURPOSES_LEGITIMATE_INTERESTS);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        if (U2.a.a(r0) == false) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean g() {
        /*
            r7 = this;
            T3.i r0 = r7.f841c
            T3.c r0 = r0.f19281b
            java.util.List r0 = r0.f19237b
            java.lang.String r1 = "GDPR"
            boolean r0 = r0.contains(r1)
            r1 = 0
            if (r0 != 0) goto L_0x0010
            return r1
        L_0x0010:
            T3.i r0 = r7.f841c
            T3.c r0 = r0.f19281b
            java.util.List r0 = r0.f19226Q
            boolean r2 = r7.l()
            java.lang.String r3 = "WORLDWIDE"
            r4 = 1
            if (r2 == 0) goto L_0x0037
            T3.i r2 = r7.f841c
            T3.c r2 = r2.f19281b
            boolean r2 = r2.f19228S
            if (r2 == 0) goto L_0x0036
            java.lang.String r2 = "USA"
            boolean r2 = r0.contains(r2)
            if (r2 != 0) goto L_0x0035
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L_0x0036
        L_0x0035:
            return r4
        L_0x0036:
            return r1
        L_0x0037:
            boolean r0 = r0.contains(r3)
            if (r0 != 0) goto L_0x0085
            T3.i r0 = r7.f841c
            T3.c r0 = r0.f19281b
            java.util.List r0 = r0.f19226Q
            java.lang.String r2 = "EEA"
            boolean r0 = r0.contains(r2)
            r2 = 0
            if (r0 == 0) goto L_0x005a
            U2.c r0 = r7.f853o
            if (r0 != 0) goto L_0x0052
            r0 = r2
            goto L_0x0054
        L_0x0052:
            java.lang.String r0 = r0.f19303a
        L_0x0054:
            boolean r0 = U2.a.a(r0)
            if (r0 != 0) goto L_0x0083
        L_0x005a:
            T3.i r0 = r7.f841c
            T3.c r0 = r0.f19281b
            java.util.List r0 = r0.f19226Q
            java.util.Iterator r0 = r0.iterator()
            r3 = r1
        L_0x0065:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0081
            java.lang.Object r5 = r0.next()
            java.lang.String r5 = (java.lang.String) r5
            U2.c r6 = r7.f853o
            if (r6 != 0) goto L_0x0077
            r6 = r2
            goto L_0x0079
        L_0x0077:
            java.lang.String r6 = r6.f19303a
        L_0x0079:
            boolean r5 = t3.s.E(r5, r6, r4)
            if (r5 == 0) goto L_0x0065
            r3 = r4
            goto L_0x0065
        L_0x0081:
            if (r3 == 0) goto L_0x0084
        L_0x0083:
            return r4
        L_0x0084:
            return r1
        L_0x0085:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b.x.g():boolean");
    }

    public final String h() {
        return e.b(this.f841c.f19282c.f19279c + this.f841c.f19281b.f19261z + this.f841c.f19281b.f19257v + this.f841c.f19281b.f19258w + this.f841c.f19281b.f19256u + this.f841c.f19281b.f19254s + this.f841c.f19281b.f19255t);
    }

    public final int i() {
        a aVar = this.f839a;
        b bVar = b.TCF_POLICY_VERSION;
        aVar.getClass();
        kotlin.jvm.internal.t.e(bVar, "preferenceKey");
        int i5 = aVar.f25721a.getInt("IABTCF_PolicyVersion", 0);
        if (i5 != 0) {
            return i5;
        }
        a aVar2 = this.f839a;
        b bVar2 = b.GPP_POLICY_VERSION;
        aVar2.getClass();
        kotlin.jvm.internal.t.e(bVar2, "preferenceKey");
        return aVar2.f25721a.getInt("IABGPP_TCFEU2_PolicyVersion", 0);
    }

    public final int j() {
        Integer num;
        d dVar = this.f840b.f18314a;
        if (dVar == null) {
            num = null;
        } else {
            num = dVar.f18870b;
        }
        if (num != null) {
            return num.intValue();
        }
        a aVar = this.f839a;
        b bVar = b.VENDOR_LIST_VERSION;
        aVar.getClass();
        kotlin.jvm.internal.t.e(bVar, "preferenceKey");
        return aVar.f25721a.getInt("gvl_version", 0);
    }

    public final boolean k() {
        String str;
        if (!this.f841c.f19281b.f19222M) {
            return false;
        }
        String str2 = s4.c.f25865m;
        R3.h hVar = R3.h.f18998a;
        kotlin.jvm.internal.t.e(hVar, MRAIDCommunicatorUtil.KEY_STATE);
        switch (hVar.ordinal()) {
            case 0:
                str = DownloadCommon.DOWNLOAD_REPORT_CANCEL;
                break;
            case 1:
                str = "co";
                break;
            case 2:
                str = "ct";
                break;
            case 3:
                str = "ut";
                break;
            case 4:
                str = "va";
                break;
            case 5:
                str = "fl";
                break;
            case 6:
                str = "mt";
                break;
            case 7:
                str = "or";
                break;
            case 8:
                str = "tx";
                break;
            case 9:
                str = DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR;
                break;
            case 10:
                str = "ia";
                break;
            case 11:
                str = "ne";
                break;
            case 12:
                str = "nh";
                break;
            case 13:
                str = "nj";
                break;
            case 14:
                str = "tn";
                break;
            default:
                str = "";
                break;
        }
        if (kotlin.jvm.internal.t.a(str2, str)) {
            return true;
        }
        return false;
    }

    public final boolean l() {
        String str;
        c cVar = this.f853o;
        if (cVar == null) {
            str = null;
        } else {
            str = cVar.f19303a;
        }
        return s.E(str, "USA", true);
    }

    public final boolean m() {
        String str;
        String str2;
        String str3;
        T3.f fVar = this.f841c.f19281b.f19232W;
        List list = fVar.f19268b;
        c cVar = this.f853o;
        String str4 = null;
        if (cVar == null) {
            str = null;
        } else {
            str = cVar.f19303a;
        }
        if (fVar.f19267a) {
            if (list.contains("WORLDWIDE")) {
                return true;
            }
            if (list.contains("EEA")) {
                int[] b5 = H2.c.b(32);
                int length = b5.length;
                int i5 = 0;
                while (i5 < length) {
                    int i6 = b5[i5];
                    i5++;
                    String a5 = U2.b.a(i6);
                    if (str == null) {
                        str3 = null;
                    } else {
                        str3 = str.toUpperCase(Locale.ROOT);
                        kotlin.jvm.internal.t.d(str3, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    }
                    if (kotlin.jvm.internal.t.a(a5, str3)) {
                        return true;
                    }
                }
            }
            if (str == null) {
                str2 = null;
            } else {
                str2 = str.toUpperCase(Locale.ROOT);
                kotlin.jvm.internal.t.d(str2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            }
            if (C2250q.E(list, str2)) {
                return true;
            }
            if (str != null) {
                str4 = str.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.t.d(str4, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            if (C2250q.E(list, str4)) {
                return true;
            }
        }
        return false;
    }

    public final boolean n() {
        a aVar = this.f839a;
        b bVar = b.VENDOR_LIST_LAST_UPDATED;
        aVar.getClass();
        kotlin.jvm.internal.t.e(bVar, "preferenceKey");
        if (l4.a.a(aVar.f25721a.getLong("gvl_last_updated", 0), System.currentTimeMillis()) < ((long) this.f841c.f19281b.f19210A)) {
            return true;
        }
        int j5 = j();
        a aVar2 = this.f839a;
        b bVar2 = b.VENDOR_LIST_VERSION;
        aVar2.getClass();
        kotlin.jvm.internal.t.e(bVar2, "preferenceKey");
        if (j5 <= aVar2.f25721a.getInt("gvl_version", 0)) {
            return true;
        }
        return false;
    }

    public final boolean o() {
        if (!this.f841c.f19281b.f19237b.contains("USP")) {
            return false;
        }
        if (this.f841c.f19281b.f19226Q.contains("WORLDWIDE") || this.f841c.f19281b.f19226Q.contains("USA")) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void p() {
        /*
            r33 = this;
            r0 = r33
            k1.a r1 = s4.c.g()
            int r2 = r1.C1797g.f16398e
            boolean r1 = r1.k(r2)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x00c5
            k1.a r1 = s4.c.g()
            int r4 = r1.C1797g.f16398e
            r1.b r1 = r1.h(r4)
            J2.u r4 = r0.f840b
            com.inmobi.cmp.core.model.Vector r4 = r4.f18331r
            java.lang.String r5 = q1.C1762f.f15933m
            java.lang.Object r5 = r1.c(r5)
            java.lang.String r6 = "gppModel.getFieldValue(\n…ONSENTS\n                )"
            kotlin.jvm.internal.t.d(r5, r6)
            com.inmobi.cmp.core.model.Vector r5 = a(r5)
            r4.set((com.inmobi.cmp.core.model.Vector) r5)
            J2.u r4 = r0.f840b
            com.inmobi.cmp.core.model.Vector r4 = r4.f18332s
            r4.unsetAllOwnedItems()
            java.lang.String r5 = q1.C1762f.f15934n
            java.lang.Object r5 = r1.c(r5)
            java.lang.String r6 = "gppModel.getFieldValue(T…OSE_LEGITIMATE_INTERESTS)"
            kotlin.jvm.internal.t.d(r5, r6)
            com.inmobi.cmp.core.model.Vector r5 = a(r5)
            r4.set((com.inmobi.cmp.core.model.Vector) r5)
            J2.u r4 = r0.f840b
            com.inmobi.cmp.core.model.Vector r4 = r4.f18330q
            java.lang.String r5 = q1.C1762f.f15932l
            java.lang.Object r5 = r1.c(r5)
            java.lang.String r6 = "gppModel.getFieldValue(T…d.SPECIAL_FEATURE_OPTINS)"
            kotlin.jvm.internal.t.d(r5, r6)
            com.inmobi.cmp.core.model.Vector r5 = a(r5)
            r4.set((com.inmobi.cmp.core.model.Vector) r5)
            J2.u r4 = r0.f840b
            com.inmobi.cmp.core.model.Vector r4 = r4.f18339z
            r4.unsetAllOwnedItems()
            java.lang.String r5 = q1.C1762f.f15937q
            java.lang.Object r5 = r1.c(r5)
            java.lang.String r6 = "gppModel.getFieldValue(T…uV2Field.VENDOR_CONSENTS)"
            kotlin.jvm.internal.t.d(r5, r6)
            com.inmobi.cmp.core.model.Vector r5 = e(r5)
            r4.setOwnedItems(r5)
            J2.u r4 = r0.f840b
            com.inmobi.cmp.core.model.Vector r4 = r4.f18309C
            r4.unsetAllOwnedItems()
            java.lang.String r5 = q1.C1762f.f15938r
            java.lang.Object r5 = r1.c(r5)
            java.lang.String r6 = "gppModel.getFieldValue(T…DOR_LEGITIMATE_INTERESTS)"
            kotlin.jvm.internal.t.d(r5, r6)
            com.inmobi.cmp.core.model.Vector r5 = e(r5)
            r4.setOwnedItems(r5)
            J2.u r4 = r0.f840b
            com.inmobi.cmp.core.model.Vector r4 = r4.f18335v
            r4.unsetAllOwnedItems()
            java.lang.String r5 = q1.C1762f.f15941u
            java.lang.Object r5 = r1.c(r5)
            java.lang.String r6 = "gppModel.getFieldValue(T…Field.PUBLISHER_CONSENTS)"
            kotlin.jvm.internal.t.d(r5, r6)
            com.inmobi.cmp.core.model.Vector r5 = a(r5)
            r4.setOwnedItems(r5)
            J2.u r4 = r0.f840b
            com.inmobi.cmp.core.model.Vector r4 = r4.f18336w
            r4.unsetAllOwnedItems()
            java.lang.String r5 = q1.C1762f.f15942v
            java.lang.Object r1 = r1.c(r5)
            java.lang.String r5 = "gppModel.getFieldValue(T…HER_LEGITIMATE_INTERESTS)"
            kotlin.jvm.internal.t.d(r1, r5)
            com.inmobi.cmp.core.model.Vector r1 = a(r1)
            r4.setOwnedItems(r1)
            goto L_0x08f4
        L_0x00c5:
            r4.a r1 = r0.f839a
            r4.b r4 = r4.b.TC_STRING
            java.lang.String r1 = r1.k(r4)
            int r4 = r1.length()
            if (r4 <= 0) goto L_0x00d5
        L_0x00d3:
            r4 = r1
            goto L_0x00d7
        L_0x00d5:
            r1 = 0
            goto L_0x00d3
        L_0x00d7:
            if (r4 != 0) goto L_0x00db
            goto L_0x08f4
        L_0x00db:
            java.lang.String r1 = "encodedTCString"
            kotlin.jvm.internal.t.e(r4, r1)
            java.lang.String r1 = "."
            java.lang.String[] r5 = new java.lang.String[]{r1}
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            java.util.List r1 = t3.s.G0(r4, r5, r6, r7, r8, r9)
            int r4 = r1.size()
            J2.u r5 = new J2.u
            r5.<init>()
            r6 = r3
        L_0x00f8:
            if (r6 >= r4) goto L_0x08a6
            int r7 = r6 + 1
            java.lang.Object r6 = r1.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            java.util.Map r8 = L2.b.f18402a
            char r8 = r6.charAt(r3)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r8 = L2.a.a(r8)
            java.util.Map r9 = L2.e.f18404a
            L2.f r9 = L2.f.SEGMENT_TYPE
            java.lang.String r10 = "key"
            kotlin.jvm.internal.t.e(r9, r10)
            java.util.Map r11 = L2.e.f18405b
            java.lang.Object r12 = r11.get(r9)
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 != 0) goto L_0x0125
            r12 = r3
            goto L_0x0129
        L_0x0125:
            int r12 = r12.intValue()
        L_0x0129:
            java.lang.String r8 = r8.substring(r3, r12)
            java.lang.String r12 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.t.d(r8, r12)
            java.util.Set r13 = J2.o.f18300a
            kotlin.jvm.internal.t.e(r9, r10)
            java.lang.Object r9 = r11.get(r9)
            java.lang.Integer r9 = (java.lang.Integer) r9
            if (r9 != 0) goto L_0x0141
            r9 = r3
            goto L_0x0145
        L_0x0141:
            int r9 = r9.intValue()
        L_0x0145:
            int r8 = N2.d.a(r9, r8)
            java.lang.Object r8 = X2.C2250q.G(r13, r8)
            J2.n r8 = (J2.n) r8
            java.lang.String r9 = "encodedString"
            kotlin.jvm.internal.t.e(r6, r9)
            java.lang.String r11 = "tcModel"
            kotlin.jvm.internal.t.e(r5, r11)
            java.lang.String r11 = "segment"
            kotlin.jvm.internal.t.e(r8, r11)
            java.lang.String r6 = L2.a.a(r6)
            J2.n r11 = J2.n.CORE
            if (r8 != r11) goto L_0x0199
            J2.b r13 = J2.b.VERSION
            kotlin.jvm.internal.t.e(r13, r10)
            java.util.Map r14 = L2.e.f18404a
            java.lang.Object r15 = r14.get(r13)
            java.lang.Integer r15 = (java.lang.Integer) r15
            if (r15 != 0) goto L_0x0177
            r15 = r3
            goto L_0x017b
        L_0x0177:
            int r15 = r15.intValue()
        L_0x017b:
            java.lang.String r15 = r6.substring(r3, r15)
            kotlin.jvm.internal.t.d(r15, r12)
            kotlin.jvm.internal.t.e(r13, r10)
            java.lang.Object r13 = r14.get(r13)
            java.lang.Integer r13 = (java.lang.Integer) r13
            if (r13 != 0) goto L_0x018f
            r13 = r3
            goto L_0x0193
        L_0x018f:
            int r13 = r13.intValue()
        L_0x0193:
            int r13 = N2.d.a(r13, r15)
            r5.f18322i = r13
        L_0x0199:
            if (r8 == r11) goto L_0x01aa
            java.lang.String r11 = "segmentType"
            kotlin.jvm.internal.t.e(r11, r10)
            java.util.Map r13 = L2.e.f18406c
            java.lang.Object r11 = r13.get(r11)
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 != 0) goto L_0x01ac
        L_0x01aa:
            r11 = r3
            goto L_0x01b0
        L_0x01ac:
            int r11 = r11.intValue()
        L_0x01b0:
            int r13 = r5.f18322i
            if (r13 != r2) goto L_0x01bf
            java.util.Map r13 = P2.a.f18864a
            java.lang.String r8 = r8.f18299a
            java.lang.Object r8 = r13.get(r8)
            java.lang.String[] r8 = (java.lang.String[]) r8
            goto L_0x01c9
        L_0x01bf:
            java.util.Map r13 = P2.a.f18865b
            java.lang.String r8 = r8.f18299a
            java.lang.Object r8 = r13.get(r8)
            java.lang.String[] r8 = (java.lang.String[]) r8
        L_0x01c9:
            if (r8 != 0) goto L_0x01d3
        L_0x01cb:
            r16 = r1
            r21 = r4
            r22 = r7
            goto L_0x089c
        L_0x01d3:
            int r13 = r8.length
            r14 = r3
        L_0x01d5:
            if (r14 >= r13) goto L_0x01cb
            r15 = r8[r14]
            int r14 = r14 + 1
            java.util.Map r16 = N2.b.f18704a
            kotlin.jvm.internal.t.e(r15, r10)
            java.util.Map r2 = N2.b.f18704a
            java.lang.Object r2 = r2.get(r15)
            java.lang.String r2 = (java.lang.String) r2
            java.util.Map r2 = L2.e.f18404a
            kotlin.jvm.internal.t.e(r15, r10)
            java.util.Map r2 = L2.e.f18406c
            java.lang.Object r2 = r2.get(r15)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 != 0) goto L_0x020d
            r19 = 6
            r20 = 0
            java.lang.String r16 = "publisherCustom"
            r17 = 0
            r18 = 0
            int r16 = t3.s.f0(r15, r16, r17, r18, r19, r20)
            if (r16 != 0) goto L_0x020d
            int r2 = r5.f18329p
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x020d:
            if (r2 != 0) goto L_0x0210
            goto L_0x0216
        L_0x0210:
            int r16 = r2.intValue()
            if (r16 == 0) goto L_0x087b
        L_0x0216:
            if (r2 == 0) goto L_0x087b
            int r16 = r2.intValue()     // Catch:{ IndexOutOfBoundsException -> 0x0228 }
            int r3 = r16 + r11
            java.lang.String r3 = r6.substring(r11, r3)     // Catch:{ IndexOutOfBoundsException -> 0x0228 }
            kotlin.jvm.internal.t.d(r3, r12)     // Catch:{ IndexOutOfBoundsException -> 0x0228 }
            r16 = r1
            goto L_0x0241
        L_0x0228:
            int r3 = r2.intValue()
            int r3 = r3 + r11
            r16 = r1
            r1 = 48
            java.lang.String r1 = t3.s.q0(r6, r3, r1)
            int r3 = r2.intValue()
            int r3 = r3 + r11
            java.lang.String r3 = r1.substring(r11, r3)
            kotlin.jvm.internal.t.d(r3, r12)
        L_0x0241:
            java.lang.String r1 = "version"
            boolean r1 = kotlin.jvm.internal.t.a(r15, r1)
            if (r1 == 0) goto L_0x0267
            int r1 = r2.intValue()
            int r1 = N2.d.a(r1, r3)
            r5.f18322i = r1
            r18 = r2
        L_0x0255:
            r21 = r4
            r23 = r6
            r22 = r7
        L_0x025b:
            r19 = r8
        L_0x025d:
            r20 = r9
            r27 = r11
            r28 = r13
            r30 = r14
            goto L_0x083e
        L_0x0267:
            java.lang.String r1 = "created"
            boolean r1 = kotlin.jvm.internal.t.a(r15, r1)
            if (r1 == 0) goto L_0x027c
            int r1 = r2.intValue()
            r18 = r2
            long r1 = N2.a.a(r1, r3)
            r5.f18315b = r1
            goto L_0x0255
        L_0x027c:
            r18 = r2
            java.lang.String r1 = "lastUpdated"
            boolean r1 = kotlin.jvm.internal.t.a(r15, r1)
            if (r1 == 0) goto L_0x0291
            int r1 = r18.intValue()
            long r1 = N2.a.a(r1, r3)
            r5.f18316c = r1
            goto L_0x0255
        L_0x0291:
            java.lang.String r1 = "cmpId"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r1)
            r19 = r2
            java.lang.String r2 = "msg"
            r21 = r4
            java.lang.String r4 = "f.u"
            r22 = r7
            java.lang.String r7 = ""
            if (r19 == 0) goto L_0x02e4
            int r15 = r18.intValue()
            int r3 = N2.d.a(r15, r3)
            r15 = -1
            if (r3 <= r15) goto L_0x02b5
            r5.f18326m = r3
        L_0x02b2:
            r23 = r6
            goto L_0x025b
        L_0x02b5:
            J2.w r15 = new J2.w
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r15.<init>(r1, r3, r7)
            com.inmobi.cmp.ChoiceCmp r1 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r1 = r1.getCallback()
            if (r1 != 0) goto L_0x02c7
            goto L_0x02cc
        L_0x02c7:
            com.inmobi.cmp.model.ChoiceError r3 = com.inmobi.cmp.model.ChoiceError.TC_MODEL_PROPERTY_ERROR
            r1.onCmpError(r3)
        L_0x02cc:
            java.lang.String r1 = r15.getMessage()
            if (r1 != 0) goto L_0x02d3
            goto L_0x02d4
        L_0x02d3:
            r7 = r1
        L_0x02d4:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            kotlin.jvm.internal.t.e(r7, r2)
            boolean r1 = kotlin.jvm.internal.t.a(r1, r1)
            if (r1 != 0) goto L_0x02e0
        L_0x02df:
            goto L_0x02b2
        L_0x02e0:
            android.util.Log.e(r4, r7, r15)
            goto L_0x02b2
        L_0x02e4:
            java.lang.String r1 = "cmpVersion"
            boolean r19 = kotlin.jvm.internal.t.a(r15, r1)
            if (r19 == 0) goto L_0x0329
            int r15 = r18.intValue()
            int r3 = N2.d.a(r15, r3)
            r15 = -1
            if (r3 <= r15) goto L_0x02fa
            r5.f18327n = r3
            goto L_0x02b2
        L_0x02fa:
            J2.w r15 = new J2.w
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r15.<init>(r1, r3, r7)
            com.inmobi.cmp.ChoiceCmp r1 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r1 = r1.getCallback()
            if (r1 != 0) goto L_0x030c
            goto L_0x0311
        L_0x030c:
            com.inmobi.cmp.model.ChoiceError r3 = com.inmobi.cmp.model.ChoiceError.TC_MODEL_PROPERTY_ERROR
            r1.onCmpError(r3)
        L_0x0311:
            java.lang.String r1 = r15.getMessage()
            if (r1 != 0) goto L_0x0318
            goto L_0x0319
        L_0x0318:
            r7 = r1
        L_0x0319:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            kotlin.jvm.internal.t.e(r7, r2)
            boolean r1 = kotlin.jvm.internal.t.a(r1, r1)
            if (r1 != 0) goto L_0x0325
            goto L_0x02df
        L_0x0325:
            android.util.Log.e(r4, r7, r15)
            goto L_0x02b2
        L_0x0329:
            java.lang.String r1 = "consentScreen"
            boolean r19 = kotlin.jvm.internal.t.a(r15, r1)
            if (r19 == 0) goto L_0x0371
            int r15 = r18.intValue()
            int r3 = N2.d.a(r15, r3)
            r15 = -1
            if (r3 <= r15) goto L_0x0340
            r5.f18323j = r3
            goto L_0x02b2
        L_0x0340:
            J2.w r15 = new J2.w
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r15.<init>(r1, r3, r7)
            com.inmobi.cmp.ChoiceCmp r1 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r1 = r1.getCallback()
            if (r1 != 0) goto L_0x0352
            goto L_0x0357
        L_0x0352:
            com.inmobi.cmp.model.ChoiceError r3 = com.inmobi.cmp.model.ChoiceError.TC_MODEL_PROPERTY_ERROR
            r1.onCmpError(r3)
        L_0x0357:
            java.lang.String r1 = r15.getMessage()
            if (r1 != 0) goto L_0x035e
            goto L_0x035f
        L_0x035e:
            r7 = r1
        L_0x035f:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            kotlin.jvm.internal.t.e(r7, r2)
            boolean r1 = kotlin.jvm.internal.t.a(r1, r1)
            if (r1 != 0) goto L_0x036c
            goto L_0x02df
        L_0x036c:
            android.util.Log.e(r4, r7, r15)
            goto L_0x02b2
        L_0x0371:
            java.lang.String r1 = "consentLanguage"
            boolean r1 = kotlin.jvm.internal.t.a(r15, r1)
            r19 = r1
            java.lang.String r1 = "<set-?>"
            if (r19 == 0) goto L_0x038c
            int r2 = r18.intValue()
            java.lang.String r2 = N2.e.a(r2, r3)
            kotlin.jvm.internal.t.e(r2, r1)
            r5.f18325l = r2
            goto L_0x02b2
        L_0x038c:
            r19 = r8
            java.lang.String r8 = "vendorListVersion"
            boolean r20 = kotlin.jvm.internal.t.a(r15, r8)
            if (r20 == 0) goto L_0x03d4
            int r1 = r18.intValue()
            int r1 = N2.d.a(r1, r3)
            r5.f18328o = r1
            if (r1 >= 0) goto L_0x03cc
            J2.w r3 = new J2.w
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r3.<init>(r8, r1, r7)
            com.inmobi.cmp.ChoiceCmp r1 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r1 = r1.getCallback()
            if (r1 != 0) goto L_0x03b4
            goto L_0x03b9
        L_0x03b4:
            com.inmobi.cmp.model.ChoiceError r8 = com.inmobi.cmp.model.ChoiceError.TC_MODEL_PROPERTY_ERROR
            r1.onCmpError(r8)
        L_0x03b9:
            java.lang.String r1 = r3.getMessage()
            if (r1 != 0) goto L_0x03c0
            goto L_0x03c1
        L_0x03c0:
            r7 = r1
        L_0x03c1:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            kotlin.jvm.internal.t.e(r7, r2)
            boolean r1 = kotlin.jvm.internal.t.a(r1, r1)
            if (r1 != 0) goto L_0x03d0
        L_0x03cc:
            r23 = r6
            goto L_0x025d
        L_0x03d0:
            android.util.Log.e(r4, r7, r3)
            goto L_0x03cc
        L_0x03d4:
            java.lang.String r8 = "policyVersion"
            boolean r20 = kotlin.jvm.internal.t.a(r15, r8)
            if (r20 == 0) goto L_0x0417
            int r1 = r18.intValue()
            int r1 = N2.d.a(r1, r3)
            r5.f18324k = r1
            if (r1 >= 0) goto L_0x03cc
            J2.w r3 = new J2.w
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r3.<init>(r8, r1, r7)
            com.inmobi.cmp.ChoiceCmp r1 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r1 = r1.getCallback()
            if (r1 != 0) goto L_0x03fa
            goto L_0x03ff
        L_0x03fa:
            com.inmobi.cmp.model.ChoiceError r8 = com.inmobi.cmp.model.ChoiceError.TC_MODEL_PROPERTY_ERROR
            r1.onCmpError(r8)
        L_0x03ff:
            java.lang.String r1 = r3.getMessage()
            if (r1 != 0) goto L_0x0406
            goto L_0x0407
        L_0x0406:
            r7 = r1
        L_0x0407:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            kotlin.jvm.internal.t.e(r7, r2)
            boolean r1 = kotlin.jvm.internal.t.a(r1, r1)
            if (r1 != 0) goto L_0x0413
            goto L_0x03cc
        L_0x0413:
            android.util.Log.e(r4, r7, r3)
            goto L_0x03cc
        L_0x0417:
            java.lang.String r2 = "isServiceSpecific"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r2)
            java.lang.String r4 = "1"
            java.lang.String r7 = "value"
            if (r2 == 0) goto L_0x042d
            kotlin.jvm.internal.t.e(r3, r7)
            boolean r1 = kotlin.jvm.internal.t.a(r3, r4)
            r5.f18318e = r1
            goto L_0x03cc
        L_0x042d:
            java.lang.String r2 = "useNonStandardStacks"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r2)
            if (r2 == 0) goto L_0x043f
            kotlin.jvm.internal.t.e(r3, r7)
            boolean r1 = kotlin.jvm.internal.t.a(r3, r4)
            r5.f18319f = r1
            goto L_0x03cc
        L_0x043f:
            java.lang.String r2 = "specialFeatureOptions"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r2)
            if (r2 == 0) goto L_0x0456
            int r2 = r18.intValue()
            com.inmobi.cmp.core.model.Vector r2 = N2.c.a(r2, r3)
            kotlin.jvm.internal.t.e(r2, r1)
            r5.f18330q = r2
            goto L_0x03cc
        L_0x0456:
            java.lang.String r2 = "purposeConsents"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r2)
            if (r2 == 0) goto L_0x046d
            int r2 = r18.intValue()
            com.inmobi.cmp.core.model.Vector r2 = N2.c.a(r2, r3)
            kotlin.jvm.internal.t.e(r2, r1)
            r5.f18331r = r2
            goto L_0x03cc
        L_0x046d:
            java.lang.String r2 = "purposeLegitimateInterests"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r2)
            if (r2 == 0) goto L_0x0484
            int r2 = r18.intValue()
            com.inmobi.cmp.core.model.Vector r2 = N2.c.a(r2, r3)
            kotlin.jvm.internal.t.e(r2, r1)
            r5.f18332s = r2
            goto L_0x03cc
        L_0x0484:
            java.lang.String r2 = "purposeOneTreatment"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r2)
            if (r2 == 0) goto L_0x0497
            kotlin.jvm.internal.t.e(r3, r7)
            boolean r1 = kotlin.jvm.internal.t.a(r3, r4)
            r5.f18320g = r1
            goto L_0x03cc
        L_0x0497:
            java.lang.String r2 = "publisherCountryCode"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r2)
            if (r2 == 0) goto L_0x04ac
            int r1 = r18.intValue()
            java.lang.String r1 = N2.e.a(r1, r3)
            r5.b(r1)
            goto L_0x03cc
        L_0x04ac:
            java.lang.String r2 = "vendorConsents"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r2)
            java.lang.String r8 = "this as java.lang.String).substring(startIndex)"
            if (r2 == 0) goto L_0x04da
            java.lang.String r2 = r6.substring(r11)
            kotlin.jvm.internal.t.d(r2, r8)
            com.inmobi.cmp.core.model.Vector r2 = N2.g.a(r2)
            kotlin.jvm.internal.t.e(r2, r1)
            r5.f18339z = r2
            int r1 = r2.getBitLength()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
        L_0x04ce:
            r23 = r6
            r20 = r9
            r27 = r11
            r28 = r13
            r30 = r14
            goto L_0x0840
        L_0x04da:
            java.lang.String r2 = "vendorLegitimateInterests"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r2)
            if (r2 == 0) goto L_0x04fb
            java.lang.String r2 = r6.substring(r11)
            kotlin.jvm.internal.t.d(r2, r8)
            com.inmobi.cmp.core.model.Vector r2 = N2.g.a(r2)
            kotlin.jvm.internal.t.e(r2, r1)
            r5.f18309C = r2
            int r1 = r2.getBitLength()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            goto L_0x04ce
        L_0x04fb:
            java.lang.String r2 = "publisherRestrictions"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r2)
            if (r2 == 0) goto L_0x07a5
            P3.d r2 = new P3.d
            r2.<init>()
            kotlin.jvm.internal.t.e(r3, r9)
            java.lang.String r8 = "gvl"
            kotlin.jvm.internal.t.e(r2, r8)
            J2.l r8 = new J2.l
            r8.<init>(r2)
            java.util.Map r2 = L2.e.f18404a
            L2.f r2 = L2.f.NUM_RESTRICTIONS
            kotlin.jvm.internal.t.e(r2, r10)
            java.util.Map r15 = L2.e.f18405b
            java.lang.Object r20 = r15.get(r2)
            java.lang.Integer r20 = (java.lang.Integer) r20
            if (r20 != 0) goto L_0x052d
            r23 = r6
            r6 = 0
        L_0x0529:
            r20 = r9
            r9 = 0
            goto L_0x0536
        L_0x052d:
            int r20 = r20.intValue()
            r23 = r6
            r6 = r20
            goto L_0x0529
        L_0x0536:
            java.lang.String r6 = r3.substring(r9, r6)
            kotlin.jvm.internal.t.d(r6, r12)
            kotlin.jvm.internal.t.e(r2, r10)
            java.lang.Object r9 = r15.get(r2)
            java.lang.Integer r9 = (java.lang.Integer) r9
            if (r9 != 0) goto L_0x054a
            r9 = 0
            goto L_0x054e
        L_0x054a:
            int r9 = r9.intValue()
        L_0x054e:
            int r6 = N2.d.a(r9, r6)
            kotlin.jvm.internal.t.e(r2, r10)
            java.lang.Object r2 = r15.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 != 0) goto L_0x055f
            r2 = 0
            goto L_0x0563
        L_0x055f:
            int r2 = r2.intValue()
        L_0x0563:
            r9 = 0
        L_0x0564:
            if (r9 >= r6) goto L_0x0798
            int r9 = r9 + 1
            java.util.Map r15 = L2.e.f18404a
            L2.f r15 = L2.f.PURPOSE_ID
            kotlin.jvm.internal.t.e(r15, r10)
            r24 = r6
            java.util.Map r6 = L2.e.f18405b
            java.lang.Object r25 = r6.get(r15)
            java.lang.Integer r25 = (java.lang.Integer) r25
            if (r25 != 0) goto L_0x057f
            r26 = r9
            r9 = 0
            goto L_0x0587
        L_0x057f:
            int r25 = r25.intValue()
            r26 = r9
            r9 = r25
        L_0x0587:
            java.lang.String r9 = r3.substring(r2, r9)
            kotlin.jvm.internal.t.d(r9, r12)
            kotlin.jvm.internal.t.e(r15, r10)
            java.lang.Object r25 = r6.get(r15)
            java.lang.Integer r25 = (java.lang.Integer) r25
            if (r25 != 0) goto L_0x059d
            r27 = r2
            r2 = 0
            goto L_0x05a5
        L_0x059d:
            int r25 = r25.intValue()
            r27 = r2
            r2 = r25
        L_0x05a5:
            int r2 = N2.d.a(r2, r9)
            kotlin.jvm.internal.t.e(r15, r10)
            java.lang.Object r9 = r6.get(r15)
            java.lang.Integer r9 = (java.lang.Integer) r9
            if (r9 != 0) goto L_0x05b6
            r9 = 0
            goto L_0x05ba
        L_0x05b6:
            int r9 = r9.intValue()
        L_0x05ba:
            int r9 = r27 + r9
            L2.f r15 = L2.f.RESTRICTION_TYPE
            kotlin.jvm.internal.t.e(r15, r10)
            java.lang.Object r25 = r6.get(r15)
            java.lang.Integer r25 = (java.lang.Integer) r25
            if (r25 != 0) goto L_0x05cd
            r27 = r11
            r11 = 0
            goto L_0x05d5
        L_0x05cd:
            int r25 = r25.intValue()
            r27 = r11
            r11 = r25
        L_0x05d5:
            java.lang.String r11 = r3.substring(r9, r11)
            kotlin.jvm.internal.t.d(r11, r12)
            kotlin.jvm.internal.t.e(r15, r10)
            java.lang.Object r25 = r6.get(r15)
            java.lang.Integer r25 = (java.lang.Integer) r25
            if (r25 != 0) goto L_0x05eb
            r28 = r9
            r9 = 0
            goto L_0x05f3
        L_0x05eb:
            int r25 = r25.intValue()
            r28 = r9
            r9 = r25
        L_0x05f3:
            int r9 = N2.d.a(r9, r11)
            kotlin.jvm.internal.t.e(r15, r10)
            java.lang.Object r11 = r6.get(r15)
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 != 0) goto L_0x0604
            r11 = 0
            goto L_0x0608
        L_0x0604:
            int r11 = r11.intValue()
        L_0x0608:
            int r11 = r28 + r11
            J2.k r15 = new J2.k
            java.lang.String r9 = java.lang.String.valueOf(r9)
            J2.m r9 = J2.m.valueOf(r9)
            r15.<init>(r2, r9)
            L2.f r2 = L2.f.NUM_ENTRIES
            kotlin.jvm.internal.t.e(r2, r10)
            java.lang.Object r9 = r6.get(r2)
            java.lang.Integer r9 = (java.lang.Integer) r9
            if (r9 != 0) goto L_0x0626
            r9 = 0
            goto L_0x062a
        L_0x0626:
            int r9 = r9.intValue()
        L_0x062a:
            java.lang.String r9 = r3.substring(r11, r9)
            kotlin.jvm.internal.t.d(r9, r12)
            kotlin.jvm.internal.t.e(r2, r10)
            java.lang.Object r25 = r6.get(r2)
            java.lang.Integer r25 = (java.lang.Integer) r25
            if (r25 != 0) goto L_0x0640
            r28 = r11
            r11 = 0
            goto L_0x0648
        L_0x0640:
            int r25 = r25.intValue()
            r28 = r11
            r11 = r25
        L_0x0648:
            int r9 = N2.d.a(r11, r9)
            kotlin.jvm.internal.t.e(r2, r10)
            java.lang.Object r2 = r6.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 != 0) goto L_0x0659
            r2 = 0
            goto L_0x065d
        L_0x0659:
            int r2 = r2.intValue()
        L_0x065d:
            int r2 = r28 + r2
            if (r9 < 0) goto L_0x0790
            r6 = 0
        L_0x0662:
            int r11 = r6 + 1
            java.util.Map r25 = L2.e.f18404a
            r25 = r11
            L2.f r11 = L2.f.ANY_BOOLEAN
            kotlin.jvm.internal.t.e(r11, r10)
            r28 = r13
            java.util.Map r13 = L2.e.f18405b
            java.lang.Object r29 = r13.get(r11)
            java.lang.Integer r29 = (java.lang.Integer) r29
            if (r29 != 0) goto L_0x067d
            r30 = r14
            r14 = 0
            goto L_0x0685
        L_0x067d:
            int r29 = r29.intValue()
            r30 = r14
            r14 = r29
        L_0x0685:
            java.lang.String r14 = r3.substring(r2, r14)
            kotlin.jvm.internal.t.d(r14, r12)
            kotlin.jvm.internal.t.e(r14, r7)
            boolean r14 = kotlin.jvm.internal.t.a(r14, r4)
            kotlin.jvm.internal.t.e(r11, r10)
            java.lang.Object r11 = r13.get(r11)
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 != 0) goto L_0x06a0
            r11 = 0
            goto L_0x06a4
        L_0x06a0:
            int r11 = r11.intValue()
        L_0x06a4:
            int r2 = r2 + r11
            L2.f r11 = L2.f.VENDOR_ID
            kotlin.jvm.internal.t.e(r11, r10)
            java.lang.Object r29 = r13.get(r11)
            java.lang.Integer r29 = (java.lang.Integer) r29
            if (r29 != 0) goto L_0x06b6
            r31 = r4
            r4 = 0
            goto L_0x06be
        L_0x06b6:
            int r29 = r29.intValue()
            r31 = r4
            r4 = r29
        L_0x06be:
            java.lang.String r4 = r3.substring(r2, r4)
            kotlin.jvm.internal.t.d(r4, r12)
            kotlin.jvm.internal.t.e(r11, r10)
            java.lang.Object r29 = r13.get(r11)
            java.lang.Integer r29 = (java.lang.Integer) r29
            if (r29 != 0) goto L_0x06d4
            r32 = r2
            r2 = 0
            goto L_0x06dc
        L_0x06d4:
            int r29 = r29.intValue()
            r32 = r2
            r2 = r29
        L_0x06dc:
            int r2 = N2.d.a(r2, r4)
            kotlin.jvm.internal.t.e(r11, r10)
            java.lang.Object r4 = r13.get(r11)
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 != 0) goto L_0x06ed
            r4 = 0
            goto L_0x06f1
        L_0x06ed:
            int r4 = r4.intValue()
        L_0x06f1:
            int r4 = r32 + r4
            if (r14 == 0) goto L_0x076f
            kotlin.jvm.internal.t.e(r11, r10)
            java.lang.Object r14 = r13.get(r11)
            java.lang.Integer r14 = (java.lang.Integer) r14
            if (r14 != 0) goto L_0x0702
            r14 = 0
            goto L_0x0706
        L_0x0702:
            int r14 = r14.intValue()
        L_0x0706:
            java.lang.String r14 = r3.substring(r4, r14)
            kotlin.jvm.internal.t.d(r14, r12)
            kotlin.jvm.internal.t.e(r11, r10)
            java.lang.Object r29 = r13.get(r11)
            java.lang.Integer r29 = (java.lang.Integer) r29
            if (r29 != 0) goto L_0x071c
            r32 = r4
            r4 = 0
            goto L_0x0724
        L_0x071c:
            int r29 = r29.intValue()
            r32 = r4
            r4 = r29
        L_0x0724:
            int r4 = N2.d.a(r4, r14)
            kotlin.jvm.internal.t.e(r11, r10)
            java.lang.Object r11 = r13.get(r11)
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 != 0) goto L_0x0735
            r11 = 0
            goto L_0x0739
        L_0x0735:
            int r11 = r11.intValue()
        L_0x0739:
            int r11 = r32 + r11
            if (r4 < r2) goto L_0x074b
            if (r2 > r4) goto L_0x0749
        L_0x073f:
            int r13 = r2 + 1
            r8.a(r2, r15)
            if (r2 != r4) goto L_0x0747
            goto L_0x0749
        L_0x0747:
            r2 = r13
            goto L_0x073f
        L_0x0749:
            r2 = r11
            goto L_0x0776
        L_0x074b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "h.k"
            r1.append(r3)
            java.lang.String r3 = ": Invalid RangeEntry: endVendorId "
            r1.append(r3)
            r1.append(r4)
            java.lang.String r3 = " is less than "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            L2.g r2 = new L2.g
            r2.<init>(r1)
            throw r2
        L_0x076f:
            r32 = r4
            r8.a(r2, r15)
            r2 = r32
        L_0x0776:
            if (r6 != r9) goto L_0x0786
            r6 = r24
            r9 = r26
            r11 = r27
            r13 = r28
            r14 = r30
            r4 = r31
            goto L_0x0564
        L_0x0786:
            r6 = r25
            r13 = r28
            r14 = r30
            r4 = r31
            goto L_0x0662
        L_0x0790:
            r6 = r24
            r9 = r26
            r11 = r27
            goto L_0x0564
        L_0x0798:
            r27 = r11
            r28 = r13
            r30 = r14
            kotlin.jvm.internal.t.e(r8, r1)
            r5.f18313G = r8
            goto L_0x083e
        L_0x07a5:
            r23 = r6
            r20 = r9
            r27 = r11
            r28 = r13
            r30 = r14
            java.lang.String r2 = "publisherConsents"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r2)
            if (r2 == 0) goto L_0x07c6
            int r2 = r18.intValue()
            com.inmobi.cmp.core.model.Vector r2 = N2.c.a(r2, r3)
            kotlin.jvm.internal.t.e(r2, r1)
            r5.f18335v = r2
            goto L_0x083e
        L_0x07c6:
            java.lang.String r2 = "publisherLegitimateInterests"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r2)
            if (r2 == 0) goto L_0x07dc
            int r2 = r18.intValue()
            com.inmobi.cmp.core.model.Vector r2 = N2.c.a(r2, r3)
            kotlin.jvm.internal.t.e(r2, r1)
            r5.f18336w = r2
            goto L_0x083e
        L_0x07dc:
            java.lang.String r2 = "numCustomPurposes"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r2)
            if (r2 == 0) goto L_0x07ef
            int r1 = r18.intValue()
            int r1 = N2.d.a(r1, r3)
            r5.f18329p = r1
            goto L_0x083e
        L_0x07ef:
            java.lang.String r2 = "publisherCustomConsents"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r2)
            if (r2 == 0) goto L_0x0805
            int r2 = r18.intValue()
            com.inmobi.cmp.core.model.Vector r2 = N2.c.a(r2, r3)
            kotlin.jvm.internal.t.e(r2, r1)
            r5.f18337x = r2
            goto L_0x083e
        L_0x0805:
            java.lang.String r2 = "publisherCustomLegitimateInterests"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r2)
            if (r2 == 0) goto L_0x081b
            int r2 = r18.intValue()
            com.inmobi.cmp.core.model.Vector r2 = N2.c.a(r2, r3)
            kotlin.jvm.internal.t.e(r2, r1)
            r5.f18338y = r2
            goto L_0x083e
        L_0x081b:
            java.lang.String r2 = "vendorsAllowed"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r2)
            if (r2 == 0) goto L_0x082d
            com.inmobi.cmp.core.model.Vector r2 = N2.g.a(r3)
            kotlin.jvm.internal.t.e(r2, r1)
            r5.f18312F = r2
            goto L_0x083e
        L_0x082d:
            java.lang.String r2 = "vendorsDisclosed"
            boolean r2 = kotlin.jvm.internal.t.a(r15, r2)
            if (r2 == 0) goto L_0x085a
            com.inmobi.cmp.core.model.Vector r2 = N2.g.a(r3)
            kotlin.jvm.internal.t.e(r2, r1)
            r5.f18311E = r2
        L_0x083e:
            r2 = r18
        L_0x0840:
            int r1 = r2.intValue()
            int r11 = r1 + r27
            r1 = r16
            r8 = r19
            r9 = r20
            r4 = r21
            r7 = r22
            r6 = r23
        L_0x0852:
            r13 = r28
            r14 = r30
            r2 = 1
            r3 = 0
            goto L_0x01d5
        L_0x085a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "g.i"
            r1.append(r2)
            java.lang.String r2 = ": Unable to find: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r2 = " field on TCModel, segment"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            L2.g r2 = new L2.g
            r2.<init>(r1)
            throw r2
        L_0x087b:
            r16 = r1
            r21 = r4
            r23 = r6
            r22 = r7
            r19 = r8
            r20 = r9
            r27 = r11
            r28 = r13
            r30 = r14
            r1 = r16
            r8 = r19
            r9 = r20
            r4 = r21
            r7 = r22
            r6 = r23
            r11 = r27
            goto L_0x0852
        L_0x089c:
            r1 = r16
            r4 = r21
            r6 = r22
            r2 = 1
            r3 = 0
            goto L_0x00f8
        L_0x08a6:
            J2.u r1 = r0.f840b
            com.inmobi.cmp.core.model.Vector r1 = r1.f18331r
            com.inmobi.cmp.core.model.Vector r2 = r5.f18331r
            r1.set((com.inmobi.cmp.core.model.Vector) r2)
            J2.u r1 = r0.f840b
            com.inmobi.cmp.core.model.Vector r1 = r1.f18332s
            r1.unsetAllOwnedItems()
            com.inmobi.cmp.core.model.Vector r2 = r5.f18332s
            r1.set((com.inmobi.cmp.core.model.Vector) r2)
            J2.u r1 = r0.f840b
            com.inmobi.cmp.core.model.Vector r1 = r1.f18330q
            com.inmobi.cmp.core.model.Vector r2 = r5.f18330q
            r1.set((com.inmobi.cmp.core.model.Vector) r2)
            J2.u r1 = r0.f840b
            com.inmobi.cmp.core.model.Vector r1 = r1.f18339z
            r1.unsetAllOwnedItems()
            com.inmobi.cmp.core.model.Vector r2 = r5.f18339z
            r1.setOwnedItems(r2)
            J2.u r1 = r0.f840b
            com.inmobi.cmp.core.model.Vector r1 = r1.f18309C
            r1.unsetAllOwnedItems()
            com.inmobi.cmp.core.model.Vector r2 = r5.f18309C
            r1.setOwnedItems(r2)
            J2.u r1 = r0.f840b
            com.inmobi.cmp.core.model.Vector r1 = r1.f18335v
            r1.unsetAllOwnedItems()
            com.inmobi.cmp.core.model.Vector r2 = r5.f18335v
            r1.set((com.inmobi.cmp.core.model.Vector) r2)
            J2.u r1 = r0.f840b
            com.inmobi.cmp.core.model.Vector r1 = r1.f18336w
            r1.unsetAllOwnedItems()
            com.inmobi.cmp.core.model.Vector r2 = r5.f18336w
            r1.set((com.inmobi.cmp.core.model.Vector) r2)
        L_0x08f4:
            k1.a r1 = s4.c.g()
            java.lang.String r2 = r1.C1797g.f16400g
            boolean r1 = r1.l(r2)
            if (r1 != 0) goto L_0x090e
            r4.a r1 = r0.f839a
            r4.b r2 = r4.b.TC_STRING
            java.lang.String r1 = r1.k(r2)
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x09b9
        L_0x090e:
            T3.i r1 = r0.f841c
            T3.c r1 = r1.f19281b
            java.lang.String r1 = r1.f19218I
            if (r1 != 0) goto L_0x0917
            goto L_0x093d
        L_0x0917:
            com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode r2 = com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode.GPP
            java.lang.String r3 = r2.getValue()
            boolean r1 = r1.equals(r3)
            r3 = 1
            if (r1 != r3) goto L_0x093d
            k1.a r1 = s4.c.g()
            int r3 = r1.C1797g.f16398e
            boolean r1 = r1.k(r3)
            if (r1 != 0) goto L_0x0938
            o4.j r1 = r0.f849k
            o4.m r1 = (o4.m) r1
            r9 = 0
            r1.b(r2, r9, r9)
        L_0x0938:
            r0.f()
            goto L_0x09b9
        L_0x093d:
            T3.i r1 = r0.f841c
            T3.c r1 = r1.f19281b
            java.lang.String r1 = r1.f19218I
            if (r1 != 0) goto L_0x0947
        L_0x0945:
            r9 = 0
            goto L_0x098d
        L_0x0947:
            com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode r2 = com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode.TCF
            java.lang.String r3 = r2.getValue()
            boolean r1 = r1.equals(r3)
            r3 = 1
            if (r1 != r3) goto L_0x0945
            k1.a r1 = s4.c.g()
            int r3 = r1.C1797g.f16398e
            r1.c(r3)
            r0.b()
            k1.a r1 = s4.c.g()
            java.lang.String r1 = r1.e()
            r4.a r3 = s4.c.l()
            r4.b r4 = r4.b.HDR_GPP_STRING
            java.lang.String r5 = "gppString"
            kotlin.jvm.internal.t.d(r1, r5)
            r3.i(r4, r1)
            r4.a r1 = r0.f839a
            r4.b r3 = r4.b.TC_STRING
            java.lang.String r1 = r1.k(r3)
            int r1 = r1.length()
            if (r1 != 0) goto L_0x09b9
            o4.j r1 = r0.f849k
            o4.m r1 = (o4.m) r1
            r9 = 0
            r1.b(r2, r9, r9)
            goto L_0x09b9
        L_0x098d:
            k1.a r1 = s4.c.g()
            int r2 = r1.C1797g.f16398e
            boolean r1 = r1.k(r2)
            if (r1 != 0) goto L_0x09a2
            o4.j r1 = r0.f849k
            com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode r2 = com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode.GPP
            o4.m r1 = (o4.m) r1
            r1.b(r2, r9, r9)
        L_0x09a2:
            r4.a r1 = r0.f839a
            r4.b r2 = r4.b.TC_STRING
            java.lang.String r1 = r1.k(r2)
            int r1 = r1.length()
            if (r1 != 0) goto L_0x09b9
            o4.j r1 = r0.f849k
            com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode r2 = com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode.TCF
            o4.m r1 = (o4.m) r1
            r1.b(r2, r9, r9)
        L_0x09b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.x.p():void");
    }

    public final void q() {
        J j5;
        T3.k kVar;
        T3.k kVar2;
        T3.k kVar3;
        T3.c cVar = this.f841c.f19281b;
        try {
            c cVar2 = this.f853o;
            if (cVar2 == null) {
                j5 = null;
            } else {
                List list = cVar.f19238c;
                String substring = cVar2.f19303a.substring(0, 2);
                kotlin.jvm.internal.t.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                Locale locale = Locale.ROOT;
                kotlin.jvm.internal.t.d(locale, "ROOT");
                String upperCase = substring.toUpperCase(locale);
                kotlin.jvm.internal.t.d(upperCase, "this as java.lang.String).toUpperCase(locale)");
                if (!list.contains(upperCase)) {
                    List list2 = cVar.f19238c;
                    String substring2 = cVar2.f19304b.substring(0, 2);
                    kotlin.jvm.internal.t.d(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    kotlin.jvm.internal.t.d(locale, "ROOT");
                    String upperCase2 = substring2.toUpperCase(locale);
                    kotlin.jvm.internal.t.d(upperCase2, "this as java.lang.String).toUpperCase(locale)");
                    if (!list2.contains(upperCase2)) {
                        this.f839a.i(b.PRIVACY_STRING, "1---");
                        return;
                    }
                }
                j5 = J.f19942a;
            }
            if (j5 != null) {
                String k5 = this.f839a.k(b.SAVED_PRIVACY_STRING);
                if (!k()) {
                    this.f839a.i(b.PRIVACY_STRING, "1---");
                } else if (k5.length() > 0) {
                    this.f839a.i(b.PRIVACY_STRING, k5);
                } else {
                    a aVar = this.f839a;
                    kotlin.jvm.internal.t.e(aVar, "storage");
                    if (kotlin.jvm.internal.t.a(aVar.b(1, 2), "Y")) {
                        kVar = T3.k.YES;
                    } else {
                        kVar = T3.k.NO;
                    }
                    a aVar2 = this.f839a;
                    kotlin.jvm.internal.t.e(aVar2, "storage");
                    if (kotlin.jvm.internal.t.a(aVar2.b(2, 3), "Y")) {
                        kVar2 = T3.k.YES;
                    } else {
                        kVar2 = T3.k.NO;
                    }
                    if (kotlin.jvm.internal.t.a(cVar.f19239d, "Y")) {
                        kVar3 = T3.k.YES;
                    } else {
                        kVar3 = T3.k.NO;
                    }
                    a.d(aVar, kVar, kVar2, kVar3);
                }
            }
        } catch (StringIndexOutOfBoundsException unused) {
            ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
            if (callback != null) {
                callback.onCmpError(ChoiceError.GEO_IP_UNEXPECTED_ERROR);
            }
        }
    }

    public final void r() {
        this.f839a.f(b.GPP_CMP_SDK_ID, this.f840b.f18326m);
        this.f839a.f(b.GPP_CMP_SDK_VERSION, this.f840b.f18327n);
        this.f839a.f(b.GPP_POLICY_VERSION, this.f840b.f());
        this.f839a.f(b.GPP_GDPR_APPLIES, g() ? 1 : 0);
        this.f839a.i(b.GPP_PUBLISHER_CC, this.f841c.f19281b.f19241f);
        this.f839a.f(b.GPP_PURPOSE_ONE_TREATMENT, this.f840b.f18320g ? 1 : 0);
        this.f839a.f(b.GPP_USE_NON_STANDARD_STACKS, this.f840b.f18319f ? 1 : 0);
    }

    public final void s() {
        this.f839a.f(b.TCF_CMP_SDK_ID, this.f840b.f18326m);
        this.f839a.f(b.TCF_CMP_SDK_VERSION, this.f840b.f18327n);
        this.f839a.f(b.TCF_POLICY_VERSION, this.f840b.f());
        if (this.f854p <= 0) {
            this.f854p = this.f840b.f();
        }
        this.f839a.f(b.TCF_GDPR_APPLIES, g() ? 1 : 0);
        this.f839a.i(b.TCF_PUBLISHER_CC, this.f841c.f19281b.f19241f);
        this.f839a.f(b.TCF_PURPOSE_ONE_TREATMENT, this.f840b.f18320g ? 1 : 0);
        this.f839a.f(b.TCF_USE_NON_STANDARD_STACKS, this.f840b.f18319f ? 1 : 0);
    }

    public final boolean t() {
        boolean z4;
        boolean z5;
        long j5 = this.f841c.f19287h;
        a aVar = this.f839a;
        b bVar = b.LAST_VISIT_TIME;
        aVar.getClass();
        kotlin.jvm.internal.t.e(bVar, "preferenceKey");
        long j6 = aVar.f25721a.getLong("LastVisitTime", 0);
        if (((double) (j5 - j6)) / ((double) MBridgeCommon.DEFAULT_LOAD_TIMEOUT) >= 30.0d) {
            z4 = true;
        } else {
            z4 = false;
        }
        TimeZone timeZone = DesugarTimeZone.getTimeZone("UTC");
        Calendar instance = Calendar.getInstance(timeZone);
        instance.setTimeInMillis(j6);
        Calendar instance2 = Calendar.getInstance(timeZone);
        instance2.setTimeInMillis(j5);
        if (instance.get(6) != instance2.get(6)) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f839a.g(bVar, this.f841c.f19287h);
        if (z4 || z5) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00bc, code lost:
        if (kotlin.jvm.internal.t.a(r0, l4.e.b(r1.toString())) == false) goto L_0x00be;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean u() {
        /*
            r5 = this;
            r4.a r0 = r5.f839a
            r4.b r1 = r4.b.TRANSLATIONS_TEXT
            java.lang.String r0 = r0.k(r1)
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x00c0
            r4.a r0 = r5.f839a
            r4.b r1 = r4.b.PORTAL_CONFIG
            java.lang.String r0 = r0.k(r1)
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x00c0
            J2.h r0 = r5.f855q
            java.util.Map r0 = r0.f18278b
            J2.u r1 = r5.f840b
            int r1 = r1.f18326m
            java.lang.String r1 = java.lang.String.valueOf(r1)
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x00be
            boolean r0 = r5.n()
            if (r0 == 0) goto L_0x00be
            r4.a r0 = r5.f839a
            r4.b r1 = r4.b.NON_IAB_VENDOR_CONSENT_HASH
            java.lang.String r0 = r0.k(r1)
            java.lang.String r1 = r5.h()
            java.lang.String r0 = kotlin.jvm.internal.t.n(r0, r1)
            r4.a r1 = r5.f839a
            r4.b r2 = r4.b.OPTION_HASH
            java.lang.String r1 = r1.k(r2)
            boolean r0 = kotlin.jvm.internal.t.a(r0, r1)
            if (r0 == 0) goto L_0x00be
            int r0 = r5.f854p
            J2.u r1 = r5.f840b
            P3.d r1 = r1.f18314a
            if (r1 != 0) goto L_0x005c
            r1 = 0
            goto L_0x005e
        L_0x005c:
            java.lang.Integer r1 = r1.f18871c
        L_0x005e:
            if (r1 != 0) goto L_0x0065
            int r1 = r5.i()
            goto L_0x0069
        L_0x0065:
            int r1 = r1.intValue()
        L_0x0069:
            if (r0 == r1) goto L_0x006c
            goto L_0x00be
        L_0x006c:
            r4.a r0 = r5.f839a
            r4.b r1 = r4.b.TC_STRING
            java.lang.String r0 = r0.k(r1)
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0087
            k1.a r0 = s4.c.g()
            java.lang.String r1 = r1.C1797g.f16400g
            boolean r0 = r0.l(r1)
            if (r0 != 0) goto L_0x0087
            goto L_0x00be
        L_0x0087:
            boolean r0 = r5.m()
            if (r0 == 0) goto L_0x00c0
            r4.a r0 = r5.f839a
            r4.b r1 = r4.b.GBC_PURPOSE_HASH
            java.lang.String r0 = r0.k(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            T3.i r2 = r5.f841c
            T3.c r2 = r2.f19281b
            T3.f r2 = r2.f19232W
            java.util.List r2 = r2.f19269c
            r1.append(r2)
            T3.i r2 = r5.f841c
            T3.c r2 = r2.f19281b
            T3.f r2 = r2.f19232W
            boolean r2 = r2.f19267a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = l4.e.b(r1)
            boolean r0 = kotlin.jvm.internal.t.a(r0, r1)
            if (r0 != 0) goto L_0x00c0
        L_0x00be:
            r0 = 1
            goto L_0x00c1
        L_0x00c0:
            r0 = 0
        L_0x00c1:
            boolean r1 = r5.m()
            if (r1 == 0) goto L_0x00f1
            r4.a r1 = r5.f839a
            r4.b r2 = r4.b.GBC_PURPOSE_HASH
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            T3.i r4 = r5.f841c
            T3.c r4 = r4.f19281b
            T3.f r4 = r4.f19232W
            java.util.List r4 = r4.f19269c
            r3.append(r4)
            T3.i r4 = r5.f841c
            T3.c r4 = r4.f19281b
            T3.f r4 = r4.f19232W
            boolean r4 = r4.f19267a
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = l4.e.b(r3)
            r1.i(r2, r3)
        L_0x00f1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.x.u():boolean");
    }
}
