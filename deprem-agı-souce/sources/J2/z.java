package J2;

import W2.J;
import com.inmobi.cmp.core.model.Vector;
import k3.p;
import kotlin.jvm.internal.u;

public final class z extends u implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Vector f18345a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Vector f18346b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(Vector vector, Vector vector2) {
        super(2);
        this.f18345a = vector;
        this.f18346b = vector2;
    }

    public final Object invoke(Object obj, Object obj2) {
        int intValue = ((Number) obj).intValue();
        ((Boolean) obj2).getClass();
        Vector vector = this.f18345a;
        if (vector != null && !vector.contains(intValue)) {
            this.f18346b.unset(intValue);
        }
        return J.f19942a;
    }
}
