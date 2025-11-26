package w3;

import b3.C2304a;
import b3.C2312i;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class L extends C2304a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f26242b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f26243a;

    public static final class a implements C2312i.c {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public L(String str) {
        super(f26242b);
        this.f26243a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof L) && t.a(this.f26243a, ((L) obj).f26243a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f26243a.hashCode();
    }

    public String toString() {
        return "CoroutineName(" + this.f26243a + ')';
    }
}
