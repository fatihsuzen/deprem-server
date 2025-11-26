package l0;

import j$.util.Objects;
import java.io.Serializable;

public abstract class l {

    static class a implements k, Serializable {

        /* renamed from: a  reason: collision with root package name */
        final k f15527a;

        /* renamed from: b  reason: collision with root package name */
        volatile transient boolean f15528b;

        /* renamed from: c  reason: collision with root package name */
        transient Object f15529c;

        a(k kVar) {
            this.f15527a = (k) h.h(kVar);
        }

        public Object get() {
            if (!this.f15528b) {
                synchronized (this) {
                    try {
                        if (!this.f15528b) {
                            Object obj = this.f15527a.get();
                            this.f15529c = obj;
                            this.f15528b = true;
                            return obj;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return e.a(this.f15529c);
        }

        public String toString() {
            Object obj;
            if (this.f15528b) {
                String valueOf = String.valueOf(this.f15529c);
                StringBuilder sb = new StringBuilder(valueOf.length() + 25);
                sb.append("<supplier that returned ");
                sb.append(valueOf);
                sb.append(">");
                obj = sb.toString();
            } else {
                obj = this.f15527a;
            }
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 19);
            sb2.append("Suppliers.memoize(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    static class b implements k {

        /* renamed from: a  reason: collision with root package name */
        volatile k f15530a;

        /* renamed from: b  reason: collision with root package name */
        volatile boolean f15531b;

        /* renamed from: c  reason: collision with root package name */
        Object f15532c;

        b(k kVar) {
            this.f15530a = (k) h.h(kVar);
        }

        public Object get() {
            if (!this.f15531b) {
                synchronized (this) {
                    try {
                        if (!this.f15531b) {
                            k kVar = this.f15530a;
                            Objects.requireNonNull(kVar);
                            Object obj = kVar.get();
                            this.f15532c = obj;
                            this.f15531b = true;
                            this.f15530a = null;
                            return obj;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return e.a(this.f15532c);
        }

        public String toString() {
            Object obj = this.f15530a;
            if (obj == null) {
                String valueOf = String.valueOf(this.f15532c);
                StringBuilder sb = new StringBuilder(valueOf.length() + 25);
                sb.append("<supplier that returned ");
                sb.append(valueOf);
                sb.append(">");
                obj = sb.toString();
            }
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 19);
            sb2.append("Suppliers.memoize(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    private static class c implements k, Serializable {

        /* renamed from: a  reason: collision with root package name */
        final Object f15533a;

        c(Object obj) {
            this.f15533a = obj;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return f.a(this.f15533a, ((c) obj).f15533a);
            }
            return false;
        }

        public Object get() {
            return this.f15533a;
        }

        public int hashCode() {
            return f.b(this.f15533a);
        }

        public String toString() {
            String valueOf = String.valueOf(this.f15533a);
            StringBuilder sb = new StringBuilder(valueOf.length() + 22);
            sb.append("Suppliers.ofInstance(");
            sb.append(valueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static k a(k kVar) {
        if ((kVar instanceof b) || (kVar instanceof a)) {
            return kVar;
        }
        if (kVar instanceof Serializable) {
            return new a(kVar);
        }
        return new b(kVar);
    }

    public static k b(Object obj) {
        return new c(obj);
    }
}
