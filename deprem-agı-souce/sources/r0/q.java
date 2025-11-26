package r0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

abstract class q {

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final C1786c f16368a;

        /* renamed from: b  reason: collision with root package name */
        private final Set f16369b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Set f16370c = new HashSet();

        b(C1786c cVar) {
            this.f16368a = cVar;
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            this.f16369b.add(bVar);
        }

        /* access modifiers changed from: package-private */
        public void b(b bVar) {
            this.f16370c.add(bVar);
        }

        /* access modifiers changed from: package-private */
        public C1786c c() {
            return this.f16368a;
        }

        /* access modifiers changed from: package-private */
        public Set d() {
            return this.f16369b;
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            return this.f16369b.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public boolean f() {
            return this.f16370c.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public void g(b bVar) {
            this.f16370c.remove(bVar);
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private final F f16371a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean f16372b;

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (!cVar.f16371a.equals(this.f16371a) || cVar.f16372b != this.f16372b) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((this.f16371a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f16372b).hashCode();
        }

        private c(F f5, boolean z4) {
            this.f16371a = f5;
            this.f16372b = z4;
        }
    }

    static void a(List list) {
        Set<b> c5 = c(list);
        Set b5 = b(c5);
        int i5 = 0;
        while (!b5.isEmpty()) {
            b bVar = (b) b5.iterator().next();
            b5.remove(bVar);
            i5++;
            for (b bVar2 : bVar.d()) {
                bVar2.g(bVar);
                if (bVar2.f()) {
                    b5.add(bVar2);
                }
            }
        }
        if (i5 != list.size()) {
            ArrayList arrayList = new ArrayList();
            for (b bVar3 : c5) {
                if (!bVar3.f() && !bVar3.e()) {
                    arrayList.add(bVar3.c());
                }
            }
            throw new s(arrayList);
        }
    }

    private static Set b(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    private static Set c(List list) {
        Set<b> set;
        HashMap hashMap = new HashMap(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1786c cVar = (C1786c) it.next();
            b bVar = new b(cVar);
            Iterator it2 = cVar.j().iterator();
            while (true) {
                if (it2.hasNext()) {
                    F f5 = (F) it2.next();
                    c cVar2 = new c(f5, !cVar.p());
                    if (!hashMap.containsKey(cVar2)) {
                        hashMap.put(cVar2, new HashSet());
                    }
                    Set set2 = (Set) hashMap.get(cVar2);
                    if (set2.isEmpty() || cVar2.f16372b) {
                        set2.add(bVar);
                    } else {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{f5}));
                    }
                }
            }
        }
        for (Set<b> it3 : hashMap.values()) {
            for (b bVar2 : it3) {
                for (r rVar : bVar2.c().g()) {
                    if (rVar.e() && (set = (Set) hashMap.get(new c(rVar.c(), rVar.g()))) != null) {
                        for (b bVar3 : set) {
                            bVar2.a(bVar3);
                            bVar3.b(bVar2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set addAll : hashMap.values()) {
            hashSet.addAll(addAll);
        }
        return hashSet;
    }
}
