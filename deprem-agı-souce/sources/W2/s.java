package W2;

import java.io.Serializable;
import kotlin.jvm.internal.t;

public final class s implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final Object f19964a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f19965b;

    public s(Object obj, Object obj2) {
        this.f19964a = obj;
        this.f19965b = obj2;
    }

    public final Object a() {
        return this.f19964a;
    }

    public final Object b() {
        return this.f19965b;
    }

    public final Object c() {
        return this.f19964a;
    }

    public final Object d() {
        return this.f19965b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        if (t.a(this.f19964a, sVar.f19964a) && t.a(this.f19965b, sVar.f19965b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i5;
        Object obj = this.f19964a;
        int i6 = 0;
        if (obj == null) {
            i5 = 0;
        } else {
            i5 = obj.hashCode();
        }
        int i7 = i5 * 31;
        Object obj2 = this.f19965b;
        if (obj2 != null) {
            i6 = obj2.hashCode();
        }
        return i7 + i6;
    }

    public String toString() {
        return '(' + this.f19964a + ", " + this.f19965b + ')';
    }
}
