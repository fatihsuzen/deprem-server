package Z0;

import j$.util.DesugarCollections;
import java.util.HashSet;
import java.util.Set;

public class d {

    /* renamed from: b  reason: collision with root package name */
    private static volatile d f4502b;

    /* renamed from: a  reason: collision with root package name */
    private final Set f4503a = new HashSet();

    d() {
    }

    public static d a() {
        d dVar;
        d dVar2 = f4502b;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (d.class) {
            try {
                dVar = f4502b;
                if (dVar == null) {
                    dVar = new d();
                    f4502b = dVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    /* access modifiers changed from: package-private */
    public Set b() {
        Set unmodifiableSet;
        synchronized (this.f4503a) {
            unmodifiableSet = DesugarCollections.unmodifiableSet(this.f4503a);
        }
        return unmodifiableSet;
    }
}
