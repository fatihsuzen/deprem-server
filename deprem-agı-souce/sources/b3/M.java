package B3;

import b3.C2312i;
import kotlin.jvm.internal.t;

public final class M implements C2312i.c {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal f17380a;

    public M(ThreadLocal threadLocal) {
        this.f17380a = threadLocal;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof M) && t.a(this.f17380a, ((M) obj).f17380a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f17380a.hashCode();
    }

    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f17380a + ')';
    }
}
