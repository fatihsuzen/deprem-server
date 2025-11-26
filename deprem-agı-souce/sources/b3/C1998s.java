package B3;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import s3.C2754h;
import w3.I0;

/* renamed from: B3.s  reason: case insensitive filesystem */
public final class C1998s {

    /* renamed from: a  reason: collision with root package name */
    public static final C1998s f17423a;

    /* renamed from: b  reason: collision with root package name */
    public static final I0 f17424b;

    static {
        C1998s sVar = new C1998s();
        f17423a = sVar;
        E.f("kotlinx.coroutines.fast.service.loader", true);
        f17424b = sVar.a();
    }

    private C1998s() {
    }

    private final I0 a() {
        Object obj;
        Class<r> cls = r.class;
        try {
            List x4 = C2754h.x(C2754h.d(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
            Iterator it = x4.iterator();
            if (!it.hasNext()) {
                obj = null;
            } else {
                obj = it.next();
                if (it.hasNext()) {
                    int c5 = ((r) obj).c();
                    do {
                        Object next = it.next();
                        int c6 = ((r) next).c();
                        if (c5 < c6) {
                            obj = next;
                            c5 = c6;
                        }
                    } while (it.hasNext());
                }
            }
            r rVar = (r) obj;
            if (rVar != null) {
                I0 e5 = t.e(rVar, x4);
                if (e5 != null) {
                    return e5;
                }
            }
            t.b((Throwable) null, (String) null, 3, (Object) null);
            return null;
        } catch (Throwable th) {
            t.b(th, (String) null, 2, (Object) null);
            return null;
        }
    }
}
