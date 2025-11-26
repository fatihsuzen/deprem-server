package m;

import W2.J;
import com.inmobi.cmp.core.model.Vector;
import k3.p;
import kotlin.jvm.internal.u;

public final class i extends u implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Vector f957a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(Vector vector) {
        super(2);
        this.f957a = vector;
    }

    public final Object invoke(Object obj, Object obj2) {
        int intValue = ((Number) obj).intValue();
        boolean booleanValue = ((Boolean) obj2).booleanValue();
        if (!this.f957a.contains(intValue)) {
            if (booleanValue) {
                this.f957a.set(intValue);
            } else {
                this.f957a.unset(intValue);
            }
        }
        return J.f19942a;
    }
}
