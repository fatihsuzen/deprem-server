package W2;

import kotlin.jvm.internal.C2633k;

public final class D implements Comparable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19931b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final long f19932a;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    private /* synthetic */ D(long j5) {
        this.f19932a = j5;
    }

    public static final /* synthetic */ D a(long j5) {
        return new D(j5);
    }

    public static boolean c(long j5, Object obj) {
        if ((obj instanceof D) && j5 == ((D) obj).f()) {
            return true;
        }
        return false;
    }

    public static int d(long j5) {
        return androidx.collection.a.a(j5);
    }

    public static String e(long j5) {
        return L.c(j5, 10);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return L.b(f(), ((D) obj).f());
    }

    public boolean equals(Object obj) {
        return c(this.f19932a, obj);
    }

    public final /* synthetic */ long f() {
        return this.f19932a;
    }

    public int hashCode() {
        return d(this.f19932a);
    }

    public String toString() {
        return e(this.f19932a);
    }

    public static long b(long j5) {
        return j5;
    }
}
