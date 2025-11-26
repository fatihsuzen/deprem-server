package z2;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class O {

    public static final class a extends O {

        /* renamed from: a  reason: collision with root package name */
        public static final a f26507a = new a();

        private a() {
            super((C2633k) null);
        }
    }

    public static final class b extends O {

        /* renamed from: a  reason: collision with root package name */
        public static final b f26508a = new b();

        private b() {
            super((C2633k) null);
        }
    }

    public static final class c extends O {

        /* renamed from: a  reason: collision with root package name */
        private final Object f26509a;

        public c(Object obj) {
            super((C2633k) null);
            this.f26509a = obj;
        }

        public final Object a() {
            return this.f26509a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof c) && t.a(this.f26509a, ((c) obj).f26509a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.f26509a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.f26509a + ')';
        }
    }

    public /* synthetic */ O(C2633k kVar) {
        this();
    }

    private O() {
    }
}
