package f1;

import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;
import r0.C1786c;
import r0.C1788e;
import r0.j;

/* renamed from: f1.b  reason: case insensitive filesystem */
public class C1663b implements j {
    public static /* synthetic */ Object b(String str, C1786c cVar, C1788e eVar) {
        try {
            c.b(str);
            return cVar.h().a(eVar);
        } finally {
            c.a();
        }
    }

    public List a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (C1786c cVar : componentRegistrar.getComponents()) {
            String i5 = cVar.i();
            if (i5 != null) {
                cVar = cVar.r(new C1662a(i5, cVar));
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }
}
