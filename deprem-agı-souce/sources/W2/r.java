package W2;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class r extends Error {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(String str) {
        super(str);
        t.e(str, "message");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(String str, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? "An operation is not implemented." : str);
    }
}
