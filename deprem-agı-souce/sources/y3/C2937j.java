package y3;

import k3.l;

/* renamed from: y3.j  reason: case insensitive filesystem */
public abstract class C2937j {
    public static final C2934g a(int i5, C2928a aVar, l lVar) {
        if (i5 != -2) {
            if (i5 != -1) {
                if (i5 != 0) {
                    if (i5 == Integer.MAX_VALUE) {
                        return new C2932e(Integer.MAX_VALUE, lVar);
                    }
                    if (aVar == C2928a.SUSPEND) {
                        return new C2932e(i5, lVar);
                    }
                    return new s(i5, aVar, lVar);
                } else if (aVar == C2928a.SUSPEND) {
                    return new C2932e(0, lVar);
                } else {
                    return new s(1, aVar, lVar);
                }
            } else if (aVar == C2928a.SUSPEND) {
                return new s(1, C2928a.DROP_OLDEST, lVar);
            } else {
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
            }
        } else if (aVar == C2928a.SUSPEND) {
            return new C2932e(C2934g.f26433l0.a(), lVar);
        } else {
            return new s(1, aVar, lVar);
        }
    }

    public static /* synthetic */ C2934g b(int i5, C2928a aVar, l lVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = 0;
        }
        if ((i6 & 2) != 0) {
            aVar = C2928a.SUSPEND;
        }
        if ((i6 & 4) != 0) {
            lVar = null;
        }
        return a(i5, aVar, lVar);
    }
}
