package W2;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class z implements Comparable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19980b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final byte f19981a;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    private /* synthetic */ z(byte b5) {
        this.f19981a = b5;
    }

    public static final /* synthetic */ z a(byte b5) {
        return new z(b5);
    }

    public static boolean c(byte b5, Object obj) {
        if ((obj instanceof z) && b5 == ((z) obj).f()) {
            return true;
        }
        return false;
    }

    public static String e(byte b5) {
        return String.valueOf(b5 & 255);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return t.g(f() & 255, ((z) obj).f() & 255);
    }

    public boolean equals(Object obj) {
        return c(this.f19981a, obj);
    }

    public final /* synthetic */ byte f() {
        return this.f19981a;
    }

    public int hashCode() {
        return d(this.f19981a);
    }

    public String toString() {
        return e(this.f19981a);
    }

    public static byte b(byte b5) {
        return b5;
    }

    public static int d(byte b5) {
        return b5;
    }
}
