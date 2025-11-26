package L3;

import J3.e;
import J3.f;
import W2.C2219h;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import kotlin.jvm.internal.t;

public final class N0 implements f {

    /* renamed from: a  reason: collision with root package name */
    private final String f18472a;

    /* renamed from: b  reason: collision with root package name */
    private final e f18473b;

    public N0(String str, e eVar) {
        t.e(str, "serialName");
        t.e(eVar, "kind");
        this.f18472a = str;
        this.f18473b = eVar;
    }

    private final Void b() {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public String a() {
        return this.f18472a;
    }

    public boolean c() {
        return f.a.c(this);
    }

    public int d(String str) {
        t.e(str, RewardPlus.NAME);
        b();
        throw new C2219h();
    }

    public int e() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N0)) {
            return false;
        }
        N0 n02 = (N0) obj;
        if (!t.a(a(), n02.a()) || !t.a(getKind(), n02.getKind())) {
            return false;
        }
        return true;
    }

    public String f(int i5) {
        b();
        throw new C2219h();
    }

    public List g(int i5) {
        b();
        throw new C2219h();
    }

    public List getAnnotations() {
        return f.a.a(this);
    }

    public f h(int i5) {
        b();
        throw new C2219h();
    }

    public int hashCode() {
        return a().hashCode() + (getKind().hashCode() * 31);
    }

    public boolean i(int i5) {
        b();
        throw new C2219h();
    }

    public boolean isInline() {
        return f.a.b(this);
    }

    /* renamed from: j */
    public e getKind() {
        return this.f18473b;
    }

    public String toString() {
        return "PrimitiveDescriptor(" + a() + ')';
    }
}
