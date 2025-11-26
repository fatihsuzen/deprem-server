package W2;

import kotlin.jvm.internal.C2633k;

public final class B implements Comparable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19926b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f19927a;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    private /* synthetic */ B(int i5) {
        this.f19927a = i5;
    }

    public static final /* synthetic */ B a(int i5) {
        return new B(i5);
    }

    public static boolean c(int i5, Object obj) {
        if ((obj instanceof B) && i5 == ((B) obj).f()) {
            return true;
        }
        return false;
    }

    public static String e(int i5) {
        return String.valueOf(((long) i5) & 4294967295L);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return L.a(f(), ((B) obj).f());
    }

    public boolean equals(Object obj) {
        return c(this.f19927a, obj);
    }

    public final /* synthetic */ int f() {
        return this.f19927a;
    }

    public int hashCode() {
        return d(this.f19927a);
    }

    public String toString() {
        return e(this.f19927a);
    }

    public static int b(int i5) {
        return i5;
    }

    public static int d(int i5) {
        return i5;
    }
}
