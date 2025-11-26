package J2;

import T3.g;
import T3.i;
import W2.J;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.u;
import s4.c;

public final class p extends u implements k3.p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u f18302a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(u uVar) {
        super(2);
        this.f18302a = uVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        int intValue = ((Number) obj).intValue();
        ((Boolean) obj2).getClass();
        i j5 = c.j();
        List list = j5.f19282c.f19277a;
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (intValue == ((g) next).f19270a) {
                arrayList.add(next);
            }
        }
        u uVar = this.f18302a;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj3 = arrayList.get(i5);
            i5++;
            List list2 = j5.f19281b.f19243h;
            List list3 = ((g) obj3).f19275f;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                Iterator it = list3.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (list2.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                            uVar.f18307A.set(intValue);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return J.f19942a;
    }
}
