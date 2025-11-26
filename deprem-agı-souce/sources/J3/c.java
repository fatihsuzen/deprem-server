package J3;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import kotlin.jvm.internal.t;
import r3.C2733c;

final class c implements f {

    /* renamed from: a  reason: collision with root package name */
    private final f f18354a;

    /* renamed from: b  reason: collision with root package name */
    public final C2733c f18355b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18356c;

    public c(f fVar, C2733c cVar) {
        t.e(fVar, "original");
        t.e(cVar, "kClass");
        this.f18354a = fVar;
        this.f18355b = cVar;
        this.f18356c = fVar.a() + '<' + cVar.c() + '>';
    }

    public String a() {
        return this.f18356c;
    }

    public boolean c() {
        return this.f18354a.c();
    }

    public int d(String str) {
        t.e(str, RewardPlus.NAME);
        return this.f18354a.d(str);
    }

    public int e() {
        return this.f18354a.e();
    }

    public boolean equals(Object obj) {
        c cVar;
        if (obj instanceof c) {
            cVar = (c) obj;
        } else {
            cVar = null;
        }
        if (cVar != null && t.a(this.f18354a, cVar.f18354a) && t.a(cVar.f18355b, this.f18355b)) {
            return true;
        }
        return false;
    }

    public String f(int i5) {
        return this.f18354a.f(i5);
    }

    public List g(int i5) {
        return this.f18354a.g(i5);
    }

    public List getAnnotations() {
        return this.f18354a.getAnnotations();
    }

    public n getKind() {
        return this.f18354a.getKind();
    }

    public f h(int i5) {
        return this.f18354a.h(i5);
    }

    public int hashCode() {
        return (this.f18355b.hashCode() * 31) + a().hashCode();
    }

    public boolean i(int i5) {
        return this.f18354a.i(i5);
    }

    public boolean isInline() {
        return this.f18354a.isInline();
    }

    public String toString() {
        return "ContextDescriptor(kClass: " + this.f18355b + ", original: " + this.f18354a + ')';
    }
}
