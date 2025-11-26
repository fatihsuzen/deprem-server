package J2;

import W2.J;
import com.inmobi.cmp.core.model.Vector;
import k3.p;
import kotlin.jvm.internal.u;

public final class y extends u implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Vector f18344a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(Vector vector) {
        super(2);
        this.f18344a = vector;
    }

    public final Object invoke(Object obj, Object obj2) {
        int intValue = ((Number) obj).intValue();
        boolean booleanValue = ((Boolean) obj2).booleanValue();
        if (this.f18344a.getMap().containsKey(Integer.valueOf(intValue))) {
            if (booleanValue) {
                this.f18344a.set(intValue);
            } else {
                this.f18344a.unset(intValue);
            }
        }
        return J.f19942a;
    }
}
