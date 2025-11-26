package z0;

import D0.g;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import y0.i;

public class n {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final C1978g f17230a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final i f17231b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f17232c;

    /* renamed from: d  reason: collision with root package name */
    private final a f17233d = new a(false);

    /* renamed from: e  reason: collision with root package name */
    private final a f17234e = new a(true);

    /* renamed from: f  reason: collision with root package name */
    private final k f17235f = new k(128);

    /* renamed from: g  reason: collision with root package name */
    private final AtomicMarkableReference f17236g = new AtomicMarkableReference((Object) null, false);

    private class a {

        /* renamed from: a  reason: collision with root package name */
        final AtomicMarkableReference f17237a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicReference f17238b = new AtomicReference((Object) null);

        /* renamed from: c  reason: collision with root package name */
        private final boolean f17239c;

        public a(boolean z4) {
            int i5;
            this.f17239c = z4;
            if (z4) {
                i5 = 8192;
            } else {
                i5 = 1024;
            }
            this.f17237a = new AtomicMarkableReference(new C1976e(64, i5), false);
        }

        public static /* synthetic */ void a(a aVar) {
            aVar.f17238b.set((Object) null);
            aVar.d();
        }

        private void c() {
            m mVar = new m(this);
            if (androidx.lifecycle.a.a(this.f17238b, (Object) null, mVar)) {
                n.this.f17231b.f17085b.d(mVar);
            }
        }

        private void d() {
            Map map;
            synchronized (this) {
                try {
                    if (this.f17237a.isMarked()) {
                        map = ((C1976e) this.f17237a.getReference()).a();
                        AtomicMarkableReference atomicMarkableReference = this.f17237a;
                        atomicMarkableReference.set((C1976e) atomicMarkableReference.getReference(), false);
                    } else {
                        map = null;
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (map != null) {
                n.this.f17230a.r(n.this.f17232c, map, this.f17239c);
            }
        }

        public Map b() {
            return ((C1976e) this.f17237a.getReference()).a();
        }

        public boolean e(String str, String str2) {
            synchronized (this) {
                try {
                    if (!((C1976e) this.f17237a.getReference()).d(str, str2)) {
                        return false;
                    }
                    AtomicMarkableReference atomicMarkableReference = this.f17237a;
                    atomicMarkableReference.set((C1976e) atomicMarkableReference.getReference(), true);
                    c();
                    return true;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    public n(String str, g gVar, i iVar) {
        this.f17232c = str;
        this.f17230a = new C1978g(gVar);
        this.f17231b = iVar;
    }

    public static /* synthetic */ void a(n nVar, String str, Map map, List list) {
        if (nVar.h() != null) {
            nVar.f17230a.t(str, nVar.h());
        }
        if (!map.isEmpty()) {
            nVar.f17230a.q(str, map);
        }
        if (!list.isEmpty()) {
            nVar.f17230a.s(str, list);
        }
    }

    public static n i(String str, g gVar, i iVar) {
        C1978g gVar2 = new C1978g(gVar);
        n nVar = new n(str, gVar, iVar);
        ((C1976e) nVar.f17233d.f17237a.getReference()).e(gVar2.i(str, false));
        ((C1976e) nVar.f17234e.f17237a.getReference()).e(gVar2.i(str, true));
        nVar.f17236g.set(gVar2.k(str), false);
        nVar.f17235f.c(gVar2.j(str));
        return nVar;
    }

    public static String j(String str, g gVar) {
        return new C1978g(gVar).k(str);
    }

    public Map e(Map map) {
        if (map.isEmpty()) {
            return this.f17233d.b();
        }
        HashMap hashMap = new HashMap(this.f17233d.b());
        int i5 = 0;
        for (Map.Entry entry : map.entrySet()) {
            String c5 = C1976e.c((String) entry.getKey(), 1024);
            if (hashMap.size() < 64 || hashMap.containsKey(c5)) {
                hashMap.put(c5, C1976e.c((String) entry.getValue(), 1024));
            } else {
                i5++;
            }
        }
        if (i5 > 0) {
            u0.g f5 = u0.g.f();
            f5.k("Ignored " + i5 + " keys when adding event specific keys. Maximum allowable: " + 1024);
        }
        return DesugarCollections.unmodifiableMap(hashMap);
    }

    public Map f() {
        return this.f17234e.b();
    }

    public List g() {
        return this.f17235f.a();
    }

    public String h() {
        return (String) this.f17236g.getReference();
    }

    public boolean k(String str, String str2) {
        return this.f17234e.e(str, str2);
    }

    public void l(String str) {
        synchronized (this.f17232c) {
            this.f17232c = str;
            this.f17231b.f17085b.d(new l(this, str, this.f17233d.b(), this.f17235f.b()));
        }
    }
}
