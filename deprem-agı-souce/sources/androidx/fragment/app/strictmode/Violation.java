package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class Violation extends RuntimeException {
    private final Fragment fragment;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Violation(Fragment fragment2, String str, int i5, C2633k kVar) {
        this(fragment2, (i5 & 2) != 0 ? null : str);
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Violation(Fragment fragment2, String str) {
        super(str);
        t.e(fragment2, "fragment");
        this.fragment = fragment2;
    }
}
