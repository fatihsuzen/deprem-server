package P3;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import kotlin.jvm.internal.t;

public final class i extends e {

    /* renamed from: c  reason: collision with root package name */
    public final List f18885c;

    /* renamed from: d  reason: collision with root package name */
    public final List f18886d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(int i5, String str, String str2, List list, List list2) {
        super(i5, str);
        t.e(str, RewardPlus.NAME);
        t.e(str2, "description");
        t.e(list, "purposes");
        t.e(list2, "specialFeatures");
        this.f18885c = list;
        this.f18886d = list2;
    }
}
