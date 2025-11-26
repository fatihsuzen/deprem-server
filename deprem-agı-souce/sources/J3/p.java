package J3;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import kotlin.jvm.internal.t;

public final class p implements f {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ f f18394a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18395b;

    public p(String str, f fVar) {
        t.e(str, "serialName");
        t.e(fVar, "original");
        this.f18394a = fVar;
        this.f18395b = str;
    }

    public String a() {
        return this.f18395b;
    }

    public boolean c() {
        return this.f18394a.c();
    }

    public int d(String str) {
        t.e(str, RewardPlus.NAME);
        return this.f18394a.d(str);
    }

    public int e() {
        return this.f18394a.e();
    }

    public String f(int i5) {
        return this.f18394a.f(i5);
    }

    public List g(int i5) {
        return this.f18394a.g(i5);
    }

    public List getAnnotations() {
        return this.f18394a.getAnnotations();
    }

    public n getKind() {
        return this.f18394a.getKind();
    }

    public f h(int i5) {
        return this.f18394a.h(i5);
    }

    public boolean i(int i5) {
        return this.f18394a.i(i5);
    }

    public boolean isInline() {
        return this.f18394a.isInline();
    }
}
