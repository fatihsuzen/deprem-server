package P3;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.t;

public final class h extends e implements f {

    /* renamed from: c  reason: collision with root package name */
    public final String f18883c;

    /* renamed from: d  reason: collision with root package name */
    public final String f18884d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(int i5, String str, String str2, String str3) {
        super(i5, str);
        t.e(str, RewardPlus.NAME);
        t.e(str2, "description");
        t.e(str3, "illustrations");
        this.f18883c = str2;
        this.f18884d = str3;
    }

    public final String a() {
        return this.f18883c;
    }

    public final String b() {
        return this.f18884d;
    }
}
