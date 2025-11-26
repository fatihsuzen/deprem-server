package J2;

import W2.J;
import com.inmobi.cmp.core.model.Vector;
import k3.p;
import kotlin.jvm.internal.u;

public final class x extends u implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Vector f18343a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(Vector vector) {
        super(2);
        this.f18343a = vector;
    }

    public final Object invoke(Object obj, Object obj2) {
        int intValue = ((Number) obj).intValue();
        if (((Boolean) obj2).booleanValue()) {
            this.f18343a.set(intValue);
        } else {
            this.f18343a.unset(intValue);
        }
        return J.f19942a;
    }
}
