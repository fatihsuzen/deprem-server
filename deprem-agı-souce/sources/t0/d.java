package T0;

import T0.a;
import T0.c;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static d f4380a = a().a();

    public static abstract class a {
        public abstract d a();

        public abstract a b(String str);

        public abstract a c(long j5);

        public abstract a d(String str);

        public abstract a e(String str);

        public abstract a f(String str);

        public abstract a g(c.a aVar);

        public abstract a h(long j5);
    }

    public static a a() {
        return new a.b().h(0).g(c.a.ATTEMPT_MIGRATION).c(0);
    }

    public abstract String b();

    public abstract long c();

    public abstract String d();

    public abstract String e();

    public abstract String f();

    public abstract c.a g();

    public abstract long h();

    public boolean i() {
        if (g() == c.a.REGISTER_ERROR) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (g() == c.a.NOT_GENERATED || g() == c.a.ATTEMPT_MIGRATION) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (g() == c.a.REGISTERED) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (g() == c.a.UNREGISTERED) {
            return true;
        }
        return false;
    }

    public boolean m() {
        if (g() == c.a.ATTEMPT_MIGRATION) {
            return true;
        }
        return false;
    }

    public abstract a n();

    public d o(String str, long j5, long j6) {
        return n().b(str).c(j5).h(j6).a();
    }

    public d p() {
        return n().b((String) null).a();
    }

    public d q(String str) {
        return n().e(str).g(c.a.REGISTER_ERROR).a();
    }

    public d r() {
        return n().g(c.a.NOT_GENERATED).a();
    }

    public d s(String str, String str2, long j5, String str3, long j6) {
        return n().d(str).g(c.a.REGISTERED).b(str3).f(str2).c(j6).h(j5).a();
    }

    public d t(String str) {
        return n().d(str).g(c.a.UNREGISTERED).a();
    }
}
