package m4;

import kotlin.jvm.internal.t;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public final String f25485a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25486b;

    public q(String str, String str2) {
        t.e(str, "label");
        t.e(str2, "link");
        this.f25485a = str;
        this.f25486b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (t.a(this.f25485a, qVar.f25485a) && t.a(this.f25486b, qVar.f25486b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f25486b.hashCode() + (this.f25485a.hashCode() * 31);
    }

    public final String toString() {
        return "PublisherCustomLink(label=" + this.f25485a + ", link=" + this.f25486b + ')';
    }
}
