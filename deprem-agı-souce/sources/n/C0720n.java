package N;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: N.n  reason: case insensitive filesystem */
public abstract class C0720n {

    /* renamed from: N.n$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List f3121a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final Object f3122b;

        /* synthetic */ a(Object obj, Z z4) {
            C0722p.k(obj);
            this.f3122b = obj;
        }

        public a a(String str, Object obj) {
            C0722p.k(str);
            String valueOf = String.valueOf(obj);
            this.f3121a.add(str + "=" + valueOf);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f3122b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f3121a.size();
            for (int i5 = 0; i5 < size; i5++) {
                sb.append((String) this.f3121a.get(i5));
                if (i5 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || !obj.equals(obj2)) {
            return false;
        }
        return true;
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a c(Object obj) {
        return new a(obj, (Z) null);
    }
}
