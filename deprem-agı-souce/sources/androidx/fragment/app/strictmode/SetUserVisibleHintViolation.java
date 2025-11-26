package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.t;

public final class SetUserVisibleHintViolation extends Violation {
    private final boolean isVisibleToUser;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SetUserVisibleHintViolation(Fragment fragment, boolean z4) {
        super(fragment, "Attempting to set user visible hint to " + z4 + " for fragment " + fragment);
        t.e(fragment, "fragment");
        this.isVisibleToUser = z4;
    }

    public final boolean isVisibleToUser() {
        return this.isVisibleToUser;
    }
}
