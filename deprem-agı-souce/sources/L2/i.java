package L2;

import P3.d;
import P3.k;
import W2.J;
import java.util.Map;
import k3.p;
import kotlin.jvm.internal.u;

public final class i extends u implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ J2.u f18422a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(J2.u uVar) {
        super(2);
        this.f18422a = uVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        k kVar;
        Map map;
        int intValue = ((Number) obj).intValue();
        boolean booleanValue = ((Boolean) obj2).booleanValue();
        d dVar = this.f18422a.f18314a;
        if (dVar == null || (map = dVar.f18877i) == null) {
            kVar = null;
        } else {
            kVar = (k) map.get(String.valueOf(intValue));
        }
        if (kVar == null || (booleanValue && kVar.f18889e.isEmpty())) {
            this.f18422a.f18309C.unset(intValue);
        }
        return J.f19942a;
    }
}
