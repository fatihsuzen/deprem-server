package J2;

import P3.d;
import P3.k;
import X2.C2250q;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public List f18285a;

    /* renamed from: b  reason: collision with root package name */
    public List f18286b;

    /* renamed from: c  reason: collision with root package name */
    public final Map f18287c;

    /* renamed from: d  reason: collision with root package name */
    public d f18288d;

    public l(d dVar, List list, List list2, Map map) {
        t.e(list, "consentRestrictionIds");
        t.e(list2, "liRestrictionIds");
        t.e(map, "map");
        this.f18285a = list;
        this.f18286b = list2;
        this.f18287c = map;
        this.f18288d = dVar;
    }

    public final void a(int i5, k kVar) {
        t.e(kVar, "purposeRestriction");
        m mVar = kVar.f18284b;
        int i6 = kVar.f18283a;
        d dVar = this.f18288d;
        if (dVar != null) {
            k kVar2 = (k) dVar.f18877i.get(String.valueOf(i5));
            if (kVar2 != null) {
                if (mVar == m.NOT_ALLOWED) {
                    if (!kVar2.f18889e.contains(Integer.valueOf(i6)) && !kVar2.f18888d.contains(Integer.valueOf(i6))) {
                        return;
                    }
                } else if (!kVar2.f18890f.isEmpty()) {
                    int ordinal = mVar.ordinal();
                    if (ordinal != 1) {
                        if (ordinal != 2 || !kVar2.f18890f.contains(Integer.valueOf(i6)) || !kVar2.f18888d.contains(Integer.valueOf(i6))) {
                            return;
                        }
                    } else if (!kVar2.f18890f.contains(Integer.valueOf(i6)) || !kVar2.f18889e.contains(Integer.valueOf(i6))) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        String a5 = kVar.a();
        t.e(a5, "hash");
        if (!this.f18287c.containsKey(a5)) {
            this.f18287c.put(a5, new LinkedHashSet());
        }
        Integer valueOf = Integer.valueOf(i5);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.f18287c.entrySet()) {
            if (((Set) entry.getValue()).contains(valueOf)) {
                arrayList.add(j.a((String) entry.getKey()));
            }
        }
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj = arrayList.get(i7);
            i7++;
            k kVar3 = (k) obj;
            if (kVar3.f18283a == kVar.f18283a) {
                String a6 = kVar3.a();
                Set set = (Set) this.f18287c.get(a6);
                if (set != null) {
                    set.remove(Integer.valueOf(i5));
                    if (set.isEmpty()) {
                        this.f18287c.remove(a6);
                    }
                }
            }
        }
        Set set2 = (Set) this.f18287c.get(a5);
        if (set2 != null) {
            set2.add(Integer.valueOf(i5));
        }
    }

    public /* synthetic */ l(d dVar) {
        this(dVar, C2250q.g(), C2250q.g(), new LinkedHashMap());
    }
}
