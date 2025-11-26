package z3;

import A3.h;
import B3.D;
import b3.C2312i;
import y3.C2928a;

public abstract class B {

    /* renamed from: a  reason: collision with root package name */
    public static final D f26588a = new D("NO_VALUE");

    public static final v a(int i5, int i6, C2928a aVar) {
        if (i5 < 0) {
            throw new IllegalArgumentException(("replay cannot be negative, but was " + i5).toString());
        } else if (i6 < 0) {
            throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + i6).toString());
        } else if (i5 > 0 || i6 > 0 || aVar == C2928a.SUSPEND) {
            int i7 = i6 + i5;
            if (i7 < 0) {
                i7 = Integer.MAX_VALUE;
            }
            return new C2967A(i5, i7, aVar);
        } else {
            throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + aVar).toString());
        }
    }

    public static final C2972e d(z zVar, C2312i iVar, int i5, C2928a aVar) {
        if ((i5 == 0 || i5 == -3) && aVar == C2928a.SUSPEND) {
            return zVar;
        }
        return new h(zVar, iVar, i5, aVar);
    }

    /* access modifiers changed from: private */
    public static final Object e(Object[] objArr, long j5) {
        return objArr[((int) j5) & (objArr.length - 1)];
    }

    /* access modifiers changed from: private */
    public static final void f(Object[] objArr, long j5, Object obj) {
        objArr[((int) j5) & (objArr.length - 1)] = obj;
    }
}
