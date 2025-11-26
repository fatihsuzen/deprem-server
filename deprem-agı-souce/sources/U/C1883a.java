package u;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;
import r.m;

/* renamed from: u.a  reason: case insensitive filesystem */
public final class C1883a {

    /* renamed from: e  reason: collision with root package name */
    private static final C1883a f16605e = new C0164a().b();

    /* renamed from: a  reason: collision with root package name */
    private final f f16606a;

    /* renamed from: b  reason: collision with root package name */
    private final List f16607b;

    /* renamed from: c  reason: collision with root package name */
    private final C1884b f16608c;

    /* renamed from: d  reason: collision with root package name */
    private final String f16609d;

    /* renamed from: u.a$a  reason: collision with other inner class name */
    public static final class C0164a {

        /* renamed from: a  reason: collision with root package name */
        private f f16610a = null;

        /* renamed from: b  reason: collision with root package name */
        private List f16611b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private C1884b f16612c = null;

        /* renamed from: d  reason: collision with root package name */
        private String f16613d = "";

        C0164a() {
        }

        public C0164a a(d dVar) {
            this.f16611b.add(dVar);
            return this;
        }

        public C1883a b() {
            return new C1883a(this.f16610a, DesugarCollections.unmodifiableList(this.f16611b), this.f16612c, this.f16613d);
        }

        public C0164a c(String str) {
            this.f16613d = str;
            return this;
        }

        public C0164a d(C1884b bVar) {
            this.f16612c = bVar;
            return this;
        }

        public C0164a e(f fVar) {
            this.f16610a = fVar;
            return this;
        }
    }

    C1883a(f fVar, List list, C1884b bVar, String str) {
        this.f16606a = fVar;
        this.f16607b = list;
        this.f16608c = bVar;
        this.f16609d = str;
    }

    public static C0164a e() {
        return new C0164a();
    }

    public String a() {
        return this.f16609d;
    }

    public C1884b b() {
        return this.f16608c;
    }

    public List c() {
        return this.f16607b;
    }

    public f d() {
        return this.f16606a;
    }

    public byte[] f() {
        return m.a(this);
    }
}
