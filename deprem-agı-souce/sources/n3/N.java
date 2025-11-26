package N3;

import I3.a;
import J3.f;
import M3.i;
import W2.B;
import W2.D;
import W2.G;
import W2.z;
import X2.T;
import java.util.Set;
import kotlin.jvm.internal.t;

public abstract class N {

    /* renamed from: a  reason: collision with root package name */
    private static final Set f18763a = T.g(a.v(B.f19926b).getDescriptor(), a.w(D.f19931b).getDescriptor(), a.u(z.f19980b).getDescriptor(), a.x(G.f19937b).getDescriptor());

    public static final boolean a(f fVar) {
        t.e(fVar, "<this>");
        if (!fVar.isInline() || !t.a(fVar, i.i())) {
            return false;
        }
        return true;
    }

    public static final boolean b(f fVar) {
        t.e(fVar, "<this>");
        if (!fVar.isInline() || !f18763a.contains(fVar)) {
            return false;
        }
        return true;
    }
}
