package L3;

import J3.f;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Arrays;
import kotlin.jvm.internal.t;

public final class S extends H0 {

    /* renamed from: m  reason: collision with root package name */
    private final boolean f18482m = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public S(String str, M m5) {
        super(str, m5, 1);
        t.e(str, RewardPlus.NAME);
        t.e(m5, "generatedSerializer");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof S)) {
            return false;
        }
        f fVar = (f) obj;
        if (!t.a(a(), fVar.a())) {
            return false;
        }
        S s5 = (S) obj;
        if (!s5.isInline() || !Arrays.equals(t(), s5.t()) || e() != fVar.e()) {
            return false;
        }
        int e5 = e();
        for (int i5 = 0; i5 < e5; i5++) {
            if (!t.a(h(i5).a(), fVar.h(i5).a()) || !t.a(h(i5).getKind(), fVar.h(i5).getKind())) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode() * 31;
    }

    public boolean isInline() {
        return this.f18482m;
    }
}
