package W2;

import java.io.Serializable;
import kotlin.jvm.internal.t;

public final class x implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final Object f19977a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f19978b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f19979c;

    public x(Object obj, Object obj2, Object obj3) {
        this.f19977a = obj;
        this.f19978b = obj2;
        this.f19979c = obj3;
    }

    public final Object a() {
        return this.f19977a;
    }

    public final Object b() {
        return this.f19978b;
    }

    public final Object c() {
        return this.f19979c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        if (t.a(this.f19977a, xVar.f19977a) && t.a(this.f19978b, xVar.f19978b) && t.a(this.f19979c, xVar.f19979c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i5;
        int i6;
        Object obj = this.f19977a;
        int i7 = 0;
        if (obj == null) {
            i5 = 0;
        } else {
            i5 = obj.hashCode();
        }
        int i8 = i5 * 31;
        Object obj2 = this.f19978b;
        if (obj2 == null) {
            i6 = 0;
        } else {
            i6 = obj2.hashCode();
        }
        int i9 = (i8 + i6) * 31;
        Object obj3 = this.f19979c;
        if (obj3 != null) {
            i7 = obj3.hashCode();
        }
        return i9 + i7;
    }

    public String toString() {
        return '(' + this.f19977a + ", " + this.f19978b + ", " + this.f19979c + ')';
    }
}
