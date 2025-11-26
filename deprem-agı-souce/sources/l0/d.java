package l0;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public abstract class d {

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f15518a;

        /* renamed from: b  reason: collision with root package name */
        private final a f15519b;

        /* renamed from: c  reason: collision with root package name */
        private a f15520c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f15521d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f15522e;

        private static class a {

            /* renamed from: a  reason: collision with root package name */
            String f15523a;

            /* renamed from: b  reason: collision with root package name */
            Object f15524b;

            /* renamed from: c  reason: collision with root package name */
            a f15525c;

            private a() {
            }
        }

        private a a() {
            a aVar = new a();
            this.f15520c.f15525c = aVar;
            this.f15520c = aVar;
            return aVar;
        }

        private b b(Object obj) {
            a().f15524b = obj;
            return this;
        }

        private static boolean d(Object obj) {
            if (obj instanceof CharSequence) {
                if (((CharSequence) obj).length() == 0) {
                    return true;
                }
                return false;
            } else if (obj instanceof Collection) {
                return ((Collection) obj).isEmpty();
            } else {
                if (obj instanceof Map) {
                    return ((Map) obj).isEmpty();
                }
                if (obj instanceof g) {
                    return !((g) obj).c();
                }
                if (!obj.getClass().isArray() || Array.getLength(obj) != 0) {
                    return false;
                }
                return true;
            }
        }

        public b c(Object obj) {
            return b(obj);
        }

        public String toString() {
            boolean z4 = this.f15521d;
            boolean z5 = this.f15522e;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f15518a);
            sb.append('{');
            String str = "";
            for (a aVar = this.f15519b.f15525c; aVar != null; aVar = aVar.f15525c) {
                Object obj = aVar.f15524b;
                if (obj == null) {
                    if (z4) {
                    }
                } else if (z5 && d(obj)) {
                }
                sb.append(str);
                String str2 = aVar.f15523a;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append('=');
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb.append(obj);
                } else {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb.append(deepToString, 1, deepToString.length() - 1);
                }
                str = ", ";
            }
            sb.append('}');
            return sb.toString();
        }

        private b(String str) {
            a aVar = new a();
            this.f15519b = aVar;
            this.f15520c = aVar;
            this.f15521d = false;
            this.f15522e = false;
            this.f15518a = (String) h.h(str);
        }
    }

    public static b a(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
