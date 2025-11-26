package u0;

import A0.F;
import A0.G;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: u0.d  reason: case insensitive filesystem */
public final class C1889d implements C1886a {

    /* renamed from: c  reason: collision with root package name */
    private static final h f16651c = new b();

    /* renamed from: a  reason: collision with root package name */
    private final R0.a f16652a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference f16653b = new AtomicReference((Object) null);

    /* renamed from: u0.d$b */
    private static final class b implements h {
        private b() {
        }

        public File a() {
            return null;
        }

        public File b() {
            return null;
        }

        public File c() {
            return null;
        }

        public F.a d() {
            return null;
        }

        public File e() {
            return null;
        }

        public File f() {
            return null;
        }

        public File g() {
            return null;
        }
    }

    public C1889d(R0.a aVar) {
        this.f16652a = aVar;
        aVar.a(new C1887b(this));
    }

    public static /* synthetic */ void f(C1889d dVar, R0.b bVar) {
        dVar.getClass();
        g.f().b("Crashlytics native component now available.");
        dVar.f16653b.set((C1886a) bVar.get());
    }

    public h a(String str) {
        C1886a aVar = (C1886a) this.f16653b.get();
        if (aVar == null) {
            return f16651c;
        }
        return aVar.a(str);
    }

    public boolean b() {
        C1886a aVar = (C1886a) this.f16653b.get();
        if (aVar == null || !aVar.b()) {
            return false;
        }
        return true;
    }

    public boolean c(String str) {
        C1886a aVar = (C1886a) this.f16653b.get();
        if (aVar == null || !aVar.c(str)) {
            return false;
        }
        return true;
    }

    public void d(String str, String str2, long j5, G g5) {
        g f5 = g.f();
        f5.i("Deferring native open session: " + str);
        this.f16652a.a(new C1888c(str, str2, j5, g5));
    }
}
