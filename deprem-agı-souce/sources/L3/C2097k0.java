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

/* renamed from: L3.k0  reason: case insensitive filesystem */
public abstract class C2097k0 implements f {

    /* renamed from: a  reason: collision with root package name */
    private final String f18548a;

    /* renamed from: b  reason: collision with root package name */
    private final f f18549b;

    /* renamed from: c  reason: collision with root package name */
    private final f f18550c;

    /* renamed from: d  reason: collision with root package name */
    private final int f18551d;

    public /* synthetic */ C2097k0(String str, f fVar, f fVar2, C2633k kVar) {
        this(str, fVar, fVar2);
    }

    public String a() {
        return this.f18548a;
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
        throw new IllegalArgumentException(str + " is not a valid map index");
    }

    public int e() {
        return this.f18551d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2097k0)) {
            return false;
        }
        C2097k0 k0Var = (C2097k0) obj;
        if (t.a(a(), k0Var.a()) && t.a(this.f18549b, k0Var.f18549b) && t.a(this.f18550c, k0Var.f18550c)) {
            return true;
        }
        return false;
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
        return o.c.f18392a;
    }

    public f h(int i5) {
        if (i5 >= 0) {
            int i6 = i5 % 2;
            if (i6 == 0) {
                return this.f18549b;
            }
            if (i6 == 1) {
                return this.f18550c;
            }
            throw new IllegalStateException("Unreached");
        }
        throw new IllegalArgumentException(("Illegal index " + i5 + ", " + a() + " expects only non-negative indices").toString());
    }

    public int hashCode() {
        return (((a().hashCode() * 31) + this.f18549b.hashCode()) * 31) + this.f18550c.hashCode();
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
        return a() + '(' + this.f18549b + ", " + this.f18550c + ')';
    }

    private C2097k0(String str, f fVar, f fVar2) {
        this.f18548a = str;
        this.f18549b = fVar;
        this.f18550c = fVar2;
        this.f18551d = 2;
    }
}
