package N3;

import W2.t;
import W2.u;
import t3.s;

/* renamed from: N3.d  reason: case insensitive filesystem */
public abstract class C2134d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final int f18783a;

    static {
        Object obj;
        int i5;
        try {
            t.a aVar = t.f19966b;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            kotlin.jvm.internal.t.d(property, "getProperty(...)");
            obj = t.b(s.t(property));
        } catch (Throwable th) {
            t.a aVar2 = t.f19966b;
            obj = t.b(u.a(th));
        }
        if (t.g(obj)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        if (num != null) {
            i5 = num.intValue();
        } else {
            i5 = 2097152;
        }
        f18783a = i5;
    }
}
