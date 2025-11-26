package J2;

import P3.d;
import P3.k;
import W2.J;
import java.util.Map;
import k3.p;
import kotlin.jvm.internal.u;

public final class q extends u implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u f18303a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(u uVar) {
        super(2);
        this.f18303a = uVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        k kVar;
        Map map;
        int intValue = ((Number) obj).intValue();
        ((Boolean) obj2).getClass();
        d dVar = this.f18303a.f18314a;
        if (dVar == null || (map = dVar.f18877i) == null) {
            kVar = null;
        } else {
            kVar = (k) map.get(String.valueOf(intValue));
        }
        if (kVar != null) {
            this.f18303a.getClass();
            if (u.d(kVar)) {
                this.f18303a.f18339z.set(intValue);
            }
        }
        return J.f19942a;
    }
}
