package L3;

import J3.f;
import J3.j;
import J3.n;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.t;

public abstract class I0 {
    public static final int a(f fVar, f[] fVarArr) {
        int i5;
        t.e(fVar, "<this>");
        t.e(fVarArr, "typeParams");
        int hashCode = (fVar.a().hashCode() * 31) + Arrays.hashCode(fVarArr);
        Iterable<f> a5 = j.a(fVar);
        Iterator it = a5.iterator();
        int i6 = 1;
        int i7 = 1;
        while (true) {
            int i8 = 0;
            if (!it.hasNext()) {
                break;
            }
            int i9 = i7 * 31;
            String a6 = ((f) it.next()).a();
            if (a6 != null) {
                i8 = a6.hashCode();
            }
            i7 = i9 + i8;
        }
        for (f kind : a5) {
            int i10 = i6 * 31;
            n kind2 = kind.getKind();
            if (kind2 != null) {
                i5 = kind2.hashCode();
            } else {
                i5 = 0;
            }
            i6 = i10 + i5;
        }
        return (((hashCode * 31) + i7) * 31) + i6;
    }
}
