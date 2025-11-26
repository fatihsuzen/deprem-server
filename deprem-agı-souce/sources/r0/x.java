package r0;

import R0.b;

public class x implements b {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f16381c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile Object f16382a = f16381c;

    /* renamed from: b  reason: collision with root package name */
    private volatile b f16383b;

    public x(b bVar) {
        this.f16383b = bVar;
    }

    public Object get() {
        Object obj;
        Object obj2 = this.f16382a;
        Object obj3 = f16381c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f16382a;
                if (obj == obj3) {
                    obj = this.f16383b.get();
                    this.f16382a = obj;
                    this.f16383b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
