package t3;

import kotlin.jvm.internal.t;
import q3.C2728d;

/* renamed from: t3.j  reason: case insensitive filesystem */
public final class C2786j {

    /* renamed from: a  reason: collision with root package name */
    private final String f25940a;

    /* renamed from: b  reason: collision with root package name */
    private final C2728d f25941b;

    public C2786j(String str, C2728d dVar) {
        t.e(str, "value");
        t.e(dVar, "range");
        this.f25940a = str;
        this.f25941b = dVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2786j)) {
            return false;
        }
        C2786j jVar = (C2786j) obj;
        if (t.a(this.f25940a, jVar.f25940a) && t.a(this.f25941b, jVar.f25941b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f25940a.hashCode() * 31) + this.f25941b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f25940a + ", range=" + this.f25941b + ')';
    }
}
