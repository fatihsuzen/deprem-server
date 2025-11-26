package d1;

/* renamed from: d1.a  reason: case insensitive filesystem */
public final class C1624a implements e {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f15223c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile e f15224a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f15225b = f15223c;

    private C1624a(e eVar) {
        this.f15224a = eVar;
    }

    public static e a(e eVar) {
        d.b(eVar);
        if (eVar instanceof C1624a) {
            return eVar;
        }
        return new C1624a(eVar);
    }

    private static Object b(Object obj, Object obj2) {
        if (obj == f15223c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public Object get() {
        Object obj;
        Object obj2 = this.f15225b;
        Object obj3 = f15223c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f15225b;
                if (obj == obj3) {
                    obj = this.f15224a.get();
                    this.f15225b = b(this.f15225b, obj);
                    this.f15224a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
