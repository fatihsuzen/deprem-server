package i4;

import g4.d;
import g4.e;
import i4.d;
import java.util.HashMap;
import java.util.Map;

public class f {

    /* renamed from: b  reason: collision with root package name */
    private static final String f24519b = g4.b.i(f.class);

    /* renamed from: a  reason: collision with root package name */
    protected final d f24520a;

    static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private final f f24521a;

        a(f fVar) {
            this.f24521a = fVar;
        }

        public abstract d a();

        /* access modifiers changed from: package-private */
        public d b() {
            return this.f24521a.f24520a;
        }

        public void c(e eVar) {
            eVar.k(a());
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private d f24522a;

        /* renamed from: b  reason: collision with root package name */
        private final f f24523b;

        /* renamed from: c  reason: collision with root package name */
        private d.a f24524c = new d.a.C0246a();

        /* renamed from: d  reason: collision with root package name */
        private boolean f24525d = false;

        /* renamed from: e  reason: collision with root package name */
        private String f24526e;

        b(d dVar, f fVar) {
            this.f24522a = dVar;
            this.f24523b = fVar;
        }

        public void a(e eVar) {
            if (this.f24522a == null) {
                this.f24522a = new d(eVar);
            }
            String str = this.f24526e;
            if (str != null) {
                this.f24522a.e(str);
            }
            if (this.f24525d) {
                this.f24522a.f(this.f24523b.f24520a, this.f24524c);
            } else {
                this.f24522a.h(this.f24523b.f24520a, this.f24524c);
            }
        }
    }

    public static class c extends a {

        /* renamed from: b  reason: collision with root package name */
        private final String f24527b;

        /* renamed from: c  reason: collision with root package name */
        private final b f24528c = new b();

        /* renamed from: d  reason: collision with root package name */
        private final Map f24529d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private String f24530e;

        /* renamed from: f  reason: collision with root package name */
        private String f24531f;

        /* renamed from: g  reason: collision with root package name */
        private String f24532g;

        c(f fVar, String str) {
            super(fVar);
            this.f24527b = str;
        }

        public g4.d a() {
            if (this.f24527b != null) {
                g4.d c5 = new g4.d(b()).c(g4.c.URL_PATH, this.f24527b).c(g4.c.ACTION_NAME, this.f24530e).c(g4.c.CAMPAIGN_NAME, this.f24531f).c(g4.c.CAMPAIGN_KEYWORD, this.f24532g);
                if (this.f24528c.a() > 0) {
                    c5.c(g4.c.SCREEN_SCOPE_CUSTOM_VARIABLES, this.f24528c.toString());
                }
                for (Map.Entry entry : this.f24529d.entrySet()) {
                    a.b(c5, ((Integer) entry.getKey()).intValue(), (String) entry.getValue());
                }
                return c5;
            }
            throw new IllegalArgumentException("Screen tracking requires a non-empty path");
        }

        public /* bridge */ /* synthetic */ void c(e eVar) {
            super.c(eVar);
        }
    }

    private f() {
        this((g4.d) null);
    }

    public static f c() {
        return new f();
    }

    public b a() {
        return new b((d) null, this);
    }

    public c b(String str) {
        return new c(this, str);
    }

    private f(g4.d dVar) {
        this.f24520a = dVar == null ? new g4.d() : dVar;
    }
}
