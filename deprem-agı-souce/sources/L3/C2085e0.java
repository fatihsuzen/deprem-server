package L3;

import J3.f;
import J3.n;
import J3.o;
import X2.C2250q;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

/* renamed from: L3.e0  reason: case insensitive filesystem */
public abstract class C2085e0 implements f {

    /* renamed from: a  reason: collision with root package name */
    private final f f18517a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18518b;

    public /* synthetic */ C2085e0(f fVar, C2633k kVar) {
        this(fVar);
    }

    public boolean c() {
        return f.a.c(this);
    }

    public int d(String str) {
        t.e(str, RewardPlus.NAME);
        Integer t5 = s.t(str);
        if (t5 != null) {
            return t5.intValue();
        }
        throw new IllegalArgumentException(str + " is not a valid list index");
    }

    public int e() {
        return this.f18518b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2085e0)) {
            return false;
        }
        C2085e0 e0Var = (C2085e0) obj;
        if (!t.a(this.f18517a, e0Var.f18517a) || !t.a(a(), e0Var.a())) {
            return false;
        }
        return true;
    }

    public String f(int i5) {
        return String.valueOf(i5);
    }

    public List g(int i5) {
        if (i5 >= 0) {
            return C2250q.g();
        }
        throw new IllegalArgumentException(("Illegal index " + i5 + ", " + a() + " expects only non-negative indices").toString());
    }

    public List getAnnotations() {
        return f.a.a(this);
    }

    public n getKind() {
        return o.b.f18391a;
    }

    public f h(int i5) {
        if (i5 >= 0) {
            return this.f18517a;
        }
        throw new IllegalArgumentException(("Illegal index " + i5 + ", " + a() + " expects only non-negative indices").toString());
    }

    public int hashCode() {
        return (this.f18517a.hashCode() * 31) + a().hashCode();
    }

    public boolean i(int i5) {
        if (i5 >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i5 + ", " + a() + " expects only non-negative indices").toString());
    }

    public boolean isInline() {
        return f.a.b(this);
    }

    public String toString() {
        return a() + '(' + this.f18517a + ')';
    }

    private C2085e0(f fVar) {
        this.f18517a = fVar;
        this.f18518b = 1;
    }
}
