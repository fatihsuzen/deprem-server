package W2;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class G implements Comparable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19937b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final short f19938a;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    private /* synthetic */ G(short s5) {
        this.f19938a = s5;
    }

    public static final /* synthetic */ G a(short s5) {
        return new G(s5);
    }

    public static boolean c(short s5, Object obj) {
        if ((obj instanceof G) && s5 == ((G) obj).f()) {
            return true;
        }
        return false;
    }

    public static String e(short s5) {
        return String.valueOf(s5 & 65535);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return t.g(f() & 65535, ((G) obj).f() & 65535);
    }

    public boolean equals(Object obj) {
        return c(this.f19938a, obj);
    }

    public final /* synthetic */ short f() {
        return this.f19938a;
    }

    public int hashCode() {
        return d(this.f19938a);
    }

    public String toString() {
        return e(this.f19938a);
    }

    public static short b(short s5) {
        return s5;
    }

    public static int d(short s5) {
        return s5;
    }
}
