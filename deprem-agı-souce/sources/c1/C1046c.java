package c1;

import d3.C2345b;
import kotlin.jvm.internal.t;

/* renamed from: c1.c  reason: case insensitive filesystem */
public interface C1046c {

    /* renamed from: c1.c$a */
    public enum a {
        CRASHLYTICS,
        PERFORMANCE,
        MATT_SAYS_HI;

        static {
            a[] a5;
            f4764e = C2345b.a(a5);
        }
    }

    /* renamed from: c1.c$b */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f4765a;

        public b(String str) {
            t.e(str, "sessionId");
            this.f4765a = str;
        }

        public final String a() {
            return this.f4765a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof b) && t.a(this.f4765a, ((b) obj).f4765a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f4765a.hashCode();
        }

        public String toString() {
            return "SessionDetails(sessionId=" + this.f4765a + ')';
        }
    }

    boolean a();

    a b();

    void c(b bVar);
}
