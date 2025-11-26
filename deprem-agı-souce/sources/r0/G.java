package r0;

import O0.c;
import R0.b;
import j$.util.DesugarCollections;
import java.util.HashSet;
import java.util.Set;

final class G implements C1788e {

    /* renamed from: a  reason: collision with root package name */
    private final Set f16318a;

    /* renamed from: b  reason: collision with root package name */
    private final Set f16319b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f16320c;

    /* renamed from: d  reason: collision with root package name */
    private final Set f16321d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f16322e;

    /* renamed from: f  reason: collision with root package name */
    private final Set f16323f;

    /* renamed from: g  reason: collision with root package name */
    private final C1788e f16324g;

    private static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final Set f16325a;

        /* renamed from: b  reason: collision with root package name */
        private final c f16326b;

        public a(Set set, c cVar) {
            this.f16325a = set;
            this.f16326b = cVar;
        }
    }

    G(C1786c cVar, C1788e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (r rVar : cVar.g()) {
            if (rVar.e()) {
                if (rVar.g()) {
                    hashSet4.add(rVar.c());
                } else {
                    hashSet.add(rVar.c());
                }
            } else if (rVar.d()) {
                hashSet3.add(rVar.c());
            } else if (rVar.g()) {
                hashSet5.add(rVar.c());
            } else {
                hashSet2.add(rVar.c());
            }
        }
        if (!cVar.k().isEmpty()) {
            hashSet.add(F.b(c.class));
        }
        this.f16318a = DesugarCollections.unmodifiableSet(hashSet);
        this.f16319b = DesugarCollections.unmodifiableSet(hashSet2);
        this.f16320c = DesugarCollections.unmodifiableSet(hashSet3);
        this.f16321d = DesugarCollections.unmodifiableSet(hashSet4);
        this.f16322e = DesugarCollections.unmodifiableSet(hashSet5);
        this.f16323f = cVar.k();
        this.f16324g = eVar;
    }

    public Object a(Class cls) {
        if (this.f16318a.contains(F.b(cls))) {
            Object a5 = this.f16324g.a(cls);
            if (!cls.equals(c.class)) {
                return a5;
            }
            return new a(this.f16323f, (c) a5);
        }
        throw new t(String.format("Attempting to request an undeclared dependency %s.", new Object[]{cls}));
    }

    public b b(F f5) {
        if (this.f16319b.contains(f5)) {
            return this.f16324g.b(f5);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[]{f5}));
    }

    public b c(Class cls) {
        return b(F.b(cls));
    }

    public Set d(F f5) {
        if (this.f16321d.contains(f5)) {
            return this.f16324g.d(f5);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[]{f5}));
    }

    public Object e(F f5) {
        if (this.f16318a.contains(f5)) {
            return this.f16324g.e(f5);
        }
        throw new t(String.format("Attempting to request an undeclared dependency %s.", new Object[]{f5}));
    }

    public b f(F f5) {
        if (this.f16322e.contains(f5)) {
            return this.f16324g.f(f5);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[]{f5}));
    }

    public R0.a g(F f5) {
        if (this.f16320c.contains(f5)) {
            return this.f16324g.g(f5);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Deferred<%s>.", new Object[]{f5}));
    }

    public /* synthetic */ Set h(Class cls) {
        return C1787d.e(this, cls);
    }

    public R0.a i(Class cls) {
        return g(F.b(cls));
    }
}
