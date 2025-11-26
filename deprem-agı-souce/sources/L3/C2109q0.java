package L3;

import J3.f;
import J3.n;
import J3.o;
import W2.C2219h;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import kotlin.jvm.internal.t;

/* renamed from: L3.q0  reason: case insensitive filesystem */
public final class C2109q0 implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final C2109q0 f18574a = new C2109q0();

    /* renamed from: b  reason: collision with root package name */
    private static final n f18575b = o.d.f18393a;

    /* renamed from: c  reason: collision with root package name */
    private static final String f18576c = "kotlin.Nothing";

    private C2109q0() {
    }

    private final Void b() {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    public String a() {
        return f18576c;
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
        return false;
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

    public n getKind() {
        return f18575b;
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

    public String toString() {
        return "NothingSerialDescriptor";
    }
}
