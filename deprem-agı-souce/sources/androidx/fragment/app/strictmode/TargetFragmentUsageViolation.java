package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class TargetFragmentUsageViolation extends Violation {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TargetFragmentUsageViolation(Fragment fragment, String str, int i5, C2633k kVar) {
        this(fragment, (i5 & 2) != 0 ? null : str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TargetFragmentUsageViolation(Fragment fragment, String str) {
        super(fragment, str);
        t.e(fragment, "fragment");
    }
}
