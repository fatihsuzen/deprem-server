package S2;

import J2.u;
import P3.c;
import P3.d;
import P3.h;
import T3.g;
import T3.i;
import X2.C2250q;
import androidx.lifecycle.ViewModel;
import b.w;
import c.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;
import m4.s;
import o4.k;

public final class e extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final u f19034a;

    /* renamed from: b  reason: collision with root package name */
    public final i f19035b;

    /* renamed from: c  reason: collision with root package name */
    public final k f19036c;

    public e(u uVar, i iVar, k kVar) {
        t.e(uVar, "tcModel");
        t.e(iVar, "portalConfig");
        t.e(kVar, "translationsTextRepository");
        this.f19034a = uVar;
        this.f19035b = iVar;
        this.f19036c = kVar;
    }

    public final LinkedHashSet a(int i5) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList c5 = c(i5);
        c5.addAll(d(i5));
        int size = c5.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = c5.get(i6);
            i6++;
            Boolean bool = ((c.i) obj).f895b;
            if (bool != null) {
                linkedHashSet.add(bool);
            }
        }
        return linkedHashSet;
    }

    public final s b() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        k kVar = this.f19036c;
        kVar.i();
        m4.t tVar = null;
        if (kVar.f25596g.f25355Q.length() == 0) {
            m4.t tVar2 = kVar.f25595f;
            if (tVar2 == null) {
                t.w("translationsText");
                tVar2 = null;
            }
            str = tVar2.f25496a.f25355Q;
        } else {
            str = kVar.f25596g.f25355Q;
        }
        if (kVar.f25596g.f25339A.length() == 0) {
            m4.t tVar3 = kVar.f25595f;
            if (tVar3 == null) {
                t.w("translationsText");
                tVar3 = null;
            }
            str2 = tVar3.f25496a.f25339A;
        } else {
            str2 = kVar.f25596g.f25339A;
        }
        if (kVar.f25596g.f25366c.length() == 0) {
            m4.t tVar4 = kVar.f25595f;
            if (tVar4 == null) {
                t.w("translationsText");
                tVar4 = null;
            }
            str3 = tVar4.f25496a.f25366c;
        } else {
            str3 = kVar.f25596g.f25366c;
        }
        if (kVar.f25597h.f25417b.length() == 0) {
            m4.t tVar5 = kVar.f25595f;
            if (tVar5 == null) {
                t.w("translationsText");
                tVar5 = null;
            }
            str4 = tVar5.f25498c.f25417b;
        } else {
            str4 = kVar.f25597h.f25417b;
        }
        if (kVar.f25597h.f25427l.length() == 0) {
            m4.t tVar6 = kVar.f25595f;
            if (tVar6 == null) {
                t.w("translationsText");
            } else {
                tVar = tVar6;
            }
            str5 = tVar.f25498c.f25427l;
        } else {
            str5 = kVar.f25597h.f25427l;
        }
        return new s(str, str2, str3, str4, str5, kVar.b());
    }

    public final ArrayList c(int i5) {
        Map map;
        int i6;
        int i7;
        Map map2;
        int i8;
        Map map3;
        P3.i iVar;
        List list;
        ArrayList arrayList = new ArrayList();
        d dVar = this.f19034a.f18314a;
        if (!(dVar == null || (map = dVar.f18872d) == null)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (this.f19034a.f18331r.contains(((h) entry.getValue()).f18881a)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                d dVar2 = this.f19034a.f18314a;
                if (!(dVar2 == null || (map3 = dVar2.f18878j) == null || (iVar = (P3.i) map3.get(String.valueOf(i5))) == null || (list = iVar.f18885c) == null || !list.contains(Integer.valueOf(((h) entry2.getValue()).f18881a)))) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                int i9 = ((h) entry3.getValue()).f18881a;
                d dVar3 = this.f19034a.f18314a;
                if (dVar3 == null || (map2 = dVar3.f18877i) == null) {
                    i6 = 0;
                } else {
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    for (Map.Entry entry4 : map2.entrySet()) {
                        if (((P3.k) entry4.getValue()).f18895k == null) {
                            linkedHashMap3.put(entry4.getKey(), entry4.getValue());
                        }
                    }
                    i6 = 0;
                    for (Map.Entry value : linkedHashMap3.entrySet()) {
                        Set<Number> set = ((P3.k) value.getValue()).f18888d;
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
                        i6 += i8;
                    }
                }
                for (g gVar : this.f19035b.f19282c.f19277a) {
                    List<Number> list2 = gVar.f19275f;
                    if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                        i7 = 0;
                        for (Number intValue2 : list2) {
                            if (intValue2.intValue() == i9 && (i7 = i7 + 1) < 0) {
                                C2250q.n();
                            }
                        }
                    } else {
                        i7 = 0;
                    }
                    i6 += i7;
                }
                if (i6 > 0) {
                    arrayList.add(new c.i((P3.e) entry3.getValue(), this.f19034a.f18331r.get(((h) entry3.getValue()).f18881a), (l) null, c.k.PURPOSE, this.f19036c.f().f25469d, Integer.valueOf(i6), 20));
                }
            }
        }
        return arrayList;
    }

    public final ArrayList d(int i5) {
        Map map;
        Map map2;
        int i6;
        Map map3;
        P3.i iVar;
        List list;
        ArrayList arrayList = new ArrayList();
        d dVar = this.f19034a.f18314a;
        if (!(dVar == null || (map = dVar.f18875g) == null)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (this.f19034a.f18330q.contains(((c) entry.getValue()).f18881a)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                d dVar2 = this.f19034a.f18314a;
                if (!(dVar2 == null || (map3 = dVar2.f18878j) == null || (iVar = (P3.i) map3.get(String.valueOf(i5))) == null || (list = iVar.f18886d) == null || !list.contains(Integer.valueOf(((c) entry2.getValue()).f18881a)))) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                int i7 = ((c) entry3.getValue()).f18881a;
                d dVar3 = this.f19034a.f18314a;
                int i8 = 0;
                if (!(dVar3 == null || (map2 = dVar3.f18877i) == null)) {
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    for (Map.Entry entry4 : map2.entrySet()) {
                        if (((P3.k) entry4.getValue()).f18895k == null) {
                            linkedHashMap3.put(entry4.getKey(), entry4.getValue());
                        }
                    }
                    int i9 = 0;
                    for (Map.Entry value : linkedHashMap3.entrySet()) {
                        Set<Number> set = ((P3.k) value.getValue()).f18893i;
                        if (!w.a(set) || !set.isEmpty()) {
                            i6 = 0;
                            for (Number intValue : set) {
                                if (intValue.intValue() == i7 && (i6 = i6 + 1) < 0) {
                                    C2250q.n();
                                }
                            }
                        } else {
                            i6 = 0;
                        }
                        i9 += i6;
                    }
                    i8 = i9;
                }
                if (i8 > 0) {
                    arrayList.add(new c.i((P3.e) entry3.getValue(), this.f19034a.f18330q.get(((c) entry3.getValue()).f18881a), (l) null, c.k.SPECIAL_FEATURE, this.f19036c.f().f25469d, Integer.valueOf(i8), 20));
                }
            }
        }
        return arrayList;
    }
}
