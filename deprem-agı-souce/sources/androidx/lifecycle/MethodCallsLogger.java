package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MethodCallsLogger {
    private final Map<String, Integer> calledMethods = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean approveCall(String str, int i5) {
        int i6;
        t.e(str, RewardPlus.NAME);
        Integer num = this.calledMethods.get(str);
        boolean z4 = false;
        if (num != null) {
            i6 = num.intValue();
        } else {
            i6 = 0;
        }
        if ((i6 & i5) != 0) {
            z4 = true;
        }
        this.calledMethods.put(str, Integer.valueOf(i5 | i6));
        return !z4;
    }
}
