package u3;

import kotlin.jvm.internal.t;

/* renamed from: u3.e  reason: case insensitive filesystem */
abstract class C2799e {
    public static final double a(double d5, C2798d dVar, C2798d dVar2) {
        t.e(dVar, "sourceUnit");
        t.e(dVar2, "targetUnit");
        long convert = dVar2.b().convert(1, dVar.b());
        if (convert > 0) {
            return d5 * ((double) convert);
        }
        return d5 / ((double) dVar.b().convert(1, dVar2.b()));
    }

    public static final long b(long j5, C2798d dVar, C2798d dVar2) {
        t.e(dVar, "sourceUnit");
        t.e(dVar2, "targetUnit");
        return dVar2.b().convert(j5, dVar.b());
    }

    public static final long c(long j5, C2798d dVar, C2798d dVar2) {
        t.e(dVar, "sourceUnit");
        t.e(dVar2, "targetUnit");
        return dVar2.b().convert(j5, dVar.b());
    }
}
