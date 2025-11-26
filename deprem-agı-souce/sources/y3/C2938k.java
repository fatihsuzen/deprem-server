package y3;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: y3.k  reason: case insensitive filesystem */
public final class C2938k {

    /* renamed from: b  reason: collision with root package name */
    public static final b f26437b = new b((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final c f26438c = new c();

    /* renamed from: a  reason: collision with root package name */
    private final Object f26439a;

    /* renamed from: y3.k$a */
    public static final class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f26440a;

        public a(Throwable th) {
            this.f26440a = th;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a) || !t.a(this.f26440a, ((a) obj).f26440a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            Throwable th = this.f26440a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Closed(" + this.f26440a + ')';
        }
    }

    /* renamed from: y3.k$b */
    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public final Object a(Throwable th) {
            return C2938k.c(new a(th));
        }

        public final Object b() {
            return C2938k.c(C2938k.f26438c);
        }

        public final Object c(Object obj) {
            return C2938k.c(obj);
        }

        private b() {
        }
    }

    /* renamed from: y3.k$c */
    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    private /* synthetic */ C2938k(Object obj) {
        this.f26439a = obj;
    }

    public static final /* synthetic */ C2938k b(Object obj) {
        return new C2938k(obj);
    }

    public static boolean d(Object obj, Object obj2) {
        if ((obj2 instanceof C2938k) && t.a(obj, ((C2938k) obj2).k())) {
            return true;
        }
        return false;
    }

    public static final Throwable e(Object obj) {
        a aVar;
        if (obj instanceof a) {
            aVar = (a) obj;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.f26440a;
        }
        return null;
    }

    public static final Object f(Object obj) {
        if (!(obj instanceof c)) {
            return obj;
        }
        return null;
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean h(Object obj) {
        return obj instanceof a;
    }

    public static final boolean i(Object obj) {
        return !(obj instanceof c);
    }

    public static String j(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f26439a, obj);
    }

    public int hashCode() {
        return g(this.f26439a);
    }

    public final /* synthetic */ Object k() {
        return this.f26439a;
    }

    public String toString() {
        return j(this.f26439a);
    }

    public static Object c(Object obj) {
        return obj;
    }
}
