package z0;

import D0.g;
import java.io.File;

/* renamed from: z0.f  reason: case insensitive filesystem */
public class C1977f {

    /* renamed from: c  reason: collision with root package name */
    private static final b f17191c = new b();

    /* renamed from: a  reason: collision with root package name */
    private final g f17192a;

    /* renamed from: b  reason: collision with root package name */
    private C1975d f17193b;

    public C1977f(g gVar) {
        this.f17192a = gVar;
        this.f17193b = f17191c;
    }

    private File d(String str) {
        return this.f17192a.q(str, "userlog");
    }

    public void a() {
        this.f17193b.d();
    }

    public byte[] b() {
        return this.f17193b.c();
    }

    public String c() {
        return this.f17193b.b();
    }

    public final void e(String str) {
        this.f17193b.a();
        this.f17193b = f17191c;
        if (str != null) {
            f(d(str), 65536);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(File file, int i5) {
        this.f17193b = new C1980i(file, i5);
    }

    public void g(long j5, String str) {
        this.f17193b.e(j5, str);
    }

    public C1977f(g gVar, String str) {
        this(gVar);
        e(str);
    }

    /* renamed from: z0.f$b */
    private static final class b implements C1975d {
        private b() {
        }

        public String b() {
            return null;
        }

        public byte[] c() {
            return null;
        }

        public void a() {
        }

        public void d() {
        }

        public void e(long j5, String str) {
        }
    }
}
