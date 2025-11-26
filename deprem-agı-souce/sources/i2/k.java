package I2;

import J2.f;
import J2.u;
import P3.d;
import P3.e;
import P3.h;
import R2.c;
import T3.g;
import T3.i;
import X2.C2250q;
import X2.T;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import b.w;
import c.l;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;
import m4.r;
import o4.j;
import o4.m;

public final class k extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final u f18228a;

    /* renamed from: b  reason: collision with root package name */
    public final i f18229b;

    /* renamed from: c  reason: collision with root package name */
    public final f f18230c;

    /* renamed from: d  reason: collision with root package name */
    public final P3.k f18231d;

    /* renamed from: e  reason: collision with root package name */
    public final j f18232e;

    /* renamed from: f  reason: collision with root package name */
    public final o4.k f18233f;

    /* renamed from: g  reason: collision with root package name */
    public final List f18234g;

    /* renamed from: h  reason: collision with root package name */
    public final List f18235h;

    /* renamed from: i  reason: collision with root package name */
    public final List f18236i;

    /* renamed from: j  reason: collision with root package name */
    public final List f18237j;

    /* renamed from: k  reason: collision with root package name */
    public final c f18238k;

    /* renamed from: l  reason: collision with root package name */
    public final int f18239l = 2;

    /* renamed from: m  reason: collision with root package name */
    public final LinkedHashSet f18240m = new LinkedHashSet();

    /* renamed from: n  reason: collision with root package name */
    public final LinkedHashSet f18241n = new LinkedHashSet();

    /* renamed from: o  reason: collision with root package name */
    public final MutableLiveData f18242o = new MutableLiveData();

    public k(u uVar, i iVar, f fVar, P3.k kVar, m mVar, o4.k kVar2, List list, List list2, List list3, List list4, c cVar) {
        t.e(uVar, "tcModel");
        t.e(iVar, "portalConfig");
        t.e(fVar, "googleVendorList");
        t.e(mVar, "consentRepository");
        t.e(kVar2, "translationsTextRepository");
        t.e(list, "initScreenCustomLinks");
        t.e(list2, "vendorSpecialPurposeIds");
        t.e(list3, "vendorFeaturesIds");
        t.e(list4, "publisherStacksSelectedIds");
        t.e(cVar, "gbcPurposeResponse");
        this.f18228a = uVar;
        this.f18229b = iVar;
        this.f18230c = fVar;
        this.f18231d = kVar;
        this.f18232e = mVar;
        this.f18233f = kVar2;
        this.f18234g = list;
        this.f18235h = list2;
        this.f18236i = list3;
        this.f18237j = list4;
        this.f18238k = cVar;
    }

    public final c.i a(String str, Set set, int i5) {
        if (!t.a(str, "ALL_VENDORS") || this.f18231d == null || !set.contains(Integer.valueOf(i5))) {
            return null;
        }
        P3.k kVar = this.f18231d;
        return new c.i((e) kVar, (Boolean) null, l.NON_SWITCH, c.k.PURPOSE_PARTNER, kVar.f18882b, (Integer) null, 82);
    }

    public final ArrayList b() {
        Map map;
        int i5;
        int i6;
        Map map2;
        int i7;
        Collection collection;
        Map map3;
        P3.i iVar;
        ArrayList arrayList = new ArrayList();
        d dVar = this.f18228a.f18314a;
        if (!(dVar == null || (map = dVar.f18872d) == null)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (this.f18228a.f18331r.contains(((h) entry.getValue()).f18881a)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                LinkedHashSet linkedHashSet = this.f18240m;
                if (linkedHashSet == null || linkedHashSet.isEmpty()) {
                    LinkedHashSet linkedHashSet2 = this.f18240m;
                    for (Number intValue : this.f18237j) {
                        int intValue2 = intValue.intValue();
                        d dVar2 = this.f18228a.f18314a;
                        if (dVar2 == null || (map3 = dVar2.f18878j) == null || (iVar = (P3.i) map3.get(String.valueOf(intValue2))) == null) {
                            collection = null;
                        } else {
                            collection = iVar.f18885c;
                        }
                        if (collection == null) {
                            collection = T.d();
                        }
                        linkedHashSet2.addAll(collection);
                    }
                }
                if (!this.f18240m.contains(Integer.valueOf(((h) entry2.getValue()).f18881a))) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                int i8 = ((h) entry3.getValue()).f18881a;
                d dVar3 = this.f18228a.f18314a;
                if (dVar3 == null || (map2 = dVar3.f18877i) == null) {
                    i5 = 0;
                } else {
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    for (Map.Entry entry4 : map2.entrySet()) {
                        if (((P3.k) entry4.getValue()).f18895k == null) {
                            linkedHashMap3.put(entry4.getKey(), entry4.getValue());
                        }
                    }
                    i5 = 0;
                    for (Map.Entry value : linkedHashMap3.entrySet()) {
                        Set<Number> set = ((P3.k) value.getValue()).f18888d;
                        if (!w.a(set) || !set.isEmpty()) {
                            i7 = 0;
                            for (Number intValue3 : set) {
                                if (intValue3.intValue() == i8 && (i7 = i7 + 1) < 0) {
                                    C2250q.n();
                                }
                            }
                        } else {
                            i7 = 0;
                        }
                        i5 += i7;
                    }
                }
                for (g gVar : this.f18229b.f19282c.f19277a) {
                    List<Number> list = gVar.f19275f;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        i6 = 0;
                        for (Number intValue4 : list) {
                            if (intValue4.intValue() == i8 && (i6 = i6 + 1) < 0) {
                                C2250q.n();
                            }
                        }
                    } else {
                        i6 = 0;
                    }
                    i5 += i6;
                }
                for (Number intValue5 : this.f18229b.f19281b.f19254s) {
                    if (intValue5.intValue() == i8) {
                        i5++;
                    }
                }
                if (i5 > 0) {
                    arrayList.add(new c.i((e) entry3.getValue(), this.f18228a.f18331r.get(((h) entry3.getValue()).f18881a), (l) null, c.k.PURPOSE, this.f18233f.f().f25469d, Integer.valueOf(i5), 20));
                }
            }
        }
        arrayList.addAll(c());
        return arrayList;
    }

    public final ArrayList c() {
        Map map;
        Map map2;
        int i5;
        Collection collection;
        Map map3;
        P3.i iVar;
        ArrayList arrayList = new ArrayList();
        d dVar = this.f18228a.f18314a;
        if (!(dVar == null || (map = dVar.f18875g) == null)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (this.f18228a.f18330q.contains(((P3.c) entry.getValue()).f18881a)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                LinkedHashSet linkedHashSet = this.f18241n;
                if (linkedHashSet == null || linkedHashSet.isEmpty()) {
                    LinkedHashSet linkedHashSet2 = this.f18241n;
                    for (Number intValue : this.f18237j) {
                        int intValue2 = intValue.intValue();
                        d dVar2 = this.f18228a.f18314a;
                        if (dVar2 == null || (map3 = dVar2.f18878j) == null || (iVar = (P3.i) map3.get(String.valueOf(intValue2))) == null) {
                            collection = null;
                        } else {
                            collection = iVar.f18886d;
                        }
                        if (collection == null) {
                            collection = T.d();
                        }
                        linkedHashSet2.addAll(collection);
                    }
                }
                if (!this.f18241n.contains(Integer.valueOf(((P3.c) entry2.getValue()).f18881a))) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                int i6 = ((P3.c) entry3.getValue()).f18881a;
                d dVar3 = this.f18228a.f18314a;
                int i7 = 0;
                if (!(dVar3 == null || (map2 = dVar3.f18877i) == null)) {
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    for (Map.Entry entry4 : map2.entrySet()) {
                        if (((P3.k) entry4.getValue()).f18895k == null) {
                            linkedHashMap3.put(entry4.getKey(), entry4.getValue());
                        }
                    }
                    int i8 = 0;
                    for (Map.Entry value : linkedHashMap3.entrySet()) {
                        Set<Number> set = ((P3.k) value.getValue()).f18893i;
                        if (!w.a(set) || !set.isEmpty()) {
                            i5 = 0;
                            for (Number intValue3 : set) {
                                if (intValue3.intValue() == i6 && (i5 = i5 + 1) < 0) {
                                    C2250q.n();
                                }
                            }
                        } else {
                            i5 = 0;
                        }
                        i8 += i5;
                    }
                    i7 = i8;
                }
                for (Number intValue4 : this.f18229b.f19281b.f19258w) {
                    if (intValue4.intValue() == i6) {
                        i7++;
                    }
                }
                if (i7 > 0) {
                    arrayList.add(new c.i((e) entry3.getValue(), this.f18228a.f18330q.get(((P3.c) entry3.getValue()).f18881a), (l) null, c.k.SPECIAL_FEATURE, this.f18233f.f().f25469d, Integer.valueOf(i7), 20));
                }
            }
        }
        return arrayList;
    }

    public final ArrayList d() {
        Map map;
        int i5;
        Map map2;
        int i6;
        Map map3;
        int i7;
        Map map4;
        int i8;
        ArrayList arrayList = new ArrayList();
        d dVar = this.f18228a.f18314a;
        if (!(dVar == null || (map3 = dVar.f18873e) == null)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map3.entrySet()) {
                if (this.f18235h.contains(Integer.valueOf(((h) entry.getValue()).f18881a)) || this.f18229b.f19281b.f19256u.contains(Integer.valueOf(((h) entry.getValue()).f18881a))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                int i9 = ((h) entry2.getValue()).f18881a;
                d dVar2 = this.f18228a.f18314a;
                if (dVar2 == null || (map4 = dVar2.f18877i) == null) {
                    i7 = 0;
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (Map.Entry entry3 : map4.entrySet()) {
                        if (((P3.k) entry3.getValue()).f18895k == null) {
                            linkedHashMap2.put(entry3.getKey(), entry3.getValue());
                        }
                    }
                    i7 = 0;
                    for (Map.Entry value : linkedHashMap2.entrySet()) {
                        Set<Number> set = ((P3.k) value.getValue()).f18891g;
                        if (!w.a(set) || !set.isEmpty()) {
                            i8 = 0;
                            for (Number intValue : set) {
                                if (intValue.intValue() == i9 && (i8 = i8 + 1) < 0) {
                                    C2250q.n();
                                }
                            }
                        } else {
                            i8 = 0;
                        }
                        i7 += i8;
                    }
                }
                for (Number intValue2 : this.f18229b.f19281b.f19256u) {
                    if (intValue2.intValue() == i9) {
                        i7++;
                    }
                }
                if (i7 > 0) {
                    arrayList.add(new c.i((e) entry2.getValue(), (Boolean) null, (l) null, c.k.SPECIAL_PURPOSE, this.f18233f.f().f25469d, Integer.valueOf(i7), 22));
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        d dVar3 = this.f18228a.f18314a;
        if (!(dVar3 == null || (map = dVar3.f18874f) == null)) {
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry4 : map.entrySet()) {
                if (this.f18236i.contains(Integer.valueOf(((P3.c) entry4.getValue()).f18881a)) || this.f18229b.f19281b.f19257v.contains(Integer.valueOf(((P3.c) entry4.getValue()).f18881a))) {
                    linkedHashMap3.put(entry4.getKey(), entry4.getValue());
                }
            }
            for (Map.Entry entry5 : linkedHashMap3.entrySet()) {
                int i10 = ((P3.c) entry5.getValue()).f18881a;
                d dVar4 = this.f18228a.f18314a;
                if (dVar4 == null || (map2 = dVar4.f18877i) == null) {
                    i5 = 0;
                } else {
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                    for (Map.Entry entry6 : map2.entrySet()) {
                        if (((P3.k) entry6.getValue()).f18895k == null) {
                            linkedHashMap4.put(entry6.getKey(), entry6.getValue());
                        }
                    }
                    i5 = 0;
                    for (Map.Entry value2 : linkedHashMap4.entrySet()) {
                        Set<Number> set2 = ((P3.k) value2.getValue()).f18892h;
                        if (!w.a(set2) || !set2.isEmpty()) {
                            i6 = 0;
                            for (Number intValue3 : set2) {
                                if (intValue3.intValue() == i10 && (i6 = i6 + 1) < 0) {
                                    C2250q.n();
                                }
                            }
                        } else {
                            i6 = 0;
                        }
                        i5 += i6;
                    }
                }
                for (Number intValue4 : this.f18229b.f19281b.f19257v) {
                    if (intValue4.intValue() == i10) {
                        i5++;
                    }
                }
                if (i5 > 0) {
                    arrayList2.add(new c.i((e) entry5.getValue(), (Boolean) null, (l) null, c.k.FEATURES, this.f18233f.f().f25469d, Integer.valueOf(i5), 22));
                }
            }
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    public final ArrayList e() {
        Map map;
        String str;
        Map map2;
        P3.i iVar;
        boolean z4;
        boolean z5;
        Map map3;
        ArrayList arrayList = new ArrayList();
        d dVar = this.f18228a.f18314a;
        if (!(dVar == null || (map = dVar.f18878j) == null)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (this.f18237j.contains(Integer.valueOf(((P3.i) entry.getValue()).f18881a))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                boolean z6 = false;
                for (Number intValue : ((P3.i) entry2.getValue()).f18885c) {
                    int intValue2 = intValue.intValue();
                    d dVar2 = this.f18228a.f18314a;
                    if (!(dVar2 == null || (map3 = dVar2.f18877i) == null)) {
                        for (Map.Entry entry3 : map3.entrySet()) {
                            if (((P3.k) entry3.getValue()).f18895k == null && ((P3.k) entry3.getValue()).f18888d.contains(Integer.valueOf(intValue2))) {
                                z6 = true;
                            }
                        }
                    }
                }
                if (z6) {
                    int i5 = ((P3.i) entry2.getValue()).f18881a;
                    String str2 = ((P3.i) entry2.getValue()).f18882b;
                    int i6 = ((P3.i) entry2.getValue()).f18881a;
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    d dVar3 = this.f18228a.f18314a;
                    if (!(dVar3 == null || (map2 = dVar3.f18878j) == null || (iVar = (P3.i) map2.get(String.valueOf(i6))) == null)) {
                        List list = iVar.f18885c;
                        ArrayList arrayList2 = new ArrayList();
                        for (Object next : list) {
                            if (this.f18228a.f18331r.contains(((Number) next).intValue())) {
                                arrayList2.add(next);
                            }
                        }
                        int size = arrayList2.size();
                        int i7 = 0;
                        while (i7 < size) {
                            Object obj = arrayList2.get(i7);
                            i7++;
                            Boolean bool = this.f18228a.f18331r.get(((Number) obj).intValue());
                            if (bool == null) {
                                z5 = false;
                            } else {
                                z5 = bool.booleanValue();
                            }
                            linkedHashSet.add(Boolean.valueOf(z5));
                        }
                        List list2 = iVar.f18886d;
                        ArrayList arrayList3 = new ArrayList();
                        for (Object next2 : list2) {
                            if (this.f18228a.f18330q.contains(((Number) next2).intValue())) {
                                arrayList3.add(next2);
                            }
                        }
                        int size2 = arrayList3.size();
                        int i8 = 0;
                        while (i8 < size2) {
                            Object obj2 = arrayList3.get(i8);
                            i8++;
                            Boolean bool2 = this.f18228a.f18330q.get(((Number) obj2).intValue());
                            if (bool2 == null) {
                                z4 = false;
                            } else {
                                z4 = bool2.booleanValue();
                            }
                            linkedHashSet.add(Boolean.valueOf(z4));
                        }
                    }
                    Boolean bool3 = Boolean.TRUE;
                    if (linkedHashSet.contains(bool3) && linkedHashSet.contains(Boolean.FALSE)) {
                        str = this.f18233f.e().f25443l;
                    } else if (linkedHashSet.contains(bool3)) {
                        str = this.f18233f.e().f25444m;
                    } else {
                        str = this.f18233f.e().f25442k;
                    }
                    arrayList.add(new r(str2, i5, str));
                }
            }
        }
        return arrayList;
    }

    public final void f() {
        String str = this.f18229b.f19281b.f19218I;
        PrivacyEncodingMode privacyEncodingMode = PrivacyEncodingMode.GPP;
        if (t.a(str, privacyEncodingMode.getValue())) {
            ((m) this.f18232e).b(privacyEncodingMode, true, true);
            return;
        }
        PrivacyEncodingMode privacyEncodingMode2 = PrivacyEncodingMode.TCF;
        if (t.a(str, privacyEncodingMode2.getValue())) {
            ((m) this.f18232e).b(privacyEncodingMode2, true, true);
        } else {
            ((m) this.f18232e).b(PrivacyEncodingMode.TCF_AND_GPP, true, true);
        }
    }
}
