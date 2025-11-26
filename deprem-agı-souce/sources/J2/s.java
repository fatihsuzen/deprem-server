package J2;

import P3.d;
import P3.k;
import W2.J;
import b.w;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.p;
import kotlin.jvm.internal.u;
import s4.c;

public final class s extends u implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u f18305a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(u uVar) {
        super(2);
        this.f18305a = uVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        k kVar;
        Map map;
        int intValue = ((Number) obj).intValue();
        ((Boolean) obj2).getClass();
        d dVar = this.f18305a.f18314a;
        if (dVar == null || (map = dVar.f18877i) == null) {
            kVar = null;
        } else {
            kVar = (k) map.get(String.valueOf(intValue));
        }
        if (kVar != null) {
            this.f18305a.getClass();
            if (!u.d(kVar) && !u.c(this.f18305a, kVar)) {
                this.f18305a.getClass();
                List list = c.j().f19281b.f19247l;
                Set set = kVar.f18891g;
                if (!w.a(set) || !set.isEmpty()) {
                    Iterator it = set.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (list.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                                this.f18305a.f18309C.set(intValue);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return J.f19942a;
    }
}
