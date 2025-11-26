package L3;

import H3.c;
import J3.f;
import java.util.ArrayList;
import kotlin.jvm.internal.t;

public abstract class C0 {
    public static final void a(int i5, int i6, f fVar) {
        t.e(fVar, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i7 = (~i5) & i6;
        for (int i8 = 0; i8 < 32; i8++) {
            if ((i7 & 1) != 0) {
                arrayList.add(fVar.f(i8));
            }
            i7 >>>= 1;
        }
        throw new c(arrayList, fVar.a());
    }
}
