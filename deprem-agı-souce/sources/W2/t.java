package W2;

import java.io.Serializable;
import kotlin.jvm.internal.C2633k;

public final class t implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19966b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final Object f19967a;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f19968a;

        public b(Throwable th) {
            kotlin.jvm.internal.t.e(th, "exception");
            this.f19968a = th;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b) || !kotlin.jvm.internal.t.a(this.f19968a, ((b) obj).f19968a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f19968a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f19968a + ')';
        }
    }

    private /* synthetic */ t(Object obj) {
        this.f19967a = obj;
    }

    public static final /* synthetic */ t a(Object obj) {
        return new t(obj);
    }

    public static boolean c(Object obj, Object obj2) {
        if ((obj2 instanceof t) && kotlin.jvm.internal.t.a(obj, ((t) obj2).j())) {
            return true;
        }
        return false;
    }

    public static final boolean d(Object obj, Object obj2) {
        return kotlin.jvm.internal.t.a(obj, obj2);
    }

    public static final Throwable e(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f19968a;
        }
        return null;
    }

    public static int f(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean g(Object obj) {
        return obj instanceof b;
    }

    public static final boolean h(Object obj) {
        return !(obj instanceof b);
    }

    public static String i(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f19967a, obj);
    }

    public int hashCode() {
        return f(this.f19967a);
    }

    public final /* synthetic */ Object j() {
        return this.f19967a;
    }

    public String toString() {
        return i(this.f19967a);
    }

    public static Object b(Object obj) {
        return obj;
    }
}
