package r0;

import j$.util.DesugarCollections;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: r0.c  reason: case insensitive filesystem */
public final class C1786c {

    /* renamed from: a  reason: collision with root package name */
    private final String f16329a;

    /* renamed from: b  reason: collision with root package name */
    private final Set f16330b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f16331c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16332d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16333e;

    /* renamed from: f  reason: collision with root package name */
    private final h f16334f;

    /* renamed from: g  reason: collision with root package name */
    private final Set f16335g;

    public static /* synthetic */ Object a(Object obj, C1788e eVar) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, C1788e eVar) {
        return obj;
    }

    public static b c(Class cls) {
        return new b(cls, new Class[0]);
    }

    public static b d(Class cls, Class... clsArr) {
        return new b(cls, clsArr);
    }

    public static b e(F f5) {
        return new b(f5, new F[0]);
    }

    public static b f(F f5, F... fArr) {
        return new b(f5, fArr);
    }

    public static C1786c l(Object obj, Class cls) {
        return m(cls).f(new C1784a(obj)).d();
    }

    public static b m(Class cls) {
        return c(cls).g();
    }

    public static C1786c q(Object obj, Class cls, Class... clsArr) {
        return d(cls, clsArr).f(new C1785b(obj)).d();
    }

    public Set g() {
        return this.f16331c;
    }

    public h h() {
        return this.f16334f;
    }

    public String i() {
        return this.f16329a;
    }

    public Set j() {
        return this.f16330b;
    }

    public Set k() {
        return this.f16335g;
    }

    public boolean n() {
        if (this.f16332d == 1) {
            return true;
        }
        return false;
    }

    public boolean o() {
        if (this.f16332d == 2) {
            return true;
        }
        return false;
    }

    public boolean p() {
        if (this.f16333e == 0) {
            return true;
        }
        return false;
    }

    public C1786c r(h hVar) {
        return new C1786c(this.f16329a, this.f16330b, this.f16331c, this.f16332d, this.f16333e, hVar, this.f16335g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f16330b.toArray()) + ">{" + this.f16332d + ", type=" + this.f16333e + ", deps=" + Arrays.toString(this.f16331c.toArray()) + "}";
    }

    /* renamed from: r0.c$b */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private String f16336a;

        /* renamed from: b  reason: collision with root package name */
        private final Set f16337b;

        /* renamed from: c  reason: collision with root package name */
        private final Set f16338c;

        /* renamed from: d  reason: collision with root package name */
        private int f16339d;

        /* renamed from: e  reason: collision with root package name */
        private int f16340e;

        /* renamed from: f  reason: collision with root package name */
        private h f16341f;

        /* renamed from: g  reason: collision with root package name */
        private final Set f16342g;

        /* access modifiers changed from: private */
        public b g() {
            this.f16340e = 1;
            return this;
        }

        private b i(int i5) {
            boolean z4;
            if (this.f16339d == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            E.d(z4, "Instantiation type has already been set.");
            this.f16339d = i5;
            return this;
        }

        private void j(F f5) {
            E.a(!this.f16337b.contains(f5), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b b(r rVar) {
            E.c(rVar, "Null dependency");
            j(rVar.c());
            this.f16338c.add(rVar);
            return this;
        }

        public b c() {
            return i(1);
        }

        public C1786c d() {
            boolean z4;
            if (this.f16341f != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            E.d(z4, "Missing required property: factory.");
            return new C1786c(this.f16336a, new HashSet(this.f16337b), new HashSet(this.f16338c), this.f16339d, this.f16340e, this.f16341f, this.f16342g);
        }

        public b e() {
            return i(2);
        }

        public b f(h hVar) {
            this.f16341f = (h) E.c(hVar, "Null factory");
            return this;
        }

        public b h(String str) {
            this.f16336a = str;
            return this;
        }

        private b(Class cls, Class... clsArr) {
            this.f16336a = null;
            HashSet hashSet = new HashSet();
            this.f16337b = hashSet;
            this.f16338c = new HashSet();
            this.f16339d = 0;
            this.f16340e = 0;
            this.f16342g = new HashSet();
            E.c(cls, "Null interface");
            hashSet.add(F.b(cls));
            for (Class cls2 : clsArr) {
                E.c(cls2, "Null interface");
                this.f16337b.add(F.b(cls2));
            }
        }

        private b(F f5, F... fArr) {
            this.f16336a = null;
            HashSet hashSet = new HashSet();
            this.f16337b = hashSet;
            this.f16338c = new HashSet();
            this.f16339d = 0;
            this.f16340e = 0;
            this.f16342g = new HashSet();
            E.c(f5, "Null interface");
            hashSet.add(f5);
            for (F c5 : fArr) {
                E.c(c5, "Null interface");
            }
            Collections.addAll(this.f16337b, fArr);
        }
    }

    private C1786c(String str, Set set, Set set2, int i5, int i6, h hVar, Set set3) {
        this.f16329a = str;
        this.f16330b = DesugarCollections.unmodifiableSet(set);
        this.f16331c = DesugarCollections.unmodifiableSet(set2);
        this.f16332d = i5;
        this.f16333e = i6;
        this.f16334f = hVar;
        this.f16335g = DesugarCollections.unmodifiableSet(set3);
    }
}
