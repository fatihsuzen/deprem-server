package O2;

import J2.f;
import J2.g;
import J2.u;
import P3.b;
import P3.d;
import P3.e;
import T3.i;
import W2.q;
import X2.C2250q;
import androidx.appcompat.R;
import androidx.lifecycle.ViewModel;
import b.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;
import o4.k;
import t3.s;

public final class l extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final k f18836a;

    /* renamed from: b  reason: collision with root package name */
    public final u f18837b;

    /* renamed from: c  reason: collision with root package name */
    public final i f18838c;

    /* renamed from: d  reason: collision with root package name */
    public final f f18839d;

    /* renamed from: e  reason: collision with root package name */
    public final P3.k f18840e;

    /* renamed from: f  reason: collision with root package name */
    public final List f18841f;

    /* renamed from: g  reason: collision with root package name */
    public final List f18842g;

    /* renamed from: h  reason: collision with root package name */
    public final List f18843h;

    /* renamed from: i  reason: collision with root package name */
    public final List f18844i;

    /* renamed from: j  reason: collision with root package name */
    public j f18845j = j.f18829a;

    /* renamed from: k  reason: collision with root package name */
    public boolean f18846k;

    /* renamed from: l  reason: collision with root package name */
    public final int f18847l = 3;

    public l(k kVar, u uVar, i iVar, f fVar, P3.k kVar2, List list, List list2, List list3, List list4) {
        t.e(kVar, "translationsTextRepository");
        t.e(uVar, "tcModel");
        t.e(iVar, "portalConfig");
        t.e(fVar, "googleVendorList");
        t.e(list, "vendorPurposeIds");
        t.e(list2, "vendorSpecialPurposeIds");
        t.e(list3, "vendorFeaturesIds");
        t.e(list4, "vendorSpecialFeaturesIds");
        this.f18836a = kVar;
        this.f18837b = uVar;
        this.f18838c = iVar;
        this.f18839d = fVar;
        this.f18840e = kVar2;
        this.f18841f = list;
        this.f18842g = list2;
        this.f18843h = list3;
        this.f18844i = list4;
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
            J2.u r1 = r7.f18837b
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
            java.util.List r9 = r7.f18844i
            java.util.Set r9 = X2.C2250q.r0(r9)
            J2.u r1 = r7.f18837b
            P3.d r1 = r1.f18314a
            if (r1 != 0) goto L_0x0040
            goto L_0x006f
        L_0x0040:
            java.util.Map r1 = r1.f18875g
            goto L_0x0073
        L_0x0043:
            java.util.List r9 = r7.f18843h
            java.util.Set r9 = X2.C2250q.r0(r9)
            J2.u r1 = r7.f18837b
            P3.d r1 = r1.f18314a
            if (r1 != 0) goto L_0x0050
            goto L_0x006f
        L_0x0050:
            java.util.Map r1 = r1.f18874f
            goto L_0x0073
        L_0x0053:
            java.util.List r9 = r7.f18842g
            java.util.Set r9 = X2.C2250q.r0(r9)
            J2.u r1 = r7.f18837b
            P3.d r1 = r1.f18314a
            if (r1 != 0) goto L_0x0060
            goto L_0x006f
        L_0x0060:
            java.util.Map r1 = r1.f18873e
            goto L_0x0073
        L_0x0063:
            java.util.List r9 = r7.f18841f
            java.util.Set r9 = X2.C2250q.r0(r9)
            J2.u r1 = r7.f18837b
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
        throw new UnsupportedOperationException("Method not decompiled: O2.l.a(java.util.Set, O2.a):java.lang.String");
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.f18839d.f18273a.entrySet()) {
            if (this.f18837b.f18308B.get(((g) entry.getValue()).f18274a) != null) {
                g gVar = (g) entry.getValue();
                arrayList.add(new c.i((e) new P3.k(gVar.f18274a, gVar.f18275b, (String) null, (Set) null, (Set) null, (Set) null, (Set) null, (Set) null, (Set) null, gVar.f18276c, (String) null, (P3.g) null, 0, false, false, (Boolean) null, (Set) null, (b) null, (LinkedHashSet) null, (String) null, 914940), this.f18837b.f18308B.get(((g) entry.getValue()).f18274a), (c.l) null, c.k.GOOGLE_VENDOR, (String) null, (Integer) null, 116));
            }
        }
        return arrayList;
    }

    public final List c(String str) {
        ArrayList arrayList;
        c.i iVar;
        boolean z4;
        Set r02;
        t.e(str, "search");
        int ordinal = this.f18845j.ordinal();
        int i5 = 0;
        if (ordinal == 0) {
            arrayList = e();
            arrayList.addAll(d());
            arrayList.addAll(b());
            P3.k kVar = this.f18840e;
            if (kVar == null) {
                iVar = null;
            } else {
                Set set = kVar.f18888d;
                if (set != null && (r02 = C2250q.r0(set)) != null) {
                    Iterator it = r02.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (!t.a(this.f18837b.f18335v.get(((Number) it.next()).intValue()), Boolean.TRUE)) {
                            z4 = false;
                            break;
                        }
                    }
                }
                z4 = true;
                iVar = new c.i((e) kVar, Boolean.valueOf(z4), (c.l) null, c.k.PUBLISHER_VENDOR, (String) null, (Integer) null, 116);
            }
            if (iVar != null) {
                arrayList.add(0, iVar);
            }
        } else if (ordinal == 1) {
            arrayList = d();
        } else if (ordinal == 2) {
            arrayList = e();
        } else if (ordinal == 3) {
            arrayList = b();
        } else {
            throw new q();
        }
        arrayList.add(0, new c.i((e) null, (Boolean) null, c.l.LABEL, (c.k) null, this.f18836a.f().f25469d, (Integer) null, 91));
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            if (s.T(((c.i) obj).f894a.f18882b, str, true)) {
                arrayList2.add(obj);
            }
        }
        return C2250q.p0(arrayList2);
    }

    public final ArrayList d() {
        Map map;
        ArrayList arrayList = new ArrayList();
        d dVar = this.f18837b.f18314a;
        if (!(dVar == null || (map = dVar.f18877i) == null)) {
            for (Map.Entry entry : map.entrySet()) {
                if (this.f18837b.f18339z.get(((P3.k) entry.getValue()).f18881a) != null) {
                    Set set = ((P3.k) entry.getValue()).f18888d;
                    List list = this.f18838c.f19281b.f19243h;
                    if (!w.a(set) || !set.isEmpty()) {
                        Iterator it = set.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (list.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                                    arrayList.add(new c.i((e) entry.getValue(), this.f18837b.f18339z.get(((P3.k) entry.getValue()).f18881a), (c.l) null, (c.k) null, (String) null, (Integer) null, (int) R.styleable.AppCompatTheme_windowMinWidthMajor));
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    arrayList.add(new c.i((e) entry.getValue(), (Boolean) null, (c.l) null, (c.k) null, (String) null, (Integer) null, (int) R.styleable.AppCompatTheme_windowMinWidthMajor));
                }
            }
        }
        return arrayList;
    }

    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (T3.g gVar : this.f18838c.f19282c.f19277a) {
            if (this.f18837b.f18307A.get(gVar.f19270a) != null) {
                arrayList.add(new c.i((e) gVar.a(), this.f18837b.f18307A.get(gVar.f19270a), (c.l) null, c.k.NON_IAB_VENDOR, (String) null, (Integer) null, 116));
            }
        }
        return arrayList;
    }
}
