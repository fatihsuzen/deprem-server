package r0;

import O0.c;
import O0.d;
import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public class o implements C1788e, J0.a {

    /* renamed from: i  reason: collision with root package name */
    private static final R0.b f16354i = new k();

    /* renamed from: a  reason: collision with root package name */
    private final Map f16355a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f16356b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f16357c;

    /* renamed from: d  reason: collision with root package name */
    private final List f16358d;

    /* renamed from: e  reason: collision with root package name */
    private Set f16359e;

    /* renamed from: f  reason: collision with root package name */
    private final v f16360f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference f16361g;

    /* renamed from: h  reason: collision with root package name */
    private final j f16362h;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Executor f16363a;

        /* renamed from: b  reason: collision with root package name */
        private final List f16364b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final List f16365c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private j f16366d = j.f16347a;

        b(Executor executor) {
            this.f16363a = executor;
        }

        public static /* synthetic */ ComponentRegistrar a(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }

        public b b(C1786c cVar) {
            this.f16365c.add(cVar);
            return this;
        }

        public b c(ComponentRegistrar componentRegistrar) {
            this.f16364b.add(new p(componentRegistrar));
            return this;
        }

        public b d(Collection collection) {
            this.f16364b.addAll(collection);
            return this;
        }

        public o e() {
            return new o(this.f16363a, this.f16364b, this.f16365c, this.f16366d);
        }

        public b f(j jVar) {
            this.f16366d = jVar;
            return this;
        }
    }

    public static b m(Executor executor) {
        return new b(executor);
    }

    private void n(List list) {
        int i5;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.f16358d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((R0.b) it.next()).get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f16362h.a(componentRegistrar));
                        it.remove();
                    }
                } catch (w e5) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e5);
                }
            }
            Iterator it2 = list.iterator();
            while (true) {
                i5 = 0;
                if (!it2.hasNext()) {
                    break;
                }
                Object[] array = ((C1786c) it2.next()).j().toArray();
                int length = array.length;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    Object obj = array[i5];
                    if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                        if (this.f16359e.contains(obj.toString())) {
                            it2.remove();
                            break;
                        }
                        this.f16359e.add(obj.toString());
                    }
                    i5++;
                }
            }
            if (this.f16355a.isEmpty()) {
                q.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f16355a.keySet());
                arrayList2.addAll(list);
                q.a(arrayList2);
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                C1786c cVar = (C1786c) it3.next();
                this.f16355a.put(cVar, new x(new l(this, cVar)));
            }
            arrayList.addAll(t(list));
            arrayList.addAll(u());
            s();
        }
        int size = arrayList.size();
        while (i5 < size) {
            Object obj2 = arrayList.get(i5);
            i5++;
            ((Runnable) obj2).run();
        }
        r();
    }

    private void o(Map map, boolean z4) {
        for (Map.Entry entry : map.entrySet()) {
            C1786c cVar = (C1786c) entry.getKey();
            R0.b bVar = (R0.b) entry.getValue();
            if (cVar.n() || (cVar.o() && z4)) {
                bVar.get();
            }
        }
        this.f16360f.d();
    }

    private static List q(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        for (Object add : iterable) {
            arrayList.add(add);
        }
        return arrayList;
    }

    private void r() {
        Boolean bool = (Boolean) this.f16361g.get();
        if (bool != null) {
            o(this.f16355a, bool.booleanValue());
        }
    }

    private void s() {
        for (C1786c cVar : this.f16355a.keySet()) {
            Iterator it = cVar.g().iterator();
            while (true) {
                if (it.hasNext()) {
                    r rVar = (r) it.next();
                    if (rVar.g() && !this.f16357c.containsKey(rVar.c())) {
                        this.f16357c.put(rVar.c(), y.b(Collections.EMPTY_SET));
                    } else if (this.f16356b.containsKey(rVar.c())) {
                        continue;
                    } else if (rVar.f()) {
                        throw new z(String.format("Unsatisfied dependency for component %s: %s", new Object[]{cVar, rVar.c()}));
                    } else if (!rVar.g()) {
                        this.f16356b.put(rVar.c(), D.e());
                    }
                }
            }
        }
    }

    private List t(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1786c cVar = (C1786c) it.next();
            if (cVar.p()) {
                R0.b bVar = (R0.b) this.f16355a.get(cVar);
                for (F f5 : cVar.j()) {
                    if (!this.f16356b.containsKey(f5)) {
                        this.f16356b.put(f5, bVar);
                    } else {
                        arrayList.add(new m((D) ((R0.b) this.f16356b.get(f5)), bVar));
                    }
                }
            }
        }
        return arrayList;
    }

    private List u() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.f16355a.entrySet()) {
            C1786c cVar = (C1786c) entry.getKey();
            if (!cVar.p()) {
                R0.b bVar = (R0.b) entry.getValue();
                for (F f5 : cVar.j()) {
                    if (!hashMap.containsKey(f5)) {
                        hashMap.put(f5, new HashSet());
                    }
                    ((Set) hashMap.get(f5)).add(bVar);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            if (!this.f16357c.containsKey(entry2.getKey())) {
                this.f16357c.put((F) entry2.getKey(), y.b((Collection) entry2.getValue()));
            } else {
                y yVar = (y) this.f16357c.get(entry2.getKey());
                for (R0.b nVar : (Set) entry2.getValue()) {
                    arrayList.add(new n(yVar, nVar));
                }
            }
        }
        return arrayList;
    }

    public /* synthetic */ Object a(Class cls) {
        return C1787d.a(this, cls);
    }

    public synchronized R0.b b(F f5) {
        E.c(f5, "Null interface requested.");
        return (R0.b) this.f16356b.get(f5);
    }

    public /* synthetic */ R0.b c(Class cls) {
        return C1787d.d(this, cls);
    }

    public /* synthetic */ Set d(F f5) {
        return C1787d.f(this, f5);
    }

    public /* synthetic */ Object e(F f5) {
        return C1787d.b(this, f5);
    }

    public synchronized R0.b f(F f5) {
        y yVar = (y) this.f16357c.get(f5);
        if (yVar != null) {
            return yVar;
        }
        return f16354i;
    }

    public R0.a g(F f5) {
        R0.b b5 = b(f5);
        if (b5 == null) {
            return D.e();
        }
        if (b5 instanceof D) {
            return (D) b5;
        }
        return D.f(b5);
    }

    public /* synthetic */ Set h(Class cls) {
        return C1787d.e(this, cls);
    }

    public /* synthetic */ R0.a i(Class cls) {
        return C1787d.c(this, cls);
    }

    public void p(boolean z4) {
        HashMap hashMap;
        if (androidx.lifecycle.a.a(this.f16361g, (Object) null, Boolean.valueOf(z4))) {
            synchronized (this) {
                hashMap = new HashMap(this.f16355a);
            }
            o(hashMap, z4);
        }
    }

    private o(Executor executor, Iterable iterable, Collection collection, j jVar) {
        this.f16355a = new HashMap();
        this.f16356b = new HashMap();
        this.f16357c = new HashMap();
        this.f16359e = new HashSet();
        this.f16361g = new AtomicReference();
        v vVar = new v(executor);
        this.f16360f = vVar;
        this.f16362h = jVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(C1786c.q(vVar, v.class, d.class, c.class));
        arrayList.add(C1786c.q(this, J0.a.class, new Class[0]));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            C1786c cVar = (C1786c) it.next();
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        this.f16358d = q(iterable);
        n(arrayList);
    }
}
