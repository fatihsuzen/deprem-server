package L3;

import J3.f;
import J3.n;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.t;

public final class Q0 implements f, C2102n {

    /* renamed from: a  reason: collision with root package name */
    private final f f18479a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18480b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f18481c;

    public Q0(f fVar) {
        t.e(fVar, "original");
        this.f18479a = fVar;
        this.f18480b = fVar.a() + '?';
        this.f18481c = B0.a(fVar);
    }

    public String a() {
        return this.f18480b;
    }

    public Set b() {
        return this.f18481c;
    }

    public boolean c() {
        return true;
    }

    public int d(String str) {
        t.e(str, RewardPlus.NAME);
        return this.f18479a.d(str);
    }

    public int e() {
        return this.f18479a.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Q0) && t.a(this.f18479a, ((Q0) obj).f18479a)) {
            return true;
        }
        return false;
    }

    public String f(int i5) {
        return this.f18479a.f(i5);
    }

    public List g(int i5) {
        return this.f18479a.g(i5);
    }

    public List getAnnotations() {
        return this.f18479a.getAnnotations();
    }

    public n getKind() {
        return this.f18479a.getKind();
    }

    public f h(int i5) {
        return this.f18479a.h(i5);
    }

    public int hashCode() {
        return this.f18479a.hashCode() * 31;
    }

    public boolean i(int i5) {
        return this.f18479a.i(i5);
    }

    public boolean isInline() {
        return this.f18479a.isInline();
    }

    public final f j() {
        return this.f18479a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18479a);
        sb.append('?');
        return sb.toString();
    }
}
