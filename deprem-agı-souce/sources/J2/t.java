package J2;

import P3.d;
import P3.k;
import W2.J;
import java.util.Map;
import k3.p;
import kotlin.jvm.internal.u;

public final class t extends u implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u f18306a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(u uVar) {
        super(2);
        this.f18306a = uVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        k kVar;
        Map map;
        int intValue = ((Number) obj).intValue();
        ((Boolean) obj2).getClass();
        d dVar = this.f18306a.f18314a;
        if (dVar == null || (map = dVar.f18877i) == null) {
            kVar = null;
        } else {
            kVar = (k) map.get(String.valueOf(intValue));
        }
        if (kVar != null) {
            this.f18306a.getClass();
            if (u.d(kVar)) {
                this.f18306a.f18339z.unset(intValue);
            }
        }
        return J.f19942a;
    }
}
