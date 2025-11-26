package t;

import T2.a;

/* renamed from: t.a  reason: case insensitive filesystem */
public final class C1875a implements a {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f16580c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile a f16581a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f16582b = f16580c;

    private C1875a(a aVar) {
        this.f16581a = aVar;
    }

    public static a a(a aVar) {
        C1878d.b(aVar);
        if (aVar instanceof C1875a) {
            return aVar;
        }
        return new C1875a(aVar);
    }

    private static Object b(Object obj, Object obj2) {
        if (obj == f16580c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public Object get() {
        Object obj;
        Object obj2 = this.f16582b;
        Object obj3 = f16580c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f16582b;
                if (obj == obj3) {
                    obj = this.f16581a.get();
                    this.f16582b = b(this.f16582b, obj);
                    this.f16581a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
