package q3;

import X2.J;
import e3.C2351c;
import kotlin.jvm.internal.C2633k;
import l3.C2677a;

/* renamed from: q3.b  reason: case insensitive filesystem */
public class C2726b implements Iterable, C2677a {

    /* renamed from: d  reason: collision with root package name */
    public static final a f25690d = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f25691a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25692b;

    /* renamed from: c  reason: collision with root package name */
    private final int f25693c;

    /* renamed from: q3.b$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final C2726b a(int i5, int i6, int i7) {
            return new C2726b(i5, i6, i7);
        }

        private a() {
        }
    }

    public C2726b(int i5, int i6, int i7) {
        if (i7 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i7 != Integer.MIN_VALUE) {
            this.f25691a = i5;
            this.f25692b = C2351c.b(i5, i6, i7);
            this.f25693c = i7;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final int c() {
        return this.f25691a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2726b)) {
            return false;
        }
        if (isEmpty() && ((C2726b) obj).isEmpty()) {
            return true;
        }
        C2726b bVar = (C2726b) obj;
        if (this.f25691a == bVar.f25691a && this.f25692b == bVar.f25692b && this.f25693c == bVar.f25693c) {
            return true;
        }
        return false;
    }

    public final int f() {
        return this.f25692b;
    }

    public final int g() {
        return this.f25693c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f25691a * 31) + this.f25692b) * 31) + this.f25693c;
    }

    /* renamed from: i */
    public J iterator() {
        return new C2727c(this.f25691a, this.f25692b, this.f25693c);
    }

    public boolean isEmpty() {
        if (this.f25693c > 0) {
            if (this.f25691a > this.f25692b) {
                return true;
            }
            return false;
        } else if (this.f25691a < this.f25692b) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder sb;
        int i5;
        if (this.f25693c > 0) {
            sb = new StringBuilder();
            sb.append(this.f25691a);
            sb.append("..");
            sb.append(this.f25692b);
            sb.append(" step ");
            i5 = this.f25693c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f25691a);
            sb.append(" downTo ");
            sb.append(this.f25692b);
            sb.append(" step ");
            i5 = -this.f25693c;
        }
        sb.append(i5);
        return sb.toString();
    }
}
