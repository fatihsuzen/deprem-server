package B3;

import W2.C2216e;
import b3.C2312i;
import k3.l;
import w3.K;

public abstract class w {
    public static final void a(l lVar, Object obj, C2312i iVar) {
        S b5 = b(lVar, obj, (S) null);
        if (b5 != null) {
            K.a(iVar, b5);
        }
    }

    public static final S b(l lVar, Object obj, S s5) {
        try {
            lVar.invoke(obj);
            return s5;
        } catch (Throwable th) {
            if (s5 == null || s5.getCause() == th) {
                return new S("Exception in undelivered element handler for " + obj, th);
            }
            C2216e.a(s5, th);
            return s5;
        }
    }

    public static /* synthetic */ S c(l lVar, Object obj, S s5, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            s5 = null;
        }
        return b(lVar, obj, s5);
    }
}
