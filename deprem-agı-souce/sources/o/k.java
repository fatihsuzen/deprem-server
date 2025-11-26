package o;

import J2.u;
import O2.j;
import P3.d;
import P3.e;
import T3.g;
import T3.h;
import T3.i;
import X2.C2250q;
import androidx.appcompat.R;
import androidx.lifecycle.ViewModel;
import b.w;
import c.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;
import t3.s;

public final class k extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final u f988a;

    /* renamed from: b  reason: collision with root package name */
    public final i f989b;

    /* renamed from: c  reason: collision with root package name */
    public final h f990c;

    /* renamed from: d  reason: collision with root package name */
    public final o4.k f991d;

    /* renamed from: e  reason: collision with root package name */
    public final P3.k f992e;

    /* renamed from: f  reason: collision with root package name */
    public final List f993f;

    /* renamed from: g  reason: collision with root package name */
    public final List f994g;

    /* renamed from: h  reason: collision with root package name */
    public final List f995h;

    /* renamed from: i  reason: collision with root package name */
    public final List f996i;

    /* renamed from: j  reason: collision with root package name */
    public j f997j = j.f18829a;

    /* renamed from: k  reason: collision with root package name */
    public boolean f998k;

    /* renamed from: l  reason: collision with root package name */
    public final int f999l = 4;

    public k(u uVar, i iVar, h hVar, o4.k kVar, P3.k kVar2, List list, List list2, List list3, List list4) {
        t.e(uVar, "tcModel");
        t.e(iVar, "portalConfig");
        t.e(hVar, "nonIabVendorsInfo");
        t.e(kVar, "translationsTextRepository");
        t.e(list, "vendorPurposeLegitimateInterestIds");
        t.e(list2, "vendorSpecialPurposeIds");
        t.e(list3, "vendorFeaturesIds");
        t.e(list4, "vendorSpecialFeaturesIds");
        this.f988a = uVar;
        this.f989b = iVar;
        this.f990c = hVar;
        this.f991d = kVar;
        this.f992e = kVar2;
        this.f993f = list;
        this.f994g = list2;
        this.f995h = list3;
        this.f996i = list4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.util.Set r8, O2.a r9) {
        /*
            r7 = this;
            java.lang.String r0 = "ids"
            kotlin.jvm.internal.t.e(r8, r0)
            java.lang.String r0 = "type"
            kotlin.jvm.internal.t.e(r9, r0)
            X2.T.d()
            int r9 = r9.ordinal()
            r0 = 1
            if (r9 == 0) goto L_0x0063
            if (r9 == r0) goto L_0x0053
            r1 = 2
            if (r9 == r1) goto L_0x0043
            r1 = 3
            if (r9 == r1) goto L_0x0033
            r1 = 4
            if (r9 != r1) goto L_0x002d
            java.util.Set r9 = X2.C2250q.r0(r8)
            J2.u r1 = r7.f988a
            P3.d r1 = r1.f18314a
            if (r1 != 0) goto L_0x002a
            goto L_0x006f
        L_0x002a:
            java.util.Map r1 = r1.f18879k
            goto L_0x0073
        L_0x002d:
            W2.q r8 = new W2.q
            r8.<init>()
            throw r8
        L_0x0033:
            java.util.List r9 = r7.f996i
            java.util.Set r9 = X2.C2250q.r0(r9)
            J2.u r1 = r7.f988a
            P3.d r1 = r1.f18314a
            if (r1 != 0) goto L_0x0040
            goto L_0x006f
        L_0x0040:
            java.util.Map r1 = r1.f18875g
            goto L_0x0073
        L_0x0043:
            java.util.List r9 = r7.f995h
            java.util.Set r9 = X2.C2250q.r0(r9)
            J2.u r1 = r7.f988a
            P3.d r1 = r1.f18314a
            if (r1 != 0) goto L_0x0050
            goto L_0x006f
        L_0x0050:
            java.util.Map r1 = r1.f18874f
            goto L_0x0073
        L_0x0053:
            java.util.List r9 = r7.f994g
            java.util.Set r9 = X2.C2250q.r0(r9)
            J2.u r1 = r7.f988a
            P3.d r1 = r1.f18314a
            if (r1 != 0) goto L_0x0060
            goto L_0x006f
        L_0x0060:
            java.util.Map r1 = r1.f18873e
            goto L_0x0073
        L_0x0063:
            java.util.List r9 = r7.f993f
            java.util.Set r9 = X2.C2250q.r0(r9)
            J2.u r1 = r7.f988a
            P3.d r1 = r1.f18314a
            if (r1 != 0) goto L_0x0071
        L_0x006f:
            r1 = 0
            goto L_0x0073
        L_0x0071:
            java.util.Map r1 = r1.f18872d
        L_0x0073:
            java.util.SortedSet r8 = X2.C2250q.B(r8)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x0080:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x0097
            java.lang.Object r3 = r8.next()
            r4 = r3
            java.lang.Integer r4 = (java.lang.Integer) r4
            boolean r4 = r9.contains(r4)
            if (r4 == 0) goto L_0x0080
            r2.add(r3)
            goto L_0x0080
        L_0x0097:
            int r8 = r2.size()
            r9 = 0
            java.lang.String r3 = ""
            r4 = r9
        L_0x009f:
            if (r4 >= r8) goto L_0x00e5
            java.lang.Object r5 = r2.get(r4)
            int r4 = r4 + 1
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r1 != 0) goto L_0x00ac
            goto L_0x009f
        L_0x00ac:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.Object r5 = r1.get(r5)
            P3.e r5 = (P3.e) r5
            if (r5 != 0) goto L_0x00b9
            goto L_0x009f
        L_0x00b9:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r3)
            kotlin.jvm.internal.Q r3 = kotlin.jvm.internal.Q.f24695a
            java.lang.String r3 = r5.f18882b
            java.lang.Object[] r5 = new java.lang.Object[r0]
            r5[r9] = r3
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r5, r0)
            java.lang.String r5 = "• %s."
            java.lang.String r3 = java.lang.String.format(r5, r3)
            java.lang.String r5 = "format(format, *args)"
            kotlin.jvm.internal.t.d(r3, r5)
            r6.append(r3)
            r3 = 10
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            goto L_0x009f
        L_0x00e5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: o.k.a(java.util.Set, O2.a):java.lang.String");
    }

    public final LinkedHashSet b() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (c.i iVar : c("")) {
            Boolean bool = iVar.f895b;
            if (bool != null) {
                linkedHashSet.add(bool);
            }
        }
        return linkedHashSet;
    }

    public final List c(String str) {
        ArrayList arrayList;
        int i5;
        P3.k kVar;
        Set set;
        int i6;
        d dVar;
        Map map;
        int i7;
        Set set2;
        boolean z4;
        Set set3;
        String str2 = str;
        t.e(str2, "search");
        int ordinal = this.f997j.ordinal();
        int i8 = 0;
        if (ordinal != 0) {
            arrayList = ordinal != 1 ? ordinal != 2 ? new ArrayList() : f() : d();
        } else {
            arrayList = f();
            arrayList.addAll(d());
            P3.k kVar2 = this.f992e;
            c.i iVar = null;
            if (kVar2 == null) {
                set2 = null;
            } else {
                set2 = kVar2.f18889e;
            }
            if (set2 != null && !kVar2.f18889e.isEmpty()) {
                P3.k kVar3 = this.f992e;
                if (kVar3 != null && (set3 = kVar3.f18889e) != null) {
                    Iterator it = set3.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (!t.a(this.f988a.f18336w.get(((Number) it.next()).intValue()), Boolean.TRUE)) {
                            z4 = false;
                            break;
                        }
                    }
                }
                z4 = true;
                iVar = new c.i((e) kVar3, Boolean.valueOf(z4), (l) null, c.k.PUBLISHER_VENDOR, (String) null, (Integer) null, 116);
            }
            if (iVar != null) {
                arrayList.add(0, iVar);
            }
        }
        String str3 = e().f25412h;
        l lVar = l.LABEL;
        arrayList.add(0, new c.i((e) null, (Boolean) null, lVar, (c.k) null, str3, (Integer) null, 91));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(0, new c.i((e) null, (Boolean) null, lVar, (c.k) null, e().f25411g, (Integer) null, 91));
        LinkedHashMap g5 = g();
        if (g5 != null) {
            for (Map.Entry entry : g5.entrySet()) {
                int i9 = ((P3.h) entry.getValue()).f18881a;
                j jVar = this.f997j;
                if ((jVar != j.f18829a && jVar != j.f18830b) || (dVar = this.f988a.f18314a) == null || (map = dVar.f18877i) == null) {
                    i5 = 0;
                } else {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry entry2 : map.entrySet()) {
                        if (((P3.k) entry2.getValue()).f18895k == null) {
                            linkedHashMap.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                    i5 = 0;
                    for (Map.Entry value : linkedHashMap.entrySet()) {
                        Set<Number> set4 = ((P3.k) value.getValue()).f18889e;
                        if (!w.a(set4) || !set4.isEmpty()) {
                            i7 = 0;
                            for (Number intValue : set4) {
                                if (intValue.intValue() == i9 && (i7 = i7 + 1) < 0) {
                                    C2250q.n();
                                }
                            }
                        } else {
                            i7 = 0;
                        }
                        i5 += i7;
                    }
                }
                j jVar2 = this.f997j;
                if (jVar2 == j.f18829a || jVar2 == j.f18831c) {
                    for (g gVar : this.f989b.f19282c.f19277a) {
                        List<Number> list = gVar.f19276g;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            i6 = 0;
                            for (Number intValue2 : list) {
                                if (intValue2.intValue() == i9 && (i6 = i6 + 1) < 0) {
                                    C2250q.n();
                                }
                            }
                        } else {
                            i6 = 0;
                        }
                        i5 += i6;
                    }
                }
                if (this.f997j == j.f18829a && (kVar = this.f992e) != null && (set = kVar.f18889e) != null && set.contains(Integer.valueOf(i9))) {
                    i5++;
                }
                if (i5 > 0) {
                    arrayList2.add(new c.i((e) entry.getValue(), this.f988a.f18332s.get(((P3.h) entry.getValue()).f18881a), (l) null, c.k.PURPOSE, this.f991d.f().f25469d, Integer.valueOf(i5), 4));
                }
            }
        }
        arrayList.addAll(0, arrayList2);
        if (str2.length() <= 0) {
            return arrayList;
        }
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            c.i iVar2 = (c.i) obj;
            if (iVar2.f897d != c.k.PURPOSE && s.T(iVar2.f894a.f18882b, str2, true)) {
                arrayList3.add(obj);
            }
        }
        return C2250q.p0(arrayList3);
    }

    public final ArrayList d() {
        Map map;
        ArrayList arrayList = new ArrayList();
        d dVar = this.f988a.f18314a;
        if (!(dVar == null || (map = dVar.f18877i) == null)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (((P3.k) entry.getValue()).f18895k == null) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                if (!((P3.k) entry2.getValue()).f18889e.isEmpty()) {
                    arrayList.add(new c.i((e) entry2.getValue(), this.f988a.f18309C.get(((P3.k) entry2.getValue()).f18881a), (l) null, (c.k) null, (String) null, (Integer) null, (int) R.styleable.AppCompatTheme_windowMinWidthMajor));
                }
            }
        }
        return arrayList;
    }

    public final m4.j e() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        o4.k kVar = this.f991d;
        kVar.i();
        m4.t tVar = null;
        if (kVar.f25596g.f25381r.length() == 0) {
            m4.t tVar2 = kVar.f25595f;
            if (tVar2 == null) {
                t.w("translationsText");
                tVar2 = null;
            }
            str = tVar2.f25496a.f25381r;
        } else {
            str = kVar.f25596g.f25381r;
        }
        if (kVar.f25596g.f25345G.length() == 0) {
            m4.t tVar3 = kVar.f25595f;
            if (tVar3 == null) {
                t.w("translationsText");
                tVar3 = null;
            }
            str2 = tVar3.f25496a.f25345G;
        } else {
            str2 = kVar.f25596g.f25345G;
        }
        if (kVar.f25596g.f25349K.length() == 0) {
            m4.t tVar4 = kVar.f25595f;
            if (tVar4 == null) {
                t.w("translationsText");
                tVar4 = null;
            }
            str3 = tVar4.f25496a.f25349K;
        } else {
            str3 = kVar.f25596g.f25349K;
        }
        if (kVar.f25596g.f25350L.length() == 0) {
            m4.t tVar5 = kVar.f25595f;
            if (tVar5 == null) {
                t.w("translationsText");
                tVar5 = null;
            }
            str4 = tVar5.f25496a.f25350L;
        } else {
            str4 = kVar.f25596g.f25350L;
        }
        if (kVar.f25596g.f25351M.length() == 0) {
            m4.t tVar6 = kVar.f25595f;
            if (tVar6 == null) {
                t.w("translationsText");
                tVar6 = null;
            }
            str5 = tVar6.f25496a.f25351M;
        } else {
            str5 = kVar.f25596g.f25351M;
        }
        if (kVar.f25597h.f25417b.length() == 0) {
            m4.t tVar7 = kVar.f25595f;
            if (tVar7 == null) {
                t.w("translationsText");
                tVar7 = null;
            }
            str6 = tVar7.f25498c.f25417b;
        } else {
            str6 = kVar.f25597h.f25417b;
        }
        if (kVar.f25596g.f25355Q.length() == 0) {
            m4.t tVar8 = kVar.f25595f;
            if (tVar8 == null) {
                t.w("translationsText");
                tVar8 = null;
            }
            str7 = tVar8.f25496a.f25355Q;
        } else {
            str7 = kVar.f25596g.f25355Q;
        }
        if (kVar.f25596g.f25380q.length() == 0) {
            m4.t tVar9 = kVar.f25595f;
            if (tVar9 == null) {
                t.w("translationsText");
                tVar9 = null;
            }
            str8 = tVar9.f25496a.f25380q;
        } else {
            str8 = kVar.f25596g.f25380q;
        }
        if (kVar.f25597h.f25419d.length() == 0) {
            m4.t tVar10 = kVar.f25595f;
            if (tVar10 == null) {
                t.w("translationsText");
                tVar10 = null;
            }
            str9 = tVar10.f25498c.f25419d;
        } else {
            str9 = kVar.f25597h.f25419d;
        }
        if (kVar.f25597h.f25420e.length() == 0) {
            m4.t tVar11 = kVar.f25595f;
            if (tVar11 == null) {
                t.w("translationsText");
            } else {
                tVar = tVar11;
            }
            str10 = tVar.f25498c.f25420e;
        } else {
            str10 = kVar.f25597h.f25420e;
        }
        return new m4.j(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, kVar.b());
    }

    public final ArrayList f() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.f990c.f19277a) {
            if (!gVar.f19276g.isEmpty()) {
                arrayList.add(new c.i((e) gVar.a(), this.f988a.f18310D.get(gVar.f19270a), (l) null, c.k.NON_IAB_VENDOR, (String) null, (Integer) null, 116));
            }
        }
        return arrayList;
    }

    public final LinkedHashMap g() {
        Map map;
        d dVar = this.f988a.f18314a;
        if (dVar == null || (map = dVar.f18872d) == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (this.f988a.f18332s.contains(((P3.h) entry.getValue()).f18881a)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (t.a(this.f988a.f18321h, "DE")) {
            return linkedHashMap;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (((P3.h) entry2.getValue()).f18881a != 1) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        return linkedHashMap2;
    }
}
